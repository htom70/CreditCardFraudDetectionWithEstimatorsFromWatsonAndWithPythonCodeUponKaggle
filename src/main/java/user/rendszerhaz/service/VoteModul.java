package user.rendszerhaz.service;

import io.spring.guides.gs_producing_web_service.DetectionRequest;
import io.spring.guides.gs_producing_web_service.DetectionResponse;
import io.spring.guides.gs_producing_web_service.Estimator;
import io.spring.guides.gs_producing_web_service.GenerateDetectionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.rendszerhaz.config.EstimatorConfig;
import user.rendszerhaz.domain.Fraud;
import user.rendszerhaz.repository.FraudRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VoteModul {

    private EstimatorConfig estimatorConfig;
    private SinglePrediction singlePrediction;
    private FraudRepository fraudRepository;

    @Autowired
    public VoteModul(EstimatorConfig estimatorConfig, SinglePrediction singlePrediction, FraudRepository fraudRepository) {
        this.estimatorConfig = estimatorConfig;
        this.singlePrediction = singlePrediction;
        this.fraudRepository = fraudRepository;
    }

    public DetectionResponse voting(GenerateDetectionRequest generateDetectionRequest) {
        long startVoteTime = System.currentTimeMillis();
        DetectionRequest detectionRequest = generateDetectionRequest.getDetectionRequest();
        List<Estimator> estimators = estimatorConfig.getEstimators();
//        List<Response> predictions = new ArrayList<>();
        Map<DetectionResponse, Integer> predictionsAndWeights = new HashMap<>();
        for (Estimator estimator : estimators) {
            URI estimatorRestUri = null;
            try {
                estimatorRestUri = new URI(estimator.getEstimatorURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            predictionsAndWeights.put(singlePrediction.getPrediction(detectionRequest, estimatorRestUri), estimator.getEstimatorWeight());
        }
        long endVoteTime = System.currentTimeMillis();
        long elapsedTime = endVoteTime - startVoteTime;
        System.out.println("Szinkron predikciós összidő: "+elapsedTime+" ms");
        DetectionResponse summaryzedResponse= predictionsEvaluate(predictionsAndWeights);
        String transactionId = detectionRequest.getTransactionId();
        Fraud predictedFraud = new Fraud();
        predictedFraud.setTransactionId(transactionId);
        predictedFraud.setPredictedValue(summaryzedResponse.getPrediction());
        predictedFraud.setPredicted(true);
        predictedFraud.setV1(detectionRequest.getV1());
        predictedFraud.setV2(detectionRequest.getV2());
        predictedFraud.setV3(detectionRequest.getV3());
        predictedFraud.setV4(detectionRequest.getV4());
        predictedFraud.setV5(detectionRequest.getV5());
        predictedFraud.setV6(detectionRequest.getV6());
        predictedFraud.setV7(detectionRequest.getV7());
        predictedFraud.setV8(detectionRequest.getV8());
        predictedFraud.setV9(detectionRequest.getV9());
        predictedFraud.setV10(detectionRequest.getV10());
        predictedFraud.setV11(detectionRequest.getV11());
        predictedFraud.setV12(detectionRequest.getV12());
        predictedFraud.setV13(detectionRequest.getV13());
        predictedFraud.setV14(detectionRequest.getV14());
        predictedFraud.setV15(detectionRequest.getV15());
        predictedFraud.setV16(detectionRequest.getV16());
        predictedFraud.setV17(detectionRequest.getV17());
        predictedFraud.setV18(detectionRequest.getV18());
        predictedFraud.setV19(detectionRequest.getV19());
        predictedFraud.setV20(detectionRequest.getV20());
        predictedFraud.setV21(detectionRequest.getV21());
        predictedFraud.setV22(detectionRequest.getV22());
        predictedFraud.setV23(detectionRequest.getV23());
        predictedFraud.setV24(detectionRequest.getV24());
        predictedFraud.setV25(detectionRequest.getV25());
        predictedFraud.setV26(detectionRequest.getV26());
        predictedFraud.setV27(detectionRequest.getV27());
        predictedFraud.setV28(detectionRequest.getV28());
        predictedFraud.setAmount(detectionRequest.getAmount());
        predictedFraud.setPositiveProbability(summaryzedResponse.getPositiveProbability());
        predictedFraud.setNegativeProbability(summaryzedResponse.getNegativeProbability());
        Integer status = generateDetectionRequest.getStatus();
        if (status != null) {
            predictedFraud.setObservedValue(status);
            predictedFraud.setObserved(true);
        }
        fraudRepository.save(predictedFraud);
        return summaryzedResponse;
    }

    private DetectionResponse predictionsEvaluate(Map<DetectionResponse, Integer> predictionsAndWeights) {
        DetectionResponse summaryzedResponse = new DetectionResponse();
        int noOKNumber = 0;
        int OKNumber = 0;
        double noOKProbability = 1;
        double OKProbability = 1;
        for (Map.Entry<DetectionResponse, Integer> entry : predictionsAndWeights.entrySet()) {
            if (entry.getKey().getPrediction() == 1) {
                noOKNumber += entry.getValue();
                noOKProbability *= entry.getKey().getPositiveProbability();
            } else {
                OKNumber += entry.getValue();
                OKProbability *= entry.getKey().getNegativeProbability();
            }
        }
        if (OKNumber > noOKNumber) {
            summaryzedResponse.setPrediction(0);
            summaryzedResponse.setNegativeProbability(OKProbability);
            summaryzedResponse.setPositiveProbability(1-OKProbability);
        } else if (OKNumber < noOKNumber) {
            summaryzedResponse.setPrediction(1);
            summaryzedResponse.setPositiveProbability(noOKProbability);
            summaryzedResponse.setNegativeProbability(1-noOKProbability);
        }
        return summaryzedResponse;
    }
}

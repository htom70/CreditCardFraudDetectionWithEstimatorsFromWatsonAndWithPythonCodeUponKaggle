package user.rendszerhaz.service;

import io.spring.guides.gs_producing_web_service.DetectionRequest;
import io.spring.guides.gs_producing_web_service.DetectionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import user.rendszerhaz.config.RestConfig;
import user.rendszerhaz.domain.ResponseFromEstimator;

import java.net.URI;
import java.util.*;

@Service
public class SinglePrediction {

    private RestConfig restConfig;
    private RestTemplate restTemplate;

    @Autowired
    public SinglePrediction(RestConfig restConfig) {
        restTemplate = restConfig.getRestTemplate(new RestTemplateBuilder());
    }

    public DetectionResponse getPrediction(DetectionRequest detectionRequest, URI estimatorURI) {
        Map<String, List<Number>> requestMap = new HashMap<>();
        List<Number> requestParameters = new ArrayList<>();
        requestParameters.add(detectionRequest.getTime());
        requestParameters.add(detectionRequest.getV1());
        requestParameters.add(detectionRequest.getV2());
        requestParameters.add(detectionRequest.getV3());
        requestParameters.add(detectionRequest.getV4());
        requestParameters.add(detectionRequest.getV5());
        requestParameters.add(detectionRequest.getV6());
        requestParameters.add(detectionRequest.getV7());
        requestParameters.add(detectionRequest.getV8());
        requestParameters.add(detectionRequest.getV9());
        requestParameters.add(detectionRequest.getV10());
        requestParameters.add(detectionRequest.getV11());
        requestParameters.add(detectionRequest.getV12());
        requestParameters.add(detectionRequest.getV13());
        requestParameters.add(detectionRequest.getV14());
        requestParameters.add(detectionRequest.getV15());
        requestParameters.add(detectionRequest.getV16());
        requestParameters.add(detectionRequest.getV17());
        requestParameters.add(detectionRequest.getV18());
        requestParameters.add(detectionRequest.getV19());
        requestParameters.add(detectionRequest.getV20());
        requestParameters.add(detectionRequest.getV21());
        requestParameters.add(detectionRequest.getV22());
        requestParameters.add(detectionRequest.getV23());
        requestParameters.add(detectionRequest.getV24());
        requestParameters.add(detectionRequest.getV25());
        requestParameters.add(detectionRequest.getV26());
        requestParameters.add(detectionRequest.getV27());
        requestParameters.add(detectionRequest.getV28());
        requestParameters.add(detectionRequest.getAmount());
        requestMap.put("values", requestParameters);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String,List<Number>>> httpEntity = new HttpEntity<>(requestMap, httpHeaders);
        ResponseEntity<ResponseFromEstimator> responseEntity = restTemplate.postForEntity(estimatorURI,  httpEntity, ResponseFromEstimator.class);
        ResponseFromEstimator responseFromEstimator = responseEntity.getBody();
        DetectionResponse detectionResponse = new DetectionResponse();
        detectionResponse.setPrediction(responseFromEstimator.getPrediction());
        detectionResponse.setNegativeProbability(responseFromEstimator.getNegativeProbability());
        detectionResponse.setPositiveProbability(responseFromEstimator.getPositiveProbability());
        return detectionResponse;
    }
}

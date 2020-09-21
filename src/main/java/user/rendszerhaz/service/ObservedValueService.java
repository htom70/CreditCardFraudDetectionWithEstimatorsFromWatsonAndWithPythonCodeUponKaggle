package user.rendszerhaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.rendszerhaz.domain.Fraud;
import user.rendszerhaz.repository.FraudRepository;

@Service
public class ObservedValueService {

    private FraudRepository fraudRepository;

    @Autowired
    public ObservedValueService(FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }

    public void saveObservedValue(String transactionId, int value) {
        Fraud fraud = fraudRepository.findByTransactionId(transactionId);
        fraud.setObservedValue(value);
        fraud.setObserved(true);
        fraudRepository.save(fraud);
    }
}

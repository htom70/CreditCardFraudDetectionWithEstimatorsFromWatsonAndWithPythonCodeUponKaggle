package user.rendszerhaz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import user.rendszerhaz.domain.Fraud;

import java.util.List;

@Repository
public interface FraudRepository extends CrudRepository<Fraud, Long> {

    public Fraud findByTransactionId(String id);

    @Query("select f from Fraud f where f.isObserved=true and f.isPredicted=true")
    public List<Fraud> findObservedAndPredictedFrauds();
}

package app.medrem.api.repository;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import app.medrem.api.model.Medicine;

public interface MedicineRepository extends MongoRepository<Medicine, String>  {

    public Medicine findByAccountNumber(String accountNumber);

    @DeleteQuery
    public void deleteByAccountNumber(String accountNumber);
}

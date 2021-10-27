package app.medrem.api.repository;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.medrem.api.entity.Water;
import java.lang.String;

@Repository
public interface WaterReminderRepository extends MongoRepository<Water, String> {

    public Water findByAccountNumber(String accountNumber);

    @DeleteQuery
    public void deleteByAccountNumber(String accountNumber);
}

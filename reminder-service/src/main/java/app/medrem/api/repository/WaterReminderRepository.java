package app.medrem.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import app.medrem.api.entity.WaterReminder;

@Repository
public interface WaterReminderRepository extends MongoRepository<WaterReminder, String> {

    public WaterReminder findByAccountNumber(String accountNumber);

    @Query(delete = true, value = "{'accountNumber': $0}")
    public void deleteByAccount(String accountNumber);
}

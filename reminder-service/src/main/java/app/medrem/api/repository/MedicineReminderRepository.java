package app.medrem.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.medrem.api.entity.MedicineReminder;

public interface MedicineReminderRepository extends MongoRepository<MedicineReminder, String>  {

    public MedicineReminder findByAccountNumber(String accountNumber);

    @Query(delete = true, value = "{'accountNumber': $0}")
    public void deleteByAccount(String accountNumber);
}

package app.medrem.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import app.medrem.api.entity.Medicine;

public interface MedicineRepository extends MongoRepository<Medicine, String>  {

}

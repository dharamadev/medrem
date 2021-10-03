package app.medrem.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import app.medrem.api.entity.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

	public Account findByContactNumber(String contactNumber);
	
	@Query(delete = true, value = "{'contactNumber': $0}")
	public Account deleteByContactNumber(String contactNumber);
}

package app.medrem.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import app.medrem.api.entity.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

	public Account findByAccountNumber(String accountNumber);
	
	@Query(delete = true, value = "{'accountNumber': $0}")
	public Account deleteByAccountNumber(String accountNumber);
}

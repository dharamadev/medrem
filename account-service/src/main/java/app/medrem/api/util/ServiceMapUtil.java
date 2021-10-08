package app.medrem.api.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

import app.medrem.api.entity.Account;

@Component
public class ServiceMapUtil {

	public Account updateAccountMap(Account account, Account updatedAccount) {
		
		return Optional.of(updatedAccount).map(a->{
			a.setFirstName(account.getFirstName());
			a.setLastName(account.getLastName());
			a.setEmail(account.getEmail());
//			a.setContactNumber(account.getContactNumber());
			return a;
		}).get();
	}
}


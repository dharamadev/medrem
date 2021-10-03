package app.medrem.api.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

import app.medrem.api.entity.Account;

@Component
public class ServiceMapUtil {

	public Account updateAccountMap(Account account, Account updatedAccount) {
		
		return Optional.of(updatedAccount).map(a->{
			a.setAddress(Optional.of(a.getAddress()).map(addr -> {
				addr.setLine1(account.getAddress().getLine1());
				addr.setLine2(account.getAddress().getLine2());
				addr.setLine3(account.getAddress().getLine3());
				addr.setCity(account.getAddress().getCity());
				addr.setState(account.getAddress().getState());
				addr.setCountry(account.getAddress().getCountry());
				addr.setPin(account.getAddress().getPin());
				return addr;
			}).get());
			a.setFirstName(account.getFirstName());
			a.setLastName(account.getLastName());
			a.setEmail(account.getEmail());
//			a.setContactNumber(account.getContactNumber());
			return a;
		}).get();
	}
}


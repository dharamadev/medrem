package app.medrem.api.service;

import app.medrem.api.model.Account;

public interface AccountService {

	public Account getAccount(String accountNumber);

	public Account createAccount(Account account);

	public Account updateAccount(Account account);

	public void deleteAccount(String accountNumber);

}

package app.medrem.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.medrem.api.model.Account;
import app.medrem.api.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccount(String accountNumber) {
	return this.accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Account createAccount(Account account) {
	account.setAccountNumber("MR" + account.getContactNumber());
	return this.accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
	return this.accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String accountNumber) {
	this.accountRepository.deleteByAccountNumber(accountNumber);
    }
}

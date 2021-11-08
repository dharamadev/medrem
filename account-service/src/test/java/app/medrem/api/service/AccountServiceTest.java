package app.medrem.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import app.medrem.api.model.Account;
import app.medrem.api.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountServiceImpl accountServiceImpl;

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void getAtccoutntTest() {
	when(this.accountRepository.findByAccountNumber(Mockito.anyString()))
		.then(a -> new Account("12we34567yt", null, null, null, null, null, null));

	assertNotNull(this.accountServiceImpl.getAccount("12we34567yt"));
	assertEquals(this.accountServiceImpl.getAccount("12we34567yt").getId(), new String("12we34567yt"));
    }

    @Test
    public void createtAccountTest() {
	when(this.accountRepository.save(Mockito.any()))
		.thenReturn(new Account("12we34567yt", null, null, null, null, null, null));

	assertNotNull(this.accountServiceImpl.createAccount(new Account()));
	assertEquals(this.accountServiceImpl.createAccount(new Account()).getId(), new String("12we34567yt"));
    }

    @Test
    public void updateAccount() {
	when(this.accountRepository.save(Mockito.any()))
		.thenReturn(new Account("12we34567yt", null, null, null, null, null, null));

	assertNotNull(this.accountServiceImpl.updateAccount(new Account()));
	assertEquals(this.accountServiceImpl.updateAccount(new Account()).getId(), new String("12we34567yt"));
    }

    @Test
    public void deleteAccount() {
	this.accountServiceImpl.deleteAccount(new String("12we34567yt"));
	verify(accountRepository, Mockito.times(1)).deleteByAccountNumber(new String("12we34567yt"));
    }
}

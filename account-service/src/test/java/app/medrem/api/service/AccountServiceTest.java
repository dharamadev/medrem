package app.medrem.api.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import app.medrem.api.entity.Account;
import app.medrem.api.repository.AccountRepository;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountServiceImpl accountServiceImpl;

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void getAccountTest() {
	when(this.accountRepository.findByAccountNumber(Mockito.anyString()))
		.then(a -> new Account("12we34567yt", null, null, null, null, null));

	assertNotNull(this.accountServiceImpl.getAccount("12we34567yt"));
	assertEquals(this.accountServiceImpl.getAccount("12we34567yt").getId(), new String("12we34567yt"));
    }
}

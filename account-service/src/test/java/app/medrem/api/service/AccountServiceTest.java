package app.medrem.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
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

	private static Account account;

	@BeforeAll
	static void init() {
		account = Account.builder().id("12we34567yt").firstName("Test").lastName("Test").gender("Test")
				.email("test@test.com").contactNumber("9999999999").accountNumber("MR9454318045").build();
	}

	@Test
	public void getAtccoutntTest() {
		when(this.accountRepository.findByAccountNumber(Mockito.anyString())).then(a -> account);

		assertNotNull(this.accountServiceImpl.getAccount("12we34567yt"));
		assertEquals(this.accountServiceImpl.getAccount("12we34567yt").getId(), new String("12we34567yt"));
	}

	@Test
	public void createtAccountTest() {
		when(this.accountRepository.save(Mockito.any())).thenReturn(account);

		assertNotNull(this.accountServiceImpl.createAccount(account));
		assertEquals(this.accountServiceImpl.createAccount(account).getId(), new String("12we34567yt"));
	}

	@Test
	public void updateAccountTest() {
		when(this.accountRepository.save(Mockito.any())).thenReturn(account);
		account.setFirstName("Test2");
		assertNotNull(this.accountServiceImpl.updateAccount(account));
		assertEquals(this.accountServiceImpl.updateAccount(account).getId(), new String("12we34567yt"));
	}

	@Test
	public void deleteAccountTest() {
		this.accountServiceImpl.deleteAccount(new String("12we34567yt"));
		verify(accountRepository, Mockito.times(1)).deleteByAccountNumber(new String("12we34567yt"));
	}
}

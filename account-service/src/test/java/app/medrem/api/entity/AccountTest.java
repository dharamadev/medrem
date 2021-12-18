package app.medrem.api.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import app.medrem.api.model.Account;

@ExtendWith(MockitoExtension.class)
class AccountTest {

    @Autowired
    private static Account account;

    @BeforeAll
    static void init() {
	account = Account.builder().id("12we34567yt").firstName("Test").lastName("Test").gender("Test")
		.email("test@test.com").contactNumber("9999999999").accountNumber("MR9454318045").build();
    }

    @Test
    void testGetters() {

	assertEquals(new String("12we34567yt"), account.getId());
	assertEquals(new String("Test"), account.getFirstName());
	assertEquals(new String("Test"), account.getLastName());
	assertEquals(new String("test@test.com"), account.getEmail());
	assertEquals(new String("9999999999"), account.getContactNumber());
	assertEquals(new String("MR9454318045"), account.getAccountNumber());

    }

    @Test
    void testSetters() {

	account.setId("12we34567yt");
	account.setFirstName("Test");
	account.setLastName("Test");
	account.setGender("Test");
	account.setEmail("test@test.com");
	account.setContactNumber("9999999999");
	account.setAccountNumber("MR9454318045");

	assertNotNull(account);
	assertEquals(account, Account.builder().id("12we34567yt").firstName("Test").lastName("Test").gender("Test")
		.email("test@test.com").contactNumber("9999999999").accountNumber("MR9454318045").build());
    }

    @Test
    void testHashCodeEquals() {

	Account account1 = Account.builder().id("12we34567yt").firstName("Test").lastName("Test").gender("Test")
		.email("test@test.com").contactNumber("9999999999").accountNumber("MR9454318045").build();
	assertNotNull(account);
	assertTrue(account.equals(account1));
	assertEquals(account.toString(), account1.toString());
	assertEquals(account.hashCode(), account1.hashCode());
	assertEquals(account.getId(), new String("12we34567yt"));
    }

}

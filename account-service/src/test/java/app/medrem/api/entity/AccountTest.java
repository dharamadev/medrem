package app.medrem.api.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountTest {

    @Test
    void testGetterSetter() {
	Account account = new Account();
	account.setId("12we34567yt");
	account.setFirstName("Test");
	account.setLastName("Test");
	account.setEmail("test@test.com");
	account.setContactNumber("123");
	account.setAccountNumber("Test");

	assertEquals(new String("12we34567yt"), account.getId());
	assertEquals(new String("Test"), account.getFirstName());
	assertEquals(new String("Test"), account.getLastName());
	assertEquals(new String("test@test.com"), account.getEmail());
	assertEquals(new String("123"), account.getContactNumber());
	assertEquals(new String("Test"), account.getAccountNumber());

    }

    @Test
    void testHashCodeEquals() {
	Account account1 = new Account("12we34567yt",null, null, null, null, null, null);

	boolean equalVerify = account1.equals(account1);

	assertNotNull(account1);
	assertTrue(equalVerify);
	assertEquals(account1.toString(), account1.toString());
	assertEquals(account1.hashCode(), account1.hashCode());
	assertEquals(account1.getId(), new String("12we34567yt"));
    }
}

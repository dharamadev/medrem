package app.medrem.api.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    void testGetterSetterHashCodeEquals() {
	Address address = new Address();
	boolean equalVerify = address.equals(address);
	
	address.setLine1("Test");
	address.setLine2("Test");
	address.setLine3("Test");
	address.setCountry("Test");
	address.setState(null);
	address.setCity(null);
	address.setPin(124356);
	
	assertEquals(address.getLine1(), new String("Test"));
	assertEquals(address.getLine2(), new String("Test"));
	assertEquals(address.getLine3(), new String("Test"));
	assertEquals(address.getCountry(), new String("Test"));
	assertEquals(address.getState(), null);
	assertEquals(address.getCity(), null);
	assertEquals(address.getPin(), 124356);
	assertTrue(equalVerify);
	assertEquals(address.hashCode(), address.hashCode());
	assertEquals(address.toString(), address.toString());
    }

}

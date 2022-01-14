package app.medrem.api.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ErrordtoTest {

	private static Errordto errordto;

	@BeforeAll
	static void init() {
		errordto = Errordto.builder().uri("Test").status(100).message("Test").time(LocalDateTime.of(1, 1, 1, 1, 1))
				.build();
	}

	@Test
	void testGetter() {
		assertNotNull(errordto);
		assertEquals(errordto.getMessage(), new String("Test"));
		assertEquals(errordto.getStatus(), 100);
		assertEquals(errordto.getTime(), LocalDateTime.of(1, 1, 1, 1, 1));
		assertEquals(errordto.getUri(), new String("Test"));
	}

	@Test
	void SetterTest() {
		errordto.setMessage("Test");
		errordto.setStatus(100);
		errordto.setTime(LocalDateTime.of(1, 1, 1, 1, 1));
		errordto.setUri("Test");
		assertNotNull(errordto);
		assertEquals(errordto, Errordto.builder().uri("Test").status(100).message("Test")
				.time(LocalDateTime.of(1, 1, 1, 1, 1)).build());
	}

	@Test
	void testHashCodeEquals() {
		Errordto errordto1 = Errordto.builder().uri("Test").status(100).message("Test")
				.time(LocalDateTime.of(1, 1, 1, 1, 1)).build();
		assertNotNull(errordto1);
		assertNotNull(errordto);
		assertTrue(errordto1.equals(errordto));
		assertEquals(errordto1.toString(), errordto.toString());
		assertEquals(errordto1.hashCode(), errordto.hashCode());
		assertEquals(errordto1, errordto);

	}
}

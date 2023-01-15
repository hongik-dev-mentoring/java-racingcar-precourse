package racingcar.util.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NameValidatorTest {

	@Test
	void string_trim_test() {
		String name = "   ";
		assertEquals(0, name.trim().length());
	}

}
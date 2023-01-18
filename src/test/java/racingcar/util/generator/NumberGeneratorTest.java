package racingcar.util.generator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

	@Test
	@DisplayName("시도할 횟수 생성 성공")
	void create_attempt_number_success() {
		int attemptNumber = NumberGenerator.generateNumber("5");
		assertEquals(attemptNumber, 5);
	}
	
}
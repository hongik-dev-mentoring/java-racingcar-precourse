package racingcar.util.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.util.generator.NumberGenerator;

class NumberValidatorTest {

	@Test
	@DisplayName("시도 횟수 생성 테스트")
	void create_attempt_number() {
		int attemptNumber = NumberGenerator.generateNumber("1");
		assertEquals(1, attemptNumber);
	}

	@ParameterizedTest(name = "시도 횟수 : {0}, 결과 : {1}")
	@DisplayName("시도 횟수 유효성 검사")
	@MethodSource("invalidAttemptNumber")
	void validate_attempt_number_success(String attemptNumber, String expectedResult) {
		assertThrows(IllegalArgumentException.class, () ->
			NumberGenerator.generateNumber(attemptNumber)
		);
	}

	static Stream<Arguments> invalidAttemptNumber() {
		return Stream.of(
			Arguments.arguments("a", "숫자가 아닌 문자 입력"),
			Arguments.arguments("-1", "1회 미만의 숫자 입력")
		);
	}

}
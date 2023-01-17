package racingcar.util.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.model.Car;

class NameValidatorTest {

	@Test
	void string_trim_test() {
		String name = "   ";
		assertEquals(0, name.trim().length());
	}

	private final Car car = new Car("chan");

	@Test
	@DisplayName("자동차 생성 테스트")
	void create_car() {
		assertAll(
			() -> assertNotNull(car),
			() -> assertEquals(car.getName(), "chan"),
			() -> assertEquals(car.getPosition(), 0)
		);
	}

	@ParameterizedTest(name = "자동차 이름 : {0}, 결과 : {1}")
	@DisplayName("자동차 이름 유효성 검사")
	@MethodSource("invalidCarNames")
	void validate_car_name(String carName, String expectedResult) {
		assertThrows(IllegalArgumentException.class, () ->
			new Car(carName)
		);
	}

	static Stream<Arguments> invalidCarNames() {
		return Stream.of(
			Arguments.of("euichan", "이름 5자 초과"),
			Arguments.of("", "1글자 미만"),
			Arguments.of(null, "null 입력"),
			Arguments.of("chan,,dong", "이름이 0자")
		);
	}

}
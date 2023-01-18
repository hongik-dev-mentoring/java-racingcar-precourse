package racingcar.util.generator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.model.Car;

class NameGeneratorTest {

	@Test
	@DisplayName("자동차 이름 생성 성공")
	void create_name_success() {
		List<String> carNameList = NameGenerator.generateCarNames("chan,dong,ho");
		assertEquals(3, carNameList.size());
	}

	@ParameterizedTest(name = "자동차 이름 : {0}, 결과 : {1}")
	@DisplayName("자동차 이름 생성 실패")
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
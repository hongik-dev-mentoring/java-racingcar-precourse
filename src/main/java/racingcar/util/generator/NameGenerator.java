package racingcar.util.generator;

import java.util.Arrays;
import java.util.List;

import racingcar.util.validator.NameValidator;

public class NameGenerator {
	private static final String SEPARATE_BY_COMMA = ",";

	public static List<String> generateCarNames(String carNames) {
		NameValidator.validateCarNames(carNames);
		List<String> carNamesList = Arrays.asList(carNames.split(SEPARATE_BY_COMMA));
		for (String carName : carNamesList) {
			NameValidator.validateCarName(carName);
		}
		return carNamesList;
	}
}

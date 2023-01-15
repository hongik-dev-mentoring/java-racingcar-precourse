package racingcar.util.generator;

import racingcar.util.validator.AttemptNumberValidator;

public class NumberGenerator {

	public static int generateNumber(String attemptNumber) {
		AttemptNumberValidator.validateNumber(attemptNumber);
		return Integer.parseInt(attemptNumber);
	}
}

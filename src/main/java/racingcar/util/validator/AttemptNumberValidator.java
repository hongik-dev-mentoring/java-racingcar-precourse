package racingcar.util.validator;

public class AttemptNumberValidator {

	private static final String MIN_ATTEMPT_NUMBER_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";
	private static final String ATTEMPT_NUMBER_IS_NOT_INTEGER = "시도 횟수는 숫자여야 한다.";

	public static void validateNumber(String attemptNumber) {
		/**
		 * 시도 횟수 예외처리
		 * 1. 1 미만의 숫자 입력했을 경우
		 * 2. 숫자를 입력하지 않았을 경우
		 */
		checkNumberIsNotInteger(attemptNumber);
		checkNumberRange(attemptNumber);
	}

	private static void checkNumberIsNotInteger(String attemptNumber) {
		try {
			Integer.parseInt(attemptNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_IS_NOT_INTEGER);
		}
	}

	private static void checkNumberRange(String attemptNumber) {
		int attemptNumberToInteger = Integer.parseInt(attemptNumber);
		if (attemptNumberToInteger < 1) {
			throw new IllegalArgumentException(MIN_ATTEMPT_NUMBER_MESSAGE);
		}
	}
}

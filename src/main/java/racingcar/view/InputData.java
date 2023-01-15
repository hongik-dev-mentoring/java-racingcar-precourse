package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputData {
	private static final String CAR_NAME_ALERT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String NUMBER_OF_ATTEMPT_ALERT_MESSAGE = "시도할 회수는 몇회인가요?";

	public static String getCarNames() {
		System.out.println(CAR_NAME_ALERT_MESSAGE);
		return Console.readLine();
	}

	public static String getAttemptNumbers() {
		System.out.println(NUMBER_OF_ATTEMPT_ALERT_MESSAGE);
		return Console.readLine();
	}
}

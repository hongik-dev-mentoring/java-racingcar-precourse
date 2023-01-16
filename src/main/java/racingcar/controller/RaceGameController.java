package racingcar.controller;

import java.util.List;

import racingcar.model.Cars;
import racingcar.util.generator.NameGenerator;
import racingcar.util.generator.NumberGenerator;
import racingcar.view.InputData;
import racingcar.view.OutputData;

public class RaceGameController {
	private Cars cars;
	private int attemptNumber;

	public void ready() {
		// 자동차 경주 게임 준비
		cars = new Cars();
		addCarNamesToCarList();
		attemptNumber = getAttemptNumber();
	}

	public void run() {
		// 자동차 경주 게임 시작
		OutputData.printBlankLine();
		OutputData.printGameResultHeader();
		moveCarsForwardByAttemptNumber();
	}

	public void announceWinner() {
		// 자동차 경주 게임 최종 우승자 발표
	}

	private void moveCarsForwardByAttemptNumber() {
		for (int i = 0; i < attemptNumber; ++i) {
			cars.moveForward();
			OutputData.printCarsPosition(cars.getCarList());
		}
	}

	private void addCarNamesToCarList() {
		try {
			List<String> carNamesList = NameGenerator.generateCarNames(InputData.getCarNames());
			cars.addCarNames(carNamesList);
		} catch (IllegalArgumentException e) {
			OutputData.printErrorMessage(e.getMessage()); // [ERROR] + 메시지 출력
			addCarNamesToCarList();
		}
	}

	private int getAttemptNumber() {
		try {
			return NumberGenerator.generateNumber(InputData.getAttemptNumber());
		} catch (IllegalArgumentException e) {
			OutputData.printErrorMessage(e.getMessage());
			return getAttemptNumber();
		}
	}
}

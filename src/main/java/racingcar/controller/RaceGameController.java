package racingcar.controller;

import java.util.List;

import racingcar.model.Cars;
import racingcar.util.generator.NameGenerator;
import racingcar.util.generator.NumberGenerator;
import racingcar.view.InputData;
import racingcar.view.OutputData;

public class RaceGameController {
	private Cars cars;
	private int AttemptNumbers;

	public void ready() {
		cars = new Cars();
		addCarNamesToCarList();
		getAttemptNumbers();
	}

	public void run() {
		OutputData.printBlankLine();
		OutputData.printGameResultHeader();
	}

	public void announceWinner() {

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

	private void getAttemptNumbers() {
		try {
			int attemptNumber = NumberGenerator.generateNumber(InputData.getAttemptNumber());
		} catch (IllegalArgumentException e) {
			OutputData.printErrorMessage(e.getMessage());
			getAttemptNumbers();
		}
	}
}

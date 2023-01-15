package racingcar.controller;

import java.util.List;

import racingcar.model.Cars;
import racingcar.util.generator.NameGenerator;
import racingcar.view.InputData;
import racingcar.view.OutputData;

public class RaceGameController {
	private Cars cars;
	private int AttemptNumbers;

	public void ready() {
		cars = new Cars();
		addCarNamesToCarList();
	}

	public void run() {

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

}

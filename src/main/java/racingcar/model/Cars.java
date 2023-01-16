package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import racingcar.util.validator.NameValidator;

public class Cars {
	private List<Car> carList = new ArrayList<>();

	public void addCarNames(List<String> carNamesList) {
		NameValidator.validateCarNames(carNamesList.toString());
		for (String carName : carNamesList) {
			NameValidator.validateCarName(carName);
			this.carList.add(new Car(carName));
		}
	}

}

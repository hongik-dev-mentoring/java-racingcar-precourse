package racingcar.model;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
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

	public List<Car> getCarList() {
		return carList.stream()
			.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

	public List<String> findWinnersName() {
		return carList.stream()
			.filter(car -> car.isWinner(findMaxPosition()))
			.map(Car::getName)
			.collect(toList());
	}

	private int findMaxPosition() {
		return carList.stream()
			.map(car -> car.getPosition())
			.max(Integer::compare)
			.orElse(0);
	}
}

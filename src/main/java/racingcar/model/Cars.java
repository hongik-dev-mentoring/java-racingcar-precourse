package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private List<Car> carList = new ArrayList<>();

	public void addCarNames(List<String> carNamesList) {
		for (String carName : carNamesList) {
			this.carList.add(new Car(carName));
		}
	}
	
}

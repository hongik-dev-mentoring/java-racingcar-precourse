package racingcar;

import java.util.List;

public class Race {

	private final List<Car> cars;

	public Race(List<Car> cars) {
		this.cars = cars;
	}

	public void proceed() {
		for (Car car : cars) {
			car.go();
		}
	}

	public void print() {
		for (Car car : cars) {
			car.printPosition();
		}
	}
}

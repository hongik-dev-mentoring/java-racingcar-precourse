package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private final List<Car> cars;

	private final List<Car> winners = new ArrayList<>();

	public Race(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> selectWinners() {
		int maxPosition = -1;
		for (Car car : cars) {
			int position = car.getPosition();
			if (maxPosition < position) {
				maxPosition = position;
			}
		}
		for (Car car : cars) {
			int position = car.getPosition();
			if (maxPosition == position) {
				winners.add(car);
			}
		}
		return winners;
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


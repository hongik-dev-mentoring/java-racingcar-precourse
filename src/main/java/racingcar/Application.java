package racingcar;

import java.util.*;

public class Application {
	public static void main(String[] args) {

		List<Car> cars = InputProcess.getCarList();
		Integer moves = InputProcess.getNumberOfMoves();

		Race race = new Race(cars, moves);
		race.start();
		race.printWinners();

	}
}

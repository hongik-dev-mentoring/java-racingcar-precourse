package racingcar;

import java.util.*;

public class Application {
	public static void main(String[] args) {

		List<Car> cars = InputProcess.getCarList();
//		System.out.println("cars = " + cars);

		Integer moves = InputProcess.getNumberOfMoves();
//		System.out.println("moves = " + moves);

		Race race = new Race(cars, moves);
		race.start();
		race.selectWinners();

	}
}

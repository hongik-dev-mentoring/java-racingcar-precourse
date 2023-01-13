package racingcar;

import java.util.*;

public class Application {
	public static void main(String[] args) {

		List<Car> cars = InputProcess.getCarList();
//		System.out.println("cars = " + cars);

		Integer moves = InputProcess.getNumberOfMoves();
//		System.out.println("moves = " + moves);

		Race race = new Race(cars);
		System.out.println("실행결과");
		for (int i = 0; i < moves; i++) {
			race.proceed();
			race.print();
			System.out.println();
		}

	}
}

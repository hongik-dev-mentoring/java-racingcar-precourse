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

		List<Car> winners = race.selectWinners();
		StringBuilder sb = new StringBuilder("최종 우승자 : ");
		for (int i = 0; i < winners.size(); i++) {
			sb.append(winners.get(i).getName());
			if (i != winners.size() - 1) {
				sb.append(", ");
			}
		}
		System.out.println(sb);
	}
}

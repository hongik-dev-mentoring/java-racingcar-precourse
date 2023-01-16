package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
	private ArrayList<Car> cars = new ArrayList<Car>();
	private List<Car> SortedCars;
	private int TryNum;
	private int carNum;

	public Game() {
		ArrayList<String> StringInput = Input.ReadCarName();
		TryNum = Input.ReadTryNum();
		setCars(StringInput);
		carNum = cars.size();

		System.out.println("실행 결과");
		Play();
		finalWin();
	}

	private void Play() {
		for (int i = 0; i < TryNum; i++) {
			Round();
			SortCars();
			Score();
		}
	}

	private void SortCars() {
		SortedCars = cars.stream()
			.sorted(Comparator.comparing(Car::getPosition).reversed())
			.collect(Collectors.toList());
	}

	private void Score() {
		Car maxCar = SortedCars.get(0);
		maxCar.increaseWinNum();
		int max = maxCar.getPosition();

		handleRoundCoWinner(max);
	}

	private void handleRoundCoWinner(int max) {
		for (int i = 1; i < carNum; i++) {
			Car c1 = SortedCars.get(i);
			if (c1.getPosition() != max) {
				break;
			}
			c1.increaseWinNum();
		}
	}

	private void Round() {
		for (Car c1 : cars) {
			c1.Race(TryNum);
			Output.printRound(c1);
		}
		System.out.println();
	}

	private void setCars(ArrayList<String> input) {
		for (int i = 0; i < input.size(); i++) {
			cars.add(new Car(input.get(i)));
		}
	}

	private void finalWin() {
		Collections.sort(cars, (c1, c2) -> c2.getWinNum() - c1.getWinNum());
		Car maxCar = cars.get(0);
		int max = maxCar.getWinNum();
		System.out.print("최종 우승자 : " + maxCar.getName());
		handleFinalCoWinner(max);
		System.out.println();
	}

	private void handleFinalCoWinner(int max) {
		for (int i = 1; i < carNum; i++) {
			Car c1 = cars.get(i);
			if (c1.getWinNum() != max) {
				break;
			}
			System.out.print(", " + c1.getName());
		}
	}
}

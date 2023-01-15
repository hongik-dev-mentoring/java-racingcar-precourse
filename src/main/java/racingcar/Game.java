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

	public void Play() {
		for (int i = 0; i < TryNum; i++) {
			Round();
			SortCars();
			Score();
		}
	}

	public void SortCars() {
		SortedCars = cars.stream()
			.sorted(Comparator.comparing(Car::getPosition).reversed())
			.collect(Collectors.toList());
	}

	public void Score() {
		Car maxCar = SortedCars.get(0);
		maxCar.increaseWinNum();
		int max = maxCar.getPosition();

		for (int i = 1; i < carNum; i++) {
			Car c1 = SortedCars.get(i);
			if (c1.getPosition() != max) {
				break;
			}
			c1.increaseWinNum();
		}
	}

	public void Round() {
		for (Car c1 : cars) {
			c1.Race(TryNum);
			Output.printRound(c1);
		}
		System.out.println();
	}

	public void setCars(ArrayList<String> input) {
		for (int i = 0; i < input.size(); i++) {
			cars.add(new Car(input.get(i)));
		}
	}

	public void finalWin() {
		Collections.sort(cars, (c1, c2) -> c2.getWinNum() - c1.getWinNum());
		Car maxCar = cars.get(0);
		int max = maxCar.getWinNum();
		System.out.print("최종 우승자 : " + maxCar.getName());
		for (int i = 1; i < carNum; i++) {
			Car c1 = cars.get(i);
			if (c1.getWinNum() != max) {
				break;
			}
			System.out.print(", " + c1.getName());
		}
		System.out.println();
	}
}

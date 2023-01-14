package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private final List<Car> cars;

	private final Integer moves;

	private final List<Car> winners = new ArrayList<>();

	public Race(List<Car> cars, Integer moves) {
		this.cars = cars;
		this.moves = moves;
	}

	public void start() {
		System.out.println("실행결과");
		for (int i = 0; i < moves; i++) {
			this.proceed();
			this.print();
			System.out.println();
		}
	}

	public void selectWinners() {
		int maxPosition = getMaxPosition();
		addCarsAtMaxPosition(maxPosition);
		StringBuilder sb = new StringBuilder("최종 우승자 : ");
		for (int i = 0; i < winners.size(); i++) {
			sb.append(winners.get(i).getName());
			if (i != winners.size() - 1) {
				sb.append(", ");
			}
		}
		System.out.println(sb);
	}

	private void addCarsAtMaxPosition(int maxPosition) {
		for (Car car : cars) {
			int position = car.getPosition();
			if (maxPosition == position) {
				winners.add(car);
			}
		}
	}

	private int getMaxPosition() {
		int maxPosition = -1;
		for (Car car : cars) {
			int position = car.getPosition();
			if (maxPosition < position) {
				maxPosition = position;
			}
		}
		return maxPosition;
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


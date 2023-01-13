package racingcar;

import java.util.*;

public class Application {
	public static void main(String[] args) {
		// input 단계
		List<Car> cars = InputProcess.getCarList();
		System.out.println("cars = " + cars);

	}
}

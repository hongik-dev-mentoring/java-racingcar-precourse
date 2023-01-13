package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputProcess {

	private static final String errorTag = "[ERROR] ";

	private static List<Car> carList;

	public static List<Car> getCarList() {
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String readLine = Console.readLine(); // CarName 추출 - 5자 이하만 가능
			String[] splitedStrings = readLine.split(",");
			carList = new ArrayList<>();
			for (String s : splitedStrings) {
				String carName = s.trim();
				if (carName.length() > 5) {
					StringBuilder sb = new StringBuilder();
					String errorMessage = sb.append(errorTag)
							.append("자동차 이름은 5자 이하만 가능합니다. ")
							.append(carName)
							.append("은 자동차 이름이 될 수 없습니다.")
							.toString();
					throw (new IllegalArgumentException(errorMessage));
				}
				carList.add(new Car(carName));
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getCarList();
		}
		return new ArrayList<>(carList); // clone, 복사해서 리턴해야 함
	}

}

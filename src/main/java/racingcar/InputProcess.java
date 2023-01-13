package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputProcess {

	private static final String errorTag = "[ERROR] ";

	private static List<Car> carList;

	private static Integer numberOfMoves;

	public static List<Car> getCarList() {
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String readLine = Console.readLine();
			createCarListFromInputString(readLine);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getCarList();
		}
		return new ArrayList<>(carList);
	}

	private static void createCarListFromInputString(String input) {
		String[] splitedStrings = input.split(",");
		carList = new ArrayList<>();
		for (String s : splitedStrings) {
			String carName = s.trim();
			checkStringLengthLimit(carName);
			carList.add(new Car(carName));
		}
	}

	private static void checkStringLengthLimit(String carName) {
		if (carName.length() > 5) {
			StringBuilder sb = new StringBuilder();
			String errorMessage = sb.append(errorTag).append("자동차 이름은 5자 이하만 가능합니다. ")
					.append(carName).append("은 자동차 이름이 될 수 없습니다.").toString();
			throw (new IllegalArgumentException(errorMessage));
		}
	}

	public static Integer getNumberOfMoves() {
		try {
			System.out.println("시도할 회수는 몇회인가요?");
			String inputString = Console.readLine();
			checkStringContainsOnlyNumber(inputString);
			numberOfMoves = Integer.parseInt(inputString);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getNumberOfMoves();
		}
		return numberOfMoves;
	}

	private static void checkStringContainsOnlyNumber(String inputString) {
		for (char c : inputString.toCharArray()) {
			if (!Character.isDigit(c)) {
				StringBuilder sb = new StringBuilder();
				String errorMessage = sb.append(errorTag).append("이동횟수는 숫자만 입력할 수 있습니다.")
						.append(inputString).append("는 숫자가 아닙니다.").toString();
				throw new IllegalArgumentException(errorMessage);
			}
		}
	}

}

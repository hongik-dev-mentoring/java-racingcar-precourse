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
		List<String> carNames = splitAndTrimInputString(input);
		checkSameStringExists(carNames);
		carList = new ArrayList<>();
		for (String name : carNames) {
			carList.add(new Car(name));
		}
	}

	private static List<String> splitAndTrimInputString(String input) {
		String[] splitedStrings = input.split(",");
		List<String> results = new ArrayList<>();
		for (String s : splitedStrings) {
			String carName = s.trim();
			if (carName.isEmpty()) continue;
			checkStringLengthLimit(carName);
			results.add(carName);
		}
		return results;
	}

	private static void checkSameStringExists(List<String> strings) {
		if (sameStringExists(strings)) {
			StringBuilder sb = new StringBuilder();
			sb.append(errorTag).append("중복된 자동차 이름이 존재합니다.");
			throw (new IllegalArgumentException(sb.toString()));
		}
	}

	private static boolean sameStringExists(List<String> strings) {
		HashSet<String> hashSet = new HashSet<>(strings);
		return strings.size() != hashSet.size();
	}

	private static void checkStringLengthLimit(String carName) {
		if (carName.length() > 5) {
			StringBuilder sb = new StringBuilder();
			sb.append(errorTag).append("자동차 이름은 5자 이하만 가능합니다. ")
					.append(carName).append("은 자동차 이름이 될 수 없습니다.");
			throw (new IllegalArgumentException(sb.toString()));
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
				sb.append(errorTag).append("이동횟수는 숫자만 입력할 수 있습니다.")
						.append(inputString).append("는 숫자가 아닙니다.");
				throw new IllegalArgumentException(sb.toString());
			}
		}
	}

}

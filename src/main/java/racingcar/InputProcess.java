package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputProcess {

	private List<Car> carList;

	private Integer numberOfMoves;

	public List<Car> getCarList() {
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

	private void createCarListFromInputString(String input) {
		List<String> carNames = splitAndTrimInputString(input);
		checkSameStringExists(carNames);
		carList = new ArrayList<>();
		for (String name : carNames) {
			carList.add(new Car(name));
		}
	}

	private List<String> splitAndTrimInputString(String input) {
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

	private void checkSameStringExists(List<String> strings) {
		if (sameStringExists(strings)) {
			throw (new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 존재합니다."));
		}
	}

	private boolean sameStringExists(List<String> strings) {
		HashSet<String> hashSet = new HashSet<>(strings);
		return strings.size() != hashSet.size();
	}

	private void checkStringLengthLimit(String carName) {
		if (carName.length() > 5) {
			throw (new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다."));
		}
	}

	public Integer getNumberOfMoves() {
		try {
			System.out.println("시도할 회수는 몇회인가요?");
			String inputString = Console.readLine();
			numberOfMoves = Integer.parseInt(inputString);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 이동횟수는 숫자만 입력할 수 있습니다.");
			getNumberOfMoves();
		}
		return numberOfMoves;
	}

}
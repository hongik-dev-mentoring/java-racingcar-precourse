package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.message.ConsoleMessage.*;
import static racingcar.message.ErrorMessage.*;

public class InputProcess {

    private List<Car> carList;

    private Integer numberOfMoves;

    public List<Car> getCarList() {
        try {
            System.out.println(INPUT_CAR_NAMES);
            String readLine = Console.readLine();
            createCarListFromInputString(readLine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getCarList();
        }
        return carList;
    }

    private void createCarListFromInputString(String input) {
        List<String> carNames = splitAndTrimInputString(input);
        checkOnlyOneCarExists(carNames);
        checkSameStringExists(carNames);
        carList = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private void checkOnlyOneCarExists(List<String> cars) {
        if (cars.size() == 1) {
            throw new IllegalArgumentException(NOT_ENOUGH_CARS.toString());
        }
    }

    private List<String> splitAndTrimInputString(String input) {
        String[] names = input.split(",");
        List<String> results = new ArrayList<>(); //
        for (String s : names) {
            String carName = s.trim();
            checkStringLengthLimit(carName);
            results.add(carName);
        }
        return results;
    }

    private void checkSameStringExists(List<String> strings) {
        HashSet<String> hashSet = new HashSet<>(strings);
        if (strings.size() != hashSet.size()) {
            throw (new IllegalArgumentException(DUPLICATED_NAMES.toString()));
        }
    }

    private void checkStringLengthLimit(String carName) {
        if (carName.length() > 5 || carName.isEmpty()) {
            throw (new IllegalArgumentException(NOT_PROPER_NAME_LENGTH.toString()));
        }
    }

    public Integer getMoveCount() {
        try {
            System.out.println(INPUT_MOVE_COUNT);
            String input = Console.readLine();
            checkInputIsNumber(input);
            checkInputIsMoreThanOne(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getMoveCount();
        }
        return numberOfMoves;
    }

    private void checkInputIsNumber(String input) {
        try {
            numberOfMoves = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER.toString());
        }
    }

    private void checkInputIsMoreThanOne(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException(INPUT_IS_NOT_ALLOWED_UNDER_ONE.toString());
        }
    }

}

package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public List<String> getCarNamesList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getCarNamesString();
    }

    public int getRacingGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return getGameCountString();
    }

    private List<String> getCarNamesString() {
        try {
            return inputCarNamesString();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getCarNamesString();
        }
    }

    private List<String> inputCarNamesString() {
        String inputString = Console.readLine();
        List<String> carNames = Arrays.stream(inputString.split(","))
            .map(Input::getTrimString)
            .collect(Collectors.toList());
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 입력하세요.");
        }
        return carNames;
    }

    private static String getTrimString(String string) {
        String trimString = string.trim();
        if (trimString.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에 공란이 있습니다. 다시 입력해주세요.");
        }
        if (trimString.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 최대 5자 입니다. 다시 입력해주세요.");
        }
        return trimString;
    }


    private int getGameCountString() {
        try {
            return inputGameCountString();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return getGameCountString();
        }
    }

    private int inputGameCountString() {
        String inputString = Console.readLine();
        String gameCountString = inputString.trim();
        if (gameCountString.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수를 입력하세요.");
        }
        try {
            return parseGameCount(gameCountString);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return inputGameCountString();
        }
    }

    private int parseGameCount(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수를 입력하세요.");
        }
    }
}

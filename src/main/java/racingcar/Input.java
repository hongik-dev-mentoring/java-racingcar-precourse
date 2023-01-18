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
}

package racingcar;

import java.util.List;

public class CarRacingController {

    private CarRacingController() {
        throw new AssertionError();
    }

    public static void initCarRacingGame() {
        Input input = new Input();
        List<String> carNamesList = input.getCarNamesList();
        int raceGameCount = input.getRacingGameCount();

        CarRacingService.getInstance().carRacingGame(carNamesList, raceGameCount);
    }
}

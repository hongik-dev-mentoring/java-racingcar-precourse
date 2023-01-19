package racingcar;

import static racingcar.CarFactory.getCars;

import java.util.List;

public class CarRacingController {

    public static void initCarRacingGame() {
        Input input = new Input();
        List<String> carNamesList = input.getCarNamesList();
        int raceGameCount = input.getRacingGameCount();

        CarRacingService.getInstance().carRacingGame(carNamesList, raceGameCount);
    }
}

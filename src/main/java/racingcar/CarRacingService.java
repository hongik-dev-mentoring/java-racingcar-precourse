package racingcar;

import static racingcar.CarFactory.getCars;

import java.util.List;

public class CarRacingService {

    private static final CarRacingService INSTANCE = new CarRacingService();

    private CarRacingService() {
    }

    public static CarRacingService getInstance() {
        return INSTANCE;
    }

    public void carRacingGame(List<String> carNamesList, int raceGameCount) {
        NumberPicker rangedRandomNumberPicker = new RangedRandomNumberPicker(0, 9);
        List<Car> cars = getCars(carNamesList, rangedRandomNumberPicker);

        Racing racing = new Racing(cars, raceGameCount);
        racing.race();
    }
}

package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingService {

    private static final CarRacingService INSTANCE = new CarRacingService();

    private CarRacingService() {
    }

    public static CarRacingService getInstance() {
        return INSTANCE;
    }

    public void carRacingGame(List<String> carNamesList, int raceGameCount,
        NumberPicker numberPicker) {
        List<Car> cars = getCars(carNamesList, numberPicker);
        Racing racing = new Racing(cars, raceGameCount);
        racing.race();
    }

    private List<Car> getCars(List<String> carNamesList, NumberPicker numberPicker) {
        return carNamesList.stream()
            .map(name -> new Car(name, numberPicker))
            .collect(Collectors.toList());
    }
}

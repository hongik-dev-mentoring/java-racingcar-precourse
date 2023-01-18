package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {

    }

    public static List<Car> getCars(List<String> carNamesList, NumberPicker numberPicker) {
        return carNamesList.stream()
            .map(name -> new Car(name, numberPicker))
            .collect(Collectors.toList());
    }
}

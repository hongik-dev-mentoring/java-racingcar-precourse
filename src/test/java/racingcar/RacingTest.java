package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    void 레이싱_테스트() {
        NumberPicker numberPicker = new RangedRandomNumberPicker(0, 9);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("jinho", numberPicker));
        cars.add(new Car("jinho2", numberPicker));
        cars.add(new Car("jinho3", numberPicker));
        cars.add(new Car("jinho4", numberPicker));
        cars.add(new Car("jinho5", numberPicker));

        Racing racing = new Racing(cars, 10);
        racing.race();
    }
}

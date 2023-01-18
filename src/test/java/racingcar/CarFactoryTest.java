package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.CarFactory.getCars;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @Test
    void 자동차_진행_불가_범위_진행() {
        NumberPicker numberPicker = new RangedRandomNumberPicker(0, 9);
        List<String> carNameList = new ArrayList<>();
        carNameList.add("jinho0");
        carNameList.add("jinho1");
        carNameList.add("jinho2");
        carNameList.add("jinho3");

        List<Car> cars = getCars(carNameList, numberPicker);
        assertThat(cars.get(0).getName()).isEqualTo("jinho0");
        assertThat(cars.get(1).getName()).isEqualTo("jinho1");
        assertThat(cars.get(2).getName()).isEqualTo("jinho2");
        assertThat(cars.get(3).getName()).isEqualTo("jinho3");
    }
}

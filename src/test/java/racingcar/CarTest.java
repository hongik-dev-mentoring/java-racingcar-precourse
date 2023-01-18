package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class CarTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    void 자동차_진행_불가_범위_진행() {
        Car car = new Car("jinho", new RangedRandomNumberPicker(0, 3));

        car.race();
        car.race();
        car.race();
        car.race();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_진행_불가_범위_출력() {
        String name = "jinho";
        Car car = new Car(name, new RangedRandomNumberPicker(0, 3));

        car.race();
        car.race();
        car.race();
        car.race();

        System.setOut(new PrintStream(output));

        car.printPosition();
        assertThat(output.toString().trim()).isEqualTo(name + " :");

        System.setOut(System.out);
        output.reset();
    }

    @Test
    void 자동차_진행_가능_범위() {
        Car car = new Car("jinho", new RangedRandomNumberPicker(4, 9));
        assertThat(car.getPosition()).isEqualTo(0);

        car.race();
        assertThat(car.getPosition()).isEqualTo(1);
        car.race();
        assertThat(car.getPosition()).isEqualTo(2);
        car.race();
        assertThat(car.getPosition()).isEqualTo(3);
        car.race();
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @Test
    void 자동차_진행_가능_범위_출력() {
        String name = "jinho";
        Car car = new Car(name, new RangedRandomNumberPicker(4, 9));

        car.race();
        car.race();
        car.race();
        car.race();

        System.setOut(new PrintStream(output));

        car.printPosition();
        assertThat(output.toString().trim()).isEqualTo(name + " : ----");

        System.setOut(System.out);
        output.reset();
    }
}

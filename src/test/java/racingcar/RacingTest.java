package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    void 레이싱_테스트() {
        NumberPicker moveNumberPicker = new RangedRandomNumberPicker(4, 9);
        NumberPicker stopNumberPicker = new RangedRandomNumberPicker(0, 3);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("jinho1", moveNumberPicker));
        cars.add(new Car("jinho2", stopNumberPicker));

        Racing racing = new Racing(cars, 3);

        System.setOut(new PrintStream(output));

        racing.race();
        String printString = output.toString();

        output.reset();

        System.out.println("실행 결과");
        System.out.println("jinho1 : -");
        System.out.println("jinho2 : ");
        System.out.println();

        System.out.println("jinho1 : --");
        System.out.println("jinho2 : ");
        System.out.println();

        System.out.println("jinho1 : ---");
        System.out.println("jinho2 : ");
        System.out.println();

        StringBuilder str = new StringBuilder("최종 우승자 : jinho1, ");
        str.setLength(str.length() - 2);
        System.out.println(str);

        assertThat(output.toString()).isEqualTo(printString);
        System.setOut(System.out);
        output.reset();
    }
}

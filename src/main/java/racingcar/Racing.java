package racingcar;

import java.util.Comparator;
import java.util.List;

public class Racing {

    public final List<Car> cars;
    private int gameCount;
    private final StringBuilder winnerString;

    public Racing(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
        winnerString = new StringBuilder("최종 우승자 : ");
    }

    public void race() {
        System.out.println("실행 결과");
        while (checkLeftRacing()) {
            gameCount--;
            raceAllCar();
        }
    }

    private boolean checkLeftRacing() {
        return gameCount > 0;
    }

    private void raceAllCar() {
        cars.forEach(Car::race);
    }
}

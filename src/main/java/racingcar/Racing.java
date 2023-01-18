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
            printResult();
        }
        printWinner();
    }

    private boolean checkLeftRacing() {
        return gameCount > 0;
    }

    private void raceAllCar() {
        cars.forEach(Car::race);
    }

    private void printResult() {
        cars.forEach(Car::printPosition);
        System.out.println();
    }

    private void printWinner() {
        int leadCarPosition = getLeadCarPosition();
        buildWinnerString(leadCarPosition);
        System.out.println(winnerString);
    }

    private int getLeadCarPosition() {
        Car leadCar = cars.stream()
            .max(Comparator.comparing(Car::getPosition))
            .get();
        return leadCar.getPosition();
    }

    private void buildWinnerString(int leadCarPosition) {
        cars.forEach(car -> {
            if (car.getPosition() == leadCarPosition) {
                winnerString.append(car.getName()).append(", ");
            }
        });
        winnerString.setLength(winnerString.length() - 2);
    }
}

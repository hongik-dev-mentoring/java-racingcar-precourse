package racingcar;

public class Car {

    private final String name;
    private int position;
    private NumberPicker randoms;

    public Car(String name, NumberPicker randoms) {
        this.name = name;
        position = 0;
        this.randoms = randoms;
    }

    public void race() {
        if (!checkCanMoveForward()) {
            return;
        }
        position += 1;
    }

    private boolean checkCanMoveForward() {
        int randomNumber = randoms.pickNumber();
        return randomNumber >= 4;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
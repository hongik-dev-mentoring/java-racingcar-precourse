package racingcar;

public class Car {

    private final String name;
    private int position;
    private final NumberPicker numberPicker;
    private final StringBuilder currentPositionString;

    public Car(String name, NumberPicker randoms) {
        this.name = name;
        position = 0;
        currentPositionString = new StringBuilder(name);
        currentPositionString.append(" : ");
        this.numberPicker = randoms;
    }

    public void race() {
        if (!checkCanMoveForward()) {
            return;
        }
        position += 1;
        currentPositionString.append('-');
    }

    private boolean checkCanMoveForward() {
        int randomNumber = numberPicker.pickNumber();
        return randomNumber >= 4;
    }

    public void printPosition() {
        System.out.println(currentPositionString);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.validator.NameValidator;

public class Car {
	private final String name;
	private int position = 0;
	private final static int START_RANDOM_NUMBER = 0;
	private final static int END_RANDOM_NUMBER = 9;

	public Car(String name) {
		this.name = name;
		NameValidator.validateCarName(name);
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void moveForward() {
		int randomNumber = Randoms.pickNumberInRange(START_RANDOM_NUMBER, END_RANDOM_NUMBER);
		if (shouldMove(randomNumber)) {
			this.position++;
		}
	}

	public boolean shouldMove(int randomNumber) {
		if (randomNumber >= 4) {
			return true;
		}
		return false;
	}

	public boolean isWinner(int maxPosition) {
		if (this.getPosition() == maxPosition) {
			return true;
		}
		return false;
	}
}

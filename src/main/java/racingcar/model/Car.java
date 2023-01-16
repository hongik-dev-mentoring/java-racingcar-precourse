package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.validator.NameValidator;

public class Car {
	private final String name;
	private int position = 0;

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
		int randomNumber = Randoms.pickNumberInRange(0, 9);
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

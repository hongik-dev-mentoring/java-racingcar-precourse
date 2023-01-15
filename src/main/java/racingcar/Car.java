package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;
	private int positionBase = 0;
	private int winNum = 0;

	public Car(String name) {
		this.name = name;
	}

	public void Race(int num) {
		positionBase = position;//변하기전 위치 기억
		for (int i = 0; i < num; i++) {
			position += MoveOrNot();
		}
	}

	public int MoveOrNot() {
		if (Randoms.pickNumberInRange(0, 9) >= 4)
			return 1;
		return 0;
	}

	public int getPosition() {
		return position - positionBase;//전체 위치가 아닌 한라운드당 위차 계산
	}

	public String getName() {
		return name;
	}

	public void increaseWinNum() {
		winNum++;
	}

	public int getWinNum() {
		return winNum;
	}
}

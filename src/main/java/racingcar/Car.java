package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void go() {
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (randomNumber >= 4) {
			this.position++;
		}
	}

	public void printPosition() {
		StringBuilder sb = new StringBuilder(name);
		sb.append(" : ");
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		System.out.println(sb);
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}
}

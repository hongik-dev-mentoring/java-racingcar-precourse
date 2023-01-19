package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RangedRandomNumberPicker implements NumberPicker {

    private final int start, end;

    public RangedRandomNumberPicker(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(start, end);
    }
}

package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void Race(int num){
        for(int i = 0; i < num; i++){
            position += MoveOrNot();
        }
    }

    public int MoveOrNot(){
        if(Randoms.pickNumberInRange(0,9) >= 4) return 1;
        return 0;
    }

    public int getPosition(){
        return position;
    }
}

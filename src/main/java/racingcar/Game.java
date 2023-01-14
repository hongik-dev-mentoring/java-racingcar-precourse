package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int TryNum;
    private int carNum;

    public Game(){
        ArrayList<String> StringInput = Input.ReadCarName();
        TryNum = Input.ReadTryNum();
        setCars(StringInput);
        Play();
    }

    public void Play(){
        for(int i = 0; i <TryNum; i++){
            Round();
        }
    }

    public void Round(){
        for(Car c1 : cars){
            c1.Race(TryNum);
        }
    }

    public void setCars(ArrayList<String> input){
        for(int i = 0; i <input.size(); i++){
            cars.add(new Car(input.get(i)));
        }
    }
}

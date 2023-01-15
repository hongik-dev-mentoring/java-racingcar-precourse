package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Game {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int TryNum;
    private HashMap<String, Integer> scoreBoard;
    private int carNum;

    public Game(){
        ArrayList<String> StringInput = Input.ReadCarName();
        TryNum = Input.ReadTryNum();
        setCars(StringInput);
        carNum = cars.size();
        setScoreBoad();

//        for(String i : scoreBoard.keySet()){
//            System.out.println("key: " + i + " value: " + scoreBoard.get(i));
//        } scoreboard 출력 테스트

        Play();
    }

    public void Play(){
        for(int i = 0; i <TryNum; i++){
            Round();
            SortCars();

        }
    }

    public void SortCars(){
        Collections.sort(cars, (c1, c2) -> c2.getPosition() - c1.getPosition());
    }

    public void Score(){
        int max = cars.get(0).getPosition();
        updateValue(cars.get(0).getName(),cars.get(0).getPosition());
        for(int i = 1; i <carNum; i++){
            Car c1 = cars.get(i);
            if(c1.getPosition() == max) updateValue(c1.getName(),max);
        }
    }

    public void updateValue(String name, int value){
        if(scoreBoard.containsKey(name) == false){
            scoreBoard.put(name,value);
            return;
        }
        int tmp = scoreBoard.get(name);
        scoreBoard.put(name, tmp + value);
        return;
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

    public void setScoreBoad(){
        scoreBoard = new HashMap<String, Integer>();
        for(int i = 0; i < carNum; i++){
            scoreBoard.put(cars.get(i).getName(), 0);
        }
    }
}

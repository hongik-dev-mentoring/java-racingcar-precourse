package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private List<Car> SortedCars;
    private int TryNum;
    private int carNum;

    public Game(){
        ArrayList<String> StringInput = Input.ReadCarName();
        TryNum = Input.ReadTryNum();
        setCars(StringInput);
        carNum = cars.size();

        System.out.println("실행 결과");
        Play();
        for(Car c1: cars){
            System.out.println("name: " + c1.getName() + " win : " + c1.getWinNum());
        }
    }

    public void Play(){
        for(int i = 0; i <TryNum; i++){
            Round();
            SortCars();
            Score();
        }
    }

    public void SortCars(){
        SortedCars = cars.stream().sorted(Comparator.comparing(Car::getPosition).reversed()).collect(Collectors.toList());
    }

    public void Score(){
        Car maxCar = SortedCars.get(0);
        maxCar.increaseWinNum();
        int max = maxCar.getPosition();

        for(int i = 1; i <carNum; i++){
            Car c1 = SortedCars.get(i);
            if(c1.getPosition() != max){
                break;
            }
            c1.increaseWinNum();
        }
    }

    public void Round(){
        for(Car c1 : cars){
            c1.Race(TryNum);
            Output.printRound(c1);
        }
        System.out.println();
    }

    public void setCars(ArrayList<String> input){
        for(int i = 0; i <input.size(); i++){
            cars.add(new Car(input.get(i)));
        }
    }
}

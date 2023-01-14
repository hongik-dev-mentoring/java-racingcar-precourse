package racingcar;

public class Game {
    private Car[] cars = new Car[100];
    private int TryNum;
    private int carNum;

    public Game(){
        String[] StringInput = Input.ReadCarName();
        TryNum = Input.ReadTryNum();

        setCars(StringInput);

        Play();

        for(int i = 0; i <carNum; i++){
            System.out.println(cars[i].getPosition());
        }
    }

    public void setCars(String[] Input){
        for(int i = 0; Input[i] != null; i++){
            cars[i] = new Car(Input[i]);
            carNum++;
        }
    }

    public void Play(){
        for(int i = 0; i < carNum; i++){
            cars[i].Race(TryNum);
        }
    }
}

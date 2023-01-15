package racingcar;

public class Output {
    public static void printRound(Car c1){
        System.out.print(c1.getName() +": ");
        printBar(c1);
    }
    public static void printBar(Car c1){
        for(int i = 0; i <c1.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
}

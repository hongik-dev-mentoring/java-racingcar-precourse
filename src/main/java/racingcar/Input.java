package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    static ArrayList<String> carNames = new ArrayList<String>();
    public static ArrayList<String> ReadCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while(true)
        {
            String input = Console.readLine();
            String[] tmp = input.split(",");
            try{
                StringHandlingExecption(tmp);
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage() + " 5이하의 문자열을 입력하세요.");
                continue;
            }
            break;
        }
        return carNames;
    }

    public static void StringHandlingExecption(String[] tmp){

        for(int i = 0; i < tmp.length; i++){
            if(tmp[i].length() > 5){
                throw new IllegalArgumentException("[ERROR]");
            }
            carNames.add(tmp[i]);
        }
    }

    public static int ReadTryNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        while(true){
            String n;
            int num;
            try{
                n = Console.readLine();
                num = IntHandlingException(n);
            }
            catch(Exception e){
                System.out.println("[Error] 시도횟수는 숫자여야 한다.");
                continue;
            }
            return num;
        }
    }

    public static int IntHandlingException(String n){
        int num;
        try{
            num = Integer.parseInt(n);
        }catch(Exception e){
            throw new IllegalArgumentException("[Error]");
        }
        return num;
    }
}

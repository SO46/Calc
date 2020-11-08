import java.util.HashMap;

public class MathOperations {
    HashMap<String, Integer> mathOperations = new HashMap<String, Integer>();

    public MathOperations() {
        mathOperations.put("*", 1);
        mathOperations.put("/", 2);
        mathOperations.put("+", 3);
        mathOperations.put("-", 4);
    }

    public HashMap<String, Integer> getMathOperations() {
        return mathOperations;
    }

    public boolean checkArabNumber(String number){
        try{
            int d = Integer.parseInt(number);
        }
        catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }

    public int Calculate(int c, String i, String k) throws Exception {
        int a, b;
        a = Integer.parseInt(i);
        b = Integer.parseInt(k);
        if (a > 10 || b > 10){
            throw new Exception("numbers greater than 10");
        }
        switch (c){
            case 1:
               return mul(a, b);
            case 2:
               return div(a, b);
            case 3:
               return sum(a, b);
            case 4:
               return sub(a, b);
        }
        return 0;
    }

    static int mul(int x, int y){
        return x * y;
    }
    static int div(int x, int y){
        return x / y;
    }
    static int sum(int x, int y){
        return x + y;
    }
    static int sub(int x, int y){
        return x - y;
    }
}

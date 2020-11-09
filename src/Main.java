import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        MathOperations mathOperations = new MathOperations();

        for (Map.Entry<String, Integer> entry : mathOperations.getMathOperations().entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            if (line.contains(k)) {
                String regex = Pattern.quote(k);
                String[] words = line.split(regex);
                if (words.length == 2) {
                    boolean num1Check = mathOperations.checkArabNumber(words[0].trim());
                    boolean num2Check = mathOperations.checkArabNumber(words[1].trim());
                    if (num1Check == num2Check) {
                         if (num1Check) {
                             System.out.println(mathOperations.Calculate(v, words[0].trim(), words[1].trim()));
                         } else {
                             String num1 = RomanNumeral.convertToArab(words[0].trim());
                             String num2 = RomanNumeral.convertToArab(words[1].trim());
                             int result = mathOperations.Calculate(v, num1, num2);
                             System.out.println(RomanNumeral.convertToRoman(result));
                         }
                    } else {
                        throw new Exception("different types of numbers");
                    }
                    break;
                } else {
                    throw new Exception("wrong type of expression");
                }
            }

        }
    }
}

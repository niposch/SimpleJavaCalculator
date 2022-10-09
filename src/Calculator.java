import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static int getNextNumber(String numberName, Scanner sc){
        while(true){
            try{
                System.out.print(numberName + ": ");
                return sc.nextInt();
            }
            catch (Exception ex){
                System.out.println("This is not a valid number!");
                sc.next();
            }
        }
    }
    private static List<String> validOperators = Arrays.stream(new String[]{"+", "-", "*", "/"}).toList();
    private static String getOperator(Scanner sc){
        while(true){
            System.out.println("Possible operators: " + String.join(", ", validOperators));
            System.out.print("Operator: ");
            var operator = sc.next().strip();
            if(validOperators.contains(operator)){
                return operator;
            }
            System.out.println("Not a valid operator!");
        }
    }
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        do{
            int number1 = getNextNumber("number 1", sc);
            String operator = getOperator(sc);
            int number2 = getNextNumber("number 2", sc);
            Float result = calculateResult(number1, operator, number2);
            if (result == null) continue;
            System.out.println("Result: " + result);
            System.out.print("Continue? (y/n): ");
        }while (!sc.next().equalsIgnoreCase("n"));
    }

    private static Float calculateResult(int number1, String operator, int number2) {
        switch (operator){
            case "*":
                return (float)number1 * number2;
            case "+":
                return (float)number1 + number2;
            case "-":
                return (float)number1 - number2;
            case "/":
                return (float) number1 / number2;
            default:
                System.out.println("Not a valid operator!");
                return null;
        }
    }
}
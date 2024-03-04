import java.util.Scanner;

public class Culc2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = scanner.nextLine();
        System.out.println(solution(expression));
    }
    public static String solution (String expression) throws Exception{
        int num1;
        int num2;
        String operand;
        String result;
        boolean isRoman;
        String[] numbers = expression.split("[\\-+*/]");
        if (numbers.length !=2) throw new Exception("Введите только две цифры");
        operand = definitionOperand(expression);
        if (Converter.isRoman(numbers[0]) && Converter.isRoman(numbers[1])) {
            num1 = Converter.converterToArabian(numbers[0]);
            num2 = Converter.converterToArabian(numbers[1]);
            isRoman = true;
        } else if (!Converter.isRoman(numbers[0]) && !Converter.isRoman(numbers[1])){
            num1 = Integer.parseInt(numbers[0]);
            num2 = Integer.parseInt(numbers[1]);
            isRoman = false;
        } else throw new Exception("Цифры должны быть в одном формате");
        if (num1 > 10 || num1 < 0 || num2 > 10 || num2 < 0) throw new Exception("Цифры должны быть от 1 до 10");
        int num = calculation(num1, num2, operand);
        if(isRoman){
            if(num <= 1) throw new Exception("Результат вычесления должен быть не меньше единицы");
            result = Converter.converterToRoman(num);
        } else {
            result = String.valueOf(num);
        }
        return result;
    }
    static int calculation(int num1, int num2, String operand){
        if(operand.equals("+")) return num1+num2;
        else if(operand.equals("-")) return num1-num2;
        else if(operand.equals("*")) return num1*num2;
        else return num1/num2;
    }
    static String definitionOperand (String expression){
        if(expression.contains("+")) return "+";
        else if(expression.contains("-")) return "-";
        else if(expression.contains("*")) return "*";
        else if(expression.contains("/")) return "/";
        else return null;
    }
}

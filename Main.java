import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение из двух чисел(): ");
        String expression = scanner.nextLine().replaceAll(" ","");
        System.out.println(calc(expression));
        scanner.close();
    }

    public static String calc(String expression) throws Exception {
        int num1;
        int num2;
        String oper;
        String result;
        boolean isRoman;
        String[] operands = expression.split("[+\\-*/]");


        num1 = Integer.parseInt(operands[0]);
        num2 = Integer.parseInt(operands[1]);

       if (num1 > 10 || num1 < 1 || num2 > 10 || num2 < 1) {
           throw new Exception("Числа должны быть от 1 до 10");
        }

        if (operands.length != 2) throw new Exception("Должно быть два операнда и один оператор");
        oper = detectOperation(expression);

        if (oper == null) throw new Exception("Это не математическая операция");


        int arabian = calculation(num1, num2, oper);
            //Конвертируем арабское число в тип String
            result = String.valueOf(arabian);

        //возвращаем результат
        return result;
    }

    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calculation(int a, int b, String oper) {

        return switch (oper) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }

}


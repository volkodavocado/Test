import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите выражение: ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        calc(input);
    }
    public static String calc(String input) {

        String operStr = " ";
        char oper = 0;
        char[] symbol = new char[10];
        for (int i=1; i < input.length(); i++) {
            symbol[i] = input.charAt(i);
            if ( symbol[i] == '+'){
                oper = '+'; operStr = "\\+";
            }
            if ( symbol[i] == '-'){
                oper = '-'; operStr = "-";
            }
            if ( symbol[i] == '*'){
                oper = '*'; operStr = "\\*";
            }
            if ( symbol[i] == '/'){
                oper = '/'; operStr = "/";
            }
        }

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        int resultArab = 0;
        String[] numbers = input.split(" ");
        if (numbers.length > 4) {
            throw new IllegalArgumentException();
        }
        try{
            num1 = romanNumeral(numbers[0]);
            num2 = romanNumeral(numbers[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        if (num1 == 0 | num2 == 0) {
            result = 0;
            try {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[2]);
                if (num1 > 10 | num2 > 10 | num1 < 1 | num2 < 1) {
                    throw new IllegalArgumentException();
                }
                resultArab = calculate(num1, num2, oper);
                System.out.println(String.valueOf(resultArab));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException();
            }
        } else {
            try {
                result = calculate(num1, num2, oper);
                if (result == 0) {
                    throw new IllegalArgumentException();
                }
                String resultRom = romanSolution(result);
                System.out.println(resultRom);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException();
            }
        }
        return String.valueOf(resultArab);
    }

    public static int calculate(int x1, int x2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = x1 + x2;
                break;
            case '-':
                result = x1 - x2;
                break;
            case '*':
                result = x1 * x2;
                break;
            case '/':
                result = x1 / x2;
                break;
            default:
                break;
        }
        return result;
    }

    public static int romanNumeral(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return 0;
        }
    }

    public static String romanSolution(int arabNumeral) {
        String[] romanAll = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return romanAll[arabNumeral];

    }
}

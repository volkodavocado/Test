import java.util.*; // импортируем сканнер и массивы

public class Main { // создаем класс main

    public static void main(String[] args) { // создаем главный метод
        Scanner s = new Scanner(System.in);// принимает строку
        String input = s.nextLine();
        System.out.println(calc(input));
        // и возвращает результат
    }
    public static String calc(String input) { // метод работает с числами
        String[] array = input.split(" "); // создает массив
        if (array.length > 3) { // исключение на кол-во символов
            throw new IllegalArgumentException();
        }
        int num1, num2, result, resultArab;
        String resultAr = null, myResult = null, resultRom = null; // инициализация переменных
        num1 = romanNumeral(array[0]); // проверка на римские
        num2 = romanNumeral(array[2]);
        if (num1 == 0 | num2 == 0) { // если не римские
            try {
                num1 = Integer.parseInt(array[0]); // перевод в арабские
                num2 = Integer.parseInt(array[2]);
                if (num1 > 10 | num2 > 10 | num1 < 1 | num2 < 1) {
                    throw new IllegalArgumentException(); // проверка введ. арабских
                }
                resultArab = calculate(num1, num2, array[1]); // счет
                resultAr = String.valueOf(resultArab);
                //System.out.println(String.valueOf(resultArab)); // вывод
            } catch (NumberFormatException | ArithmeticException e) {
                throw new IllegalArgumentException(); // исключение на формат ввода
            }
        } else { // если римские
            try {
                result = calculate(num1, num2, array[1]); // счет
                if (result <= 0) {
                    throw new IllegalArgumentException(); // исключение на отриц рез
                }
                resultRom = romanSolution(result); // перевод обратно в римское
                //System.out.println(resultRom); // вывод строки
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException();
            }
        }
        if (resultAr != null) {
            myResult = resultAr;
        }
        if (resultRom != null) {
            myResult = resultRom;
        }
        return myResult;
    }

    static int calculate(int x1, int x2, String op) {
        return switch (op) {
            case "+" -> x1 + x2;
            case "-" -> x1 - x2;
            case "*" -> x1 * x2;
            case "/" -> x1 / x2;
            default -> throw new IllegalArgumentException();
        };
    }

    static int romanNumeral(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }

    static String romanSolution(int arabNumeral) {
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

//В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lesson4_3 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Lesson4_3.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("Lesson4_3log.xml");

            logger.addHandler(fileHandler);

            Stack<Object> stack = new Stack<>();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите число 1");
            Long number1 = scanner.nextLong();
            logger.info("Первое число:" + number1);
            stack.push("Первое число: " + number1);

            System.out.println("Введите число 2");
            Long number2 = scanner.nextLong();
            logger.info("Второе число:" + number2);
            stack.push("Второе число:" + number2);

            Long result =null;
            boolean needContinue = true;
            String operationName = " ";
            while (needContinue) {
                System.out.println("Введите операцию: 1- число1 + число2; 2- число1 - число2;3- число1 * число2;4- число1/число2;");
                String operation = scanner.next();
                switch (operation) {
                    case "1":
                        result = number1 + number2;
                        operationName = "Сложение";
                        break;
                    case "2":
                        result = number1 - number2;
                        operationName = "Вычитание";
                        break;
                    case "3":
                        result = number1 * number2;
                        operationName = "Умножение";
                        break;
                    case "4":
                        result = number1 / number2;
                        operationName = "Деление";
                        break;
                    default:
                        throw new IllegalArgumentException("Неверный ввод");
                }
                stack.push(operationName);
                System.out.println("Удалить последнюю операцию: ДА -1; НЕТ -2 ");
                String choice = scanner.next();

                switch (choice) {
                    case "1":
                        stack.pop();
                        break;
                    case "2":
                        needContinue = false;
                        break;
                }
            }
            System.out.println("Пользователь вводил: " + stack);
            System.out.println("Результат: " + result);
            logger.info("Результат:" + result);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "возможно, это не число", e);
        }
    }
}
// Реализовать консольное приложение, которое:

// 1. Принимает от пользователя и “запоминает” строки.
// 2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
// 3. Если введено revert, удаляет предыдущую введенную строку из памяти.
//
//public class Lesson4_3  {
//    public static void main(String[] args) {
//        Stack<String> stack = new Stack<>();
//        String str = "";
//        Scanner iScanner = new Scanner(System.in);
//        for (int i = 0; i < 5; i++) {
//            System.out.println("print");
//            str = iScanner.nextLine();
//            stack.push(str);
//
//        }
//        System.out.println("команда");
//        str = iScanner.nextLine();
//        System.out.println();
//        if (str.equals("print")) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(stack.pop());
//            }
//        }else{
//            if (str.equals("revert")) {
//                stack.remove(stack.size()-1);
//            }
//            System.out.println(stack);
//
//        }
//    }
//}

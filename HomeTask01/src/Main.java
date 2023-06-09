/*
1) Вычислить сумма чисел от 1 до n
2) Вывести все простые числа от 1 до 1000
3) Реализовать простой калькулятор

4) (задание со *) Задано уравнение вида q + w = e, q, w, e >= 0.
Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства.
Предложить хотя бы одно решение или сообщить, что его нет.

5) (задание со *) Доделать задания 5, 8, 9 из презинтации к уроку

*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//        SumFromOneToN();
//        PrimeNumbers();
//        Calculator();
        EquationsSolver();
    }


    private static void SumFromOneToN() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число n: ");
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Сумма чисел от 1 до " + n + " равна " + sum);
    }

    private static void PrimeNumbers() {
        System.out.println("Простые числа от 1 до 1000:");

        for (int i = 2; i <= 1000; i++) { // перебираем все числа от 2 до 1000
            boolean isPrime = true; // предполагаем, что число простое

            // проверяем, делится ли число на какое-то другое число, кроме 1 и самого себя
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false; // если число делится на другое число, то оно не является простым
                    break;
                }
            }

            // если число является простым, то выводим его на экран
            if (isPrime) {
                System.out.print(i + " является простым числом");
            }
        }
    }

    private static void Calculator() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();

        System.out.print("Введите оператор (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();

        double result = 0.0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Ошибка! Некорректный оператор.");
                return;
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }

    private static void EquationsSolver() {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();
        String[] parts = equation.split(" ");
        int q = 0, w = 0, e = 0;
        for (String part : parts) {
            if (part.contains("?")) {
                for (int i = 0; i <= 9; i++) {
                    String temp = part.replace("?", String.valueOf(i));
                    int num = Integer.parseInt(temp);
                    if (q + w == e) {
                        System.out.println(temp);
                        return;
                    }
                    if (part.equals(parts[0])) {
                        q = num;
                    } else if (part.equals(parts[2])) {
                        e = num;
                    } else {
                        w = num;
                    }
                }
            } else {
                int num = Integer.parseInt(part);
                if (part.equals(parts[0])) {
                    q = num;
                } else if (part.equals(parts[2])) {
                    e = num;
                } else {
                    w = num;
                }
            }
        }
        System.out.println("No solution");
    }
}








package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
3(со звездочкой)
В калькулятор добавьте возможность отменить последнюю операцию.
Калькулятор сделать на основе программы разработанной на семинаре.
*/
public class Calculator {
    private List<Double> history = new ArrayList<>();
    private double currentResult = 0.0;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Введите целое число или операцию для сохранения (+, -, *, /, undo):");
            String input = scanner.nextLine();
            switch (input) {
                case "+":
                    add(scanner);
                    break;
                case "-":
                    subtract(scanner);
                    break;
                case "*":
                    multiply(scanner);
                    break;
                case "/":
                    divide(scanner);
                    break;
                case "exit":
                    exit = true;
                    System.out.println("Программа завершена.");
                    break;
                case "undo":
                    undo();
                    break;
                default:
                    try {
                        double operand = Double.parseDouble(input);
                        history.add(currentResult);
                        currentResult = operand;
                        System.out.println("Результат: " + currentResult);
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректный ввод!");
                    }
            }
        }
    }

    private void add(Scanner scanner) {
        System.out.println("Введите число:");
        double operand = getOperand(scanner);
        history.add(currentResult);
        currentResult += operand;
        System.out.println("Результат: " + currentResult);
    }

    private void subtract(Scanner scanner) {
        System.out.println("Введите число:");
        double operand = getOperand(scanner);
        history.add(currentResult);
        currentResult -= operand;
        System.out.println("Результат: " + currentResult);
    }

    private void multiply(Scanner scanner) {
        System.out.println("Введите число:");
        double operand = getOperand(scanner);
        history.add(currentResult);
        currentResult *= operand;
        System.out.println("Результат: " + currentResult);
    }

    private void divide(Scanner scanner) {
        System.out.println("Введите число:");
        double operand = getOperand(scanner);
        if (operand == 0.0) {
            System.out.println("Деление на ноль невозможно!");
        } else {
            history.add(currentResult);
            currentResult /= operand;
            System.out.println("Результат: " + currentResult);
        }
    }

    private double getOperand(Scanner scanner) {
        double operand = 0.0;
        boolean validInput = false;
        while (!validInput) {
            String input = scanner.nextLine();
            try {
                operand = Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод! Введите число.");
            }
        }
        return operand;
    }

    private void undo() {
        if (history.size() > 0) {
            currentResult = history.remove(history.size() - 1);
            System.out.println("Отмена последней операции. Результат: " + currentResult);
        } else {
            System.out.println("Нечего отменять!");
        }
    }
}
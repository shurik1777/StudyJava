package Solution;

import java.util.LinkedList;

public class Calculator {
    /*
  Задание
3(со звездочкой) В калькулятор добавьте возможность отменить последнюю операцию.
Калькулятор сделать на основе программы разработанной на семинаре.
   */

    private LinkedList<Double> operands = new LinkedList<>();
    private LinkedList<Character> operators = new LinkedList<>();

    public void push(double num) {
        operands.add(num);
    }

    public void push(char op) {
        operators.add(op);
    }

    public double evaluate() {
        while (!operators.isEmpty()) {
            char op = operators.removeLast();
            double num2 = operands.removeLast();
            double num1 = operands.removeLast();
            switch (op) {
                case '+':
                    push(num1 + num2);
                    break;
                case '-':
                    push(num1 - num2);
                    break;
                case '*':
                    push(num1 * num2);
                    break;
                case '/':
                    push(num1 / num2);
                    break;
            }
        }
        return operands.getLast();
    }

    public static double evaluateExpression(String expression) throws IllegalArgumentException {
        Calculator calculator = new Calculator();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    if (calculator.operands.size() >= 2) {
                        double num2 = calculator.operands.removeLast();
                        double num1 = calculator.operands.removeLast();
                        char op = token.charAt(0);
                        calculator.push(num1);
                        calculator.push(num2);
                        calculator.push(op);
                    } else {
                        throw new IllegalArgumentException("Невозможно выполнить операцию без двух номеров.");
                    }
                    break;
                default:
                    try {
                        double num = Double.parseDouble(token);
                        calculator.push(num);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Неверный Ввод. Пожалуйста, введите номер или оператора.");
                    }
                    break;
            }
        }
        return calculator.evaluate();
    }

    public void undo() {
        if (!operators.isEmpty()) {
            operators.removeLast();
        } else if (!operands.isEmpty()) {
            operands.removeLast();
        }
    }
}
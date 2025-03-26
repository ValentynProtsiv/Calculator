package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> expression = arrayOfExpression();
        try {
            System.out.print("= " + calculateNum(expression));
        }catch (IndexOutOfBoundsException e){
            System.out.println("No expression found\nTry 2 + 2"); // example : 7 + 2 + 4 - 3 / 2 * 2 / 2 * 2 / 4 + 3 + 7 - 834
        }
    }

    static double calculateNum(ArrayList<String> expression) {

        for (int i = 0; i < expression.size(); i++) {
            if (expression.get(i).equals("*") || expression.get(i).equals("/")) {
                double a = Double.parseDouble(expression.get(i - 1));
                double b = Double.parseDouble(expression.get(i + 1));
                double result = expression.get(i).equals("/") ? a / b : a * b;
                expression.set(i - 1, String.valueOf(result));
                expression.remove(i);
                expression.remove(i);
                i--;
            }
        }

        double result = Double.parseDouble(expression.get(0));
        for (int i = 1; i < expression.size(); i+=2) {
            String operator = expression.get(i);
            double a = Double.parseDouble(expression.get(i + 1));
            result = operator.equals("+") ? result + a : result - a;
        }

        return result;
    }

    static ArrayList<String> arrayOfExpression(){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] splitText = text.split(" ");

        return new ArrayList<>(Arrays.asList(splitText));
    }

}
package main.java;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader br = new BufferedReader
            (new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String line = null;
        while (true) {
            try {
                line = br.readLine();
                break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. " +
                        "Попробуйте еще раз.");
            }
        }
        return line;
    }

    public static int readInt() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. " +
                        "Попробуйте еще раз.");
            }
        }
        return number;
    }
}

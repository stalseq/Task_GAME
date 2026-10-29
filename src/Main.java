import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int maxResult = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (true) {
            playGame(scanner, random);
        }
    }

    public static void playGame(Scanner scanner, Random random) {
        int randomNumber = random.nextInt(1, 101);
        int quantity = 0;
        boolean endPlay = true;

        while (endPlay) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("RESULT")) {
                System.out.println("Текущее количество попыток: " + quantity +
                        "\nКоличество в лучшей игре: " + maxResult + "\n");
                continue;
            }
            try {
                int number = Integer.parseInt(input);
                quantity++;

                if (number == randomNumber) {
                    endPlay = false;
                    System.out.println("Текеущее количество попыток: " + quantity +
                            "\nЗагаданное число " + randomNumber + "\n");
                    if (quantity < maxResult) {
                        maxResult = quantity;
                    }
                    System.out.println("Количество в лучшей игре: " + maxResult);
                } else if (number < randomNumber) {
                    System.out.println("Я сам в шоне, но, загаданное число больше, брат");
                } else {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                }
            } catch (NumberFormatException e) {
                System.err.println("Некоректный ввод " + e);
            }
        }
    }
}
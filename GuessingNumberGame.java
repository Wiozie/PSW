import java.util.Scanner;
import java.util.Random;

public class GuessingNumberGame {

        public static void
        guessingNumberGame()
        {

            Scanner sc = new Scanner(System.in);

            Random random = new Random();
            int number = random.nextInt(100) + 1;

            int guess;

            System.out.println("Wylosowałem liczbę pomiędzy 1 a 100. Zgadnij jaka to liczba: ");

            guess = sc.nextInt();

            while (guess != number) {

                if (number > guess) {
                    System.out.println("Wylosowana liczba jest większa niż " + guess);
                }
                else {
                    System.out.println("Wylosowana liczba jest mniejsza niż " + guess);
                }
                System.out.println("Spróbuj ponownie: ");
                guess = sc.nextInt();
            }
            System.out.println("Brawo! To prawidłowa odpowiedź!");
        }
    }


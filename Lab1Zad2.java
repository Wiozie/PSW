import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab1Zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // zbiór przechowuje wartości unikalne
        Set<Integer> uniqueNumbers = new HashSet<>();

        System.out.println(
                "Wprowadź liczby całkowite "
                + "(jedna w każdej linii, zakończ przez wprowadzenie pustej linii):");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            try {
                int number = Integer.parseInt(line);
                uniqueNumbers.add(number);
            } catch (NumberFormatException e) {
                System.err.println("Nieprawidłowe dane: " + line);
            }
        }

        System.out.println("Liczba unikalnych wartości to: " + uniqueNumbers.size());
    }
}

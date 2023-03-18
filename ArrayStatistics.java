import java.util.Arrays;
import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Długość tablicy podana przez użytkownika
        System.out.print("Podaj długość tablicy: ");
        int n = scanner.nextInt();

        double[] arr = new double[n];

        // Wartości w tablicy generowane ze zbioru dopuszczalnych wartości
        double[] allowedValues = {2, 3, 3.5, 4, 4.5, 5};

        for (int i = 0; i < n; i++) {
            arr[i] = allowedValues[(int) (Math.random() * allowedValues.length)];
        }

        // Oblicz średnią wartość liczb występujących w tablicy
        double sum = 0;

        for (double val : arr) {
            sum += val;
        }

        double avg = sum / n;

        // Znajdź wartość minimalną i maksymalną
        double min = arr[0];
        double max = arr[0];

        for (double val : arr) {
            if (val < min) {
                min = val;
            }

            if (val > max) {
                max = val;
            }
        }

        // Znajdź wartości wyższe/niższe niż średnia
        int aboveAvgCount = 0;
        int belowAvgCount = 0;

        for (double val : arr) {
            if (val > avg) {
                aboveAvgCount++;
            } else if (val < avg) {
                belowAvgCount++;
            }
        }

        // Zlicz częstotliwość występowania poszczególnych liczb
        Arrays.sort(arr);
        double[] uniqueValues = new double[allowedValues.length];
        int[] counts = new int[allowedValues.length];

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                uniqueValues[index] = arr[i];
                index++;
            }

            int count = counts[index - 1];
            count++;
            counts[index - 1] = count;
        }

        // Oblicz średnie odchylenie standardowe wartości występujących w tablicy
        double varianceSum = 0;

        for (double val : arr) {
            varianceSum += Math.pow((val - avg), 2);
        }

        double variance = varianceSum / n;
        double standardDeviation = Math.sqrt(variance);

        // Wyświetl wyniki analizy statystycznej
        System.out.println("Tablica: " + Arrays.toString(arr));
        System.out.println("Średnia wartość: " + avg);
        System.out.println("Wartość minimalna: " + min);
        System.out.println("Wartość maksymalna: " + max);
        System.out.println("Liczba wartości wyższych niż średnia: " + aboveAvgCount);
        System.out.println("Liczba wartości niższych niż średnia: " + belowAvgCount);
        System.out.println("Odchylenie standardowe wartości wynosi: " + standardDeviation);
    }
}

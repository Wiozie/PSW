//Napisz program, który umożliwi sortowanie bąbelkowe wartości wprowadzonych przez
//użytkownika

import java.util.Scanner;

public class Lab2Zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj ilość liczb do posortowania: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Podaj liczby do posortowania:");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        bubbleSort(arr);

        System.out.println("Posortowane liczby:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

// Napisz program, który pozwoli na wykonanie podstawowych operacji na macierzach
// kwadratowych o wymiarach podanych przez użytkownika:
// ▪ Dodawanie dwóch macierzy
// ▪ Odejmowanie dwóch macierzy
// ▪ Mnożenie dwóch macierzy
// Do implementacji macierzy wykorzystaj tablice wielowymiarowe, które będą
// automatycznie wypełnione wartościami losowymi z zakresu od -10 do 10.
    
import java.util.Arrays;
import java.util.Scanner;

public class Lab2Zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Wymiary macierzy podane przez użytkownika
        System.out.print("Podaj wymiar macierzy: ");
        int n = scanner.nextInt();

        // Tworzenie macierzy A
        double[][] A = new double[n][n];
        fillMatrix(A);

        // Tworzenie macierzy B
        double[][] B = new double[n][n];
        fillMatrix(B);

        // Wyświetlenie macierzy A i B
        System.out.println("Macierz A:");
        printMatrix(A);
        System.out.println("Macierz B:");
        printMatrix(B);

        // Dodawanie macierzy A i B
        double[][] sum = addMatrices(A, B);
        System.out.println("Suma macierzy A i B:");
        printMatrix(sum);

        // Odejmowanie macierzy A i B
        double[][] diff = subtractMatrices(A, B);
        System.out.println("Różnica macierzy A i B:");
        printMatrix(diff);

        // Mnożenie macierzy A i B
        double[][] product = multiplyMatrices(A, B);
        System.out.println("Iloczyn macierzy A i B:");
        printMatrix(product);
    }

    // Metoda do wypełniania macierzy wartościami losowymi z zakresu od -10 do 10
    public static void fillMatrix(double[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (Math.random() * 21) - 10;
            }
        }
    }

    // Metoda do wyświetlania macierzy
    public static void printMatrix(double[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // Metoda do dodawania dwóch macierzy
    public static double[][] addMatrices(double[][] A, double[][] B) {
        int n = A.length;
        double[][] sum = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = A[i][j] + B[i][j];
            }
        }

        return sum;
    }

    // Metoda do odejmowania dwóch macierzy
    public static double[][] subtractMatrices(double[][] A, double[][] B) {
        int n = A.length;
        double[][] diff = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = A[i][j] - B[i][j];
            }
        }

        return diff;
    }

    // Metoda do mnożenia dwóch macierzy
    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int n = A.length;
        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}

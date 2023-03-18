import java.util.*;

public class Lab1Zad4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // wprowadzenie zbiorów
        System.out.print("Podaj elementy zbioru A, oddzielając je spacją: ");
        Set<Integer> setA = new HashSet<>();
        String[] elementsA = input.nextLine().split(" ");
        for (String element : elementsA) {
            setA.add(Integer.parseInt(element));
        }

        System.out.print("Podaj elementy zbioru B, oddzielając je spacją: ");
        Set<Integer> setB = new HashSet<>();
        String[] elementsB = input.nextLine().split(" ");
        for (String element : elementsB) {
            setB.add(Integer.parseInt(element));
        }

        // suma zbiorów
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("Suma zbiorów A i B: " + union);

        // różnica zbiorów A-B
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Różnica zbiorów A-B: " + difference);

        // część wspólna zbiorów
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Część wspólna zbiorów A i B: " + intersection);

        // różnica symetryczna zbiorów
        Set<Integer> symmetricDifference = new HashSet<>(setA);
        symmetricDifference.addAll(setB);
        Set<Integer> tmp = new HashSet<>(setA);
        tmp.retainAll(setB);
        symmetricDifference.removeAll(tmp);
        System.out.println("Różnica symetryczna zbiorów A i B: " + symmetricDifference);
    }
}

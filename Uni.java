import java.util.*;

public class Uni {
    public Map<Student, List<Double>> students = new HashMap<>();
    List<Double> possibleGrades = Arrays.asList(2.0, 3.0, 3.5, 4.0, 4.5, 5.0);

    public void addStudent(Student student) {
        List<Double> studentGrades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wpisz ilość ocen: ");
        int numberOfGrades = scanner.nextInt();
        for (int i = 0; i < numberOfGrades; i++) {
            do {
                System.out.print("Wpisz ocenę: ");
                double grade = scanner.nextDouble();
                if (possibleGrades.contains(grade)) {
                    studentGrades.add(grade);
                    break;
                }
                System.out.println("Wpisana ocena jest nieprawidłowa!");
            } while (true);
        }
        students.put(student, studentGrades);
    }

    public void removeStudent(int id) {
        Iterator<Map.Entry<Student, List<Double>>> iterator = students.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Student, List<Double>> entry = iterator.next();
            if (entry.getKey().getNrIndeksu() == id) {
                iterator.remove();
            }
        }
    }

    public double average(Student student) {
        return students.get(student).stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double allAverage() {
        double wynik = 0;
        for (Map.Entry<Student, List<Double>> entry : students.entrySet()) {
            wynik += average(entry.getKey());
        }
        return wynik / students.size();
    }
}
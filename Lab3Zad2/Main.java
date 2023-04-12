public class Main {

    public static void main(String[] args) {
        zad2();
    }

    private static void zad2() {
        Student x = new Student("Wioletta", "Zielińska", 22334, 2);
        Student y = new Student("Kinga", "Kowalska", 22774, 2);
        Student z = new Student("Gabriel", "Kukiełka", 39982, 2);
        Uni politechnika = new Uni();
        politechnika.addStudent(x);
        politechnika.addStudent(y);
        politechnika.addStudent(z);

        for (Student student : politechnika.students.keySet()) {
            student.printStudent();
        }

        politechnika.removeStudent(22334);

        System.out.println("po usunięciu: ");
        for (Student student : politechnika.students.keySet()) {
            student.printStudent();
        }
        System.out.println("Średnia ocen: " + politechnika.allAverage());
    }

}

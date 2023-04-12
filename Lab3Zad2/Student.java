public class Student {
    private int nrIndeksu;
    private String imie;
    private String nazwisko;
    private int rokStudiow;

    public Student(String imie, String nazwisko, int id, int rok) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokStudiow = rok;
        this.nrIndeksu = id;
    }

    public void printStudent() {
        System.out.println("Imię: " + imie + " Nazwisko: " + nazwisko + " Numer Indeksu: " + nrIndeksu + " Rok: " + rokStudiow);
    }

    // Gettery i Settery
    public int getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(int nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getRokStudiow() {
        return rokStudiow;
    }

    public void setRokStudiow(int rokStudiow) {
        this.rokStudiow = rokStudiow;
    }
}

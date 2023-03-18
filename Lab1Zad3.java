import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab1Zad3 {
    public static void main(String[] args) {
        String binaryString = "001001000000010101";
        String regexPattern = "(?<=1)0+1";
        int holeCounter = 0;
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(binaryString);

        while (matcher.find()) {
            holeCounter++;
        }
        System.out.println("Liczba znalezionych dziur binarnych to: " + holeCounter);
    }
}






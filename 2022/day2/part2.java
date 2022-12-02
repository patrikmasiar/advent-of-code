
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File source = new File("input.txt");
        Scanner reader = null;

        try {
            int sum = 0;
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();
                int opponentPoints = line.charAt(0)-'A';
                int myPoints = (opponentPoints+(line.charAt(2)-'X')+2) % 3;

                int roundPoints = ((myPoints - opponentPoints + 4) % 3) * 3;

                sum += myPoints + 1 + roundPoints;
            }

            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File source = new File("input.txt");
        Scanner reader = null;
        ArrayList<Integer> calories = new ArrayList<Integer>();

        try {
            reader = new Scanner(source);
            int sum = 0;

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();

                if (line.length() == 0) {
                    calories.add(sum);
                    sum = 0;
                } else {
                    int lineValue = Integer.parseInt(line);
                    sum += lineValue;
                }
            }

            int caloriesSum = 0;

            Collections.sort(calories);
            Collections.reverse(calories);

            for (int i = 0; i < 3; i++) {
                caloriesSum += calories.get(i);
            }

            System.out.println(caloriesSum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

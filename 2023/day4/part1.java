import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> convertNumbers(String[] input) {
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (!input[i].isEmpty()) {
                output.add(Integer.parseInt( input[i]));
            }
        }

        return output;
    }

    public static void main(String[] args) {
        File source = new File("input.txt");
        Scanner reader = null;
        ArrayList<String> input = new ArrayList<>();
        Integer output = 0;

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();
                input.add(line);
            }

            for (int i = 0; i < input.size(); i++) {
                String line = input.get(i);
                String[] array = line.split(":");
                String[] allNumbers = array[1].split("\\|");
                ArrayList<Integer> myNumbers = convertNumbers(allNumbers[0].split(" "));
                ArrayList<Integer> winNumbers = convertNumbers(allNumbers[1].split(" "));
                int points = 0;

                for (int j = 0; j < myNumbers.size(); j++) {
                    if (winNumbers.contains(myNumbers.get(j))) {
                        points++;
                    }
                }

                points = (int) Math.pow(2, points - 1);

                output+=points;
            }


            System.out.println(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

            Map<String, Integer> cards = new HashMap<String, Integer>();

            for (int i = 1; i <= input.size() + 1; i++) {
                cards.put("card"+i, 1);
            }

            for (int i = 0; i < input.size(); i++) {
                String line = input.get(i);
                String[] array = line.split(":");
                int cardNumber = Integer.parseInt(array[0].replaceAll("[^0-9]", ""));
                String[] allNumbers = array[1].split("\\|");
                ArrayList<Integer> myNumbers = convertNumbers(allNumbers[0].split(" "));
                ArrayList<Integer> winNumbers = convertNumbers(allNumbers[1].split(" "));
                int points = 0;

                for (int j = 0; j < myNumbers.size(); j++) {
                    if (winNumbers.contains(myNumbers.get(j))) {
                        points++;
                    }
                }

                for (int k = 0; k < cards.get("card"+(cardNumber)); k++) {
                    for (int j = 1; j <= points; j++) {
                        int value = cards.get("card"+(cardNumber+j));
                        cards.put("card"+(cardNumber+j), value + 1);
                    }
                }

            }

            for (int i = 1; i < cards.size(); i++) {
                output+=cards.get("card"+i);
            }

            System.out.println(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File source = new File("input.txt");
        Scanner reader = null;
        ArrayList<String> input = new ArrayList<>();
        Integer output = 0;
        ArrayList<Integer> possibleGames = new ArrayList<>();
        int RED_LIMIT = 12;
        int GREEN_LIMIT = 13;
        int BLUE_LIMIT = 14;

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();
                input.add(line);
            }

            for (int i = 0; i < input.size(); i++) {
                String line = input.get(i);
                int gameID = i + 1;
                boolean red = true;
                boolean green = true;
                boolean blue = true;

                String[] array = line.split(":|\\,|\\;");
                List<String> list = new ArrayList<>(Arrays.asList(array));

                for (int j = 1; j < list.size(); j++) {
                    String item = list.get(j);
                    int count = Integer.parseInt(item.replaceAll("[^0-9]", ""));

                    if (item.contains("red")) {
                        if (count > RED_LIMIT) {
                            red = false;
                        }
                    }

                    if (item.contains("green")) {
                        if (count > GREEN_LIMIT) {
                            green = false;
                        }
                    }

                    if (item.contains("blue")) {
                        if (count > BLUE_LIMIT) {
                            blue = false;
                        }
                    }
                }

                if (red && green && blue) {
                    possibleGames.add(gameID);
                }
            }

            for (int i = 0; i < possibleGames.size(); i++) {
                output+=possibleGames.get(i);
            }

            System.out.println(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

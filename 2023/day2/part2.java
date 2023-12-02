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
        ArrayList<Integer> multiplies = new ArrayList<>();

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();
                input.add(line);
            }

            for (int i = 0; i < input.size(); i++) {
                String line = input.get(i);
                int red = 0;
                int green = 0;
                int blue = 0;

                String[] array = line.split(":|\\,|\\;");
                List<String> list = new ArrayList<>(Arrays.asList(array));

                for (int j = 1; j < list.size(); j++) {
                    String item = list.get(j);
                    int count = Integer.parseInt(item.replaceAll("[^0-9]", ""));

                    if (item.contains("red")) {
                        if (red < count) {
                            red = count;
                        }
                    }

                    if (item.contains("green")) {
                        if (green < count) {
                            green = count;
                        }
                    }

                    if (item.contains("blue")) {
                        if (blue < count) {
                            blue = count;
                        }
                    }
                }


                multiplies.add(red * green * blue);
            }

            for (int i = 0; i < multiplies.size(); i++) {
                output+=multiplies.get(i);
            }

            System.out.println(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

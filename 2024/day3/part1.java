import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File source = new File("input.txt");
        Scanner reader = null;
        ArrayList<String> input = new ArrayList<>();
        Integer output = 0;
        String regex = "mul\\((\\d+),(\\d+)\\)";
        ArrayList<Integer> outputs = new ArrayList<>();

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();
                input.add(line);
            }

            for (int i = 0; i < input.size(); i++) {
                int sum = 0;
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input.get(i));

                ArrayList<int[]> numberPairs = new ArrayList<>();

                while (matcher.find()) {
                    int number1 = Integer.parseInt(matcher.group(1));
                    int number2 = Integer.parseInt(matcher.group(2));

                    numberPairs.add(new int[] { number1, number2 });
                }

                for (int[] pair : numberPairs) {
                    sum += pair[0] * pair[1];
                }

                outputs.add(sum);
            }

            for (int i = 0; i < outputs.size(); i++) {
                output += outputs.get(i);
            }

            System.out.println(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

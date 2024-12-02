import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class Main {
    public static boolean isSafe(boolean increasing, int n1, int n2) {
        if (n1 == n2) {
            return false;
        }

        if (n1 > n2) {
            return n1 - n2 > 0 && n1 - n2 < 4 && !increasing;
        }

        return n1 - n2 < 0 && n1 - n2 > -4 && increasing;
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
                String[] numbers = line.split(" ");
                int validCount = 0;

                for (int j = 0; j < numbers.length - 1; j++) {
                    if (isSafe(Integer.parseInt(numbers[0]) < Integer.parseInt(numbers[1]), Integer.parseInt(numbers[j]), (Integer.parseInt(numbers[j + 1])))) {
                        validCount++;
                    }
                }
                
                if (validCount == numbers.length - 1) {
                    output++;
                }
            }

            System.out.println(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

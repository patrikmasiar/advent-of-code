import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> filterNumbers(String input) {
        ArrayList<String> output = new ArrayList<>();
        String[] numbers = input.split("[^\\d]+");

        for (int i = 0; i < numbers.length; i++) {
            if (!numbers[i].isEmpty()) {
                output.add(numbers[i]);
            }
        }

        return output;
    }

    public static boolean isLegitSymbol(char c) {
        return c != '.' && !Character.isDigit(c);
    }

    public static int getStartIndex(int n) {
        if (n == 0) {
            return n;
        }

        return n - 1;
    }

    public static int getEndIndex(int n, int max) {
        if (n == max) {
            return n;
        }

        return n + 1;
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
                ArrayList<String> numbers = filterNumbers(line);
                int firstIndex = 0;

                for (String value : numbers) {
                    int start = line.indexOf(value, firstIndex);
                    int end = start + value.length() - 1;
                    firstIndex = end + 1;
                    int startIndex = getStartIndex(start);
                    int endIndex = getEndIndex(end, line.length() - 1);

                    for (int k = startIndex; k <= endIndex; k++) {
                        if (isLegitSymbol(line.charAt(k))) {
                            output += Integer.parseInt(value);
                            break;
                        }
                    }

                    if (i == 0) {
                        String nextLine = input.get(i + 1);

                        for (int k = startIndex; k <= endIndex; k++) {
                            if (isLegitSymbol(nextLine.charAt(k))) {
                                output += Integer.parseInt(value);
                                break;
                            }
                        }
                    }

                    if (i != input.size() - 1 && i != 0) {
                        String nextLine = input.get(i + 1);
                        String prevLine = input.get(i - 1);

                        for (int k = startIndex; k <= endIndex; k++) {
                            if (isLegitSymbol(prevLine.charAt(k))) {
                                output += Integer.parseInt(value);
                                break;
                            }
                        }


                        for (int k = startIndex; k <= endIndex; k++) {
                            if (isLegitSymbol(nextLine.charAt(k))) {
                                output += Integer.parseInt(value);
                                break;
                            }
                        }
                    }

                    if (i == input.size() - 1) {
                        String prevLine = input.get(i - 1);

                        for (int k = startIndex; k <= endIndex; k++) {
                            if (isLegitSymbol(prevLine.charAt(k))) {
                                output += Integer.parseInt(value);
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

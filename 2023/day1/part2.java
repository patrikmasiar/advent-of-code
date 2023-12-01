import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static boolean isWordNumber(String word) {
        Pattern pattern = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine)");
        Matcher matcher = pattern.matcher(word);

        return matcher.find();
    }

    public static String wordToNumber(String word) {
        if (word.contains("one")) {
            return "1";
        }

        if (word.contains("two")) {
            return "2";
        }

        if (word.contains("three")) {
            return "3";
        }

        if (word.contains("four")) {
            return "4";
        }

        if (word.contains("five")) {
            return "5";
        }

        if (word.contains("six")) {
            return "6";
        }

        if (word.contains("seven")) {
            return "7";
        }

        if (word.contains("eight")) {
            return "8";
        }

        if (word.contains("nine")) {
            return "9";
        }

        return "";
    }

    public static String getTwoDigitsNumber(String line) {
        String output = "";
        String firstWord = "";
        String lastWord = "";

        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                output+=line.charAt(i);
                break;
            } else {
              firstWord+=line.charAt(i);

              if (isWordNumber(firstWord)) {
                  output+=wordToNumber(firstWord);
                  break;
              }
            }
        }

        for (int i = line.length() - 1; i >= 0; i--) {
            if (Character.isDigit(line.charAt(i))) {
                output+=line.charAt(i);
                break;
            } else {
                lastWord = line.charAt(i) + lastWord;

                if (isWordNumber(lastWord)) {
                    output+=wordToNumber(lastWord);
                    break;
                }
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
                String getLineNumber = getTwoDigitsNumber(line);

                output+=Integer.parseInt(getLineNumber);

            }

            System.out.println(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

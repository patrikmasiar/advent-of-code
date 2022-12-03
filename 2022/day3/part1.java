
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        File source = new File("input.txt");
        Scanner reader = null;
        ArrayList<Character> shares = new ArrayList<Character>();
        ArrayList<Character> lowerCaseAlphabets = new ArrayList<Character>();
        ArrayList<Character> upperCaseAlphabets = new ArrayList<Character>();
        int sum = 0;

        char lowercaseAlphabet;
        for(lowercaseAlphabet = 'a'; lowercaseAlphabet <= 'z'; lowercaseAlphabet++){
            lowerCaseAlphabets.add(lowercaseAlphabet);
        }

        char uppercaseAlphabet;
        for(uppercaseAlphabet = 'A'; uppercaseAlphabet <= 'Z'; uppercaseAlphabet++){
            upperCaseAlphabets.add(uppercaseAlphabet);
        }

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();
                int itemsCount = line.length();
                int halfCount = itemsCount / 2;
                String firstHalf = line.substring(0, halfCount);
                String secondHalf = line.substring(halfCount);
                ArrayList<Character> lineShares = new ArrayList<Character>();

                for (int i = 0; i < firstHalf.length(); i++) {
                    String item = String.valueOf(firstHalf.charAt(i));

                    if (secondHalf.contains(item)) {
                        lineShares.add(firstHalf.charAt(i));
                    }
                }

                Set<Character> unique = new LinkedHashSet<>();
                for (int i = 0; i < lineShares.size(); i++){
                    unique.add(lineShares.get(i));
                }

                shares.addAll(unique);
                lineShares.clear();
            }

            for (int i = 0; i < shares.size(); i++) {
                if (lowerCaseAlphabets.contains(shares.get(i))) {
                    int value = lowerCaseAlphabets.indexOf(shares.get(i)) + 1;
                    sum += value;
                } else {
                    int value = upperCaseAlphabets.indexOf(shares.get(i)) + 27;
                    sum += value;
                }
            }

            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

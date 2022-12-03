
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
        ArrayList<String> elfs = new ArrayList<String>();
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
                elfs.add(line);
            }

            for (int i = 0; i < elfs.size()-2; i+=3) {
                String firstElf = elfs.get(i);
                String secondElf = elfs.get(i + 1);
                String thirdElf = elfs.get(i + 2);
                ArrayList<Character> lineShares = new ArrayList<Character>();

               for (int j = 0; j < firstElf.length(); j++) {
                   if (secondElf.contains(String.valueOf(firstElf.charAt(j))) && thirdElf.contains(String.valueOf(firstElf.charAt(j)))) {
                       lineShares.add(firstElf.charAt(j));
                   }
               }

               Set<Character> unique = new LinkedHashSet<>();

               for (int j = 0; j < lineShares.size(); j++) {
                   unique.add(lineShares.get(j));
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

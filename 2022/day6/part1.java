import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static int CODE_LENGTH = 4;

    public static boolean isUnique(String input) {
        for(int i = 0; i < input.length(); i++) {
            int count = 0;
            for(int j = i; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j))
                    count++;
            }

            if(count > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        File source = new File("input.txt");
        Scanner reader = null;

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();

                for (int i = 0; i < line.length(); i++) {
                    String code = line.substring(i, i + CODE_LENGTH);

                    if (isUnique(code)) {
                        System.out.println(i + CODE_LENGTH);
                        break;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

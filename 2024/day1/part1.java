import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        File source = new File("input.txt");
        Scanner reader = null;
        ArrayList<Integer> col1 = new ArrayList<>();
        ArrayList<Integer> col2 = new ArrayList<>();
        Integer output = 0;

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();
                String[] splited = line.split("\\s+");

                col1.add(Integer.parseInt(splited[0]));
                col2.add(Integer.parseInt(splited[1]));
            }

            Collections.sort(col1);
            Collections.sort(col2);


            for (int i = 0; i < col1.size(); i++) {
                output += Math.abs(col1.get(i) - col2.get(i));
            }


            System.out.println(output);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

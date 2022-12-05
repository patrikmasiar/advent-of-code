
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File source = new File("input.txt");
        Scanner reader = null;
        int result = 0;

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().toString();
                String firstElf = line.split(",")[0];
                String secondElf = line.split(",")[1];
                int firstElfStart = Integer.parseInt(firstElf.split("-")[0]);
                int firstElfEnd = Integer.parseInt(firstElf.split("-")[1]);
                int secondElfStart = Integer.parseInt(secondElf.split("-")[0]);
                int secondElfEnd = Integer.parseInt(secondElf.split("-")[1]);
                ArrayList<Integer> firstElfData = new ArrayList<Integer>();
                ArrayList<Integer> secondElfData = new ArrayList<Integer>();

                for (int i = firstElfStart; i <= firstElfEnd; i++) {
                    firstElfData.add(i);
                }

                for (int i = secondElfStart; i <= secondElfEnd; i++) {
                    secondElfData.add(i);
                }

                if (firstElfData.size() > secondElfData.size()) {
                    for (int i = 0; i < secondElfData.size(); i++) {
                        if (firstElfData.contains(secondElfData.get(i))) {
                            result++;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < firstElfData.size(); i++) {
                        if (secondElfData.contains(firstElfData.get(i))) {
                            result++;
                            break;
                        }
                    }
                }
            }

            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

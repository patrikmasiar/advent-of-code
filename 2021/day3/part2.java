package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String getBinaryRating(int n, ArrayList<String> list, int preffer) {
        ArrayList<String> tempList = new ArrayList<>();

        if (list.size() == 1) {
            return list.get(0);
        } else {
            int zeroBits = 0;
            int oneBits = 0;

            for (int i = 0; i < list.size(); i++) {
                String line = list.get(i);

                if (line.charAt(n) == '1') {
                    oneBits++;
                } else {
                    zeroBits++;
                }
            }

            for (int i = 0; i < list.size(); i++) {
                String line = list.get(i);

                if (oneBits >= zeroBits) {
                    if (preffer == 1) {
                        if (line.charAt(n) == '1') {
                            tempList.add(line);
                        }
                    } else {
                        if (line.charAt(n) == '0') {
                            tempList.add(line);
                        }
                    }
                } else {
                    if (preffer == 1) {
                        if (line.charAt(n) == '0') {
                            tempList.add(line);
                        }
                    } else {
                        if (line.charAt(n) == '1') {
                            tempList.add(line);
                        }
                    }
                }
            }

            return getBinaryRating(n + 1, tempList, preffer);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("input.txt");
        ArrayList<String> input = new ArrayList<>();
        Scanner reader = null;

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                input.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int oxygenGeneratorRating = Integer.parseInt( getBinaryRating(0, input, 1),2);
        int CO2ScrubberRating = Integer.parseInt(getBinaryRating(0, input, 0),2);

        System.out.println(oxygenGeneratorRating * CO2ScrubberRating);

    }
}

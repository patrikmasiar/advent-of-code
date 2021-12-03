package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File source = new File("input.txt");
        ArrayList<String> input = new ArrayList<>();
        Scanner reader = null;
        int lineLength = 0;

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                lineLength = line.length();
                input.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String gammaRate = "";
        String epsilon = "";

        int zeroBits = 0;
        int oneBits = 0;

        for (int i = 0; i < lineLength; i++) {
            for (int j = 0; j < input.size(); j++) {
                String line = input.get(j);
                if (line.charAt(i) == '1') {
                    oneBits++;
                } else {
                    zeroBits++;
                }

                if (j == input.size() - 1) {
                    if (oneBits > zeroBits) {
                        gammaRate = gammaRate + "1";
                        epsilon = epsilon + "0";
                    } else {
                        gammaRate = gammaRate + "0";
                        epsilon = epsilon + "1";
                    }

                    zeroBits = 0;
                    oneBits = 0;
                }
            }
        }

        int gammaRateResult = Integer.parseInt(gammaRate,2);
        int epsilonResult = Integer.parseInt(epsilon,2);

        System.out.println(gammaRateResult * epsilonResult);
    }
}

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File source = new File("input.txt");

        Scanner reader = null;
        try {
            reader = new Scanner(source);
            List<Integer> values = new ArrayList<Integer>();

            while (reader.hasNextLine()) {
                int line = Integer.parseInt(reader.nextLine());
                values.add(line);
            }
            reader.close();

            List<Integer> sumValues = new ArrayList<Integer>();

            for (int i = 0; i < values.size(); i++) {
                int value = 0;

                if (i + 2 < values.size()) {
                    value = values.get(i) + values.get(i + 1) + values.get(i + 2);
                } else if (i + 1 < values.size()) {
                    value = values.get(i) + values.get(i + 1);
                } else {
                    value = values.get(i);
                }

                sumValues.add(value);
            }

            int increased = 0;
            int prevValue = 0;

            for (int i = 0; i < sumValues.size(); i++) {
                if (prevValue != 0 && sumValues.get(i) > prevValue) {
                    increased++;
                }

                prevValue = sumValues.get(i);
            }

            System.out.println(increased);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

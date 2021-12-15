package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File source = new File("input.txt");
        ArrayList<String> input = new ArrayList<>();
        Scanner reader = null;
        int cols = 0, rows = 0;

        try {
            reader = new Scanner(source);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                input.add(line);
                cols = line.length();
                rows++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);

            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        ArrayList<Integer> lows = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            String line = input.get(i);

            for (int j = 0; j < cols; j++) {
                int value = Character.getNumericValue(line.charAt(j));

                if (i == 0) {
                    if (j == 0) {
                        if (value < Character.getNumericValue(matrix[0][1]) && value < Character.getNumericValue(matrix[1][0])) {
                            lows.add(value);
                        }
                    } else if (j == cols - 1) {
                        if (value < Character.getNumericValue(matrix[0][cols - 2]) && value < Character.getNumericValue(matrix[1][cols - 1])) {
                            lows.add(value);
                        }
                    } else {
                        if (value < Character.getNumericValue(matrix[0][j + 1]) && value < Character.getNumericValue(matrix[0][j - 1]) && value < Character.getNumericValue(matrix[1][j])) {
                            lows.add(value);
                        }
                    }
                }

                if (i == rows - 1) {
                    if (j == 0) {
                        if (value < Character.getNumericValue(matrix[rows - 2][0]) && value < Character.getNumericValue(matrix[rows - 1][1])) {
                            lows.add(value);
                        }
                    } else if (j == cols - 1) {
                        if (value < Character.getNumericValue(matrix[rows - 1][cols - 2]) && value < Character.getNumericValue(matrix[rows - 2][cols - 1])) {
                            lows.add(value);
                        }
                    } else {
                        if (value < Character.getNumericValue(matrix[rows - 1][j + 1]) && value < Character.getNumericValue(matrix[rows - 1][j - 1]) && value < Character.getNumericValue(matrix[rows - 2][j])) {
                            lows.add(value);
                        }
                    }
                }

                if (j == 0 && i != 0 && i != rows - 1) {
                    if (value < Character.getNumericValue(matrix[i - 1][0]) && value < Character.getNumericValue(matrix[i + 1][0]) && value < Character.getNumericValue(matrix[i][1])) {
                        lows.add(value);
                    }
                }

                if (j == cols - 1 && i != 0 && i != rows - 1 ) {
                    if (value < Character.getNumericValue(matrix[i - 1][cols - 1]) && value < Character.getNumericValue(matrix[i + 1][cols - 1]) && value < Character.getNumericValue(matrix[i][cols - 2])) {
                        lows.add(value);
                    }
                }

                if (i != 0 && j != 0 && i != rows - 1 && j != cols - 1) {
                    if (value < Character.getNumericValue(matrix[i - 1][j]) && value < Character.getNumericValue(matrix[i + 1][j]) && value < Character.getNumericValue(matrix[i][j - 1]) && value < Character.getNumericValue(matrix[i][j + 1])) {
                        lows.add(value);
                    }
                }

            }
        }

        int sum = lows.size();

        for (int i = 0; i < lows.size(); i++) {
            sum += lows.get(i);
        }

        System.out.println(sum);
    }
}

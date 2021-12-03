package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        File source = new File("input.txt");
        Pattern regex = Pattern.compile("\\d+");

        Scanner reader = null;
        try {
            reader = new Scanner(source);
            int horizontalPosition = 0;
            int depthPosition = 0;
            int aim = 0;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Matcher match = regex.matcher(line);

                if (match.find()) {
                    int position = Integer.parseInt(match.group(0));

                    if (line.contains("forward")) {
                        horizontalPosition += position;
                        depthPosition += (aim * position);
                    }

                    if (line.contains("down")) {
                        aim += position;
                    }

                    if (line.contains("up")) {
                        aim -= position;
                    }
                }
            }

            System.out.println(horizontalPosition * depthPosition);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

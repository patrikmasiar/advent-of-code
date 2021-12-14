package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static Integer min(ArrayList<Integer> list)
    {
        int min = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            if (min > list.get(i)) {
                min = list.get(i);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        String values = "";
        ArrayList<Integer> input = new ArrayList<Integer>();

        try {
            values = new String(Files.readAllBytes(Paths.get("input.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] inputArr = values.split(",");

        for (String number : inputArr) {
            input.add(Integer.parseInt(number.trim()));
        }
        
        ArrayList<Integer> costs = new ArrayList<Integer>();

        for (int i = 0; i < input.size(); i++) {
            int sum = 0;

            for (int j = 0; j < input.size(); j++) {
                sum += Math.abs(input.get(j) - input.get(i));
            }

            costs.add(sum);
        }

        System.out.println(min(costs));
    }
}

package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> getList(ArrayList<Integer> list, int day) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();

        if (day == 80) {
            return list;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                tempList.add(6);
            } else {
                tempList.add(list.get(i) - 1);
            }
        }

        if (day >= 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == 0 && tempList.get(i) == 6) {
                    tempList.add(8);
                }
            }
        }


        return getList(tempList, day + 1);
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

        ArrayList<Integer> output = getList(input, 0);
	    System.out.println(output.size());
    }
}

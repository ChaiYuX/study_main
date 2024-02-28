package com.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(31);
        list.add(31);
        list.add(8);

        Map<Integer, List<Integer>> duplicatePositions = new HashMap<>();

        int start = -1;
        int end = -1;
        int previous = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            if (current == previous) {
                if (start == -1) {
                    start = i - 1;
                }
                end = i;
            } else {
                if (start != -1 && end != -1) {
                    List<Integer> positions = new ArrayList<>();
                    positions.add(start);
                    positions.add(end);
                    duplicatePositions.put(previous, positions);
                }
                start = i;
                end = i;
            }
            previous = current;
        }

        if (start != -1 && end != -1) {
            List<Integer> positions = new ArrayList<>();
            positions.add(start);
            positions.add(end);
            duplicatePositions.put(previous, positions);
        }

        for (Map.Entry<Integer, List<Integer>> entry : duplicatePositions.entrySet()) {
            int num = entry.getKey();
            List<Integer> positions = entry.getValue();
            System.out.println("Number: " + num + ", Start: " + positions.get(0) + ", End: " + positions.get(1));
        }
    }

}

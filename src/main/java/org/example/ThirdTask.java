package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ThirdTask {

    public static void main(String[] args) {
        countWordFrequency("words.txt");
    }

    public static void countWordFrequency(String fileName) {
        Map<String, Integer> freq = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            for (String line : lines) {
                String[] words = line.trim().split("\\s+");

                for (String w : words) {
                    if (!w.isEmpty()) {
                        freq.put(w, freq.getOrDefault(w, 0) + 1);
                    }
                }
            }

            // сортування
            List<Map.Entry<String, Integer>> sorted =
                    new ArrayList<>(freq.entrySet());

            sorted.sort((a, b) -> b.getValue() - a.getValue());

            for (Map.Entry<String, Integer> e : sorted) {
                System.out.println(e.getKey() + " " + e.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
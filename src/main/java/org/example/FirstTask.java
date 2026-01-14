package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class FirstTask {
    private static final Pattern VALID_PHONE = Pattern.compile(
            "^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$"
    );

    public static void printValidNumbers(String fileName) {
        try {
            Files.lines(Paths.get(fileName))
                    .filter(line -> VALID_PHONE.matcher(line).matches())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printValidNumbers("file.txt");
    }

}

package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SecondTask {

    static class User {
        String name;
        int age;

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        convertTxtToJson("file.txt", "user.json");
    }

    public static void convertTxtToJson(String inputFile, String outputFile) {
        List<User> users = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            if (lines.isEmpty()) return;

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).trim().split("\\s+");
                if (parts.length == 2) {
                    users.add(new User(parts[0], Integer.parseInt(parts[1])));
                }
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);

            Files.write(Paths.get(outputFile), json.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //create new txt files
    public static void main(String[] args) throws IOException {
        File file1 = new File("file.txt");
        if (file1.createNewFile()){
            System.out.println("New file.txt created");
        }else System.out.println("Cannot create new file, it already exists");

        File file2 = new File("words.txt");
        if (file2.createNewFile()){
            System.out.println("New words.txt created");
        }else System.out.println("Cannot create new words-file, it already exists");
    }


}
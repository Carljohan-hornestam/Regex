package com.company;

import jdk.jshell.EvalException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Program {
    Validator validator = new Validator();
    String stringToFix;
    String nextStringToFix;
    public Program(){
        readFile();
        readSecondFile();
        run();
    }

    public void run(){
        validator.stringFixer(stringToFix);
        validator.secondStringFixer(nextStringToFix);
        validator.birthdateChecker();
        validator.phoneChecker();
        validator.emailChecker();
        validator.passwordChecker();
    }
    public String readFile(){
        Path string1Path = Paths.get("Fil 1.txt");
        try {
            stringToFix = Files.readString(string1Path);
        } catch (IOException e) {
            System.out.println("Couldn't read file!");
            e.printStackTrace();
        }
        return stringToFix;
    }
    public String readSecondFile(){
        Path string1Path = Paths.get("Fil 2.txt");
        try {
            nextStringToFix = Files.readString(string1Path);
        } catch (IOException e) {
            System.out.println("Couldn't read file!");
            e.printStackTrace();
        }
        return nextStringToFix;
    }
}

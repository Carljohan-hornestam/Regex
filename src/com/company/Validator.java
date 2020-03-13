package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {

    Scanner scan = new Scanner(System.in);

    public boolean phoneChecker() {
        String phoneNumber;
        System.out.println("Enter your phonenumber: ");
        phoneNumber = scan.nextLine();

        if (Pattern.matches(".*[a-zA-Z]+.*", phoneNumber)) {
            System.out.println("Your phonenumber can only contain digits!");
            return false;
        }
        else if (phoneNumber.length() > 13){
            System.out.println("Your phonenumber can't be longer than 13 digits!");
            return false;
        }
        else {
            System.out.println(phoneNumber + " is valid.");
            return true;
        }
    }

    public boolean emailChecker() {
        String email;
        System.out.println("Enter your email: ");
        email = scan.nextLine();

        if (email.matches("^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$")) {
            System.out.println(email + " is valid");
            return true;
        } else {
            System.out.println("Your email must contain an " + "@" + " , a dot and have at least 2 characters before the @" +
                    " and 2 characters before and after the dot");
            return false;
        }
    }

    public boolean birthdateChecker() {
        String birthdate;
        System.out.println("Enter your birthdate: ");
        birthdate = scan.nextLine();

        if (Pattern.matches(".*[a-zA-Z].*", birthdate)) {
            System.out.println("Your birthdate can only contain digits!");
            return false;
        } else if (birthdate.length() > 15) {
            System.out.println("Your birthdate can't be more than 15 digits!");
            return false;
        } else if (Pattern.matches(".*[@_!#$%^&*()<>?/|}{~:].*", birthdate)){
            System.out.println("There can't be any special characters in your birthdate!");
            return false;
        }
        else {
            System.out.println(birthdate + " is valid!");
            return true;
        }
    }

    public boolean passwordChecker() {
        String password;
        System.out.println("Enter your password: ");
        password = scan.nextLine();

        if (password.matches(".*\\d.*") && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")
                && password.length() >= 8 && password.matches(".*\\W.*")) {
            System.out.println(password + " is valid!");
            return true;
        } else {
            System.out.println("Invalid! Your password must contain at least 1 uppercase letter, 1 lowercase letter" +
                    ", 1 digit and 1 of ex: #! %&/(“@ " + password);
            return false;
        }

    }

    public void stringFixer(String stringToFix) {

        String fixedString = stringToFix.replaceAll("[0-9]", "");

        List<String> fixedStringList = Arrays.asList(fixedString.split("\n"));
        List<String> resultList = fixedStringList.stream()
                .filter(s -> !s.isBlank())
                .collect(Collectors.toList());
        resultList.forEach(System.out::println);
        System.out.println();
    }

    public void secondStringFixer(String stringToFix) {
        String str = "";
        String[] strList = stringToFix.split("\n");

        for (String string : strList){
            str += string.replaceAll("\\s+", " ").trim() + "\n";
        }
        System.out.println(str);
    }
    }
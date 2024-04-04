package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static int getValidIntegerInput(){
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            try {
                n = sc.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.println("Enter again:");
                sc.nextLine();
            }
        }
        return n;
    }
    public static String getValidStringInput() {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            str = sc.nextLine();
            if (str.isEmpty()) System.out.println("Type again");
            else break;
        }
        return str;
    }
    public static String getValidStringInput(String str) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            str = sc.nextLine();
            if (str.isEmpty()) System.out.println("Type again");
            else break;
        }
        return str;
    }
    public static LocalDate getvalidDateInput() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;
        while (true) {
            String inputDate = scanner.nextLine();
            if (isValidDate(inputDate)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                date = LocalDate.parse(inputDate, formatter);
                break;
            } else {
                System.out.println("Not valid date.");
            }
        }
        return date;
    }
    public static boolean isValidDate(String inputDate) {
        String[] dateDigit = inputDate.split("/");
        if (Integer.parseInt(dateDigit[dateDigit.length - 1]) > 2023) {
            return false;
        }
        if (inputDate.length() != 10) {
            System.out.println("Wrong expected date format");
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(inputDate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean validStaffID(String id) {
        String pattern = "P\\d{3}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(id);
        return m.matches();
    }
    public static boolean validphone(String id) {
        String pattern = "\\d{10}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(id);
        return m.matches();
    }

    public static String normalizeName(String name) {
        name = name.replaceAll("[^a-z A-Z]", " ");
        name = name.trim();
        name = name.replaceAll("\\s+", " ");
        String[] words = name.toLowerCase().split(" ");
        for(int i = 0; i < words.length; i++) {
            words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
        }
        return String.join(" ", words);
    }
}

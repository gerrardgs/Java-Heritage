package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> identityMap = new HashMap<>();

        while (true) {
            try {
                System.out.println("\nSTUDENTS DATABASE");
                System.out.println("1. Add New Data");
                System.out.println("2. Delete Data (Based On The Name)");
                System.out.println("3. Show Grade (Based On The Name)");
                System.out.println("4. Show All Data");
                System.out.println("5. Exit");
                System.out.print("\nEnter Your Choice: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addData(scanner, identityMap);
                        break;
                    case 2:
                        deleteData(scanner, identityMap);
                        break;
                    case 3:
                        showGrade(scanner, identityMap);
                        break;
                    case 4:
                        showAllData(identityMap);
                        break;
                    case 5:
                        System.out.println("Exit The Program");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice. Please Re-Enter A Valid Number (Between 1 and 5)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please Re-Enter A Valid Number.");
                scanner.nextLine();
            }
        }
    }

    private static void addData(Scanner scanner, Map<String, Integer> identityMap) {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Grade: ");
            int grade = Integer.parseInt(scanner.nextLine());

            identityMap.put(name, grade);
            System.out.println("Data Successfully Added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please Re-enter A Valid Number.");
        }
    }

    private static void deleteData(Scanner scanner, Map<String, Integer> identityMap) {
        try {
            System.out.print("Enter Name To Delete The Data: ");
            String name = scanner.nextLine();

            if (identityMap.containsKey(name)) {
                identityMap.remove(name);
                System.out.println("Data For " + name + " Successfully Deleted.");
            } else {
                System.out.println("No Data Found For " + name + ".");
            }
        } catch (Exception e) {
            System.out.println("An Error Detected. Please Try Again.");
        }
    }

    private static void showGrade(Scanner scanner, Map<String, Integer> identityMap) {
        try {
            System.out.print("Enter Name To Show The Grade: ");
            String name = scanner.nextLine();

            if (identityMap.containsKey(name)) {
                int grade = identityMap.get(name);
                System.out.println("Grade For " + name + ": " + grade);
            } else {
                System.out.println("No data found for " + name + ".");
            }
        } catch (Exception e) {
            System.out.println("An Error Detected. Please Try Again.");
        }
    }

    private static void showAllData(Map<String, Integer> identityMap) {
        System.out.println("\nStudents Data's Recap:");
        for (Map.Entry<String, Integer> entry : identityMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

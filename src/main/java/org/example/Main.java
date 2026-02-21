package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentRegistration studentRegistration = new StudentRegistration();

        while(true){
            System.out.println("[1] Save Student");
            System.out.println("[2] Display Student");
            System.out.println("[3] Update Student");
            System.out.println("[4] Remove Student");

            System.out.print("\nEnter Choice:");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Student ID: ");
                    String ID = scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Student Program: ");
                    String program = scanner.nextLine();

                    studentRegistration.addStudent(new Student(name,ID,program));
                    System.out.println();
                    break;

                case "2":
                    System.out.println();
                    studentRegistration.displayAll();
                    break;

                case "3":
                    System.out.print("Enter Student ID to update: ");
                    String updateID = scanner.nextLine();

                    Student studentToUpdate = new Student();
                    studentToUpdate.setID(updateID);
                    studentRegistration.updateStudent(studentToUpdate);
                    System.out.println();
                    break;

                case "4":
                    System.out.print("Enter Student ID to remove: ");
                    String removeID = scanner.nextLine();

                    Student studentToRemove = new Student();
                    studentToRemove.setID(removeID);
                    System.out.println(studentRegistration.delete(studentToRemove));
                    break;

                default:
                    System.out.println("Invalid Choice. Please try again.");
                    break;

            }
        }

    }
}
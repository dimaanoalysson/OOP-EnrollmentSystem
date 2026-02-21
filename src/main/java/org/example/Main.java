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
        CourseRegistration courseRegistration = new CourseRegistration();

        boolean validMainChoice = false;

        while (!validMainChoice) {
            System.out.println("\n---MAIN MENU---\n");
            System.out.println("A. Student Registration");
            System.out.println("B. Course Registration");
            System.out.println("C. Exit");

            System.out.print("Enter Choice: ");
            String mainChoice = scanner.nextLine();

            if (mainChoice.equalsIgnoreCase("A")) {

                System.out.println("\n---STUDENT REGISTRATION---");
                System.out.println("[1] Save Student");
                System.out.println("[2] Display Student");
                System.out.println("[3] Update Student");
                System.out.println("[4] Remove Student");

                System.out.print("Enter Choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("\nEnter Student ID: ");
                        String ID = scanner.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Student Program: ");
                        String program = scanner.nextLine();

                        studentRegistration.addStudent(new Student(ID, name, program));
                        System.out.println();
                        break;

                    case "2":
                        System.out.println();
                        studentRegistration.displayAll();
                        break;

                    case "3":
                        System.out.print("\nEnter Student ID to update: ");
                        String updateID = scanner.nextLine();

                        Student studentToUpdate = new Student();
                        studentToUpdate.setID(updateID);
                        studentRegistration.updateStudent(studentToUpdate);
                        break;

                    case "4":
                        System.out.print("\nEnter Student ID to remove: ");
                        String removeID = scanner.nextLine();

                        Student studentToRemove = new Student();
                        studentToRemove.setID(removeID);
                        System.out.println(studentRegistration.delete(studentToRemove));
                        break;



                    default:
                        System.out.println("Invalid Choice. Please try again.\n");
                        break;
                }
            } else if (mainChoice.equalsIgnoreCase("B")) {

                System.out.println("\n---COURSE REGISTRATION---");
                System.out.println("[1] Save Course");
                System.out.println("[2] Display Course");
                System.out.println("[3] Update Course");
                System.out.println("[4] Remove Course");

                System.out.print("Enter Choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.print("\nEnter Course ID: ");
                        String courseID = scanner.nextLine();

                        System.out.print("Enter Course Name: ");
                        String courseName = scanner.nextLine();

                        System.out.print("Enter Course Program: ");
                        String courseProgram = scanner.nextLine();

                        courseRegistration.addCourse(new Course(courseID, courseName, courseProgram));
                        System.out.println();
                        break;

                    case "2":
                        System.out.println();
                        courseRegistration.displayAll();
                        break;

                    case "3":
                        System.out.print("\nEnter Course ID to update: ");
                        String updateCID = scanner.nextLine();

                        Course courseToUpdate = new Course();
                        courseToUpdate.setcourseID(updateCID);
                        courseRegistration.updateCourse(courseToUpdate);
                        break;

                    case "4":
                        System.out.print("\nEnter Course ID to remove: ");
                        String removeID = scanner.nextLine();

                        Course courseToRemove = new Course();
                        courseToRemove.setcourseID(removeID);
                        System.out.println(courseRegistration.delete(courseToRemove));
                        break;

                    default:
                        System.out.println("\nInvalid Choice. Please try again.");
                        break;
                }
            } else if (mainChoice.equalsIgnoreCase("C")) {
                    System.out.println("Program Terminated.");
                    validMainChoice = true;
            } else {
                    System.out.println("Invalid Choice. Please try again. \n");
            }
        }
    }
}
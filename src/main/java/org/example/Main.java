package org.example;

import org.example.model.Course;
import org.example.model.Person;
import org.example.model.Student;
import org.example.model.Instructor;
import org.example.model.TuitionFeePayment;
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
            System.out.println("C. Tuition Fee Payment");
            System.out.println("D. Exit");

            System.out.print("Enter Choice: ");
            String mainChoice = scanner.nextLine();

            if (mainChoice.equalsIgnoreCase("A")) {

                boolean isStudentMenu = true;
                while (isStudentMenu) {
                System.out.println("\n---STUDENT REGISTRATION---");
                System.out.println("[1] Save Student");
                System.out.println("[2] Display Student");
                System.out.println("[3] Update Student");
                System.out.println("[4] Remove Student");
                System.out.println("[5] Back to Main Menu");

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
                        studentToUpdate.setPersonID(updateID);
                        studentRegistration.updateStudent(studentToUpdate);
                        break;

                    case "4":
                        System.out.print("\nEnter Student ID to remove: ");
                        String removeID = scanner.nextLine();

                        Student studentToRemove = new Student();
                        studentToRemove.setPersonID(removeID);
                        System.out.println(studentRegistration.delete(studentToRemove));
                        break;

                    case "5":
                        isStudentMenu = false;
                        break;

                    default:
                        System.out.println("Invalid Choice. Please try again.\n");
                        break;
                    }
                }
            } else if (mainChoice.equalsIgnoreCase("B")) {

                boolean isCourseMenu = true;
                while (isCourseMenu) {
                System.out.println("\n---COURSE REGISTRATION---");
                System.out.println("[1] Save Course");
                System.out.println("[2] Display Course");
                System.out.println("[3] Update Course");
                System.out.println("[4] Remove Course");
                System.out.println("[5] Back to Main Menu");

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

                        Course newCourse = new Course(courseID, courseName, courseProgram);

                        System.out.print("Enter Instructor Name: ");
                        String instructorName = scanner.nextLine();
                        Instructor courseInstructor = new Instructor("Instructor: " + courseID, instructorName, courseProgram);

                        newCourse.setInstructor(courseInstructor);
                        courseRegistration.addCourse(newCourse);

                        System.out.print("Instructor Role: ");
                        courseInstructor.mainTask();
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

                    case "5":
                        isCourseMenu = false;
                        break;

                    default:
                        System.out.println("\nInvalid Choice. Please try again.");
                        break;
                    }
                }
            } else if (mainChoice.equalsIgnoreCase("C")) {

                boolean isTuitionMenu = true;
                while (isTuitionMenu) {
                System.out.println("\n---TUITION PAYMENT---");
                System.out.print("Enter Student ID: ");
                String studentID = scanner.nextLine();

                Student currentStudent = studentRegistration.getStudent(studentID);

                if (currentStudent == null){
                    System.out.println("Student not found! Please REGISTER the student in Main Menu: 'A'. Thank you!");
                } else {
                    System.out.println("Student Found: " + currentStudent.getPersonName());
                    System.out.println("[1] Choose Plan");
                    System.out.println("[2] Make Payment");
                    System.out.println("[3] Check Balance");

                    System.out.print("Enter Choice: ");
                    String tuitionChoice = scanner.nextLine();

                    TuitionFeePayment transaction = currentStudent.getPaymentTransaction();

                    switch (tuitionChoice) {
                        case "1":
                            System.out.print("Enter total number of units: ");
                            int units = Integer.parseInt(scanner.nextLine());

                            System.out.println("\nChoose Payment Plan:");
                            System.out.println("Plan A: Full Payment (3% discount)");
                            System.out.println("Plan B: Quarterly Payment");
                            System.out.println("Plan C: Monthly Payment");

                            System.out.print("Select Plan (A/B/C): ");
                            String plan = scanner.nextLine().toUpperCase();

                            double discount = 0.0;
                            if (plan.equalsIgnoreCase("A")){
                                discount = 0.03;
                            } else if (plan.equalsIgnoreCase("B") || plan.equalsIgnoreCase("C")){
                                discount = 0.00;
                            } else {
                                System.out.println("Invalid Payment Plan Selected. Please try again. \n");
                            break;
                        }

                        double total = transaction.calculateTuitionFee(units, discount);
                        System.out.println("\nTotal Tuition: " + total);

                        if (plan.equalsIgnoreCase("B")){
                            System.out.println("Quarterly Payment Amount (4 terms): " + (total / 4));
                        }else if (plan.equalsIgnoreCase("C")) {
                            System.out.println("Monthly payment amount (10 months): " + (total / 10));
                        }

                        System.out.println("\n--- Proceeding to Payment ---");
                        System.out.print("Enter Payment Amount: ");
                        double amount = Double.parseDouble(scanner.nextLine());

                        transaction.makePayment(amount);
                        System.out.println("Payment Applied!");
                        transaction.getRemainingBalance();

                        System.out.println("\nReturning to Main Menu...");
                        isTuitionMenu = false;

                        break;

                        case "2":
                            System.out.print("Enter Payment Amount: ");
                            double amountFull = Double.parseDouble(scanner.nextLine());

                            transaction.makePayment(amountFull);
                            System.out.println("Payment Applied!");
                            transaction.getRemainingBalance();

                            System.out.println("\nReturning to Main Menu...");
                            isTuitionMenu = false;
                            break;

                        case "3":
                            transaction.getRemainingBalance();
                            System.out.println("\nReturning to Main Menu...");
                            isTuitionMenu = false;
                            break;

                        default:
                            System.out.println("Invalid Choice. Please try again. \n");
                            break;
                            }
                         }
                    }
                } else if (mainChoice.equalsIgnoreCase("D")) {
                    System.out.println("Program Terminated.");
                    validMainChoice = true;
                } else {
                    System.out.println("Invalid Choice. Please try again. \n");
            }
        }
        scanner.close();
    }
}
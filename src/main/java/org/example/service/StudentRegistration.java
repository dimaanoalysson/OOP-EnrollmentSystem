package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {
    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent(Student student){
        studentArrayList.add(student);
    }

    public void displayAll() {
        if (studentArrayList.isEmpty()){
            System.out.println("There are no students registered yet.");
            return;
        }

        for (Student s : studentArrayList){
            System.out.println("Student ID: " + s.getID());
            System.out.println("Student Name: " + s.getName());
            System.out.println("Student Program: " + s.getProgram());
            System.out.println();
        }
    }

    public void  updateStudent(Student student){
        boolean found = false;
        for (int i = 0; i < studentArrayList.size(); i++) {
            if(studentArrayList.get(i).getID().equals(student.getID())){
                System.out.print("Enter New Student Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter New Program: ");
                String program = scanner.nextLine();

                studentArrayList.set(i, new Student(student.getID(), name, program));
                found = true;
                System.out.println("Successfully Updated!\n");
                break;
            }
        }
    }

    public String delete(Student student){
        for(int i = 0; i < studentArrayList.size(); i++){
            if(studentArrayList.get(i).getID().equals(student.getID())){
                studentArrayList.remove(i);
                return "Student Successfully Deleted!";
            }
        }
        return "No such student exists!";
    }
}
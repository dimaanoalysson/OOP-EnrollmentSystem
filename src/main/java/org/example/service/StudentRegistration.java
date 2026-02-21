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
        System.out.println(studentArrayList);
    }

    public void  updateStudent(Student student){
        for (int i = 0; i < studentArrayList.size(); i++) {
            if(studentArrayList.get(i).getID() == (student.getID())){
                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter program: ");
                String age = scanner.nextLine();

                studentArrayList.set(i, new Student(student.getID(), name, age));
                break;
            }
        }
    }

    public String delete(Student student){
        for(int i = 0; i < studentArrayList.size(); i++){
            if(studentArrayList.get(i).getID() == (student.getID())){
                studentArrayList.remove(i);
                return "Successfully Deleted!";
            }
        }

        return "No such student exists!";
    }
}
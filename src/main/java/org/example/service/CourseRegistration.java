package org.example.service;

import org.example.model.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {
    private ArrayList<Course> courseArrayList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent(Course course){
        courseArrayList.add(course);
    }

    public void displayAll() {
        System.out.println(courseArrayList);
    }

    public void  updateStudent(Course course){
        for (int i = 0; i < courseArrayList.size(); i++) {
            if(courseArrayList.get(i).getcourseID() == (course.getcourseID())){
                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter program: ");
                String age = scanner.nextLine();

                courseArrayList.set(i, new Course(course.getcourseID(), course.getcourseName(), course.getCourseProgram()));
                break;
            }
        }
    }

    public String delete(Course course){
        for(int i = 0; i < courseArrayList.size(); i++){
            if(courseArrayList.get(i).getcourseID() == (course.getcourseID())){
                courseArrayList.remove(i);
                return "Successfully Deleted!";
            }
        }

        return "No such course exists!";
    }
}
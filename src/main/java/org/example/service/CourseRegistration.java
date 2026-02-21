package org.example.service;

import org.example.model.Course;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {
    private ArrayList<Course> courseArrayList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addCourse(Course course){
        courseArrayList.add(course);
    }

    public void displayAll() {
        if (courseArrayList.isEmpty()){
            System.out.println("There are no courses registered yet.");
            return;
        }

        for (Course c : courseArrayList){
            System.out.println("Course ID: " + c.getcourseID());
            System.out.println("Course Name: " + c.getcourseName());
            System.out.println("Course Program: " + c.getCourseProgram());
            System.out.println();
        }
    }

    public void  updateCourse(Course course){
        boolean found = false;
        for (int i = 0; i < courseArrayList.size(); i++) {
            if(courseArrayList.get(i).getcourseID().equals(course.getcourseID())){
                System.out.print("Enter New Course Name: ");
                String newCourse = scanner.nextLine();

                System.out.print("Enter New Program: ");
                String newProgram = scanner.nextLine();

                courseArrayList.set(i, new Course(course.getcourseID(), newCourse, newProgram));
                found = true;
                System.out.print("Successfully Updated!\n");
                break;
            }
        }
    }

    public String delete(Course course){
        for(int i = 0; i < courseArrayList.size(); i++){
            if(courseArrayList.get(i).getcourseID().equals(course.getcourseID())){
                courseArrayList.remove(i);
                return "Successfully Deleted!";
            }
        }

        return "No such course exists!";
    }
}
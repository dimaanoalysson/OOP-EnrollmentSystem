package org.example;

public class Course {
    private String courseID;
    private String courseName;
    private String courseProgram;

    //no-args constructor
    public Course(){

    }

    // Constructor
    public Course(String CourseID, String courseName, String courseProgram){
        this.courseID = CourseID;
        this.courseName = courseName;
        this.courseProgram = courseProgram;
    }

    public String getcourseID(){
        return courseID;
    }

    public void setcourseID(String courseID){
        this.courseID = courseID;
    }

    public String getcourseName(){
        return courseName;
    }

    public void setcourseName(String courseName){
        this.courseName = courseName;
    }

    public void setcourseProgram(String courseProgram){
        this.courseProgram = courseProgram;
    }

    public String getCourseProgram(){
        return courseProgram;
    }
}

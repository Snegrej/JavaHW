package com.app;

import java.util.ArrayList;


public class Classroom
{
    private String name;
    private String teacher;
    final private int number;
    public ArrayList<Student> students;

    public Classroom(String _name,String _teacher,int _number){
      name = _name;
      teacher = _teacher;
      number = _number;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}

package com.app;

public class Student
{
    private String last;
    private String first;
    private int id;
    
    public Student(){
        last = "EXAMPLE";
        first = "STUDENT";
        id = 999999;
    }
    public Student(String _last, String _first, int _id){
      last = _last;
      first = _first;
      id = _id;
    }

    public String getLast() {
        return last;
    }

    public String getFirst() {
        return first;
    }
    public int getId(){
     return id;   
    }

}

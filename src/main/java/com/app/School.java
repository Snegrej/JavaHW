package com.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class School
{
    public ArrayList<Student> studentMasterList;
    final public String name;

    public School(String _name){
      studentMasterList = new ArrayList<Student>();
      name = _name;
    }

    /**
     *
     * @param studentFile
     * @throws FileNotFoundException
     */
    public void enrollStudents(String studentFile) throws FileNotFoundException{
      File file = new File("src/main/resources/dataFiles/"+studentFile);
      Scanner sc = new Scanner(file);
      String last, first;
      int id;

      while(sc.hasNext()){
        last = sc.next().replaceAll(",","");
        first = sc.next();
        id = sc.nextInt();
        studentMasterList.add(new Student(last,first,id));
      }
      sc.close();
    }

    public void sortStudentsName(){
        Collections.sort(studentMasterList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2){
                return s1.getLast().compareTo(s2.getLast());
            }
        });
    }

    public void sortStudentsId(){
      Collections.sort(studentMasterList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2){
                return s1.getId()-s2.getId();
            }
        });
    }

    public void printStudents(ArrayList<Student> studentList){
      for(final Student student : studentList){
        System.out.println(student.getLast() + ", " + student.getFirst() + " " + student.getId());
      }
    }

    public static void main(String[] args) throws FileNotFoundException{
      School cmu = new School("Colorado Mesa University");
      cmu.run();
    }

    public void run() throws FileNotFoundException{
      enrollStudents("students.dat");
      printStudents(studentMasterList);
      System.out.println("\n");
      sortStudentsName();
      printStudents(studentMasterList);
      System.out.println("\n");
      sortStudentsId();
      printStudents(studentMasterList);
    }
}

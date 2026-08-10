package Phase_3.Day_1;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    public static void main(String[] args) {
        List<Student> ll = new ArrayList<>();

        ll.add(new Student("Bablu", 95));
        ll.add(new Student("Suresh", 80));
        ll.add(new Student("Pauaa", 98));
        ll.add(new Student("Chintu", 40));
        ll.add(new Student("Ramesh", 71));

//        for(Student s : ll){
//            if(s.marks <= 40){
//                System.out.println(s.name + " -> " + "fail");
//            }
//        }

        ll.stream().filter(e->e.marks <= 40).forEach(x-> System.out.println(x.name + " -> " + "fail"));
    }

   static class Student{
        String name;
        int marks;

         Student(String name, int marks){
            this.name = name;
            this.marks = marks;
        }
    }
}

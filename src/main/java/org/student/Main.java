package org.student;

import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(" Welcome to student management app");
        /* Efficiently reads console input by combining BufferedReader and InputStreamReader
        1.	Uses BufferedReader for efficient input.
	    2.	Uses InputStreamReader to convert byte input from System.in to character input.
	    3.	Reads data from the console.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("press 1 to ADD Student");
            System.out.println("press 2 to Delete Student");
            System.out.println("press 3 to Display Student");
            System.out.println("press 4 to exit APP");
            int c = Integer.parseInt(br.readLine());

            if(c == 1){
                //add student
                System.out.println("Enter user name :");
                String name=br.readLine();
                System.out.println("Enter user phone :");
                String phone =br.readLine();
                System.out.println("Enter user City :");
                String city = br.readLine();

                //create student object to store student
                Student st = new Student(name,phone,city);

                // Calls the method to insert a new student record into the database
              boolean answer=  StudentDao.insertStudentToDB(st);
              if(answer){
                  System.out.println("Student added successfully...");
              }else{
                  System.out.println("Spmething went wrong");
              }
                System.out.println(st);

            }
            else if(c == 2){
                // delete student
                System.out.println("enter student id to delete");
                int userId = Integer.parseInt(br.readLine());
                boolean f = StudentDao.deleteStudent(userId);
                if(f){
                    System.out.println("deleted");
                }else{
                    System.out.println("something went wrong");
                }

            }
            else if(c == 3){
                //display students
                StudentDao.showAllStudent();

            }
            else if(c == 4){
                //exit
                break;
            }else{

            }
        }
        System.out.println("Thank you for using this application");

    }
}
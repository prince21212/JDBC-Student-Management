package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
  static  boolean f = false;
    public static boolean insertStudentToDB(Student st){
        //jdbc code.....

        try{
          Connection con = CP.createC();
          String q = "insert into students(sname,sphone,scity)values(?,?,?)";

          //prepared statement
            PreparedStatement pstmt =con.prepareStatement(q);

            //set the values of parameter
            pstmt.setString(1,st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            //execute....
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

      return f;
    }

    public static boolean deleteStudent(int userId) {

        try{
            Connection con = CP.createC();
            String q = "delete from students where sid = ?";

            //prepared statement
            PreparedStatement pstmt =con.prepareStatement(q);

            //set the values of parameter
            pstmt.setInt(1,userId);

            //execute....
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public static boolean showAllStudent() {

        try{
            Connection con = CP.createC();
            String q = "select * from students";
            Statement stmt=con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            while(set.next()){
                int id = set.getInt(1);
                String name= set.getString(2);
                String phone = set.getString(3);
                String city = set.getString("scity");
                System.out.println("ID :"+ id);
                System.out.println("Name:"+ name);
                System.out.println("Phone :"+ phone);
                System.out.println("city :"+ city);
                System.out.println("+++++++++++++++++++++++++++++");


            }
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}

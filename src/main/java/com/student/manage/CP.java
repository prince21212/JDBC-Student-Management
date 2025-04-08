package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//connection provider
public class CP {
    static Connection con;
    public static Connection createC() {
        try {
            // No need for Class.forName() with modern drivers
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_manage?useSSL=false&serverTimezone=UTC",
                    "root",
                    "root1234");
            System.out.println("Connection successful!");
           // con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return con;
    }
}

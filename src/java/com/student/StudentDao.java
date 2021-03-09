/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abhi
 */
public class StudentDao   {

    public List<Student> fetchAllStudentList() throws ClassNotFoundException, SQLException {
        List<Student> studentList = new ArrayList<Student>();

       try{
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt;
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","123456")) {
                System.out.print("conn");
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from StudentDetail");
                
                studentList = new ArrayList<>();
                if (rs.next()) {
                    System.out.println(rs.getInt("Student_no"));
                    int student_no = rs.getInt("Student_no");
                    String name = rs.getString("name");
                    String dob = rs.getString("dob");
                    String doj = rs.getString("doj");
                    studentList.add(new Student(student_no, name, dob, doj));
                 
                    System.out.print(studentList);
                }
            }

            stmt.close();
       }
       catch(SQLException e){
       System.out.print(e);}
            return studentList;
        }
    public String addstudent(int student_no,String name,String dob,String doj) throws ClassNotFoundException, SQLException{
     Class.forName("com.mysql.jdbc.Driver");
    Statement stmt;
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","123456")) {
                System.out.print("conn");
                stmt = con.createStatement();
                int rs = stmt.executeUpdate("Insert into StudentDetail values("+student_no+",'"+name+"','"+dob+"','"+doj+"')");
                    if(rs==1){
                        return "Success";
                    }}
    return "fail";
    }
    }


package org.jdbcLearning_1;

// DAO --> Data Access Object

// 👉 This program demonstrates how to:
//    1. Fetch a student record from the database using roll number
//    2. Add a new student record into the database

import java.sql.*;

class DAO {
    public static void main(String[] args) throws Exception {

        // ✅ Fetch a student using rollno
        StudentDAO dao1 = new StudentDAO();
        Student s1 = dao1.getStudent(3); // get student with rollno=5
        System.out.println(s1.sname);    // print the student name

        // ✅ Add a new student into the database
        StudentDAO dao2 = new StudentDAO();
        Student s2 = new Student();
        s2.rollno = 102;
        s2.sname = "Nikhat";
        dao2.addStudent(s2); // insert into DB
    }
}

// ✅ Model class (POJO) representing a Student record
class Student {
    int rollno;
    String sname;
}

// ✅ Data Access Object for Student
class StudentDAO {

    // 🔹 Fetch student details from DB by roll number
    public Student getStudent(int rollnumb) { // will return Student object
        Student s = new Student();
        s.rollno = rollnumb;

        try {
            // SQL query to fetch student name by roll number
            String query = "SELECT studName FROM student WHERE studRollno=" + rollnumb;

            // Load driver + create connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/school_student",
                    "root",
                    "123456789"
            );

            // Execute query
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Move to first row and get student name
            rs.next();
            s.sname = rs.getString(1);

            // Close resources
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        // Returns Student object (with name if found, null name if failed)
        return s;
    }

    // 🔹 Add a student record into DB
    public void addStudent(Student s) {
        try {
            // Use PreparedStatement to prevent SQL Injection
            String query = "INSERT INTO student VALUES (?, ?)";

            // Load driver + create connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/school_student",
                    "root",
                    "123456789"
            );

            // Prepare query and set values
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, s.rollno);    // first ? → rollno
            pst.setString(2, s.sname);  // second ? → sname

            // Execute insert
            int count = pst.executeUpdate();
            System.out.println(count + " row(s) inserted.");

            // Close resources
            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

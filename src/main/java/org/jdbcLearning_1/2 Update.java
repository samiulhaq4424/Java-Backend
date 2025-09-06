package org.jdbcLearning_1;

/*
    JDBC Steps Recap:
    1. Import package --> java.sql.*
    2. Load and register the driver (Class.forName)
    3. Create connection (DriverManager.getConnection)
    4. Create a statement (Statement or PreparedStatement)
    5. Execute the query (executeUpdate for INSERT/UPDATE/DELETE, executeQuery for SELECT)
    6. Process the results (if SELECT returns rows)
    7. Close resources
*/

import java.sql.*;

class Update {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/db";
        String username = "root";
        String password = "123456789";

        // **********************************
        // Example 1: Using Statement (manual SQL building with string concatenation)
        // -----------------------------------
        // ⚠️ You must manually add single quotes around string values in SQL.
        // If you forget quotes, MySQL will think the value is a column name and throw an error.
        // Example final SQL: INSERT INTO student VALUES (104, 'Sallu')
        int uId = 104;
        String uName = "Sallu";
        String query = "INSERT INTO student VALUES (" + uId + ", '" + uName + "')"; //this line is vulnerable to SQL Injection

        Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
        Connection con1 = DriverManager.getConnection(url, username, password); // connect DB
        Statement st1 = con1.createStatement(); // create statement
        int count = st1.executeUpdate(query); // execute query -> returns number of rows affected

        System.out.println(count + " row(s) affected (Statement)");

        st1.close();
        con1.close();
        // **********************************




        // **********************************
        // Example 2: Using PreparedStatement (recommended way)
        // -----------------------------------
        // ✅ No need to worry about quotes or string concatenation.
        // ✅ Prevents SQL Injection (safer).
        // ✅ Cleaner syntax when working with user input.
        int uId2 = 103;
        String uName2 = "Abul";
        String query2 = "INSERT INTO student VALUES (?, ?)"; // placeholders for values

        // Create connection
        Connection con2 = DriverManager.getConnection(url, username, password);
        // Create prepared statement
        PreparedStatement st2 = con2.prepareStatement(query2);
        // Bind variables to placeholders (1st ? = uId2, 2nd ? = uName2)
        st2.setInt(1, uId2);
        st2.setString(2, uName2);

        int count2 = st2.executeUpdate(); // execute prepared query
        System.out.println(count2 + " row(s) affected (PreparedStatement)");

        st2.close();
        con2.close();
        // **********************************
    }
}

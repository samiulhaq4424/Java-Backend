package org.jdbcLearning;

/*
    JDBC Steps:
    1. Import the package --> java.sql.*
    2. Load and register the driver (Class.forName)
    3. Create a connection (DriverManager.getConnection)
    4. Create a statement (Connection.createStatement)
    5. Execute the query (Statement.executeQuery / executeUpdate)
    6. Process the results (ResultSet)
    7. Close connection and statement
*/

import java.sql.*;

class Fetch {
    public static void main(String[] args) throws Exception {

        // 1. Database connection details (update with your DB name, username, password)
        String url = "jdbc:mysql://localhost:3306/db";
        String username = "root";
        String password = "123456789";

        // 2. SQL query
        // String query = "SELECT userid,userName FROM student WHERE userid=3"; // fetch single record
        String query = "SELECT * FROM student"; // fetch all records

        // 3. Load and register JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 4. Establish connection to MySQL
        Connection con = DriverManager.getConnection(url, username, password);

        // 5. Create a statement object to send SQL queries to the database
        Statement st = con.createStatement();

        // 6. Execute the query -> returns a ResultSet (like a cursor for reading rows)
        ResultSet rs = st.executeQuery(query); //DQL

        // 7. Process the ResultSet (loop through all rows)
        while (rs.next()) {
            // rs.getInt(1) → first column (userId), rs.getString(2) → second column (userName)
            String userData = rs.getInt(1) + " : " + rs.getString(2);
            System.out.println(userData);
        }

        // 8. Close statement and connection (important to free resources)
        st.close();
        con.close();
    }
}

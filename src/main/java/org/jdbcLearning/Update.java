package org.jdbcLearning;


/*
    1. import the pacakage --> java.sql.*
    2. load and register the driver
    3. Create connection
    4. Create a statement
    5. execute the query
    6. process the results
    7. close
*/

import java.sql.*;

class Update {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/db";
        String username = "root";
        String password = "123456789";

//        String query = "SELECT userid,userName from student where userid=3";
        String query = "SELECT * FROM student";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()) {
            String userData = rs.getInt(1) + " : " + rs.getString(2);
            System.out.println(userData);
        }

        st.close();
        con.close();

    }
}

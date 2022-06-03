package HRM;

import java.sql.*;

public class Connect {
    protected Connection c;
    protected Statement s;

    public Connect() throws SQLException {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            s = c.createStatement();
            s.executeUpdate("Create Database if not exists HRM");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        String url = "jdbc:mysql://localhost:3306/HRM";
        c = DriverManager.getConnection(url,"root","" );
        s = c.createStatement();
        s.executeUpdate("Create Table if not exists Admin(Uname varchar(50),pass varchar(150),Role varchar(50))");
        ResultSet rs = s.executeQuery("SELECT * FROM Admin WHERE Uname!='"+"' ");
        if (!rs.next()) {
            s.executeUpdate("INSERT INTO Admin(Uname, pass, Role) VALUES('admin','admin', 'Admin')");

        }
        s.executeUpdate("Create Table if not exists leave_employee(name varchar(150), date varchar(10), Reason varchar(150), Status int)");
        s.executeUpdate("Create Table if not exists EmployeeLogin(name varchar(100), email varchar(150), username varchar(100), pass varchar(50), role varchar(50), ID varchar(10), post varchar(10), salary int(6))");
    }


}

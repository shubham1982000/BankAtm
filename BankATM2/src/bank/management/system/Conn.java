package bank.management.system;

import java.sql.*;


public class Conn {
    public Conn(){
        Connection c;
//        Statement stmt;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","root");
            Statement stmt = c.createStatement();
        }catch (Exception e){
            System.out.println(e);

        }

    }
}

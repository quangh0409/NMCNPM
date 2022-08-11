/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nmcnpm.helper;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DatabaseUtil {
    private Connection connection = null ;
    public DatabaseUtil (){
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("true");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.out.println("false");
            return ;
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3360/nmcnpm","root","123456789");
            System.out.println(connection);
            System.out.println("success");
        } catch (SQLException e) {
            System.out.println(e);
            return;
        }
    }
     public Connection getConnection() {
         System.out.println(connection);
        return connection;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;

/**
 *
 * @author Naya
 */
public class kon {
    static final String C_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/susuin";
    
    static final String USER = "root";
    static final String PASS ="";
public static Connection Konek(){
    Connection conn = null;
    try{
        Class.forName(C_DRIVER);
        conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (ClassNotFoundException | SQLException ex){
        
    }
    return conn;
}
}

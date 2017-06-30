package ro.vladplaton.examweb.DAL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by vladplaton on 30/06/2017.
 */
public class DALBase {
    public Connection getConnection() {
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webexam","root","123456");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
}

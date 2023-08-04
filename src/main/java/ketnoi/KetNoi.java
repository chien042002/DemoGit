package ketnoi;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {
    public static Connection getConnection(){
        Connection c=null;
        try {

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url="jdbc:mysql://localhost:3306/quanly";
            String userName="root";
            String password="";

            c=DriverManager.getConnection(url,userName,password);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }
    public static void clsoeConnection(Connection c){
        try {
            if (c!=null){
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void prinrtinfo(Connection c){
        if (c!=null){
            try {
                DatabaseMetaData mtdt=c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
            }



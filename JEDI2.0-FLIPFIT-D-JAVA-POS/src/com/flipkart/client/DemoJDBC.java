package com.flipkart.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DemoJDBC {

    public static void main(String args[]){
        try{

            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo1","root", "");

            PreparedStatement stmt=con.prepareStatement("insert into Emp values(?,?)");
            stmt.setInt(1,102);//1 specifies the first parameter in the query
            stmt.setString(2,"cdsvfb");

            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}

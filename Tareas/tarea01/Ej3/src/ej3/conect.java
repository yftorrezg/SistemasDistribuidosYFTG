/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fer
 */
public class conect {
  String bd="clase";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection conexion;
    public conect() {

        
    }
    
    public Connection conectt(){
        
        try
        {
            Class.forName(driver);
            conexion=DriverManager.getConnection(url+bd, user, password);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return conexion;
      
                  
        
    }
    
}

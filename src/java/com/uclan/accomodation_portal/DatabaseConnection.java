/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclan.accomodation_portal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author student
 */
   
    public class DatabaseConnection {
   
   
   public static Connection initializeDatabase()
       throws SQLException, ClassNotFoundException
   {
       Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/accomodation","root","");  
       return con;
   }
               
  } 
   


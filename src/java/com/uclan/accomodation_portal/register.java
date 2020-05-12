/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uclan.accomodation_portal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/**
 *
 * @author student
 */
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email_id="";
        String password="";
        String username="";
        String role="";
       
            
        email_id= request.getParameter("email");
        password= request.getParameter("psw");
        username= request.getParameter("username");
        role= request.getParameter("userrole");
        int selectedItem=0;
if(request.getParameter("userrole")!=null)
{
  selectedItem=Integer.parseInt(request.getParameter("userrole"));
}
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       out.println(email_id + password + username );
       out.println(selectedItem);
        savetoDatabase(username, password);
        
                
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
private void savetoDatabase(String username, String password ){
   
   
       try{
       // Initialize the database
           Connection con = DatabaseConnection.initializeDatabase();
 
           // Create a SQL query to insert data into demo table
           // demo table consists of two columns, so two '?' is used
           PreparedStatement st = con.prepareStatement("insert into user (name, txtpassword) values(?,?)");
 
           // For the first parameter,
           // get the data using request object
           // sets the data to st pointer
           st.setString(1,username);
 
           // Same for second parameter
           st.setString(2, password);
 
           // Execute the insert command using executeUpdate()
           // to make changes in database
           st.executeUpdate();
 
           // Close all the connections
           st.close();
           con.close();
 
           // Get a writer pointer  
           // to display the successful result
         //  PrintWriter out = response.getWriter();
         //  out.println("<html><body><b>Successfully Inserted"
                   //    + "</b></body></html>");
      // processRequest(request, response);
       }
       catch (Exception ex){
           System.out.println("Exception in daabase connectivity" + ex.getMessage());
       }
   
   
   }
}

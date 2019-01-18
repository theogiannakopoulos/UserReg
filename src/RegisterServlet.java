
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

// Extend HttpServlet class to create Http Servlet
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

   private String mymsg;
   private String first_name;
   private String last_name;
   private String email;
   private String phone;
   private String company;
   private String password;
   private String hashed;
  
   
   public void doGet(HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException {
	  
	   first_name=request.getParameter("fname");
	   last_name=request.getParameter("lname");
	   email=request.getParameter("email");
	   phone=request.getParameter("mobile");
	   company=request.getParameter("company");
	   password=request.getParameter("pass");
	  
	   HashPass hs = new HashPass();
	   
	   hashed = hs.hashing(password);
	   
	   UserObj newUser = new UserObj(first_name,last_name,email,phone,company,hashed);
	   
	   DataBase db = new DataBase();
	   
	   db.InsertToTable(newUser);
	   //response.getWriter().println(hashed.length());
	   response.sendRedirect("index.html");
	   
   }
  
   
   public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {

		      doGet(request, response);
		   }
    

   
}
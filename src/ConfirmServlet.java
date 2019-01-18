

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	
	private boolean isUser;
	private String email;
	private String password;
	private String hashed;
	private UserObj user=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		email = request.getParameter("email");
		password = request.getParameter("pass");
		
		String first_name;
		String last_name;
		String number;
		String company;
		
		
		DataBase db = new DataBase();
		
		if(!email.isEmpty()){
			isUser = db.checkEmail(email);
			user = db.getUser(email);
		
			HashPass hs =new HashPass();
			hashed = hs.hashing(password);
			//response.getWriter().println(email+" "+ password + " " + isUser + " " + db.confirmUser(email).equals(password));
			
			if(isUser==true){
				if(db.confirmUser(email).equals(hashed)){
					response.getWriter().write(email+","+user.getFirst_name());
					
					response.sendRedirect("indexProfile.jsp?email="+email+"&p="+hashed);
				}else{
					response.sendRedirect("indexSignIn.html");
				}
			}else{
				response.sendRedirect("indexSignIn.html");
			}
		}else{
			response.sendRedirect("indexSignIn.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String first_name;
		String last_name;
		String email = request.getParameter("email");
		String number;
		String company;
		String password = request.getParameter("p") ;
		//System.out.println(email);
		DataBase db = new DataBase();
		UserObj user = new UserObj();
		
		user =  db.getUser(email);
		first_name = user.getFirst_name();
		
		
        
       
		String jsonString = null;
		try {
			jsonString = new JSONObject()
			        .put("firstName", user.getFirst_name())
			        .put("lastName",  user.getLast_name())
			        .put("email",email )
			        .put("number",user.getPhone())
			        .put("company",user.getCompany())
			        .put("password", user.getPassword())
			        .toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
			
       if(password.equals(user.getPassword())){
		
		response.setContentType("text/plain");
		response.getWriter().write(jsonString);
       }else{
    	   response.getWriter().write("");
       }
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

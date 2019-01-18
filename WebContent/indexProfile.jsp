<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROFILE</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>

<body>
<h1 class="text-center font-weight-bold bg-success">Profile</h1>

<div class="container"><br>
<div class="col-lg-6 m-auto d-block">
	<input id="emailid" type="hidden" name="login" value="<%= request.getParameter("email")%>">
<input id="pid" type="hidden" name="p" value="<%= request.getParameter("p")%>">
 
 
 <div>Your name:<div id="firstName" > </div></div>
 
 
 <div>Your last name:<div id="lastName" > </div></div>
 
 <div>Your email:<div id="email" > </div></div>
 
 <div>Your phone number:<div id="number" > </div></div>
 
 <div>The name of your company:<div id="company" > </div></div>
 
<button name=home onclick=signin()>Disconnect</button>   
	
</div>
</div>

<script src = profile.js></script>

</body>

</html>





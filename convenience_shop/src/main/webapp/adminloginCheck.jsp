<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	if((username.equals("manager") && password.equals("manager"))) {
		response.sendRedirect("managerHome.jsp");
	} 
	
	else if((username.equals("cashier") && password.equals("cashier"))) {
		response.sendRedirect("cashierHome.jsp");
	} 
	
	else if ((username.equals("storekeeper") && password.equals("storekeeper"))) {
		response.sendRedirect("storekeeperHome.jsp");
	} 
	
	else {
		response.sendRedirect("errorAdminLogin.html");
	}
	
	%>
</body>
</html>
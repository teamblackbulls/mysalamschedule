<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<meta charset="UTF-8">
	
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!------<title> Website Layout | CodingLab</title>------>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
	
	<title>List of Products</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	<style type="text/css">
		ul {
		  list-style-type: none;
		  margin: 0;
		  padding: 0;
		}
		
		li {
		  float: left;
		}
		
		li a {
		  color: white;
		  text-align: center;
		  padding: 14px 16px;
		  text-decoration: none;
		}
		
		li a:hover:not(.active) {
			color: black;
		}
		
		.active {
		   color: grey;
		}
		
		table, th, td {
			  border: 1px solid;
		}
		table {
			  width: 95%;
		}
			
		.center {
			  margin: auto;
			  padding: 10px;
		}
		
		@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
		
		*{
		  margin: 0;
		  padding: 0;
		  box-sizing: border-box;
		  font-family: 'Poppins',sans-serif;
		}
		::selection{
		  color: #000;
		  background: #fff;
		}
		nav{
		  position: fixed;
		  background: #A2B38B;
		  width: 100%;
		  padding: 10px 0;
		  z-index: 12;
		}
		nav .menu{
		  max-width: 1250px;
		  margin: auto;
		  display: flex;
		  align-items: center;
		  justify-content: space-between;
		  padding: 0 20px;
		}
		.menu .logo a{
		  text-decoration: none;
		  color: #FAFDD6;
		  font-size: 35px;
		  font-weight: 600;
		}
		.menu ul{
		  display: inline-flex;
		}
		.menu ul li{
		  list-style: none;
		  margin-left: 7px;
		}
		.menu ul li:first-child{
		  margin-left: 0px;
		}
		.menu ul li a{
		  text-decoration: none;
		  color: #FAFDD6;
		  font-size: 18px;
		  font-weight: 500;
		  padding: 8px 15px;
		  border-radius: 5px;
		  transition: all 0.3s ease;
		}
		.menu ul li a:hover{
		  background: #FAFDD6;
		  color: #A2B38B;
		}
		.img{
		  background-image: url('istockphoto.jpg');
		  width: 100%;
		  height:100vh;
		  background-size: cover;
		  background-position: center;
		  position: relative;
		}
		.img::before{
		  content: '';
		  position: absolute;
		  height: 100%;
		  width: 100%;
		  background: rgba(0, 0, 0, 0.4);
		}
		.center{
		  position: absolute;
	
		  left: 50%;
		  transform: translate(-50%, -50%);
		  width: 100%;
		  padding: 0 20px;
		  text-align: center;
		}
		.center .title{
		  color: #A2B38B;
		  font-size: 47px;
		  font-weight: 600;
		}
		.center .sub_title{
		  color: #fff;
		  font-size: 30epx;
		  font-weight: 600;
		}
		.center .btns{
		  margin-top: 20px;
		}
		.center .btns button{
		  height: 55px;
		  width: 240px;
		  border-radius: 5px;
		  border: none;
		  margin: 0 10px;
		  border: 2px solid white;
		  font-size: 20px;
		  font-weight: 500;
		  padding: 0 10px;
		  cursor: pointer;
		  outline: none;
		  transition: all 0.3s ease;
		}
		.center .btns button:first-child{
		  color: #fff;
		  background: none;
		}
		.btns button:first-child:hover{
		  background: white;
		  color: black;
		}
		.center .btns button:last-child{
		  background: white;
		  color: black;
		}	
		
		.button-section button[type="button"]{
		    background: #A2B38B;
		    padding: 8px 30px;
		    border-radius: 2px;
			cursor:pointer;
		    -webkit-border-radius: 2px;
		    -moz-border-radius: 2px;
		    color: #fff;
		    text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.12);
		    font: normal 30px 'Bitter', serif;
		    -moz-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
		    -webkit-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
		    box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
		    border: 1px solid #A2B38B;
		    font-size: 15px;
		
		
	</style>
</head>
<body>
		<nav>
		    <div class="menu">
		      <div class="logo">
		        <a href="#">ICT502</a>
		      </div>
		      <ul>
		      	<li><a href="managerHome.jsp">Home</a></li>
		      	<li><a href="ListOrderDetailController">List Order</a></li>
				<li><a class="active" href="#ListProductController">List Product</a></li>
				<li><a href="ListEmployeeController">List Employee</a></li>
				<li><a href="index.html">Logout</a></li>
			  </ul>
		    </div>
	    </nav>
       <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<div class="center">
			<div class="title">List of Products</div><br>
			
			<div class="button-section">
	             <a href="addProduct.jsp"><button type="button">Add New Product</button></a>
			</div>
			
			<br>

           <div align="center">
			<table>
				<tr>
					<th>Product ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Price (RM)</th>
					<th>Category</th>
					<th colspan="3">Actions</th>
				</tr>
	
				<c:forEach items="${products}" var="p" varStatus="products">
				<tr>
					<td><c:out value="${p.productID}" /></td>
					<td><c:out value="${p.productname}" /></td>
					<td><c:out value="${p.productdescription}" /></td>
					<td><c:out value="${p.price}" /></td>
					<td><c:out value="${p.productcategory}" /></td>
								
					<td><a class="btn btn-primary" href="UpdateProductController?productID=<c:out value="${p.productID}"/>">Update</a></td>
					
					<td><button class="btn btn-danger" id="<c:out value="${p.productID}"/>" onclick="confirmation(this.id)">Delete</button></td>
				</tr>
				</c:forEach>
				
			</table><br><br>
			
			<div class="title">Search by Product Name or Product Category</div>

         <div class="col-md-4">
            <form action="" method="get" style="margin:25px 50px 25px 50px; position:center;" >
                <input type="text" class="form-control" name="q" placeholder="Search here..."/>
            </form>
        </div>

            <%@page import="product.db.ConnectionManager" %>
            <%@page import="java.sql.*" %>
            <div align="center">
                <table>
                    <tr>
                        <th>Product ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price (RM)</th>
                        <th>Category</th>
                        <th colspan="3">Actions</th>
                    </tr>
            <%
            try {

                Connection con = ConnectionManager.getConnection();  
                Statement stat = con.createStatement();
                String query = request.getParameter("q");
                String data = "select * from product where productname like '%" + query + "%' OR LOWER(productname) LIKE '%" + query + "%' OR UPPER(productname) LIKE '%" + query + "%' or productcategory like '%" + query + "%'";

                ResultSet res = stat.executeQuery(data);
                while(res.next()) {

                %>

                    <tr>
                        <td><%=res.getString("productID")%></td>
                        <td><%=res.getString("productname")%></td>
                        <td><%=res.getString("productdescription")%></td>
                        <td><%=res.getString("price")%></td>
                        <td><%=res.getString("productcategory")%></td>

                        <td><a class="btn btn-primary" href="UpdateProductStorekeeperController?productID=<c:out value="${p.productID}"/>">Update</a></td>

                        <td><button class="btn btn-danger" id="<c:out value="${p.productID}"/>" onclick="confirmation(this.id)">Delete</button></td>
                    </tr>
                    <%
                }

            }
            catch (Exception e) {}
            %>


                </table>
                </div><br>
		</div>
	
	<script>
		function confirmation(id) {
			console.log(id);
			var r = confirm("Are you sure you want to delete?");
			if (r == true) {
				location.href = 'DeleteProductController?productID=' + id;
				alert("Product successfully deleted");
			} else {
				return false;
			}
		}
	</script>
</body>
</html>
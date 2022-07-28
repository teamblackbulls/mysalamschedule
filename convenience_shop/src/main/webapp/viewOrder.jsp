<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!------<title> Website Layout | CodingLab</title>------>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
	
	<title>Order Details</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
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
		  top: 55%;
		  left: 50%;
		  transform: translate(-50%, -50%);
		  width: 100%;
		  padding: 0 20px;
		  text-align: center;
		}
		.center .title{
		  color: #A2B38B;
		  font-size: 43px;
		  font-weight: 600;
		}
		
		
		.center .sub_title{
		  color: #black;
		  font-size: 66epx;
		  font-weight: 600;
		}
		.center .btns{
		  margin-top: 20px;
		}
		.center .btns button{
		  height: 55px;
		  width: 170px;
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
		
	th, td {
  font-family:'Motnserrat',sans-serif;
  text-align: left;
  font-size: 16px;
  padding: 10px;

}
th {
  background-color:#A2B38B;
  color: white;
}
.col-span-25{
	float:left;
	width:25%;
	margin-top:6px;
}

.col-span-75{
	float:left;
	width:75%;
	margin-top:6px;
}
	
</style>
	
</head>
<body>
<%
	int orderid = Integer.parseInt(request.getParameter("orderID"));
	int counter = 0;

%>
	<%-- DATABASE --%>
	<sql:setDataSource var="database" driver="oracle.jdbc.driver.OracleDriver"
         url="jdbc:oracle:thin:@localhost:1521:xe"
         user = "Shop"
         password="system"  />
	
	<%-- ORDER DETAILS SQL --%>
    <sql:query dataSource="${database}" var="orderdetails">
      SELECT *
      FROM orders
      JOIN orderdetail
      USING (orderid)
      JOIN product
      USING (productid)
      WHERE orderid = <%=orderid %>
      </sql:query>
      
      <%-- ORDER SQL --%>
    <sql:query dataSource="${database}" var="order">
      SELECT *
      FROM orders
      WHERE orderid = <%=orderid %>
      </sql:query>
      
<br>
	<nav>
	    <div class="menu">
	      <div class="logo">
	        <a href="#">ICT502</a>
	      </div>
	      <ul>
	        
			<li><a href="listOrder.jsp">Back</a></li>
		  </ul>
	    </div>
	 </nav>
  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div class="center">
		<div class="title">Order Details</div><br>
		
			<table  style="margin:50px 80px 30px 500px; text-align:center;" >
		<c:forEach var="order" items="${order.rows}">
		<tr>
			<td id="col-span-25">Order ID:</td>
			<td id="col-span-75">:&nbsp;<c:out value="${order.orderid}"/></td>
		</tr>
		
		<tr>
			<td id="col-span-25">Order Date</td>
			<td id="col-span-75">:&nbsp;<c:out value="${order.orderdate}"/></td>
		</tr>
		
		<tr>
			<td id="col-span-25">Grand Total (RM)</td>
			<td id="col-span-75">:&nbsp;<c:out value="${order.grandtotal}"/></td>
			
		</tr>
		</c:forEach>
		</table>
		
          <div class="sub_title"><b>Products</b></div>
			<table border="1" style="margin:50px 80px 30px 500px; text-align:center;">
				<tr>
					<th>No.</th>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Total Amount (RM)</th>
				</tr>
			<c:forEach var="orderdetail" items="${orderdetails.rows}">
			<% counter++; %>
				<tr>
					<td><%=counter %></td>
					<td><c:out value="${orderdetail.productname}" /></td>
					<td><c:out value="${orderdetail.quantity}" /></td>
					<td><c:out value="${orderdetail.totalamount}" /></td>
				</tr>
			</c:forEach>
			</table>
	
		
	</div>
</body>
</html>
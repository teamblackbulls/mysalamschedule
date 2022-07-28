<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import = "product.db.ConnectionManager" %>
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
	
	<title>Add Order</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
	
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
		  top: 52%;
		  left: 50%;
		  transform: translate(-50%, -50%);
		  width: 100%;
		  padding: 0 20px;
		  text-align: center;
		}
		.center .title{
		  color: #fff;
		  font-size: 55px;
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
	
	table {
  border-collapse: collapse;
  background-color: white;
  overflow: hidden;
  width: %;
  border-radius: 10px;
  justify-content: center;
  align-items: center;
  min-height: 10px;
  text-align:center;
}

th, td {
  font-family:'Motnserrat',sans-serif;
  text-align: left;
  font-size: 16px;
  padding: 10px;
}

th {
  color: #7691ab;
}

.btn-delete{
  background-color:  #d6524b;
  color: white;
  cursor: pointer;
  padding: 10px 20px;
  border-radius: 8px;
   font-size: 14px;
    margin-right: 5px;
}
.btn-proceed{
  background-color:#6b9bd1;
  border: none;
  color: white;
  padding: 10px 30px;
  text-decoration: none;
   margin-right:100px;
    position: center;
  cursor: pointer;
  text-align:center;
   top: 50%;
  left: 50%;

}
 .btn-reset{
 background-color:#DC7633;
 }
	
	</style>
	
	
</head>
	
<body>
<%
	int orderid = (int)request.getAttribute("orderid");
	int counter = 0;
	double grandtotal = 0.00;
%>

	<%-- DATABASE --%>
	<sql:setDataSource var="database" driver="oracle.jdbc.driver.OracleDriver"
         url="jdbc:oracle:thin:@localhost:1521:xe"
         user = "Shop"
         password="system"  />
    
    <%-- ORDER SQL --%>
    <sql:query dataSource="${database}" var="orderinfo">
      SELECT * from orders WHERE orderid = <%=orderid%>
      </sql:query>

	<nav>
	    <div class="menu">
	      <div class="logo">
	        <a href="#">ICT502</a>
	      </div>
	      <ul>
	      	
			<li><a href="ListOrderDetailCashierController">Back</a>
		  </ul>
	    </div>
	</nav>
	
	<br><br><br><br>
	
	<%-- ORDER INFORMATION --%>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">			
			<div>
				<table>
				<c:forEach var="order" items="${orderinfo.rows}">
					<tr>
						<th>Order ID:</th>
						<td><c:out value="${order.orderid}"/></td>
					</tr>
					<tr>
						<th>Date:</th>
						<td><c:out value="${order.orderdate}"/></td>
					</tr>
				</c:forEach>
				</table>
			</div>
			</div>
			</div>
			</div>
			
			</br></br>
			
	<%-- ADD ORDER DETAILS --%>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

			
			<form method="post" action="AddOrderDetailCashierController">
					<caption>
						<h2> Add Order Detail</h2>
					</caption>
					
					<fieldset class="form-group">
						<label>Product ID</label> 
						<input type="text" class="form-control" id="productID" name="productID" required="required" placeholder="2">
					</fieldset>
					<fieldset class="form-group">
						<label>Quantity</label> 
						<input type="number" class="form-control" id="quantity" name="quantity" required="required" placeholder="15">
					</fieldset>			
					<button type="submit" class="btn btn-success" formaction="AddOrderDetailCashierController?orderid=<%=orderid%>">Submit</button>
					<button type="reset" class="btn btn-reset">Reset</button>
			</form>
			</div>
		</div>
	</div>
	</br></br>
	<%-- LIST ORDER DETAILS BY ORDERID --%>


      	<div class="container col-md-5" style="padding:50px 50px 50px 50px; text-align:center;" >
		<div class="card">
			<div class="card-body">			
			<div>
				<table>
					<tr>
						<th>No.</th>
						<th>Product ID</th>
						<th>Quantity</th>
						<th>Total Amount (RM)</th>
						<th></th>
					</tr>
					      <%
     						 Connection con = ConnectionManager.getConnection();
      						 PreparedStatement orderdetailSQL = con.prepareStatement("SELECT * from orderdetail WHERE orderid =" + orderid);
      						 ResultSet result = orderdetailSQL.executeQuery();
      
     						 while(result.next()) {
     							counter++;
    					  %>
					<tr>
						<td><%=counter %></td>
						<td><%=result.getInt("productid") %></td>
						<td><%=result.getInt("quantity") %></td>
						<td><%=result.getDouble("totalamount") %>
						<%
							grandtotal += result.getDouble("totalamount");
						%>
						</td>
						<td><a class="btn btn-delete" href='DeleteOrderDetailCashierController?orderdetailID=<%=result.getInt("orderdetailid")%>&orderID=<%=orderid%>'>Delete</a></td>
					</tr>
					<%
      					}
     				%>
				</table>
			</div>
			<div>
				GRAND TOTAL (RM) : <%= grandtotal %>
			</div>
			</div>
		</div>
		</div>
		
		<button class="btn btn-proceed"style="padding:10px 10px 10px 10px; text-align:center; margin:3px 100px 100px 950px;" onclick="location.href='UpdateOrderCashierController?grandtotal=<%=grandtotal%>&orderID=<%=orderid%>'">Proceed</button>
	
</body>
</html>
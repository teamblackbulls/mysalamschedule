<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<br><br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<form method="post" action="AddProductController">
					<caption>
						<h2> Add New Employee </h2>
					</caption>
					<fieldset class="form-group">
						<label>Employee ID</label> 
						<input type="text" class="form-control" id="empId" name="empId" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>First Name</label> 
						<input type="text" class="form-control" id="fname" name="fname" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Last Name</label> 
						<input type="text" class="form-control" id="lname" name="lname" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Email</label> 
						<input type="text" class="form-control" id="email" name="email" required="required" placeholder="abc@email.com">
					</fieldset>
					<fieldset class="form-group">
						<label>Phone Number</label> 
						<input type="text" class="form-control" id="empphonenum" name="empphonenum" required="required">
					</fieldset>
	
					<fieldset class="form-group">
						<label>Address</label> 
						<input type="text" class="form-control" id="address" name="address">
					</fieldset>
	
					<button type="submit" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-success">Reset</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>

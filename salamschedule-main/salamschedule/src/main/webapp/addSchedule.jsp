<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!------<title> Website Layout | CodingLab</title>------>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
	
	<title>Add New Schedule</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
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
		   color: black;
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
	
	</style>
</head>
<body>

	<nav>
    <div class="menu">
      <div class="logo">
        <a href="#">MasjidSalam</a>
      </div>
      <ul>
      
		<li><a href="ListScheduleController">Back</a>
	  </ul>
    </div>
  </nav>
	
	<br><br>
	<div class="container col-md-5"><br><br>
	
		<div class="card">
			<div class="card-body">
			<form method="post" action="AddScheduleController">
					<caption>
						<h2> Add New Schedule </h2>
					</caption>
					
					<fieldset class="form-group">
						<label>Schedule Date</label> 
						<input type="date" class="form-control" id="scheduledate" name="scheduledate" required="required" placeholder="Date..">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Prayer ID</label> 
						<input type="text" class="form-control" id="prayerid" name="prayerid" placeholder="1=Subuh,2=Zuhur,....">
					</fieldset>
					  
					 <fieldset class="form-group">
						<label>Imam ID</label> 
						<input type="text" class="form-control" id="imamid" name="imamid" placeholder="1">
					</fieldset>
					
					<fieldset class="form-group">
						<label>Bilal ID</label> 
						<input type="text" class="form-control" id="bilalid" name="bilalid" placeholder="2">
					</fieldset>
					
					<button type="submit" class="btn btn-success">Submit</button>
					<button type="reset" class="btn btn-success">Reset</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>
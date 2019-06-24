<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Check In</title>
</head>
	<body>
		<div>
			<h1 style="text-align: center">Customer Check In</h1>
		</div>
		<div>
			<p>Yo baby, what you want to do!!! You can Open a checking account!!! You can Open a savings account!!!</p>
			<p>But first, we need to see if you're a customer. Type in your first and last name below.</p>
		</div>
		
		<form action="CustomerExistRedirect" method="post">
			<!-- <h3 style= "">Add Customer</h3> -->
			First Name: <input name="firstName"><br>
			Last Name: <input name="lastName"><br>
			<button name="submit" >Submit</button>
		</form>
		
	</body>
</html>
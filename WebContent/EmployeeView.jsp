<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="MainPackage.*"
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Employee Interface</title>
	</head>
	<body>
		<div>
			<h1 style="text-align: center">Employee Interface</h1>
		</div>
		<div>
			<a href="Index.jsp">Index Page</a>
		</div>
		<div>
			<form action="AddCustomer" method="post">
				<h3 style= "">Add Customer</h3>
				Customer ID Number: <input name="customerID"><br>
				First Name: <input name="firstName"><br>
				Last Name: <input name="lastName"><br>
				Account Number: <input name="accountNumber"><br>
				Account Name: <input name="accountName"><br>
				<button name="submit" >Submit</button>
			</form>
			
			<form action="GetCustomers" method="post">
			<h3 style= "">See all Customer</h3>
				<button name="submit" >Submit</button>
			</form>
			
			<form action="UpdateCustomer" method="post">
			<h3 style= "">Update Customer</h3>
				Customer ID Number: <input name="customerID"><br>
				First Name: <input name="firstName"><br>
				Last Name: <input name="lastName"><br>
				<button name="submit" >Submit</button>
			</form>
			
			<form action="DeleteCustomer" method="post">
			<h3 style= "">Delete Customer</h3>
				Customer ID Number: <input name="customerID"><br>
				Account Number: <input name="accountNumber"><br>
				<button name="submit" >Submit</button>
			</form>
			
			<form action="CustomerExist" method="post">
			<h3 style= "">Search for Customer</h3>
				First Name: <input name="firstName"><br>
				Last Name: <input name="lastName">
				<button name="submit" >Submit</button>
			</form>
			
		</div>
	</body>
</html>
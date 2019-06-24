<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="MainPackage.*"
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Interface</title>
</head>
<body>

	<div>
		<h1>You've reached the customer interface.</h1>
		<p>Hello 
			<c:out value="${firstName}" default="firstName"/> 
			<c:out value="${lastName}" default="lastName"/>
		</p>	
		<p>Here you can view and perform transactions for your accounts.</p>
		<%-- <c:out value="${firstName}" default="firstName"/>
		<c:out value="${lastName}" default="lastName"/> --%>
	</div>
	
	<div>
		<hr>
		<h3>Accounts</h3>
		<p>Hyperlinks of current accounts here.</p>
		<hr>
	</div>
	
	<div>
	
		<form action="ViewCheckingAccount" method="post">
			<h3 style= "">See Checking Account</h3>
			<button name="submit" >Submit</button>
		</form>
		
		<form action="" method="post">
			<h3 style= "">See Saving Account</h3>
			<button name="submit" >Submit</button>
		</form>

		<!-- <form action="" method="post">
			<h3 style= "">Create Checking Account</h3>
			Account Number: <input name="accountNumber"><br>
			Account Name: <input name="accountName"><br>
			<button name="submit" >Submit</button>
		</form>
	
	
		<form action="" method="post">
			<h3 style= "">Create Savingsing Account</h3>
			Account Number: <input name="accountNumber"><br>
			Account Name: <input name="accountName"><br>
			<button name="submit" >Submit</button>
		</form> -->
		
	</div>

</body>
</html>
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
	</div>
	
	<div>
		<a href="Index.jsp">Index Page</a>
	</div>
	
	<div>
		<hr>
		
		<table border="1">
            <caption><h2>Transactions</h2></caption>
            <tr>
                <th>Transaction Number</th>
                <th>Account Number</th>
                <th>Amount</th>
            </tr>
            <c:forEach var="transaction" items="${listTransaction}">
                <tr>
                    <td><c:out value="${transaction.transactionNumber}" /></td>
                    <td><c:out value="${transaction.accountNumber}" /></td>
                    <td><c:out value="${transaction.amount}" /></td>
                </tr>
            </c:forEach>
        </table>
		<hr>
	</div>
	
	<div>
	
		<form action="ViewCheckingAccount" method="post">
			<h3 style= "">See Checking Account</h3>
			<button name="submit" >Submit</button>
		</form>
		
		<!-- <form action="" method="post">
			<h3 style= "">See Saving Account</h3>
			<button name="submit" >Submit</button>
		</form> -->
		
	</div>

</body>
</html>
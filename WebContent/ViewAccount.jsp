<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account View</title>
</head>
	<body>
		<div>
			<h1 style="text-align: center">Account View</h1>
			<div>
				<a href="Index.jsp">Index Page</a>
			</div>
			<p>${firstName}</p>
			<p>${lastName}</p>
		</div>
		<!-- <div>
			<form action="" method="post">
				<h3 style= "">Add Transaction</h3>
				Deposit : <input name="deposit"><br>
				Withdraw: <input name="withdraw"><br>
				<button name="submit" >Submit</button>
			</form>
		</div> -->
		
		<div>
	        <h1>Transaction Management</h1>
	        <h2>
	            <a href="/BankAccountApp/new">Create Transaction</a>
	            &nbsp;&nbsp;&nbsp;
	            <a href="/BankAccountApp/list">List All Transactions</a>
	             
	        </h2>
    	</div>
		
		<div>
			<p>You should see the individual transactions below.</p>
		</div>
		
		<div align="center">
	        <table border="1">
	            <h2>List of Transactions</h2>
	            <tr>
	                <th>Transaction #</th>
	                <th>Account #</th>
	                <th>Amount</th>
	            </tr>
	            <c:forEach var="transaction" items="${listTransaction}">
	                <tr>
	                    <td><c:out value="${transaction.transactionNumber}" /></td>
	                    <td><c:out value="${transaction.acountNumber}" /></td>
	                    <td><c:out value="${transaction.amount}" /></td>
	                    
	                </tr>
	            </c:forEach>
	        </table>
	    </div> 
		
		
	
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
        <h1>Books Management</h1>
        <div>
			<a href="Index.jsp">Index Page</a>
		</div>
        <h2>
            <a href="/BankAccountApp/new">Add Transaction</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/BankAccountApp/list">List All Transactions</a>
             
        </h2>
    </div>
    <form action="/BankAccountApp/insert" method="post">
	    <table>
		   	<tr>
			     <th>Transaction #: </th>
			     <td>
			         <input type="number" name="transactionNumber" size="45"
			                 value="<c:out value='${transactionNumber}' />"
		             />
			     </td>
			 </tr>
			 <tr>
			     <th>Account #: </th>
			     <td>
			         <input type="number" name="accountNumber" size="45"
			                 value="<c:out value='${transaction.accountNumber}' />"
			         />
			     </td>
			 </tr>
			 <tr>
			     <th>Amount: </th>
			     <td>
			         <input type="number" name="amount" size="5"
			                 value="<c:out value='${transaction.amount}' />"
			         />
			     </td>
			 </tr>
		 	<tr>
		        <td colspan="2" align="center">
		            <input type="submit" value="Save" />
		        </td>
	       	</tr>
		</table>
	</form>
</body>
</html>
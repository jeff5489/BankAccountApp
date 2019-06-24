<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account View</title>
</head>
	<body>
		<div>
			<h1 style="text-align: center">Account View</h1>
			<p>${firstName}</p>
			<p>${lastName}</p>
		</div>
		<div>
			<form action="" method="post">
				<h3 style= "">Add Transaction</h3>
				Deposit : <input name="deposit"><br>
				Withdraw: <input name="withdraw"><br>
				<button name="submit" >Submit</button>
			</form>
		</div>
		<div>
			<p>You should see the individual transactions below.</p>
		</div>
	
	</body>
</html>
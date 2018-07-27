<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<h4>Edit user with id: ${userId} </h4>
	<form method="POST" action="/users/{userId}/edit">
		New name: <input type="text" name = "username">
		<button type="submit">Confirm</button>
	</form>
</body>
</html>
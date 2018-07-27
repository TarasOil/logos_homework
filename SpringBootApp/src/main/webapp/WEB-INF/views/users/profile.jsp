<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> Profile </h2>
	<p> This is user with ID: ${userId} </p>
	<p> This user's name is: ${userName} </p>
	<br>
	<a href="${userId}/edit">Edit</a>
	<br>
	<a href="${userId}/delete">Delete</a>
	<br>
	<a href="/users">Back to users</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post info</title>
</head>
<body>
	<p>Post with id = ${postId}, was created by user with id = ${userId}</p>
	
	<br>
	<br>
	<a href="/posts/${postId}/${userId}/edit">Edit</a>
</body>
</html>
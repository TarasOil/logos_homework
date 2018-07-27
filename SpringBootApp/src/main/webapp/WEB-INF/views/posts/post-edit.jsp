<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<form method = "POST" action="/posts/{postId}/{userId}/edit">
		Title: <input = "text" name = "title">
		<br>
		Description: <textarea rows="5" cols="20" name = "description"></textarea>
		<button type="submit">Confirm</button>
	</form>
</body>
</html>
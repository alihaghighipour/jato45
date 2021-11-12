<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Area riservata</title>
</head>
<body>
		<!-- user must be logged in order to
		view this html tag  -->
		<%if (session.getAttribute("role") != null){ %>
			<h1>Area riservata</h1>
		<% } %>
</body>
</html>
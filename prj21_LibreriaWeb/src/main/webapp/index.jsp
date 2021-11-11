<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Libro" %>
<%@page import="dao.LibroDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libreria</title>
</head>
<body>
	<%
		LibroDAO ld = new LibroDAO();
		for (Libro libro: ld.getLibri()) {
			out.print(libro.toString() + "<br>");
		}
	%>
</body>
</html>
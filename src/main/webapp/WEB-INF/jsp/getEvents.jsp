<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Events</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Event Name</th>
		</tr>
		<c:forEach items="${events}" var="event">
			<tr>
				<td>${event.id}</td>
				<td>${event.name}</td>
				<td><a href="<c:url value='/removeEvent/${event.id}'/>">Remove</a></td>				
			</tr>
		</c:forEach>
	</table>
	<a href="event.html">
		Add Event >>
	</a>
</body>
</html>
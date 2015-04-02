<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Event Page</title>
<style type="text/css">
	.error{
		color:#ff0000;
	}
	.erroblock {
		color: #000;
		background-color: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
</style>
</head>
<body>
	<form:form commandName="event">
		
		<form:input path="id" readonly="true" size="8"  disabled="true" />
        <form:hidden path="id" />
		<form:errors path="*" cssClass="errorblock" element="div"/>
		<label for="textinput1">Enter Minutes:</label>
		<form:input path="name" cssErrorClass="error"/>
		<form:errors path="name" cssClass="error"/>
		<br/>
		<input type="submit" class="button" value="Enter Event">
	</form:form>
</body>
</html>
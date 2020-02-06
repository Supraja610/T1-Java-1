<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Manage your profile here...</h1>
<hr/>
<!-- Spring form -->
<!--
	1. Map Model object with form 
	2. Map each input field with object field
	
	When form loads
		student.getUname() method gets called and its value is associated with textbox
	When form submit	
		student.setUname(<textbox>) method gets called and textbox value is passed as an argument
 -->
<spring:form action="save" method="post" modelAttribute="student">
	<spring:label path="uname">Enter name</spring:label>
	<spring:input path="uname"/>
	<br/>
	<br/>
	<spring:label path="email">Enter email</spring:label>
	<spring:input path="email"/>
	<br/>
	<br/>
	<input type="submit" value="Submit">
	
</spring:form>

</body>
</html>

















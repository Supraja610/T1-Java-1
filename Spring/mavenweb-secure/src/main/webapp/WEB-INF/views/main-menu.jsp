<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="spring-form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 
	spring security maintains logged in user details in a special object
	==> principal 
	==> roles ~ authorities
-->
<h2>Hello <security:authentication property="principal.username"/></h2>
<h2>ROLES : <security:authentication property="principal.authorities"/></h2>
<br/>
<spring-form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout">
</spring-form:form>
<hr/>
<h1>Welcome to Maven Project!!!</h1>

<security:authorize access="hasRole('ADMIN')">
	<hr/>
	<a href="${pageContext.request.contextPath}/admin/home">ADMIN HOME</a>
</security:authorize>

<security:authorize access="hasRole('MANAGER')">
	<hr/>
	<a href="${pageContext.request.contextPath}/manager/home">MANAGER HOME</a>
</security:authorize>


</body>
</html>
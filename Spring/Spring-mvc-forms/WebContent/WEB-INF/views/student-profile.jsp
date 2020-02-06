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
	<spring:label path="country">Select country</spring:label>
	<spring:select path="country">
		<spring:options items="${student.countries}"/>
	<!--
		hard-coded list 
		<spring:option value="FR" label="France"/>
		<spring:option value="IN" label="India"/>
		<spring:option value="GR" label="Germany"/>
		<-spring:option value="US" label="USA"/>
	 -->	
	</spring:select>
	<br/>
	<br/>
	<spring:label path="favoriteLanguage">Select  Favorite Langauge</spring:label>
	<br/><spring:radiobutton path="favoriteLanguage" value="Python"/> Python
	<br/><spring:radiobutton path="favoriteLanguage" value="Java"/> Java
	<br/><spring:radiobutton path="favoriteLanguage" value="C#"/> C#
	<br/><spring:radiobutton path="favoriteLanguage" value="Javascript"/> Javascript
	<br/>
	<br/>
	<spring:label path="operatingSystems">Select your experience</spring:label>
	<br/><spring:checkbox path="operatingSystems" value="Linux"/> Linux
	<br/><spring:checkbox path="operatingSystems" value="Alpine"/> Alpine
	<br/><spring:checkbox path="operatingSystems" value="Mac"/> Mac
	<br/><spring:checkbox path="operatingSystems" value="Windows"/> Windows
	<br/>
	<br/>
	<input type="submit" value="Submit">
	
</spring:form>

</body>
</html>

















<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>An Excellent Host</title>
    <link rel="stylesheet" type="text/css" href="./css/HomePage.css">
    <link rel="stylesheet" type="text/css" href="./css/header.css">
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" >
    <link href="https://fonts.googleapis.com/css2?family=Teko&display=swap" rel="stylesheet"> 
		
</head>
<!-- Yeah, I don't know why the body and head here are like this. Seems normal to me. Page works. -->
<body>
<%@ include file="navbar.html" %>
<div style="height: 120px;"></div>
        <br/>
<h1 style="margin-left: 50px;">Upload an image here</h1>

     <form:form action="saveImage" modelAttribute="images" method="post"
		enctype="multipart/form-data" style="margin-left: 50px; margin-right: auto;">
		<fieldset>
			<legend>Add an Image</legend>
			<div>
				<label >Image Name: </label>
				<form:input type="text" path="imageFileName" placeholder="50 characters max" />
				
			</div>
			<div>
				<label>Description: </label>
				<form:input  path="description" placeholder="255 characters max"/>
				
				</div>
			<div>
				<label>Images: </label>
				<input type="file" name="images" multiple="multiple"/>
			</div>
			
			<div>
				<input id="reset" type="reset" tabindex="4"/>
				<input id="submit" type="submit" tabindex="5" value="Add Image" />
			</div>
		</fieldset>
	</form:form>
     
</body>
</html>
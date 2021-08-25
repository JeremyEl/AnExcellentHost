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
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Teko&display=swap" rel="stylesheet"> 
		
</head>

<body>
    <%@ include file="navbar.html" %>
    <div style="height: 120px;"></div>

    
        <br/>
       
       <h1>Upload an image here</h1>
       <h5>This is a temporary page used to prove that the image database model works.</h5>
       <h5>This should display the image uploaded and return the information provided.</h5>
       
       <form:form action="saveImage" modelAttribute="images" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<legend>Add a Product</legend>
			<div>
				<label>Product Name: </label>
				<form:input type="text" path="imageFileName" />
				
			</div>
			<div>
				<label>Description: </label>
				<form:input  path="description" placeholder="300 characters max"/>
				
				</div>
			<div>
				<label>Product Images: </label>
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
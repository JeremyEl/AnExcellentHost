<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Display Image</title>
</head>
<body>
   <%@ include file="navbar.html" %>
    <div style="height: 120px;"></div>

    
        <br/>
	<div>
		<h4>The product has been saved.</h4>
		<h5>Details:</h5>
		<p>Product Name: <span th:text="${newImage.imageName}"></span></p>
		<p>Description: <span th:text="${newImage.description}"></span></p>
		<p>The following files are uploaded successfully.</p>
		<ol>
			<li><p th:text="${newImage.imageFileName}"></p><img th:src="*{'data:image/jpeg;base64,' + {newImage.imageItself}}" /></li>
		</ol>
	</div>
</body>
</html>
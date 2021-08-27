<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">

<head>
<meta charset="ISO-8859-1">
<title>${newImage.imageFileName}</title>
        <link rel="stylesheet" type="text/css" href="/css/header.css">
        <link rel="stylesheet" type="text/css" href="/css/LoginMenu.css">
        <link rel="stylesheet" type="text/css" href="/css/imagepages.css">
</head>
<body>
 <%@ include file="navbar.html" %>
    <div style="height: 120px;"></div>
    
<div class="tagList">
	<table >
	  <c:forEach var="tag" items="${newImage.tagAssignment}"  >
	   	<tr>
	   		<td>${tag.term}</td>
	   		<td>0</td>
	       	<td><button>+</button><button>-</button></td>
	      </tr>
	  </c:forEach>
	</table>
</div>
<div>
	<form class="addTagButton" action="/addTag" method="post">
		<input name="imageId" value="${newImage.imageId}" type="hidden" />
		<input name="term" placeholder="40 chars max">
		<button type="submit">Add Tag</button>
	</form>
</div>
        
<div class="imagePost">		
	<h1>${newImage.imageFileName}</h1>
		<div  >
			<img class="imageItself" src="${'data:image/jpeg;base64,'} ${newImage.imageItself}" alt="Image image"/>
		</div>	
	<br/>
	<div class="description">Description: ${newImage.description}</div>
	<br/>
</div>

 <div style="height: 50px;"> </div>
 
 <c:forEach var="comment" items="${newImage.comments}">
    
    <div class="name commentList">
    	<span>${comment.commentPoster.username}</span>
    </div>
    <div class="comment-text commentList">
       <span>${comment.commentBody}</span>
   	</div>
	
</c:forEach>

 <form action="/addComment" method="post" >
    <div>
         <div>
           <input name="imageId" value="${newImage.imageId}" type="hidden" />
           
         	<textarea class="textBox commentList" name="commentBody" placeholder="3000 character max" ></textarea>
         </div>
         <div class="btn">
           	<button  type="submit" >Post comment</button>
		</div>
    </div>
</form>

</body>
</html>
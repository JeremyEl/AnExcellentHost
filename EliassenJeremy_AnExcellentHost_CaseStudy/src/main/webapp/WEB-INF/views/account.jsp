<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Account</title>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="./css/header.css">
	<link rel="stylesheet" type="text/css" href="./css/LoginMenu.css">
	<link rel="stylesheet" type="text/css" href="./css/HomePage.css">
</head>
<body>
<%@ include file="navbar.html" %>
 <div style="height: 120px;"></div>
<script type="text/javascript" src="./verifyPassword.js"></script>
 <!--     
 Change account name
 Change account password
 Delete Account
 upload file
 look at friends list

  --> 
<div style="margin-left: 50px;">
	<form:form onsubmit="return(verifyPassword())"  action="./updateUser" 
			method="post" modelAttribute="user">
	<br/>
		<label class="instructions" style="font-size: 40px;">Change your name</label>
	<br/>
		<form:input id="Username" class="boxUpdate" type="text" path="username" 
	            name="Username" title="Username" placeholder="Username" required="true"/>

	<br/>

		<label class="instructions" style="font-size: 40px;">Change your password</label>
	<br/>
		<label class="instructions">Enter Old Password</label>
	<br/>
		<form:input  class="boxUpdate" type="password" path="password" 
	                            placeholder="Password" value="" required="true" /> 
	<br/>
		<label class="instructions">Enter New Password</label>
	<br/>
		<form:input  class="boxUpdate" type="password"  id="passingWord1" path="password" 
	                            placeholder="Password" value="" required="true" />
	<br/>
		<input  class="boxUpdate" type="password"  id="passingWord2"
	                            placeholder="Confirm Password"  required />
	<br/>
		<input type="submit" class="pass" value="Update User" /> 
	</form:form>
	
	<br/><br/><br/>
	

</div>

<h1 style="font-family: Teko; font-size: 40px; margin-left: 50px;">Your pictures:</h1>
<br/>
<div class="main_content">
    <script type=".js/Randomize.js"></script>
        <div class="sub_main">

            <div class="main_item">
                <a href="./image1">
                    <img class="thumbnail" src="./images/EnlistedDuck.png" />
                </a>
            </div>
		</div>
</div>



</body>
</html>
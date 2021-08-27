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
	<link rel="stylesheet" type="text/css" href="/css/header.css">
	<link rel="stylesheet" type="text/css" href="/css/LoginMenu.css">
	<link rel="stylesheet" type="text/css" href="/css/HomePage.css">
</head>
<body>
    <script type="text/javascript" src="/scripts/verifyPassword.js"></script>
<%@ include file="navbar.html" %>
<div style="height: 120px;"></div>
<script type="text/javascript" src="/scripts/verifyPassword.js"></script>

<div style="margin-left: 50px;">
	<form onsubmit="return verifyPassword()"  action="/changePassword" 
			method="post" >
	<br/>
		<label class="instructions" style="font-size: 40px;">Change your password</label>
	<br/>
		<label class="instructions">Enter Old Password</label>
	<br/>
	<!-- This doesn't actually check to see if you entered your password! Yet! -->
		<input class="boxUpdate" type="password" placeholder="Password" value="" required /> 
	<br/>
		<label class="instructions">Enter New Password</label>
	<br/>
		<input  class="boxUpdate" type="password"  id="passingWord1" name="password" 
	                            placeholder="Password" value="" required />
	<br/>
		<input  class="boxUpdate" type="password"  id="passingWord2"
	                            placeholder="Confirm Password"  required />
	<br/>
		<input type="submit" class="pass" value="Update User" /> 
	</form>
	
	<br/><br/><br/>
	<!-- This doesn't actually check what you wrote. It started as a workaround for my limited knowledge and then 
	after I discovered how to make it delete the currentUser, I kept it as a fake security feature. -->
	<form action="/removeUser"  method="post" name="currentUser">
	<div><label class="instructions">Delete Account:</label></div>
	<div><input type="text" style="width: 350px;" name="Username" placeholder="Enter your Username and click DELETE USER to delete account" /></div>
	<div><input type="submit" class="pass" value="DELETE USER" /></div>
	</form>

</div>
<!--  This was supposed to be where you can see everything you posted. Not enough time to make work, 
but I think I have a good idea as to how. One day this might be implemented.
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

 -->

</body>
</html>
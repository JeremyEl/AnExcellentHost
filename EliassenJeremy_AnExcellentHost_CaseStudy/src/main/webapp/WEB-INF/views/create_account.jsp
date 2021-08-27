<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="stylesheet" type="text/css" href="/css/LoginMenu.css">
    <link href="https://fonts.googleapis.com/css2?family=Teko&display=swap" rel="stylesheet"> 
	
<body>
    <script type="text/javascript" src="/scripts/verifyPassword.js"></script>
    <%@ include file="navbar.html" %>
<div style=" height: max-content; padding: 120px; text-align: center; display: flex; justify-content: center;">

    <div id="container" style="width: 1000px; height: 500px; background-color: rgb(150,150,150); 
                    padding-bottom: 60px; ">

        <br/>
        <form:form onsubmit="return verifyPassword()" action="/createUser"  method="post" modelAttribute="user">
            <div>
                <label class="instructions">Select a Username:</label>
                <form:input  id="Username" class="box" type="text" path="username" 
                	name="Username" title="Username" placeholder="Username" required="true" /> 
            </div>
            <br/></br>
            <div>
                <label class="instructions">Select a Password:</label>
                <form:input  class="box" type="password"  id="passingWord1" path="password" 
                        placeholder="Password" value="" required="true" /> 
            </div>
            <br/></br>
            <div>
                <label class="instructions">Confirm Password:</label>
                <input class="box" type="password"  id="passingWord2" 
                        placeholder="Confirm Password" required /> 
            </div>
            <br/>
            <div id="message" style="color:rgb(0, 0, 0); font-family: Teko; font-size: 16px">Password must be between 6 and 15 characters.</div>
            
       <!-- I was originally going to add these in onto the table for fun, but decided that it wasn't worth the time investment. For now. 
       At the current time, they are just for fun and don't actually go anywhere. -->
            <div class="instructions">What is your favorite color?</div>
            <input type="text"></input>

            <div>
                <div class="instructions">Do you exist?</div>
                <input  type="radio" name="Test3" value="Yes" >
                <label style="color: white;">Yes</label>

                <input  type="radio" name="Test3" value="No" >
                <label style="color: white;">No</label>
            </div>

            <div class="instructions">Why are you signing up?</div>
            <select aria-placeholder="Select one.">
                <option>Select one.</option>
                <option>I'm evaluating this website.</option>
                <option>I'm a rando who found this site.</option>
                <option>I'm the admin and making test accounts.</option>
            </select>
            <br/>
            <br/>
            <div>  
                <input type="submit"  class="pass" value="CREATE ACCOUNT" />
            </div>  
            
        </form:form> 
    </div>

</div>
<p style="text-align: center; margin-top: -150px;"><button id="fpass" style="opacity: 50%; "> 
        <div id="fpassword" style="font-size: 10px;">Forgot Password?</div> </button>
</p>
<!--  This is hilarious to me and more of an incentive NOT to implement such a feature. -->
    <script type="text/javascript">
        const button = document.querySelector('#fpass');
        const changeText = () => {
            button.textContent="Too bad! I haven't implemented a recovery feature.";
        }
        button.addEventListener('click', changeText);
    </script>


</body>
</html>
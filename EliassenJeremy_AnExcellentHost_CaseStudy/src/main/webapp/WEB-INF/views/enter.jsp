<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="./css/header.css">
        <link rel="stylesheet" type="text/css" href="./css/LoginMenu.css">
        
</head>
<body>
    <%@ include file="navbar.html" %>
    <div style="height: 120px;"></div>

    <div style=" height: max-content; text-align: center; width: 100%; display: block;">

	    <div id="container" style="width: 800px; height: 150px; background-color: rgb(150,150,150); 
	                    padding-bottom: 60px;  margin:auto;">	        
	        <br/>
	        <form action="login" method="post">
	            <div>
	                <input id="Username" class="box" type="text" name="username" title="Username" 
	                        placeholder="Username"   /> 
	            </div>
	            	<br/>
	            <div>
	                <input id="password" class="box" type="password" name="password" title="password" 
	                        placeholder="Password" /> 
	            </div>
	            <br/>
	            <p>${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
	            <br/>	
	            <div>
	                <input type="submit" class="pass" value="LOGIN" />
	            </div>
	            	<br/>
	       </form>
	    </div>
        <br/>
        <button style="opacity: 50%;"> <!-- Seems pretty valid to me. Won't work otherwise. -->
            <a href="./create_account">
               <div style="width: 270px; color: black; font-size: 16px; border:0; outline: none; " >Create Account</div>
            </a>
        </button>
        <br/>
        <br/>
        <button id="fpass" style="opacity: 50%;"> <div id="fpassword" style="font-size: 10px;">Forgot Password?</div> </button>
    </div>
    
    <script type="text/javascript">
        const button = document.querySelector('#fpass');
        const changeText = () => {
            button.textContent="Too bad! I haven't implemented a recovery feature.";
        }
        button.addEventListener('click', changeText);
    </script>
</body>
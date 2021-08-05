<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="org.perscholas.models.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <link rel="stylesheet" type="text/css" href="./css/header.css">
    <link rel="stylesheet" type="text/css" href="./css/LoginMenu.css">
    
    <script type="text/javascript" src="./verifyPassword.js"></script>
<body>
    
    <div class="menu_container">
        <div class="header-item">
            <a href="./css/HomePage.html" >
                <img id="logo"  src="./css/hostLogo.png"/>
            </a>
            <aside style="font-size: 36px; position: relative; margin: 5px;"> An Excellent Host</aside>
            <aside style="font-size: 18px; position: relative; margin: 16px;">Image Hosting Service</aside>
        </div>

        <div class="menu_item">
            <nav>
                <ul>
                    <li>
                        <a href="./HomePage">Home</a>
                    </li>
                    <li>
                        <a href="./Login">Login</a>
                    </li>
                    <li>
                        <a href="#">Account</a>
                    </li>
                    <li>
                        <a href="#">About/Contact</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
<!-- INCLUDE A BOX TO SPECIFY PASSWORD REQUIREMENTS-->
    <div style=" height: max-content; padding: 100px; text-align: center; display: flex; justify-content: center;">

        <div id="container" style="width: 1000px; height: 450px; background-color: rgb(150,150,150); 
                        padding-bottom: 60px; ">
    
            <br></br>
            <form:form onsubmit="return(verifyPassword())" action="createUser"  method="post" modelAttribute="user"> 
                <div>
                    <div class="instructions">Select a Username:</div>
                    <input  id="Username" class="box" type="text" name="Username" title="Username" 
                            placeholder="Username"  /> 
                </div>
                <br/></br>
                <div>
                    <div class="instructions">Select a Password:</div>
                    <input  class="box" type="password"  id="passingWord1" 
                            placeholder="Password" value="" /> 
                </div>
                <br/></br>
                <div>
                    <div class="instructions">Confirm Password:</div>
                    <input class="box" type="password"  id="passingWord2" 
                            placeholder="Confirm Password" required/> 
                </div>
                <br/></br>
                
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
                <br/>
                <div>
                    
                    <input type="submit"  class="pass" value="CREATE ACCOUNT" />
                    <div id="message" style="color:rgb(202, 29, 29)"> </div>

                </div>  
                
            </form:form> 
        </div>

    </div>
    <p style="text-align: center; margin-top: -130px;"><button id="fpass" style="opacity: 50%; "> 
            <div id="fpassword" style="font-size: 10px;">Forgot Password?</div> </button>
    </p>
        <script language="javascript" type="text/javascript">
            const button = document.querySelector('#fpass');
            const changeText = () => {
                button.textContent="Too bad! I haven't implemented a recovery feature.";
            }
            button.addEventListener('click', changeText);
        </script>


</body>
</html>
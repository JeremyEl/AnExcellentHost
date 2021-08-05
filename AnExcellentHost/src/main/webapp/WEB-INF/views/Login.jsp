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
    <div class="menu_container">
        <div class="header-item">
            <a href="./HomePage">
                <img id="logo" src="./css/hostLogo.png"/>
            </a>
            <aside style="font-size: 45px; position: relative; margin: 5px;"> An Excellent Host</aside>
            <aside style="font-size: 20px; position: relative; margin: 18px;"> Image Hosting Service</aside>
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
                    <li>
                        <a href="./UploadImage">Upload Image</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>


    <div  style=" height: max-content; padding: 100px; ">

    <center><div id="container" style="width: 1000px; height: 150px; background-color: rgb(150,150,150); 
                    padding-bottom: 60px; ">

        
        <br></br>
        <form>
            <div>
                <input id="Username" class="box" type="text" name="Username" title="Username" 
                        placeholder="Username"   /> 
            </div>
            	<br/>
            <div>
                <input id="password" class="box" type="password" name="password" title="password" 
                        placeholder="Password" /> 
            </div>
            <br/>	
            <div>
                <input type="submit" class="pass" value="LOGIN" />
            </div>
            	<br/>
       </form>
    </div>
        
        <br/>
        <button style="opacity: 50%;">
            <a href="./CreateAccount"><div style="width: 270px; color: black; font-size: 16px; border:0; outline: none; " >Create Account</div></a>
        </button>
        <br/>
        <br/>
        <button id="fpass" style="opacity: 50%;"> <div id="fpassword" style="font-size: 10px;">Forgot Password?</div> </button>
    </div></center>
    </div>
    <script language="javascript" type="text/javascript">
        const button = document.querySelector('#fpass');
        const changeText = () => {
            button.textContent="Too bad! I haven't implemented a recovery feature.";
        }
        button.addEventListener('click', changeText);
    </script>
</body>
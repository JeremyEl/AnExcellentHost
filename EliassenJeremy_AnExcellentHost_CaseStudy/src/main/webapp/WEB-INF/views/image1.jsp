<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EnlistedDuck.png</title>
    <link rel="stylesheet" type="text/css" href="./css/header.css">
    <link rel="stylesheet" type="text/css" href="./css/imagepages.css">
</head>
<body>
    <%@ include file="navbar.html" %>
    <div style="height: 120px;"></div>

<!-- Tags on the left, comments below, reactions immediately below, table of friends to the right -->
<div >
    <table border="1">
        <caption style="margin-left: -150px; font-size: 35px;">Tags</caption>
        <tr>
        <td>Duck</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Helmet</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Weapon</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Mask</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Transparant Background</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Red</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Gone With the Blastwave</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Artist: Kimmo Lemetti</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Animal</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Cute</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        <tr>
        <td>Dystopic Future</td>
        <td>0</td>
        <td><button>+</button><button>-</button></td>
        </tr>
        </table>
       
        
        <table>
        <tr>
        <td>TAG GOES HERE</td>
        <td>${TAG_TERM}</td>
        <!--  Post mapping run that method -->
        <td><button onsubmit="">+</button><button onsubmit="">-</button></td>
        </tr>
        
         <button >Add Tag</button>
        
        </table>
   
    <div class="picture" >
        <a href="./image1.html">
            <img class="fullSize"  src="./images/EnlistedDuck.png" />
        </a>
    </div>
</div>   
    <br/>
    <br/>
    <div align="center" style="color: white;">Comments (to be implemented)</div>
    
    

        

</body>
</html>
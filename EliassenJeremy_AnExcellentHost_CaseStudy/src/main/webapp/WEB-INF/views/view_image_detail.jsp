<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        
	<div class="imagePost">		
		<h1>${newImage.imageFileName}</h1>
			<div  >
				<img class="imageItself" src="${'data:image/jpeg;base64,'} ${newImage.imageItself}" alt="Image image"/>
			</div>	
		<br/>
		<div>Description: ${newImage.description}</div>
		<br/>
	<form action="/form/submit" method="post">
		<textarea class="comment" placeholder="Comment here. Max 3000 characters."></textarea>
		<input type="submit" name="submit" value="Post">
	</form>
	
	<!--   <div>Poster: ${newImage.getUserPoster.getUsername}</div>     -->	
	</div>
	
</body>
</html>
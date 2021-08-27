<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>An Excellent Host</title>
    <link rel="stylesheet" type="text/css" href="/css/HomePage.css">
    <link rel="stylesheet" type="text/css" href="/css/header.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" >
    <link href="https://fonts.googleapis.com/css2?family=Teko&display=swap" rel="stylesheet"> 
</head>

<body>
    <%@ include file="navbar.html" %>
    <div style="height: 120px;"></div>
        <br/>
    <div class="main_content">
   
        <div class="sub_main">
									<!-- Here's the hardcoded images. Ideally they are random, but this is fine for now. -->
            <div class="main_item">
                <a href="/view/1">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image1.imageItself}" alt="${image1.imageFileName}" />
                </a>
            </div>

           <div class="main_item">
                <a href="/view/2">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image2.imageItself}" alt="${image2.imageFileName}" />
                </a>
            </div>

            <div class="main_item">
                <a href="/view/3">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image3.imageItself}" alt="${image3.imageFileName}" />
                </a>
            </div>
            
            <div class="main_item">
                <a href="/view/4">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image4.imageItself}" alt="${image4.imageFileName}"/>
                </a>
            </div>

            <div class="main_item">
                <a href="/view/5">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image5.imageItself}" alt="${image5.imageFileName}"/>
                </a>
            </div>
					
            <div class="main_item">
                <a href="/view/6">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image6.imageItself}" alt="${image6.imageFileName}"/>
                </a>
            </div>

            <div class="main_item">
                <a href="/view/7">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image7.imageItself}" alt="${image7.imageFileName}"/>
                </a>
            </div>

            <div class="main_item">
                <a href="/view/8">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image8.imageItself}" alt="${image8.imageFileName}"/>
                </a>
            </div>

            <div class="main_item">
                <a href="/view/9">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image9.imageItself}" alt="${image9.imageFileName}"/>
                </a>
            </div>

            <div class="main_item">
                <a href="/view/10">
                    <img class="thumbnail" src="${'data:image/jpeg;base64,'} ${image10.imageItself}" alt="${image10.imageFileName}"/>
                </a>
            </div>
                
          </div>
      </div>

</body>

</html>
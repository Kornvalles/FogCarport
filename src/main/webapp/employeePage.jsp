<%-- 
    Document   : employeePage
    Created on : 13-May-2019, 14:24:19
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            * {box-sizing: border-box;}

            .bg-img {
                /* The image used */
                background-image: url("http://www.jari-hardware.nl/style/bg.jpg");

                min-height: 800px;

                /* Center and scale the image nicely */
                background-position: left;
                background-repeat: no-repeat;
                background-size: cover;

                /* Needed to position the navbar */
                position: relative;
            }

            /* Position the navbar container inside the image */
            .container {
                position: absolute;
                margin: 0px;
                width: auto;
            }

            /* The navbar */
            .topnav {
                overflow: hidden;
                height: 100%;
                width: 100px;
                position: fixed;
                z-index: 0;
                top: 0;
                left: 0;
                background-color: #111;
                opacity: 0.7;
                overflow-x: hidden;
                padding-top: 20px;
            }

            /* Navbar links */
            .topnav a {
                float: left;
                color: #f2f2f2;
                text-align: left;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }
        </style>
    </head>
    <body>

        
        <div class="bg-img">
            <div class="container">
                <div class="topnav">
                    <a href="editOrders.jsp">Ordre</a>
                    <a href="updateMaterialPrices.jsp">Priser</a>
                    <a href="login.jsp">Log ud</a>
                </div>
            </div>
        </div>

    </body>
</html>

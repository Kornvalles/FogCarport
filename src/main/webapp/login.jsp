<%-- 
    Document   : login
    Created on : 13-May-2019, 13:36:17
    Author     : Benjamin & ndupo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            * {box-sizing: border-box;}

            .bg-img {
                /* The image used */
                background-image: url("https://images.photowall.com/products/50264/wooden-logs-wall.jpg?h=699&q=85");

                min-height: 380px;

                /* Center and scale the image nicely */
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    </head>

    <body>
        <div class="bg-img">
            <div class="container">
                <div class="row justify-content-center align-items-center" style="height:100vh">
                    <div class="col-4">
                        <div class="card">
                            <div class="card-body">
                                <form method="POST" action="FrontController">
                                    <input type="hidden" name="command" value="Employee">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="username">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" name="password">
                                    </div>
                                    <button type="submit" id="sendlogin" class="btn btn-primary" >login</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <%
                if (request.getAttribute("error") != null) {
                    out.print(request.getAttribute("error"));
                }
            %>
        </div>
    </body>
</html>

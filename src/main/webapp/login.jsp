<%-- 
    Document   : login
    Created on : 13-May-2019, 13:36:17
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
    <body>
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
                            <button type="submit" id="sendlogin" class="btn btn-primary" onclick="location.href='employeePage.jsp">login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>        
    </body>
</html>

<%-- 
    Document   : siteheader
    Created on : Apr 24, 2019, 2:12:24 PM
    Author     : ibenk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>

    <body>

        <form method="post" action="/FogCarport/FrontController?command=back">
            <input type="hidden" name="origin" value="back">
            <input type="submit" value="Tilbage til forside">
        </form>    

        <div class="jumbotron text-center">
            <h1>FOG Trælast</h1>
            <p>Bestil din nye carport i dag!</p> 
        </div>

    </body>
</html>

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
    </head>
    
    <body>

        <form method="post" action="/FogCarport/FrontController?command=back">
            <input type="hidden" name="origin" value="back">
            <input type="submit" value="Tilbage til forside">
        </form>    

    </body>
</html>

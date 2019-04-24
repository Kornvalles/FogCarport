<%-- 
    Document   : shop
    Created on : 12-04-2019, 11:45:37
    Author     : mikkel
--%>
<jsp:include page='/jsp/siteheader.jsp'></jsp:include>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>FOG Trælast</h1>
        
        <br><br> Indsæt dropdown-liste
        
        <br><br> Indsæt checkbox
        
        <br><br>
        <form method="post" action="/FogCarport/FrontController?command=">
            <input type="hidden" name="origin" value="loginpage">
            Navn og efternavn: <br>
            <input type="text" name="name" value=""/><br>
            Email:<br> 
            <input type="password" name="email" value=""/> <br><br>
            
            
            <input type="submit" value="Bestil">
        </form>
        
        <br><br> Indsæt refresh-knap
        
    </body>
</html>

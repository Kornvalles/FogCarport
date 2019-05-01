<%-- 
    Document   : sortiment
    Created on : Apr 24, 2019, 3:28:19 PM
    Author     : ndupo
--%>
<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>
<jsp:include page='/WEB-INF/Statics/sitefooter.jsp'></jsp:include>
<%@page import="FunctionLayer.Carport" %>
<% Carport car = new Carport(100, 240, 240, false, false, false, ""); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sortiment</title>
</head>
<html>
    <body>
        <img src="img/carport1.jpg" alt="Lille carport" width="200" height="200">
        <div class="footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
        </div>
    </body>
</html>

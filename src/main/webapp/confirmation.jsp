<%-- 
    Document   : confirmation
    Created on : Apr 25, 2019, 12:14:20 PM
    Author     : ibenk
--%>
<%@page import="FunctionLayer.Carport"%>
<%@page import="FunctionLayer.Calculator"%>
<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bestilling Godkendt</title>
    </head>
    <body>
        <h1>Tak for din bestilling!</h1>
        
        Her er din stykliste:
        <%
            Carport carport = (Carport) session.getAttribute("carport");
            System.out.println(Calculator.getAllMaterial(carport));
        System.out.println(Calculator.getTotalPrice(carport));%>
        
        
    </body>
</html>

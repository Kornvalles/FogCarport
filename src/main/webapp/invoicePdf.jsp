<%-- 
    Document   : invoicePdf
    Created on : 14-05-2019, 11:45:01
    Author     : mikkel
--%>
<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>
<jsp:include page='/WEB-INF/Statics/sitefooter.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fog faktura</title>
    </head>
    <body>
        <%
            response.setContentType("pdf");
            session.getAttribute("invoice");
        %>
    </body>
</html>

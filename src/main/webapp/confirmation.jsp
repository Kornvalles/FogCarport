<%-- 
    Document   : confirmation
    Created on : Apr 25, 2019, 12:14:20 PM
    Author     : ibenk
--%>
<%@page import="FunctionLayer.Carport"%>
<%@page import="FunctionLayer.Calculator"%>
<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>
<jsp:include page='/WEB-INF/Statics/sitefooter.jsp'></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bestilling Godkendt</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <p><h1>Tak for din bestilling!</h1></p>

                    Her er din stykliste:
                    <%
                        Carport carport = (Carport) session.getAttribute("carport");
                        out.print(carport.toString());
                        out.print(Calculator.getAllMaterial(carport));
                        out.print(Calculator.getTotalPrice(carport));
                    %>
                </div>
            </div>
        </div>
        <div class="footer">
            <p>Footer</p>
        </div>
    </body>
</html>

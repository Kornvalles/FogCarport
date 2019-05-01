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
                
                    <p><%Carport carport = (Carport) session.getAttribute("carport");
                         out.print(carport.toString());%></p>

                    <p>Her er din stykliste:</p>

                    <p><%out.print(Calculator.getAllMaterial(carport));%></p>

                    <p><%out.print("Totalpris " + Calculator.getTotalPrice(carport) + " kr.");%></p>
                </div>
            </div>
        </div>
        <div class="footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
        </div>
    </body>
</html>

<%-- 
    Document   : confirmation
    Created on : Apr 25, 2019, 12:14:20 PM
    Author     : ibenk
--%>
<%@page import="FunctionLayer.Construction"%>
<%@page import="FunctionLayer.Material"%>
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
        <style>
        </style>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <h1>Tak for din bestilling!</h1>

                        <p><%Construction construction = (Construction) session.getAttribute("construction");
                            out.print(construction.getCarport().toString());%></p>


                    <p>Her er din stykliste:</p>

                    <table class="table-hover">
                        <thead>
                            <tr>
                                <th style="text-align:left">Navn</th>
                                <th style="text-align:right">Antal</th>
                                <th style="text-align:right">Pris</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Material m : construction.getMaterials()) {%>
                            <tr>
                                <td style="text-align:left"><%=m.getName()%></td>
                                <td style="text-align:right"><%=m.getQty()%></td>
                                <td style="text-align:right"><%=String.format("%.2f", m.getPrice())%></td>
                            </tr>    
                            <%}
                            %>
                        </tbody>
                        <td>Subtotal: <%=construction.getTotalPrice()%> DKK inkl. Moms</td>
                    </table>
                </div>
            </div>
        </div>

        <svg x="10">
        <rect x="135" y="10" height="200" width="1"
              style="stroke:#000000; fill: #000000"/>
        <rect x="235" y="10" height="200" width="1"
              style="stroke:#000000; fill: #000000"/>
        <rect x="135" y="10" height="1" width="100"
              style="stroke:#000000; fill: #000000"/>
        </svg>

        <div class="footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
    </div>
</body>
</html>

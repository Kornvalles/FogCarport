<%-- 
    Document   : confirmation
    Created on : Apr 25, 2019, 12:14:20 PM
    Author     : ibenk
--%>
<%@page import="FunctionLayer.Invoice"%>
<%@page import="FunctionLayer.SVGDraw"%>
<%@page import="FunctionLayer.Customer"%>
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

                    <p><%Customer customer = (Customer) session.getAttribute("customer");
                        Construction construction = (Construction) session.getAttribute("construction");
                        out.print(construction.getCarport().toString());%></p>


                    <p>Her er din stykliste:</p>

                    <table class="table-hover">

                        <thead>
                        <col width="60">
                        <col width="60">
                        <col width="200">
                        <col width="50">

                        <tr>

                            <th style="text-align:center" colspan="2" >Antal</th>
                            <th style="text-align:left">Navn</th>
                            <th style="text-align:left"></th>
                        </tr>
                        </thead>
                        <tbody>
                            <%for (Material m : construction.getMaterials()) {%>
                            <tr>
                                <td style="text-align:right"><%=m.getQty()%></td>
                                <td style="text-align:left"><%=m.getUnit()%></td>
                                <td style="text-align:left"><%=m.getName()%></td>
                                <td style="text-align:left"><%=m.getDescription()%></td>
                                <td style="text-align:left"><%=m.getId()%></td>
                            </tr>    
                            <%}%>
                        </tbody>
                    </table>
                    <form method="POST" action="FrontController">
                        <input type="hidden" name="command" value="invoice">
                        <input type="submit" value="Lav faktura">
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">

                    <br><p>Totalpris: <%=String.format("%.2f", construction.getTotalPrice())%> kr. inkl. moms</p>

                    <p>SVGCarport <%= construction.getCarport().getLength()%> cm lang og <%= construction.getCarport().getWidth()%> cm bred</p>

                    <svg height="3000" width="4000" viewBox="0 0 <%construction.getCarport().getWidth();%> <%construction.getCarport().getLength();%>">

                    <%
                        SVGDraw svg = new SVGDraw();

                        out.println(svg.makePost(0, 0, 10, construction.getCarport().getLength(), "#C0C0C0"));
                        out.println(svg.makePost(0, construction.getCarport().getWidth(), 10, construction.getCarport().getLength(), "#C0C0C0"));

                        for (int i = 0; i <= construction.getCarport().getLength(); i += 31) {
                            out.println(svg.makePost(i, 0, construction.getCarport().getWidth() + 10, 10, "#a68064"));
                            //out.println(svg.makePost(construction.getCarport().getLength()-10, 0, construction.getCarport().getWidth()+10, 10, "#a68064"));
                        }

                    %>
                    </svg>
                </div>
            </div>
        </div>


        <div class="#footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
    </div>
</body>
</html>

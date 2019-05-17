<%-- 
    Document   : confirmation
    Created on : Apr 25, 2019, 12:14:20 PM
    Author     : ibenk
--%>
<%@page import="FunctionLayer.SVGText"%>
<%@page import="FunctionLayer.SVGRectangle"%>
<%@page import="java.io.File"%>
<%@page import="FunctionLayer.Invoice"%>
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
                <div class="col-sm">
                    <h1>Tak for din bestilling!</h1>

                    <p><%Customer customer = (Customer) session.getAttribute("customer");
                        Construction construction = (Construction) session.getAttribute("construction");
                        out.print(construction.getCarport().toString());%></p>


                    <p>Her er din stykliste:</p>

                    <table class="table-hover">

                        <thead>
                        <col width="250">
                        <col width="60">
                        <col width="60">
                        <col width="70">
                        <col width="750">

                        <tr>
                            <th style="text-align:left">Materiale</th>
                            <th style="text-align:left"></th>
                            <th style="text-align:center" colspan="2" >Antal</th>
                            <th style="text-align:left">Beskrivelse</th>
                        </tr>
                        </thead>
                        <tbody>
                            <%for (Material m : construction.getMaterials()) {%>
                            <tr>
                                <td style="text-align:left"><%=m.getName()%></td>
                                <td style="text-align:left"><%=m.getId()%></td>
                                <td style="text-align:right"><%=m.getQty()%></td>
                                <td style="text-align:left"><%=m.getUnit()%></td>
                                <td style="text-align:left"><%=m.getDescription()%></td>
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

                    <svg width="1000" height="400" xmlns="http://www.w3.org/2000/svg" xmlns:svg="http://www.w3.org/2000/svg">
                    <%  /* Making the posts on the longside */
                        for (int i = 50; i <= construction.getCarport().getLength(); i = i + 100) {
                            SVGRectangle posts = new SVGRectangle("230", "1", "10", String.valueOf(i), "25");
                            out.println(posts.toString());
                        }

                        /* Making the walls of the longside with wooden boards */
                        for (int i = 55; i <= construction.getCarport().getLength(); i = i + 100) {
                            for (int j = 25; j < 255; j = j + 10) {
                                SVGRectangle boards = new SVGRectangle("10", "0.25", "100", String.valueOf(i), String.valueOf(j));
                                out.println(boards.toString());
                            }
                        }

                        SVGText text = new SVGText("100", "280", "100 cm");
                        out.println(text.toString());

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

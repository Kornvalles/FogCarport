<%-- 
    Document   : confirmation
    Created on : Apr 25, 2019, 12:14:20 PM
    Author     : ibenk
--%>
<%@page import="FunctionLayer.SVGFog"%>
<%@page import="FunctionLayer.Dimension"%>
<%@page import="FunctionLayer.SVGCarport"%>
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
                        <col width="50">
                        <col width="50">
                        <col width="200">
                        <col width="50">

                        <tr>

                            <th style="text-align:center" colspan="2" >Antal</th>
                            <th style="text-align:left">Navn</th>
                            <th style="text-align:left">PPU</th>
                        </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Material m : construction.getMaterials()) {%>
                            <tr>
                                <td style="text-align:right"><%=m.getQty()%></td>
                                <td style="text-align:left"><%=m.getUnit()%></td>
                                <td style="text-align:left"><%=m.getName()%></td>
                                <td style="text-align:left"><%=String.format("%.2f", m.getPrice())%></td>
                            </tr>    
                            <%}
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <br><p>Totalpris: <%=String.format("%.2f", construction.getTotalPrice())%> kr. inkl. moms</p>

            <%
                SVGCarport svg = new SVGCarport();
                String drawing1 = svg.drawCarport(100, 100, new Dimension(800, 800));

                SVGFog svgFOG = new SVGFog(200, 200, 200);
                svgFOG.setAngles(30);

                String drawing2 = svgFOG.drawTop();
            %>

            <p>SVGCarport</p>

            <%= drawing1%>

            <svg width="50%" viewbox="0 0 100 100" style="background: gray">
            <svg x="20%" y="20%" width="80%" height="80%">
            <rect width="100%" height="100%" fill="purple" />
            <%= drawing2%>                
            </svg>
            </svg>

        </div>



        <div class="footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
    </div>
</body>
</html>

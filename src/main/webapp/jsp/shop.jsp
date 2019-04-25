<%-- 
    Document   : shop
    Created on : 12-04-2019, 11:45:37
    Author     : mikkel
--%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Carport"%>
<%@page import="DataLayer.OrderMapper"%>
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

        <%

            LogicFacade lf = new LogicFacade();

            /* Add dropdown-list with carports  */
            List<Carport> standard = lf.getOrders();

        %>
        <br><br> Vælg carport

        <form method="POST" action="FrontController" >
            <input type="hidden" name="origin" value="makeOrder">
            <input type="hidden" name="command" value="order">
            <table class="table table-striped">
                <thead><tr><th>Bottom</th><th>Topping</th><th>Quantity</th><th></th><th></th></tr></thead>
                <tbody>
                    <tr>
                        <td><select name="standard" id="standardSelect">
                                <%  for (Carport stand : standard) {
                                        out.print("<option value=\"" + stand.getDetails()
                                                + "\">" + stand.getDetails() + "</option>\n");
                                    }

                                    out.print("<select>\n");
                                %>
                            </select>

                    </tr>
                </tbody>
            </table>


            <br><br> Indsæt checkbox

            <br><br>

            Fulde navn: <br>
            <input type="text" name="name" value=""/><br>
            Email:<br> 
            <input type="password" name="email" value=""/> <br><br>


            <td><input type="submit" name="order" value="Bestil"></td><td><span id="errorContainer"></span></td>
        </form>

    </body>
</html>

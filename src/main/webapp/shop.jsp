<%-- 
    Document   : shop
    Created on : 12-04-2019, 11:45:37
    Author     : mikkel
--%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.CarportWithSides"%>
<%@page import="DataLayer.OrderMapper"%>
<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body>


        <%

            OrderMapper mapper = new OrderMapper();
            //missing method import

        %>
        <br><br> Bestilling af carport
        <div class="container">
            <div class="row">
                <div class="col">    
                    <form method="POST" action="/FogCarport/FrontController?command=order" >
                        <input type="hidden" name="origin" value="order"> <br>
                       <br><br> Length <br><br>
                        <td><input type="text" name="length" placeholder="Insert carport length?" id="lengthInput"></td>
                        <br><br>Width<br><br>
                        <td><input type="text" name="width" placeholder="How wide would you like the carport?" id="widthInput"></td>
                        <br><br> With toolshed?? <br><br>
                        <input type="checkbox" name="redskabsskur" value="Ja">
                        <br><br> With a pointy roof? <br><br>
                        <input type="checkbox" name="spidstag" value="Ja">
                        <br><br> With walls? <br><br>
                        <input type="checkbox" name="beklædning" value="Ja">
                        

                        Fulde navn: <br>
                        <input type="text" name="name" value=""/><br>
                        Email:<br> 
                        <input type="password" name="email" value=""/> <br><br>


                        <td><input type="submit" name="order" value="Bestil"></td><td><span id="errorContainer"></span></td>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

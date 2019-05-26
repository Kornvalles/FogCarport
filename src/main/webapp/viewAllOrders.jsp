<%@page import="FunctionLayer.Employee"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.FogException"%>
<%@page import="ch.qos.logback.core.joran.action.IncludeAction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href='https://fonts.googleapis.com/css?family=Volkhov' rel='stylesheet'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <%if (session.getAttribute("employee") == null|| session.getAttribute("employee") == "") {
                request.setAttribute("error", "Please Login");
                response.sendRedirect(response.encodeURL("login.jsp"));
        }   
            List<Order> orderlist = (List<Order>) session.getAttribute("orderlist");
            
            %>
        <title>Se alle ordre</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
            <a href="index.jsp" class="navbar-brand">
                <img src="img/logo.png" class="img-thumbnail" alt="Fog">
            </a>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link" href="editOrders.jsp">Ændre Ordrer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="updateMaterialPrices.jsp">Opdater Materialepriser</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewAllOrders.jsp">Se Alle Ordrer</a>
                </li>
                <%
                    Employee e = (Employee) session.getAttribute("employee");
 //                   if (e.isAdmin()) { 
                %>
               <li class="nav-item">
                    <a class="nav-link" href="adminPage.jsp">Admin</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?command=logout">Log ud</a>
                </li>
            </ul>
        </nav>
        <%
            if (request.getAttribute("message") != null) {
                out.print(request.getAttribute("message"));
            }
        %>
            <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Order ID</th>
                                <th scope="col">Employee ID</th>
                                <th scope="col">Customer ID</th>
                                <th scope="col">Carport Height</th>
                                <th scope="col">Carport Length</th>
                                <th scope="col">Carport Width</th>
                                <th scope="col">Has Shed</th>
                                <th scope="col">Shed Width</th>
                                <th scope="col">Tall Roof</th>
                                <th scope="col">Roof type</th>
                                <th scope="col">Roof Angle</th>
                                <th scope="col">Has Walls</th>
                                <th scope="col">Details</th>
                                <th scope="col">Total Price</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <%  for(Order orders : orderlist) {
                                System.out.println("<form method=\"POST\" action=\"FrontController\">");
                                System.out.println("<input type=\"hidden\" name=\"command\" value=\"deleteOrder\">");
                                System.out.println("<input type=\"hidden\" name=\"orderid\" value=\"" + orders.getId() + "\">");
                                System.out.println("<tr>");
                                System.out.println("<td>" + orders.getId() + "</td>");
                                System.out.println("<td>" + orders.getCustomerId() + "</td>");
                                System.out.println("<td>" + orders.getEmployeeId() + "</td>");
                                System.out.println("<td>" + orders.getCarport().getHeight() + "</td>");
                                System.out.println("<td>" + orders.getCarport().getLength() + "</td>");
                                System.out.println("<td>" + orders.getCarport().getWidth() + "</td>");
                                System.out.println("<td>" + orders.getCarport().hasToolshed() + "</td>");
                                System.out.println("<td>" + orders.getCarport().getShedWidth() + "</td>");
                                System.out.println("<td>" + orders.getCarport().hasPointyRoof() + "</td>");
                                System.out.println("<td>" + orders.getCarport().roofType() + "</td>");
                                System.out.println("<td>" + orders.getCarport().getRoofAngle() + "</td>");
                                System.out.println("<td>" + orders.getCarport().hasWall() + "</td>");
                                System.out.println("<td>" + orders.getCarport().getDetails() + "</td>");
                                System.out.println("<td>" + orders.getTotalPrice() + "</td>");
                                System.out.println("<td>"); 
                                System.out.println("<input type ='submit' value ='Slet Ordre'>");
                                System.out.println("</td>");
                                System.out.println("</tr></form>"); 
                                } 
                            %> 
                        
                        </tr>
                        </tbody>
                    </table>
            </div>
        </div>
        </div>
    </body>
</html>

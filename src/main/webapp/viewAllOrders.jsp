<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.FogException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataLayer.OrderMapper"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href='https://fonts.googleapis.com/css?family=Volkhov' rel='stylesheet'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <%if (session.getAttribute("employee") == null) {
                request.setAttribute("error", "Please Login");
                response.sendRedirect(response.encodeURL("login.jsp"));
        }
                OrderMapper od = new OrderMapper();
            %>
        <title>Se alle order</title>
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
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?command=logout">Log ud</a>
                </li>
            </ul>
        </nav>
        <%if (request.getAttribute("message") != null) {
                out.print(request.getAttribute("message"));
            }%>
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
                                <th scope="col">Tag</th>
                                <th scope="col">Roof type</th>
                                <th scope="col">Roof Angle</th>
                                <th scope="col">Has Walls</th>
                                <th scope="col">Details</th>
                                <th scope="col">Total Price</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <%
                                for (Order orders : od.getAllOrders()) {
                                out.println("<tr>");
                                
                                out.println("<td>" + orders.getId() + "</td>");
                                out.println("<td>" + orders.getCustomerId() + "</td>");
                                out.println("<td>" + orders.getEmployeeId() + "</td>");
                                out.println("<td>" + orders.getCarport().getHeight() + "</td>");
                                out.println("<td>" + orders.getCarport().getLength() + "</td>");
                                out.println("<td>" + orders.getCarport().getWidth() + "</td>");
                                out.println("<td>" + orders.getCarport().hasToolshed() + "</td>");
                                out.println("<td>" + orders.getCarport().getShedWidth() + "</td>");
                                out.println("<td>" + orders.getCarport().hasPointyRoof() + "</td>");
                                out.println("<td>" + orders.getCarport().roofType() + "</td>");
                                out.println("<td>" + orders.getCarport().getRoofAngle() + "</td>");
                                out.println("<td>" + orders.getCarport().hasWall() + "</td>");
                                out.println("<td>" + orders.getCarport().getDetails() + "</td>");
                                out.println("<td>" + orders.getTotalPrice() + "</td>");
                                out.println("</tr>");
                                }
                                %>
                        </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
        </div>
    </body>
</html>

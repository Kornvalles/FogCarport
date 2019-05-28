<%@page import="FunctionLayer.Employee"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.FogException"%>
<%@page import="ch.qos.logback.core.joran.action.IncludeAction"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href='https://fonts.googleapis.com/css?family=Volkhov' rel='stylesheet'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <%if (session.getAttribute("employee") == null || session.getAttribute("employee") == "") {
                request.setAttribute("error", "Please Login");
                response.sendRedirect(response.encodeURL("login.jsp"));
            }
            List<Material> materials = (List<Material>) session.getAttribute("materials");
            Employee e = (Employee) session.getAttribute("employee");
        %>
        <title>Ændring af materiale priser!</title>
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
                <%if (e.isAdmin()) {%>
                <li class="nav-item">
                    <a class="nav-link" href="adminPage.jsp">Admin</a>
                </li> <%}%>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?command=logout">Log ud</a>
                </li>
            </ul>
        </nav>
        <br>
        <%if (request.getAttribute("message") != null) {
                out.print(request.getAttribute("message"));
            }%>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Materiale ID</th>
                                <th scope="col">Materiale Navn</th>
                                <th scope="col">MSRP</th>
                                <th scope="col">Ny MSRP</th>
                                <th scope="col">Kostpris</th>
                                <th scope="col">Ny Kostpris</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for (Material m : materials) {
                                out.println("<tr>");
                                out.println("<form method=\"POST\" action=\"FrontController\">");
                                out.println("<td>" + m.getId() + "</td>");
                                out.println("<td>" + m.getName().substring(0, 1).toUpperCase() + m.getName().substring(1) + "</td>");
                                out.println("<td>" + m.getPrice() + "</td>");
                                out.println("<td><input type=\"text\" name=\"newPrice\"></td>");
                                out.println("<td>" + m.getCostPrice() + "</td>");
                                out.println("<td><input type=\"text\" name=\"newCostPrice\"></td>");
                                out.println("<td>");
                                out.println("<input type=\"hidden\" name=\"materialId\" value=\"" + m.getId() + "\">");
                                out.println("<input type=\"hidden\" name=\"command\" value=\"updatePrice\">");
                                out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"Ændr\">");
                                out.println("</form></td>");
                                out.println("</tr>");
                            }%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

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
        <%if (session.getAttribute("employee") == null) {
                request.setAttribute("error", "Please Login");
                response.sendRedirect(response.encodeURL("login.jsp"));
            }
            List<Material> materials = (List<Material>) session.getAttribute("materials");
        %>
        <title>Ændring af materiale priser!</title>
    </head>
    <body>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <button onclick="window.location.href = 'employeePage.jsp';">Tilbage</button>
                </div>
            </div>
        </div>
        <div class="container" style="width: 80%">
            <form method="POST" action="FrontController">
                <input type="hidden" name="command" value="updatePrice">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Materiale ID</th>
                            <th scope="col">Materiale Navn</th>
                            <th scope="col">MSRP</th>
                            <th scope="col">Ny MSRP</th>
                            <th scope="col">Kostpris</th>
                            <th scope="col">Ny Kostpris</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                    <div class="form-group">
                        <th scope="row"><%=materials.get(0).getId()%></th>
                        <td><%=materials.get(0).getName().substring(0,1).toUpperCase()+materials.get(0).getName().substring(1)%></td>
                        <td><%=materials.get(0).getPrice()%></td>
                        <td><input type="text" name="newPrice"></td>
                        <td><%=materials.get(0).getCostPrice()%></td>
                        <td><input type="text" name="newCostPrice"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row"><%=materials.get(1).getId()%></th>
                        <td><%=materials.get(1).getName().substring(0,1).toUpperCase()+materials.get(1).getName().substring(1)%></td>
                        <td><%=materials.get(1).getPrice()%></td>
                        <td><input type="text" name="newPrice"></td>
                        <td><%=materials.get(1).getCostPrice()%></td>
                        <td><input type="text" name="newCostPrice"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row"><%=materials.get(2).getId()%></th>
                        <td><%=materials.get(2).getName().substring(0,1).toUpperCase()+materials.get(2).getName().substring(1)%></td>
                        <td><%=materials.get(2).getPrice()%></td>
                        <td><input type="text" name="newPrice"></td>
                        <td><%=materials.get(2).getCostPrice()%></td>
                        <td><input type="text" name="newCostPrice"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row"><%=materials.get(3).getId()%></th>
                        <td><%=materials.get(3).getName().substring(0,1).toUpperCase()+materials.get(3).getName().substring(1)%></td>
                        <td><%=materials.get(3).getPrice()%></td>
                        <td><input type="text" name="newPrice"></td>
                        <td><%=materials.get(3).getCostPrice()%></td>
                        <td><input type="text" name="newCostPrice"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row"><%=materials.get(4).getId()%></th>
                        <td><%=materials.get(4).getName().substring(0,1).toUpperCase()+materials.get(4).getName().substring(1)%></td>
                        <td><%=materials.get(4).getPrice()%></td>
                        <td><input type="text" name="newPrice"></td>
                        <td><%=materials.get(4).getCostPrice()%></td>
                        <td><input type="text" name="newCostPrice"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row"><%=materials.get(5).getId()%></th>
                        <td><%=materials.get(5).getName().substring(0,1).toUpperCase()+materials.get(5).getName().substring(1)%></td>
                        <td><%=materials.get(5).getPrice()%></td>
                        <td><input type="text" name="newPrice"></td>
                        <td><%=materials.get(5).getCostPrice()%></td>
                        <td><input type="text" name="newCostPrice"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row"><%=materials.get(6).getId()%></th>
                        <td><%=materials.get(6).getName().substring(0,1).toUpperCase()+materials.get(6).getName().substring(1)%></td>
                        <td><%=materials.get(6).getPrice()%></td>
                        <td><input type="text" name="newPrice"></td>
                        <td><%=materials.get(6).getCostPrice()%></td>
                        <td><input type="text" name="newCostPrice"></td>
                    </div>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>

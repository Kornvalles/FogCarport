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
                        <th scope="row">1000</th>
                        <td>Stolper</td>
                        <td><%=materials.get(0).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP1"></td>
                        <td><%=materials.get(0).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="KP1"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row">1010</th>
                        <td>Planker</td>
                        <td><%=materials.get(1).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP2"></td>
                        <td><%=materials.get(1).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="KP2"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row">1020</th>
                        <td>Taglægter</td>
                        <td><%=materials.get(2).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP3"></td>
                        <td><%=materials.get(2).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="KP3"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row">1030</th>
                        <td>Sidelægter</td>
                        <td><%=materials.get(3).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP4"></td>
                        <td><%=materials.get(3).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="KP4"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row">2000</th>
                        <td>Skruer 200 stk</td>
                        <td><%=materials.get(4).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP5"></td>
                        <td><%=materials.get(4).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="KP5"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row">3000</th>
                        <td>Tagsten</td>
                        <td><%=materials.get(5).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP6"></td>
                        <td><%=materials.get(5).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="KP6"></td>
                    </div>
                    </tr>
                    <tr>
                    <div class="form-group">
                        <th scope="row">3010</th>
                        <td>Tagplader</td>
                        <td><%=materials.get(6).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP7"></td>
                        <td><%=materials.get(6).getPrice()%></td>
                        <td><input type="text"><input type="submit" value="Ændr pris" name="KP7"></td>
                    </div>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>

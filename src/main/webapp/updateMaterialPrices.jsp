<%@page import="DataLayer.OrderMapper"%>
<%@page import="java.sql.ResultSet"%>

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
        <script src="WEB-INF/app/app.js" type="text/javascript"></script>
        <script src="WEB-INF/app/app.js" type="text/javascript"></script>
        <title>Ændring af materiale priser!</title>
    </head>
    <body>
        <%OrderMapper od = new OrderMapper();%>
        <form method="POST" action="FrontController">
            <input type="hidden" name="command" value="CreateOrder">
            <table class="table table-striped table-dark">
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
                    <td> <%=od.getMaterialPrice("stolpe(r)")%> </td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP1"></td>
                    <td><%=od.getCostPrice("stolpe(r)")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="KP1"></td>
                </div>
                </tr>
                <tr>
                <div class="form-group">
                    <th scope="row">1010</th>
                    <td>Planker</td>
                    <td><%=od.getMaterialPrice("planke(r) 10x100cm")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP2"></td>
                    <td><%=od.getCostPrice("planke(r) 10x100cm")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="KP2"></td>
                </div>
                </tr>
                <tr>
                <div class="form-group">
                    <th scope="row">1020</th>
                    <td>Taglægter</td>
                    <td><%=od.getMaterialPrice("taglaegte(r)")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP3"></td>
                    <td><%=od.getCostPrice("taglaegte(r)")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="KP3"></td>
                </div>
                </tr>
                <tr>
                <div class="form-group">
                    <th scope="row">1030</th>
                    <td>Sidelægter</td>
                    <td><%=od.getMaterialPrice("sidelaegte(r)")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP4"></td>
                    <td><%=od.getCostPrice("sidelaegte(r)")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="KP4"></td>
                </div>
                </tr>
                <tr>
                <div class="form-group">
                    <th scope="row">2000</th>
                    <td>Skruer 200 stk</td>
                    <td><%=od.getMaterialPrice("skruer 200 stk")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP5"></td>
                    <td><%=od.getCostPrice("skruer 200 stk")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="KP5"></td>
                </div>
                </tr>
                <tr>
                <div class="form-group">
                    <th scope="row">3000</th>
                    <td>Tagsten</td>
                    <td><%=od.getMaterialPrice("tagsten")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP6"></td>
                    <td><%=od.getCostPrice("tagsten")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="KP6"></td>
                </div>
                </tr>
                <tr>
                <div class="form-group">
                    <th scope="row">3010</th>
                    <td>Tagplader</td>
                    <td><%=od.getMaterialPrice("tagplade(r)")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="MSRP7"></td>
                    <td><%=od.getCostPrice("tagplade(r)")%></td>
                    <td><input type="text"><input type="submit" value="Ændr pris" name="KP7"></td>
                </div>
                </tr>
                </tbody>
            </table>
        </form>
        <button onclick="window.location.href = 'employeePage.jsp';">Tilbage</button>
    </body>







    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</html>

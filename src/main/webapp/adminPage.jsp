<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Employee"%>
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
        <script src="app/app.js" type="text/javascript"></script>
        <%  Employee e = (Employee) session.getAttribute("employee");
            Employee e2 = null;
            if (request.getAttribute("employeeToEdit") != null) {
                e2 = (Employee) request.getAttribute("employeeToEdit");
            }
            List<Employee> employees = (List<Employee>) session.getAttribute("employees");
            if (e == null || e.isAdmin() == false) {
                request.setAttribute("error", "Please Login");
                response.sendRedirect(response.encodeURL("login.jsp"));
            }
        %>
        <title>Admin side</title>
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
                    <a class="nav-link" href="employeePage.jsp">Tilbage</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?command=logout">Log ud</a>
                </li>
            </ul>
        </nav>
        <%if (request.getAttribute("message") != null) {%>
        <div class="alert alert-success">
            <strong>Success!</strong> <%=request.getAttribute("message")%>
        </div>
        <%}%>
        <header class="masthead">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12 text-center">
                        <h1 class="font-weight-light">Dette er administrator siden</h1>
                        <p class="lead">Her kan du ændre priser på materialer, se alle ordrer eller ændre i ordrer, hvis kunden har lavet en fejl. Derudover 
                            er der mulighed for at ændre og tilføje samt slette medarbejder.
                            Bare benyt dig af menuen i toppen af siden, til at navigere.</p>
                    </div>
                </div>
            </div>
        </header>
        <div class="container mt-3">
            <div style="text-align: center">
                <!-- Button to Open the Modal, button for Popup -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addEmp">
                    Tilføj medarbejder
                </button>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteEmp">
                    Slet medarbejder
                </button>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#allEmployees">
                    Alle medarbejder
                </button>
            </div>
            <!-- The Modal, Popupbox for add employee -->
            <div class="modal" id="addEmp">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Ny medarbejder</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="command" value="addEmployee">
                                <label for="username">Brugernavn:</label>
                                <input type="text" class="form-control" name="username" id="username" required>
                                <label for="pwd">Adgangskode:</label>
                                <input type="password" class="form-control" name="pwd" id="pwd" required>
                                <input type="checkbox" onclick="showPassword();">Vis adgangskode
                                <div class="custom-control custom-switch">
                                    <input type="checkbox" class="custom-control-input" id="switch1" name="isAdmin">
                                    <label class="custom-control-label" for="switch1">Admin rettigheder</label></div>
                                <br>
                                <button type="submit" class="btn btn-primary">Opret</button>
                            </form>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal" id="deleteEmp">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Slet medarbejder</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="command" value="deleteEmployee">
                                <label for="id">id:</label>
                                <input type="text" class="form-control" name="id" id="username" required>
                                <button type="submit" class="btn btn-danger">Slet</button>
                            </form>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="allEmployees">
                <div class="modal-dialog modal-dialog-centered modal-lg">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Alle medarbejder</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Brugernavn</th>
                                        <th>Password</th>
                                        <th style="width: 150px;">Admin status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (Employee e1 : employees) {
                                            out.println("<tr>");
                                            out.println("<td>" + e1.getId() + "</td>");
                                            out.println("<td>" + e1.getUsername() + "</td>");
                                            out.println("<td>" + e1.getPassword() + "</td>");
                                            out.println("<td>" + e1.isAdmin() + "</td>");
                                            out.println("<td>");
                                            out.println("<form method=\"POST\" action=\"FrontController\">");
                                            out.println("<input type=\"hidden\" name=\"employeeId\" value=\"" + e1.getId() + "\">");
                                            out.println("<input type=\"hidden\" name=\"command\" value=\"showEditEmployee\">");
                                            out.println("<button type=\"submit\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#allEmployees\">Ændre</button>");
                                            out.println("</form></td>");
                                            out.println("</tr>");
                                        }%>
                                </tbody>
                            </table>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <% if (request.getAttribute("employeeToEdit") != null) {%>                    
            <div class="modal" id="editEmployee">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Ændre medarbejder</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="command" value="editEmployee">
                                <input type="hidden" name="id" value="<%=e2.getId()%>">
                                <label for="usernameEdit">Brugernavn:</label>
                                <input type="text" class="form-control" name="username" id="usernameEdit" value="<%=e2.getUsername()%>" required>
                                <label for="pwdEdit">Adgangskode:</label>
                                <input type="password" class="form-control" name="pwd" id="pwdEdit" value="<%=e2.getPassword()%>" required>
                                <input type="checkbox" onclick="showPassword();">Vis adgangskode
                                <div class="custom-control custom-switch">
                                    <input type="checkbox" class="custom-control-input" id="switch2" name="isAdmin" <%if (e2.isAdmin()) {%> checked <%}%>>
                                    <label class="custom-control-label" for="switch2">Admin rettigheder</label></div>
                                <br>
                                <button type="submit" class="btn btn-primary">Ændr</button>
                            </form>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <% }%>
        </div>
        <script>
            $(function () {
                $('.btn').click(function (e) {
                    var link = $(this).attr('href');
                    if ($(this).attr('id') == 'Buy') {
                        $.get(link, function (data) {
                            modal.open({content: data});
                            $('#transType').val('buy');
                        });
                    }
                    e.preventDefault();
                });
            });
        </script>
    </body>
</html>

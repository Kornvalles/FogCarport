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
        <%if (session.getAttribute("employee") == null) {
                request.setAttribute("error", "Please Login");
                response.sendRedirect(response.encodeURL("login.jsp"));
            }%>
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
        <h1>Alle ordrerne</h1>
    </body>
</html>

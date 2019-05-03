<%-- 
    Document   : sortiment
    Created on : Apr 24, 2019, 3:28:19 PM
    Author     : ndupo
--%>
<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>
<jsp:include page='/WEB-INF/Statics/sitefooter.jsp'></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="main.css/main.css" />
</head>
<html>
    <body>
        <p> <title>Sortiment</title> </p>
        <%--
        billeder med centrering
        --%>
        <div class="row" align="center">
            <div class="column">
                <a href="shop.jsp">
                    <img src="img/lillecarport.jpeg" title="Lille Carport" width="400" height="400" /></a>
                <p class="text">Carport uden redskabsskur. 3,30X5,80M</p>
                <p class="text">Med runding på taget</p>
            </div>
            <div class="column img-with-text">
                <a href="shop.jsp">
                    <img src="img/mellemcarport.jpeg" title="Mellem Carport" width="400" height="400" /></a>
                <p class="text">Carport uden redskabsskur. 6,30X5,80M</p>
                <p class="text">Med fladt tag</p>
            </div>
            <div class="column">
                <a href="shop.jsp">
                    <img src="img/mellemmskur.jpeg" title="Mellem Carport m/ skur" width="400" height="400" /></a>
                <p class="text">Carport med redskabsskur. 6,30X5,80M</p>
                <p class="text">Med fladt tag</p>
            </div>
        </div>
        <div class="footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
    </div>
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>

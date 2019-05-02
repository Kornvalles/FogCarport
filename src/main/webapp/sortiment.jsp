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
    <style>
        * {
            box-sizing: border-box;
        }

        .column {
            float: left;
            width: 33.33%;
        }

        /* Clearfix (clear floats) */
        .row::after {
            content: "";
            clear: both;
            display: table;
        }
    </style>
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
</body>
</html>

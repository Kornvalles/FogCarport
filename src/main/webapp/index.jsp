<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>
<jsp:include page='/WEB-INF/Statics/sitefooter.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="WEB-INF/main.css/main.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>Start side</title>
    </head>
    <body>
        <div class="bd-example">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" style="width: 700px; margin:0 auto;">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/1.png" class="h-50 d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img/2.png" class="h-50 d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img/3.png" class="h-50 d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img/4.png" class="h-50 d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img/5.png" class="h-50 d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img/6.png" class="h-50 d-block w-100" alt="...">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-sm">
            <%
                if (request.getAttribute("error") != null) {
                    out.print(request.getAttribute("error"));
                }
            %>
        </div>
        <script>
            $('.carousel').carousel({
                interval: 2000
            });
        </script>
        <div class="footer">
            <p>� 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk <a href="login.jsp">Medarbejder</a></p>
        </div>
    </body>
</html>

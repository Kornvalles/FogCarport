<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link href="app/footer.css" rel="stylesheet" type="text/css"/>
        <script src="app/app.js" type="text/javascript"></script>
        <link href="app/app.css" rel="stylesheet" type="text/css"/>
        <title>Start side</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light" style="position: sticky">
            <a href="index.jsp" class="navbar-brand">
                <img src="img/logo.png" class="img-thumbnail" alt="Fog">
            </a>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Hjem</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="createCustomer.jsp">Bestilling</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sortiment.jsp">Sortiment</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Medarbejder</a>
                </li>
            </ul>
        </nav>
        <!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Fog Carporte</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/product/">

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="product.css" rel="stylesheet">
  </head>

  <body>
    <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
      <div class="col-md-5 p-lg-5 mx-auto my-5">
        <h1 class="display-4 font-weight-normal">Udforsk det bedste Fog Carporte har at byde på.</h1>
        <p class="lead font-weight-normal">Fog Carporte yder den bedste service og de bedste priser på det danske marked. </p>
        <a class="btn btn-outline-secondary" href="sortiment.jsp">Bestil en lækker carport</a>
      </div>
      <div class="product-device box-shadow d-none d-md-block"></div>
      <div class="product-device product-device-2 box-shadow d-none d-md-block"></div>
    </div>
      <style>
body {
        background-image: url("img/traebraedder.jpg");
} 
 
</style>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <script>
      Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
      });
    </script>
  </body>
</html>
        <div class="col-sm">
            <%
                if (request.getAttribute("error") != null) {
                    out.print(request.getAttribute("error"));
                }
                if (request.getAttribute("message") != null) {
                    out.print(request.getAttribute("message"));
                }
            %>
        </div>
            <div class="footer">
                <p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p>
            </div>
    </body>
</html>
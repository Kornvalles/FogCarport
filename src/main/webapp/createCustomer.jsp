<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <link href="app/footer.css" rel="stylesheet" type="text/css"/>
        <link href="app/app.css" rel="stylesheet" type="text/css"/>
        <script src="app/app.js" type="text/javascript"></script>
        <title>Opret kunde</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
            <a href="index.jsp" class="navbar-brand">
                <img src="img/logo.png" class="img-thumbnail" alt="Fog">
            </a>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Hjem</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="createCustomer.jsp">Bestilling</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sortiment.jsp">Sortiment</a>
                </li>
            </ul>
        </nav>
        <form method="POST" action="FrontController">
            <input type="hidden" name="command" value="createCustomer">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <h1 style="text-align: center">Bestilling af carport</h1>
                        <label for="nameInput">Fulde navn</label>
                        <p><input type="text" name="name" placeholder="Indtast dit fulde navn" id="nameInput" value="Test"></p>
                        <label for="emailInput">Email</label>
                        <p><input type="email" name="email" placeholder="Indtast din email" id="emailInput" value="Test@Test.dk"></p>
                        <label for="addressInput">Adresse</label>
                        <p><input type="text" name="address" placeholder="Indtast din adresse" id="addressInput" value="Test"></p>
                        <label for="zipcodeInput">Postnummer</label>
                        <p><input type="number" name="zipcode" placeholder="Indtast dit postnr" id="zipcodeInput" value="1234"></p>
                        <label for="telInput">Telefon</label>
                        <p><input type="tel" name="telephone" pattern="[0-9]{8}" placeholder="Indtast tlf nr" id="telInput" value="12345678"></p>
                        <input type="submit" value="Opret" onclick="return empty()">
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>

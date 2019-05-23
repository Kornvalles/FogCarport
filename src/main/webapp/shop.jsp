<%@page import="java.util.List"%>

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
        <title>Shop</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
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
            </ul>
        </nav>
        <div class="text-center">
            <h1>Bestilling af carport</h1>
        </div>
        <form method="POST" action="FrontController">
            <input type="hidden" name="command" value="CreateOrder">
            <div class="container">
                <div class="row">
                    <div class="col">    
                        <div class="form-group">
                            <label for="lengthInput">Carportens længde</label>
                            <p> ${lengthSelect}</p>
                        </div>
                        <div class="form-group">
                            <label for="widthInput">Carportens bredde</label>
                            <p> ${widthSelect}</p>
                        </div>

                        <input type="checkbox" name="shed" value="true" ${shedChecked} id="shedInput">
                        <label for="shedInput">Tilføj redskabsskur?</label>
                        <div class="fadeIn" id="display">
                            Vælg venligst længden på dit skur:
                            <p><select name="shedWidth" id="widthInput">
                                    <option value="150">150 cm</option>
                                    <option value="200">200 cm</option>
                                    <option value="220">220 cm</option>
                                    <option value="250">250 cm</option>
                                </select></p>
                        </div>
                        <br>

                        <input type="checkbox" name="roofType" value="true" id="roofTypeInput">
                        <label for="shedInput">Vil du udskifte tagplader med en anden tag type?</label>
                        <div class="fadeIn" id="display2">
                            Alle Fogs carporte bliver som standard monteret med tagplader:
                            <p><select name="roofType" id="roofType">
                                    <option value="rooftiles">Tagsten</option>
                                </select></p>
                        </div>
                        <br>

                        <input type="checkbox" name="roof" value="true" ${roofChecked} id="roofInput">
                        <label for="roofInput">Tilføj taghældning?</label>
                        <div class="fadeIn" id="display1">
                            Vælg venligst den ønskede hældning på deres tag:
                            <p><select name="roofAngle" id="roofAngle">
                                    <option value="15">15°</option>
                                    <option value="20">20°</option>
                                    <option value="25">25°</option>
                                    <option value="30">30°</option>
                                    <option value="35">35°</option>
                                    <option value="40">40°</option>
                                    <option value="45">45°</option>
                                </select></p>
                        </div>
                            <input type="checkbox" name="wall" value="true" id="wallsInput">
                            <label for="wallsInput">Tilføj vægge?</label>
                            <p><input type="submit" name="order" value="Bestil"></p>
                    </div>
                </div>
            </div>
        </form>
        <div class="footer">
            <p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p>
        </div>
        <script>
            shedvisibility();
            document.getElementById('shedInput').onclick = shedvisibility;
            roofvisibility();
            document.getElementById('roofInput').onclick = roofvisibility;
            rooftypevisibility();
            document.getElementById('roofTypeInput').onclick = rooftypevisibility;
        </script>
    </body>
</html>

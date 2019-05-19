<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="WEB-INF/app/Footer_and_Header.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
                    <a class="nav-link" href="FrontController?command=order">Bestilling</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sortiment.jsp">Sortiment</a>
                </li>
            </ul>
        </nav>
        <div class="text-center">
            <h1>Bestilling af carport</h1>
        </div>
        <div class="container">
            <div class="row">
                <div class="col">    
                    <form method="POST" action="FrontController">
                        <input type="hidden" name="command" value="CreateOrder">
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
                        <div class="form-group, fadeIn" id="display">
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
                        <div class="form-group, fadeIn" id="display2">
                            Alle Fogs carporte bliver som standard monteret med tagplader:
                            <p><select name="roofType" id="roofType">
                                    <option value="rooftiles">Tagsten</option>
                                </select></p>
                        </div>
                        <br>

                        <input type="checkbox" name="roof" value="true" ${roofChecked} id="roofInput">
                        <label for="roofInput">Tilføj taghældning?</label>
                        <div class="form-group, fadeIn" id="display1">
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
                        <div class="form-group">
                            <input type="checkbox" name="wall" value="true" id="wallsInput">
                            <label for="wallsInput">Tilføj vægge?</label>
                        </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="nameInput">Fulde navn</label>
                        <p><input type="text" name="name" placeholder="Indtast dit fulde navn" id="nameInput" value="Test"></p>
                    </div>
                    <div class="form-group">
                        <label for="emailInput">Email</label>
                        <p><input type="email" name="email" placeholder="Indtast din email" id="emailInput" value="Test@Test.dk"></p>
                    </div>
                    <div class="form-group">
                        <label for="addressInput">Adresse</label>
                        <p><input type="text" name="address" placeholder="Indtast din adresse" id="adresseInput" value="Test"></p>
                    </div>
                    <div class="form-group">
                        <label for="zipcodeInput">Postnummer</label>
                        <p><input type="number" name="zipcode" placeholder="Indtast dit postnr" id="zipcodeInput" value="1234"></p>
                    </div>
                    <div class="form-group">
                        <label for="telInput">Telefon</label>
                        <p><input type="tel" name="telephone" pattern="[0-9]{8}" placeholder="Indtast tlf nr" id="telInput" value="12345678"></p>
                    </div>
                    <input type="submit" name="order" value="Bestil" onclick="return empty()">
                </div>
                </form>
            </div>
        </div>
        <div class="footer">
            <p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p>
        </div>
        <script>
            function shedvisibility() {
                if (document.getElementById("shedInput").checked === false) {
                    $('#display').fadeOut(200);
                }
                if (document.getElementById("shedInput").checked === true) {
                    $('#display').fadeIn(200);
                }
            }
            shedvisibility();
            document.getElementById('shedInput').onclick = shedvisibility;


            function roofvisibility() {
                if (document.getElementById("roofInput").checked === false) {
                    $('#display1').fadeOut(200);
                }
                if (document.getElementById("roofInput").checked === true) {
                    $('#display1').fadeIn(200);

                }
            }
            roofvisibility();
            document.getElementById('roofInput').onclick = roofvisibility;


            function rooftypevisibility() {
                if (document.getElementById("roofTypeInput").checked === false) {
                    $('#display2').fadeOut(200);
                }
                if (document.getElementById("roofTypeInput").checked === true) {
                    $('#display2').fadeIn(200);

                }
            }
            rooftypevisibility();
            document.getElementById('roofTypeInput').onclick = rooftypevisibility;

            function empty() {
                var x;
                var y;
                var z;
                var c;
                var b;
                x = document.getElementById("nameInput").value;
                y = document.getElementById("emailInput").value;
                z = document.getElementById("zipcodeInput").value;
                c = document.getElementById("telInput").value;
                b = document.getElementById("adresseInput").value;
                if (x == "" || y == "" || c == "" || b == "") {
                    alert("Venligst indtast gyldig information");
                    return false;
                }
                ;
            }
        </script>
    </body>
</html>

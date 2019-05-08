<%-- 
    Document   : shop
    Created on : 12-04-2019, 11:45:37
    Author     : mikkel
--%>
<%@page import="java.util.List"%>
<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>
<jsp:include page='/WEB-INF/Statics/sitefooter.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>.fadeIn {
                display: none;
            }</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
    </head>
    <body>

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

                        <input type="checkbox" name="shedInput" id="shedInput">
                        <label for="shedInput">Tilføj redskabsskur?</label>
                        <div class="form-group, fadeIn" id="display">
                            Vælg venligst længden på dit skur:
                            <p><select name="shedWidth" id="widthInput">
                                    <option value="240">100 cm</option>
                                    <option value="270">150 cm</option>
                                </select></p>
                        </div>
                        <br>

                        <input type="checkbox" name="roof" value="true" id="roofInput">
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
                        <p><input type="text" name="name" placeholder="Indtast dit fulde navn" id="nameInput"></p>
                    </div>
                    <div class="form-group">
                        <label for="emailInput">Email</label>
                        <p><input type="email" name="email" placeholder="Indtast din email" id="emailInput"></p>
                    </div>
                    <div class="form-group">
                        <label for="addressInput">Adresse</label>
                        <p><input type="text" name="adresse" placeholder="Indtast din adresse" id="adresseInput"></p>
                    </div>
                    <div class="form-group">
                        <label for="zipcodeInput">Postnummer</label>
                        <p><input type="number" name="zipcode" placeholder="Indtast dit postnr" id="zipcodeInput"></p>
                    </div>
                    <div class="form-group">
                        <label for="telInput">Telefon</label>
                        <p><input type="tel" name="telephone" placeholder="Indtast tlf nr" id="telInput" value="Test"></p>
                    </div>
                    <input type="submit" name="order" value="Bestil" onclick="return empty()">
                </div>
                </form>
            </div>
        </div>
        <div class="footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
    </div>
    <script type='text/javascript' src='https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js'></script>
    <script type='text/javascript' src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script>
                        document.getElementById("shedInput").checked = false;
                        document.getElementById('shedInput').onclick = function () {

                            if (document.getElementById("shedInput").checked === false) {
                                $('#display').fadeOut(200);
                            }
                            if (document.getElementById("shedInput").checked === true) {
                                $('#display').fadeIn(200);

                            }
                        };
    </script>
    <script>
        document.getElementById("roofInput").checked = false;
        document.getElementById('roofInput').onclick = function () {

            if (document.getElementById("roofInput").checked === false) {
                $('#display1').fadeOut(200);
            }
            if (document.getElementById("roofInput").checked === true) {
                $('#display1').fadeIn(200);

            }
        };
    </script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>

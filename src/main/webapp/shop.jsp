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
                        <input type="hidden" name="origin" value="createOrder">
                        <input type="hidden" name="command" value="order">
                        <div class="form-group">
                            <label for="lengthInput">Carportens længde</label>
                            <p><select name="length" id="lengthInput">
                                    <option value="240">240 cm</option>
                                    <option value="270">270 cm</option>
                                    <option value="300">300 cm</option>
                                    <option value="330">330 cm</option>
                                    <option value="360">360 cm</option>
                                    <option value="390">390 cm</option>
                                    <option value="420">420 cm</option>
                                    <option value="450">450 cm</option>
                                </select></p>
                        </div>
                        <div class="form-group">
                            <label for="widthInput">Carportens bredde</label>
                            <p><select name="width" id="widthInput">
                                    <option value="240">240 cm</option>
                                    <option value="270">270 cm</option>
                                    <option value="300">300 cm</option>
                                    <option value="330">330 cm</option>
                                    <option value="360">360 cm</option>
                                    <option value="390">390 cm</option>
                                    <option value="420">420 cm</option>
                                    <option value="450">450 cm</option>
                                </select></p>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="shed" value="true" id="shedInput">
                            <label for="shedInput">Tilføj redskabsskur?</label>      
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="roof" value="true" id="roofInput">
                            <label for="roofInput">Tilføj vinkeltag?</label>
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
                        <p><input type="tel" name="telephone" placeholder="Indtast tlf nr" id="telInput"></p>
                    </div>
                    <input type="submit" name="order" value="Bestil" onclick="return empty()">
                </div>
                </form>
            </div>
        </div>
        <div class="footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
    </div>
</body>
</html>

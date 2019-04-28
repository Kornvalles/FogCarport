<%-- 
    Document   : shop
    Created on : 12-04-2019, 11:45:37
    Author     : mikkel
--%>
<%@page import="java.util.List"%>
<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>

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
                            <label for="lengthInput">Længde</label>
                            <p><input type="text" name="length" placeholder="Indtast længde" id="lengthInput"></p>
                        </div>
                        <div class="form-group">
                            <label for="widthInput">Bredde</label>
                            <p><input type="text" name="width" placeholder="Indtast bredde" id="widthInput"></p>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="shed" value="true" id="shedInput">
                            <label for="shedInput">Skur</label>      
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="roof" value="true" id="roofInput">
                            <label for="roofInput">Spids tag</label>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="wall" value="true" id="wallsInput">
                            <label for="wallsInput">Vægge</label>
                        </div>
                </div>
                        <div class="col">
                            <div class="form-group">
                                <label for="nameInput">Fulde navn</label>
                                <p><input type="text" name="name" placeholder="Indtast dit fulde navn" id="nameInput"></p>
                            </div>
                            <div class="form-group">
                                <label for="emailInput">Email</label>
                                <p><input type="text" name="email" placeholder="Indtast din email" id="emailInput"></p>
                            </div>
                            <input type="submit" name="order" value="Bestil">
                        </div>
                    </form>
                </div>
            </div>
    </body>
</html>

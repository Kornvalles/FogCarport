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
                            <label for="lengthInput">Length:</label>
                            <input type="text" name="length" placeholder="Insert carport length?" id="lengthInput">
                        </div>
                        <div class="form-group">
                            <label for="widthInput">Width:</label>
                            <input type="text" name="width" placeholder="How wide would you like the carport?" id="widthInput">
                        </div>
                        <div class="form-group">
                            <label for="shedInput">With toolshed?</label>
                            <input type="checkbox" name="redskabsskur" value="true" id="shedInput">
                        </div>
                        <div class="form-group">
                            <label for="roofInput">With a pointy roof?</label>
                            <input type="checkbox" name="spidstag" value="true" id="roofInput">
                        </div>
                        <div class="form-group">
                            <label for="wallsInput">With walls?</label>
                            <input type="checkbox" name="beklædning" value="true" id="wallsInput">
                        </div>
                </div>
                        <div class="col">
                            <div class="form-group">
                                <label for="nameInput">Fulde navn:</label>
                                <input type="text" name="name" value="" id="nameInput">
                            </div>
                            <div class="form-group">
                                <label for="emailInput">Email:</label>
                                <input type="text" name="email" value="" id="emailInput">
                            </div>
                            <input type="submit" name="order" value="Bestil">
                        </div>
                    </form>
                </div>
            </div>
    </body>
</html>

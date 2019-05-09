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
    <link rel="stylesheet" type="text/css" href="main.css/main.css" />
</head>
<html>
    <body>
        <p> <title>Sortiment</title> </p>
        <!-- Page Content -->
        <div class="container">

            <!-- Page Heading -->
            <h1 class="my-4">Sortiment
                <small>Vi har de bedste priser og de bedste carporte</small>
            </h1>

            <div class="row">
                <div class="col-lg-4 col-sm-6 mb-4">
                    <div class="card h-100">
                        <form action="FrontController">
                            <a href="#"><img class="card-img-top" src="img/1.png" alt=""></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="#">CARPORT ENKELT 3,60X7,20M CAR01HR MED REDSKABSRUM 3,20X2,20M</a>
                                </h4>
                                <p class="card-text">Enkelt carport med høj rejsning. 3,60 x 7,20 m. m/Byg-selv spær. Inkl. 3,20 x 2,25 m. redskabsrum. Højde; 3,05 mtr.
                                    Trykimprægnerede stolper, stern og beklædning.
                                    Leveres med: søm, skruer beslag og betontagstens tag.
                                    Udførlig byggevejledning til carport og spær medfølger.
                                    Betontagsten i sort med 30 års garanti.
                                    NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!  Pr. stk. 21.498,-</p>

                                    <input type="hidden" name="width" value="360" />
                                    <input type="hidden" name="length" value="720" />
                                    <input type="hidden" name="shedWidth" value="225" />
                                    <input type="hidden" name="shedLenght" value="320" />
                                    <input type="hidden" name="shedInput" value="checked"/>

                                    <button name="command" value="order">Bestil!</button>
                            </div>          
                        </form>

                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 mb-4">
                    <div class="card h-100">
                        <form action="FrontController">
                            <a href="#"><img class="card-img-top" src="img/2.png" alt=""></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="#">CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING</a>
                                </h4>
                                <p class="card-text">3,60 x 5,40 mtr. 
                                    Uden redskabsrum
                                    Trykimprægnerede stolper & stern.
                                    Leveres med: Søm, skruer, beslag og betontagstenstag.
                                    Udførlig byggevejledning til carport og spær medfølger.
                                    Betontagsten i sort med 30 års garanti.
                                    NB! Leveres som Byg-selv sæt - usamlet og ubehandlet! Pr. stk. 13.998,-</p>
                                    
                                    <input type="hidden" name="width" value="360" />
                                    <input type="hidden" name="length" value="540" />

                                    <button name="command" value="order">Bestil!</button>
                            </div>          
                        </form>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 mb-4">
                    <div class="card h-100">
                        <form action="FrontController">
                            <a href="#"><img class="card-img-top" src="img/3.png" alt=""></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="#">CARPORT ENKELT 3,90X7,80M CPO01HR MED REDSKABSRUM 2,40X3,30M</a>
                                </h4>
                                <p class="card-text">Enkelt carport med høj rejsning. 3,90 x 7,80 m.
                                    Extra bred model.
                                    3,30 x 2,40 mtr redskabsrum. Højde; 3,10 mtr.
                                    Trykimprægnerede stolper, stern og beklædning.
                                    Leveres med: Søm, skruer, beslag og betontagstenstag.
                                    Udførlig byggevejledning til carport og spær medfølger.
                                    Betontagsten i sort med 30 års garanti.
                                    NB! Leveres som Byg-selv sæt - usamlet og ubehandlet! Pr. stk. 23.498,-</p>

                                    <input type="hidden" name="width" value="390" />
                                    <input type="hidden" name="length" value="780" />

                                    <button name="command" value="order">Bestil!</button>
                            </div>          
                        </form>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 mb-4">
                    <div class="card h-100">
                        <form action="FrontController">
                            <a href="#"><img class="card-img-top" src="img/4.png" alt=""></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="#">CARPORT ENKELT 3,60X8,10M CARL01HR MED REDSKABSRUM 3,05X3,20M</a>
                                </h4>
                                <p class="card-text">Enkelt carport med høj rejsning. 3,60 x 8,10 m. Inkl. stort redskabsrum på 3,20 x 3,05 m. . Højde: 3,05 mtr.
                                    Trykimprægnerede stolper, stern og beklædning.
                                    Leveres med: Søm, skruer, beslag og betontagstenstag.
                                    Udførlig byggevejledning til carport og spær medfølger.
                                    Betontagsten i sort med 30 års garanti.
                                    NB! Leveres som Byg-selv sæt - usamlet og ubehandlet! Pr. stk. 22.998,-</p>

                                    <input type="hidden" name="width" value="360" />
                                    <input type="hidden" name="length" value="810" />

                                    <button name="command" value="order">Bestil!</button>
                            </div>          
                        </form>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 mb-4">
                    <div class="card h-100">
                        <form action="FrontController">
                        <a href="#"><img class="card-img-top" src="img/5.png" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">CARPORT ENKELT 3,00X4,80M CAR01 FLADT TAG</a>
                            </h4>
                            <p class="card-text">3,00 x 4,80 mtr. Højde; 2,30 mtr. Trykimprægnerede stolper og stern. 
                                Leveres med: søm, skruer, beslag og plasttrapez tag m/bundskruer.
                                NB! Leveres som Byg-selv sæt - usamlet, umalet og ubehandlet! Pr. stk. 3.998,-</p>
                                
                                    <input type="hidden" name="width" value="300" />
                                    <input type="hidden" name="length" value="480" />

                                    <button name="command" value="order">Bestil!</button>
                            </div>          
                        </form>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 mb-4">
                    <div class="card h-100">
                        <form action="FrontController">
                        <a href="#"><img class="card-img-top" src="img/6.png" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">CARPORT ENKELT 3,00X6,00 M CAR01R FLADT TAG MED REDSKABSRUM 1,50X2,70 M</a>
                            </h4>
                            <p class="card-text">3,00 x 6,00 mtr. incl. 1,50 x 2,70 mtr. redskabsrum. Højde; 2,30 mtr.
                                Trykimprægnerede stolper, stern og beklædning.
                                Leveres med: søm, skruer, beslag og plasttrapez tag m/bundskruer.
                                Udførlig byggevejledning medfølger.
                                NB! Leveres som Byg-selv sæt - usamlet og ubehandlet! Pr. stk. 9.498,-</p>
                                
                                    <input type="hidden" name="width" value="300" />
                                    <input type="hidden" name="length" value="600" />

                                    <button name="command" value="order">Bestil!</button>
                            </div>          
                        </form>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
        <div class="#footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
    </div>


    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>

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
        <link href="app/app.css" rel="stylesheet" type="text/css"/>
        <script src="app/app.js" type="text/javascript"></script>
        <title>Sortiment</title>
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
                    <a class="nav-link" href="createCustomer.jsp">Bestilling</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="sortiment.jsp">Sortiment</a>
                </li>
            </ul>
        </nav>
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
                                    NB! Leveres som Byg-selv sæt - usamlet og ubehandlet!  Pr. stk. 19.546,- eksklusiv moms</p>

                                <input type="hidden" name="width" value="360" />
                                <input type="hidden" name="length" value="720" />
                                <input type="hidden" name="shedWidth" value="225" />
                                <input type="hidden" name="shedLenght" value="320" />
                                <input type="hidden" name="hasShed" value="true" />
                                <input type="hidden" name="hasPointyRoof" value="true" />


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
                                    NB! Leveres som Byg-selv sæt - usamlet og ubehandlet! Pr. stk. 17.503,- eksklusiv moms</p>

                                <input type="hidden" name="width" value="360" />
                                <input type="hidden" name="length" value="540" />
                                <input type="hidden" name="hasPointyRoof" value="true" />

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
                                    NB! Leveres som Byg-selv sæt - usamlet og ubehandlet! Pr. stk. 20.637,- eksklusiv moms</p>

                                <input type="hidden" name="width" value="390" />
                                <input type="hidden" name="length" value="780" />
                                <input type="hidden" name="hasShed" value="true" />
                                <input type="hidden" name="hasPointyRoof" value="true" />

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
                                    NB! Leveres som Byg-selv sæt - usamlet og ubehandlet! Pr. stk. 20.545,- eksklusiv moms</p>

                                <input type="hidden" name="width" value="360" />
                                <input type="hidden" name="length" value="810" />
                                <input type="hidden" name="hasShed" value="true" />
                                <input type="hidden" name="hasPointyRoof" value="true" />

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
                                    NB! Leveres som Byg-selv sæt - usamlet, umalet og ubehandlet! Pr. stk. 3.998,- eksklusiv moms</p>

                                <input type="hidden" name="width" value="300" />
                                <input type="hidden" name="length" value="480" />
                                <input type="hidden" name="hasShed" value="false" />
                                <input type="hidden" name="hasPointyRoof" value="false" />

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
                                <input type="hidden" name="hasShed" value="true" />


                                <button name="command" value="order">Bestil!</button>
                            </div>          
                        </form>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <!-- /.row -->
        </div>
        <!-- /.container -->
        <div class="footer">
            <p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p>
        </div>
    </body>
</html>

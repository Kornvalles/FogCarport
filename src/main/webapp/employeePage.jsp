<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href='https://fonts.googleapis.com/css?family=Volkhov' rel='stylesheet'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="WEB-INF/app/app.js" type="text/javascript"></script>
        <script src="WEB-INF/app/app.js" type="text/javascript"></script>
        <title>Medarbejder side</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
            <a href="index.jsp" class="navbar-brand">
                <img src="img/logo.png" class="img-thumbnail" alt="Fog">
            </a>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link" href="editOrders.jsp">Ændre Ordrer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="updateMaterialPrices.jsp">Opdater Materialepriser</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewAllOrders.jsp">Se Alle Ordrer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?command=logout">Log ud</a>
                </li>
            </ul>
        </nav>
        <header class="masthead">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12 text-center">
                        <h1 class="font-weight-light">Dette er medarbejder siden</h1>
                        <p class="lead">Her kan du ændre priser på materialer, se alle ordrer eller ændre i ordrer, hvis kunden har lavet en fejl.
                            Bare benyt dig af menuen i toppen af siden, til at navigere.</p>
                    </div>
                </div>
            </div>
        </header>
        <br>
        <br>
        <!-- Page Content -->
        <section class="py-5">
            <div class="container">
                <h2 class="font-weight-light">Nyheder hos os!</h2>
                <h1>Stigende efterspørgsel: Fog går all-in på certificeret træ!</h1>
                <p>
                    - Da vi opnåede miljø- og bæredygtighedscertificeringerne for tre år siden, 
                    var der ikke samme interesse for, hvor træet kom fra, men det har ændret sig siden. 
                    I dag mærker vi tydeligt, at efterspørgslen stiger.

                    Det siger indkøbschef Steffen Lund Madsen om baggrunden for,
                    at Johannes Fog har besluttet at stile efter 100 procent bæredygtighed i salget af træ
                    fra sine 10 byggemarkeder og trælaster i København og Nordsjælland.

                    Johannes Fog har allerede de krævede processer implementeret i alle forretninger og udvider løbende sortimentet
                    af certificerede produkter. I dag har kæden over 450 certificerede træ- og pladevarer på hylderne.
                    Virksomheden er også medlem af både PEFC og FSC. Hos sidstnævnte hilser sekretariatsleder hos FSC Danmark Loa Dalgaard Worm 
                    Johannes Form velkommen i 100 %-klubben:

                    - Når vores medlemmer melder 100 procent indkøbspolitikker ud til offentligheden, så flytter det meget i markedet især nedad i kæden. 
                    Samtidig er det et stærkt signal indadtil til alle medarbejdere om, hvilken retning virksomheden ønsker at gå i - et signal som 
                    skaber både retning, arbejdsro og medarbejderstolthed, siger hun.
                    Som et led i bæredygtighedsstrategien vil Johannes Fog også investere i uddannelse af sit personale.
                </p>
            </div>
        </section>
    </body>
</html>

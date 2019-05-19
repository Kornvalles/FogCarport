<%-- 
    Document   : employeePage
    Created on : 13-May-2019, 14:24:19
    Author     : Benjamin
--%>
<jsp:include page='/WEB-INF/Statics/sitefooter.jsp'></jsp:include>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            * {box-sizing: border-box;}

            body { 
                margin: 0;
                font-family: Volkhov;
                font-size: 22px;
            }

            .header {
                position: relative;
                width: 100%;
                overflow: hidden;
                background-color: #f1f1f1;
                padding: 20px 10px;
            }

            .header a {
                float: left;
                color: black;
                text-align: center;
                padding: 12px;
                text-decoration: none;
                font-size: 18px; 
                line-height: 25px;
                border-radius: 4px;
            }

            .header a.logo {
                font-size: 25px;
                font-weight: bold;
            }

            .header a:hover {
                background-color: #ddd;
                color: black;
            }

            .header a.active {
                background-color: dodgerblue;
                color: white;
            }

            .header-right {
                float: right;
            }

            @media screen and (max-width: 500px) {
                .header a {
                    float: none;
                    display: block;
                    text-align: left;
                }

                .header-right {
                    float: none;
                }
            }
        </style>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href='https://fonts.googleapis.com/css?family=Volkhov' rel='stylesheet'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script>
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
    </head>
    <body>
        <div class="header">
            <a href="index.jsp" class="logo">
                <img src="img/logo.png"class="img-thumbnail" alt="Fog">
            </a>
            <div class="header-right">
                <a href="editOrders.jsp">Ændre Ordrer</a>
                <a href="updateMaterialPrices.jsp">Opdater Materialepriser</a>
                <a href="viewAllOrders.jsp">Se Alle Ordrer</a>
            </div>
        </div>
    </body>
    </head>
    <body>
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
    <p>
    <h1>Stigende efterspørgsel: Fog går all-in på certificeret træ!</h1>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</html>

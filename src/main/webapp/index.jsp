<%-- 
    Document   : index
    Created on : Apr 25, 2019, 9:48:24 AM
    Author     : ndupo
--%>
<jsp:include page='/WEB-INF/Statics/siteheader.jsp'></jsp:include>
<jsp:include page='/WEB-INF/Statics/sitefooter.jsp'></jsp:include>

    <!DOCTYPE html>
    <html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
        </head>
        <style>
            * {box-sizing: border-box;}
            body {font-family: Verdana, sans-serif;}
            .mySlides {display: none;}
            img {vertical-align: middle;}

            /* Slideshow container */
            .slideshow-container {
                max-width: 1000px;
                position: relative;
                margin: auto;
            }

            /* Caption text */
            .text {
                color: #f2f2f2;
                font-size: 15px;
                padding: 8px 12px;
                position: absolute;
                bottom: 8px;
                width: 100%;
                text-align: center;
            }

            /* Number text (1/3 etc) */
            .numbertext {
                color: #f2f2f2;
                font-size: 12px;
                padding: 8px 12px;
                position: absolute;
                top: 0;
            }

            /* The dots/bullets/indicators */
            .dot {
                height: 15px;
                width: 15px;
                margin: 0 2px;
                background-color: #bbb;
                border-radius: 50%;
                display: inline-block;
                transition: background-color 0.6s ease;
            }

            .active {
                background-color: #717171;
            }

            /* Fading animation */
            .fade {
                -webkit-animation-name: fade;
                -webkit-animation-duration: 5s;
                animation-name: fade;
                animation-duration: 5s;
                animation-direction: normal;
            }

            @-webkit-keyframes fade {
                from {opacity: .6} 
                to {opacity: 1}
            }

            @keyframes fade {
                from {opacity: .6} 
                to {opacity: 1}
            }

            /* On smaller screens, decrease text size */
            @media only screen and (max-width: 300px) {
                .text {font-size: 11px}
            }
        </style>
        <body>

            <div class="col-sm-6">
            <%
                if (session.getAttribute("error") != null) {
                    out.print(session.getAttribute("error"));
                }
            %>
        </div>

        <div style="padding-left:20px">
            <h1>Forside</h1>
            <h2>Velkommen til Fog Trælast</h2>
            <p>
            <div class="slideshow-container" align="center">

                <div class="mySlides fade">
                    <div class="numbertext">1 / 3</div>
                    <a href="shop.jsp">
                        <img src="img/lillecarport.jpeg" title="Mellem Carport m/ skur" width="700" height="700" /></a>
                    <div class="text">Lille carport</div>
                </div>

                <div class="mySlides fade">
                    <div class="numbertext">2 / 3</div>
                    <a href="shop.jsp">
                        <img src="img/mellemcarport.jpeg" title="Mellem Carport m/ skur" width="700" height="700" /></a>
                    <div class="text">Mellem Carport</div>
                </div>

                <div class="mySlides fade">
                    <div class="numbertext">3 / 3</div>
                    <a href="shop.jsp">
                        <img src="img/mellemmskur.jpeg" title="Mellem Carport m/ skur" width="700" height="700" /></a>
                    <div class="text">Mellem Carport m Skur</div>
                </div>

            </div>
            <br>
            </p>
            <div style="text-align:center">
                <span class="dot"></span> 
                <span class="dot"></span> 
                <span class="dot"></span> 
            </div>

            <script>
                var slideIndex = 0;
                showSlides();

                function showSlides() {
                    var i;
                    var slides = document.getElementsByClassName("mySlides");
                    var dots = document.getElementsByClassName("dot");
                    for (i = 0; i < slides.length; i++) {
                        slides[i].style.display = "none";
                    }
                    slideIndex++;
                    if (slideIndex > slides.length) {
                        slideIndex = 1
                    }
                    for (i = 0; i < dots.length; i++) {
                        dots[i].className = dots[i].className.replace(" active", "");
                    }
                    slides[slideIndex - 1].style.display = "block";
                    dots[slideIndex - 1].className += " active";
                    setTimeout(showSlides, 5000); // Change image every 2 seconds
                }
            </script>

    </body>
</html>

</div>
<div class="footer">
    <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
</div>
</body>
</html>

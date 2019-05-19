<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <div class="header">
            <a href="index.jsp" class="logo">
                <img src="img/logo.png" class="img-thumbnail" alt="Fog">
            </a>
            <div class="header-right">
                <a href="index.jsp">Hjem</a>
                <a href="FrontController?command=order">Bestilling af carport</a>
                <a href="sortiment.jsp">Sortiment</a>
            </div>
        </div>
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
    </body>
</html>
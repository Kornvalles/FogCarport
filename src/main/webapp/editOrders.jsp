<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%if (session.getAttribute("employee") == null) {
                request.setAttribute("error", "Please Login");
                response.sendRedirect(response.encodeURL("login.jsp"));
            }%>
        <title>Under opbygning</title>
    </head>
    <body>
        <style>
            body, html {
                height: 100%;
                margin: 0;
            }

            .bgimg {
                background-image: url("https://cdn.dribbble.com/users/233521/screenshots/6095229/edf_cm_chantier.gif");
                height: 100%;
                background-position: center;
                background-size: cover;
                position: relative;
                color: white;
                font-family: "Courier New", Courier, monospace;
                font-size: 25px;
            }

            .topleft {
                position: absolute;
                top: 0;
                left: 20px;
            }

            .bottomleft {
                position: absolute;
                bottom: 0;
                left: 20px;
            }

            .middle {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
            }

            hr {
                margin: auto;
                width: 40%;
            }
        </style>


        <div class="bgimg">
            <div class="topleft">
                <img src="https://media.licdn.com/dms/image/C4E0BAQGleVi1XAFxBg/company-logo_200_200/0?e=2159024400&v=beta&t=qQ2ebmGf9u4b45tNF9OyVrcy7NGpnwLXZkLrOky6ibM">
            </div>
            <div class="middle">
                <h1>Siden er under opbygning</h1>
                <hr>
                <p>11 dage tilbage</p>
            </div>
            <div class="bottomleft">
                <a class="bottomleft" href="FrontController?command=goBack">Tilbage</a>
            </div>
        </div>

    </body>
</html>
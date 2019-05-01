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
            <p>Vi har Danmarks største sortiment af carporte</p>
        </div>
        <div class="footer">
            <p><p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p></p>
        </div>
    </body>
</html>

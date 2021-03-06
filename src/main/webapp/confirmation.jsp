<%@page import="FunctionLayer.DrawSVG"%>
<%@page import="java.io.File"%>
<%@page import="FunctionLayer.Invoice"%>
<%@page import="FunctionLayer.Customer"%>
<%@page import="FunctionLayer.Construction"%>
<%@page import="FunctionLayer.Material"%>
<%@page import="FunctionLayer.Carport"%>
<%@page import="FunctionLayer.Calculator"%>

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
        <title>Bestilling Godkendt</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
            <a href="index.jsp" class="navbar-brand">
                <img src="img/logo.png" class="img-thumbnail" alt="Fog">
            </a>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Hjem</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FrontController?command=order">Bestilling</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sortiment.jsp">Sortiment</a>
                </li>
            </ul>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-sm">
                    <h1>Tak for din bestilling!</h1>
                    <p><%Customer customer = (Customer) session.getAttribute("customer");
                        Construction construction = (Construction) session.getAttribute("construction");
                        out.print(construction.getCarport().toString());%></p>


                    <p>Kære <%=customer.getName()%> her er din stykliste:</p>

                    <table class="table-hover">

                        <thead>
                        <col width="250">
                        <col width="60">
                        <col width="60">
                        <col width="70">
                        <col width="750">

                        <tr>
                            <th style="text-align:left">Materiale</th>
                            <th style="text-align:left"></th>
                            <th style="text-align:center" colspan="2" >Antal</th>
                            <th style="text-align:left">Beskrivelse</th>
                        </tr>
                        </thead>
                        <tbody>
                            <%for (Material m : construction.getMaterials()) {%>
                            <tr>
                                <td style="text-align:left"><%=m.getName()%></td>
                                <td style="text-align:left"><%=m.getId()%></td>
                                <td style="text-align:right"><%=m.getQty()%></td>
                                <td style="text-align:left"><%=m.getUnit()%></td>
                                <td style="text-align:left"><%=m.getDescription()%></td>
                            </tr>    
                            <%}%>
                        </tbody>
                    </table>
                    <form method="POST" action="FrontController">
                        <input type="hidden" name="command" value="invoice">
                        <input type="submit" value="Print faktura">
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">

                    <br><p>Totalpris: <%=String.format("%.2f", construction.getTotalPrice())%> kr. ekskl. moms</p>

                    <p>SVGCarport <%= construction.getCarport().getLength()%> cm lang og <%= construction.getCarport().getWidth()%> cm bred</p>

                    <% DrawSVG svg = new DrawSVG(); %>

                    <!-- SVG-drawing for a longside on a carport -->
                    <svg width="1000" height="350" xmlns="http://www.w3.org/2000/svg" xmlns:svg="http://www.w3.org/2000/svg">
                    <%  out.println(svg.makeText("10", "280", "Carport fra siden"));

                        int length = construction.getCarport().getLength();
                        int height = 230;
                        int boardLength = 100;
                        int start = 5;

                        /* Making the posts on the longside */
                        for (int i = start; i < length; i = i + boardLength) {
                            out.println(svg.makeRectangle(String.valueOf(height), "1", "10", String.valueOf(i), "0"));
                        }

                        /* In case that the length is not dividable with 100 (boardLength), then you need to make an extra post in the end. */
                        if (length % boardLength != 100) {
                            out.println(svg.makeRectangle(String.valueOf(height), "1", "10", String.valueOf(length), "0"));
                        }

                        if (construction.getCarport().hasWall()) {

                            /* Making the walls of the longside with wooden boards.
                        - The method stops making whole boards, when the rest of the length is less than 100 (the length of 1 board).
                        - Every index(i) is 1 whole column of wooden boards from top to bottom. 
                        - Every index(j) is 1 board in the index(i)-column. */
                            for (int i = start + 5; i < length + 5; i = i + boardLength) {
                                for (int j = 0; j < height; j = j + 10) {
                                    String boards = svg.makeRectangle("10", "0.20", String.valueOf(boardLength), String.valueOf(i), String.valueOf(j));

                                    /* In case the length of the carport is not dividable with 100 (the length of 1 board). */
                                    if (length % boardLength != 0) {

                                        /* In case that the placing of the last board and 1 whole board is longer than the full length.
                                        - It places a shorter board in the end. */
                                        if ((i + boardLength) > length) {
                                            out.println(svg.makeRectangle("10", "0.20", String.valueOf(length % boardLength), String.valueOf(length - (length % boardLength) + 5), String.valueOf(j)));
                                        } else {
                                            out.println(boards.toString());
                                        }

                                        /* In case the length is dividable with 100 (the length of 1 board). */
                                    } else {
                                        out.println(boards.toString());
                                    }
                                }
                            }
                        }

                        out.println(svg.makeText("25", "255", "100 cm"));
                        out.println(svg.makeMarker(10, 110, 240, 240));

                    %>
                    </svg>
                    <!-- SVG-drawing for the front side on a carport -->
                    <svg width="1000" height="450" xmlns="http://www.w3.org/2000/svg" xmlns:svg="http://www.w3.org/2000/svg">
                    <%  out.println(svg.makeText("10", "380", "Carport fofra"));

                        int width = construction.getCarport().getWidth();
                        int heightPointy = 100;

                        /* Making the two posts in the front corners */
                        String leftPost = svg.makeRectangle(String.valueOf(height), "1", "10", String.valueOf(start), String.valueOf(heightPointy));
                        String rightPost = svg.makeRectangle(String.valueOf(height), "1", "10", String.valueOf(width), String.valueOf(heightPointy));
                        out.println(leftPost.toString() + rightPost.toString());

                        /* Making the roof (flat or pointy) 
                        - In case the roof is pointy */
                        if (construction.getCarport().hasPointyRoof()) {
                            out.println(svg.makeTriangle(((start + width + 10) / 2) + "," + start + " " + start + "," + heightPointy + " " + (width + 10) + "," + heightPointy));

                            /* - In case the roof is flat*/
                        } else {
                            out.println(svg.makeRectangle("10", "1", String.valueOf(width + 5), String.valueOf(start), String.valueOf(heightPointy - 10)));
                        }

                    %>  
                    </svg>

                    <!-- SVG-drawing for the top side on a carport -->
                    <svg width="1000" height="900" xmlns="http://www.w3.org/2000/svg" xmlns:svg="http://www.w3.org/2000/svg">
                    <%  out.println(svg.makeText("10", "15", "Carport oppefra"));

                        /* Making the carport from the top */
                        out.println(svg.makeRectangle(String.valueOf(width), "1", String.valueOf(length), String.valueOf(start), String.valueOf(start + 50)));

                        /* Making the shed inside the carport, if there is a shed */
                        if (construction.getCarport().hasToolshed()) {
                            out.println(svg.makeRectangle(String.valueOf(width), "1", String.valueOf(construction.getCarport().getShedWidth()), String.valueOf(start), String.valueOf(start + 50)));
                            out.println(svg.makeText(String.valueOf(start + 50), String.valueOf(start + 100), "Skur"));
                        }

                    %>  
                    </svg>
                </div>
            </div>
        </div>
        <div class="footer">
            <p>© 2019 Johannes Fog | Mosevej 9 2750 Ballerup | Tlf: 99998888 | admin@fog.dk</p>
        </div>
    </body>
</html>

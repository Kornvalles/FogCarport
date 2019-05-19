<%@page import="FunctionLayer.SVGText"%>
<%@page import="FunctionLayer.SVGRectangle"%>
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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <style>.footer {
                position: fixed;
                left: 0;
                bottom: 0;
                width: 100%;
                background-color: whitesmoke;
                color: black;
                text-align: center;
            }</style>
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


                    <p>Her er din stykliste:</p>

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
                        <input type="submit" value="Lav faktura">
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6">

                    <br><p>Totalpris: <%=String.format("%.2f", construction.getTotalPrice())%> kr. inkl. moms</p>

                    <p>SVGCarport <%= construction.getCarport().getLength()%> cm lang og <%= construction.getCarport().getWidth()%> cm bred</p>

                    <!-- SVG-drawing for a longside on a carport (Not done yet)  -->
                    <svg width="1000" height="400" xmlns="http://www.w3.org/2000/svg" xmlns:svg="http://www.w3.org/2000/svg">
                    <%  int length = construction.getCarport().getLength();
                        int heigth = 230;
                        int boardLength = 100;
                        int start = 0;

                        /* Making the posts on the longside */
                        for (int i = start; i < length; i = i + boardLength) {
                            SVGRectangle posts = new SVGRectangle(String.valueOf(heigth), "1", "10", String.valueOf(i), "0");
                            out.println(posts.toString());
                        }

                        /* In case that the length is not dividable with 100 (boardLength), then you need to make an extra post in the end. */
                        if (length % boardLength != 100) {
                            SVGRectangle lastPost = new SVGRectangle(String.valueOf(heigth), "1", "10", String.valueOf(length), "0");
                            out.println(lastPost.toString());
                        }

                        /* Making the walls of the longside with wooden boards.
                        - The method stops making whole boards, when the rest of the length is less than 100 (the length of 1 board).
                        - Every index(i) is 1 whole column of wooden boards from top to bottom. 
                        - Every index(j) is 1 board in the index(i)-column. */
                        for (int i = start + 5; i < length + 5; i = i + boardLength) {
                            for (int j = 0; j < heigth; j = j + 10) {
                                SVGRectangle boards = new SVGRectangle("10", "0.20", String.valueOf(boardLength), String.valueOf(i), String.valueOf(j));

                                /* In case the length of the carport is not dividable with 100 (the length of 1 board). */
                                if (length % boardLength != 0) {

                                    /* In case that the placing of the last board and 1 whole board is longer than the full length.
                                    - It places a shorter board in the end. */
                                    if ((i + boardLength) > length) {
                                        SVGRectangle lastBoard = new SVGRectangle("10", "0.20", String.valueOf(length % boardLength), String.valueOf(length - (length % boardLength) + 5), String.valueOf(j));
                                        out.println(lastBoard.toString());
                                    } else {
                                        out.println(boards.toString());
                                    }

                                    /* In case the length is dividable with 100 (the length of 1 board). */
                                } else {
                                    out.println(boards.toString());
                                }
                            }
                        }

                        SVGText text = new SVGText("100", "280", "100 cm");
                        out.println(text.toString());

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

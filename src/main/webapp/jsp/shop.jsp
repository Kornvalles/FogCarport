<%-- 
    Document   : shop
    Created on : 12-04-2019, 11:45:37
    Author     : mikkel
--%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Carport"%>
<%@page import="DataLayer.OrderMapper"%>
<jsp:include page='/jsp/siteheader.jsp'></jsp:include>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
        
        <% 
        
            OrderMapper mapper = new OrderMapper();
            
            /* Add dropdown-list with carports  */
            List<Carport> standard = mapper.getStandard();

        %>
        <br><br> Vælg carport
        
        <form method="POST" action="/FogCarport/FrontController?command=order" >
             <input type="hidden" name="origin" value="order">
                <table class="table table-striped">
                    
                        <tbody>
                            <tr>
                                <td><select name="standard" id="standardSelect">
                                    <%  for (Carport stand : standard) {
                                            out.print("<option value=\"" + stand.getDetails()
                                            + "\">" + stand.getDetails() + "</option>\n");
                                        }

                                            out.print("<select>\n");
                                    %>
                                </td></select>

                            </tr>
                        </tbody>
                </table>
       
        
                                    <br><br> Med redskabsskur? <br><br>
        <input type="checkbox" name="redskabsskur" value="Ja"><br> 
        
        
        
        <br><br>

            Fulde navn: <br>
            <input type="text" name="name" value=""/><br>
            Email:<br> 
            <input type="password" name="email" value=""/> <br><br>
            
            
            <td><input type="submit" name="order" value="Bestil"></td><td><span id="errorContainer"></span></td>
        </form>
        
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="app/app.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <div class="bg-img">
            <div class="container">
                <div class="row justify-content-center align-items-center" style="height:100vh">
                    <div class="col-4">
                        <div class="card">
                            <div class="card-body">
                                <form method="POST" action="FrontController">
                                    <input type="hidden" name="command" value="Employee">
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="username">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" name="password">
                                    </div>
                                    <button type="submit" id="sendlogin" class="btn btn-primary" >login</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <%
                if (request.getAttribute("error") != null) {
                    out.print(request.getAttribute("error"));
                }
            %>
        </div>
    </body>
</html>

<%-- 
    Document   : f
    Created on : 29-04-2019, 00:05:05
    Author     : mikkel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <head>
        <style>
            .footer {
                display: block;
                position: relative;
                height: 100px;
                left: 0;
                bottom: 0;
                width: 100%;
                background-color: #f1f1f1;
                color: #000000;
                text-align: center;
            }
        </style>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/cookieconsent2/3.1.0/cookieconsent.min.css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/cookieconsent2/3.1.0/cookieconsent.min.js"></script>
        <script>
            window.addEventListener("load", function () {
                window.cookieconsent.initialise({
                    "palette": {
                        "popup": {
                            "background": "#edeff5",
                            "text": "#838391"
                        },
                        "button": {
                            "background": "#4b81e8"
                        }
                    },
                    "theme": "classic"
                })
            });
        </script>
    </head> 
</html>

<%-- 
    Document   : index
    Created on : Apr 25, 2019, 9:48:24 AM
    Author     : ndupo
--%>

<!DOCTYPE html>
<html>
 <head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.header {
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
</head>
<body>

<div class="header">
  <a href="http://localhost:8084/FogCarport/index.jsp" class="logo">Fog Trælast</a>
  <div class="header-right">
    <a class="active" href="http://localhost:8084/FogCarport/index.jsp">Hjem</a>
    <a href="http://localhost:8084/FogCarport/jsp/shop.jsp">Bestilling af carport</a>
    <a href="http://localhost:8084/FogCarport/jsp/sortiment.jsp">Sortiment</a>
  </div>
</div>

<div style="padding-left:20px">
  <h1>Forside</h1>
  <h2>Velkommen til Fog Trælast</h2>
  <p>Vi har danmarks største sortiment af carporte.</p>
</div>

</body>
</html>

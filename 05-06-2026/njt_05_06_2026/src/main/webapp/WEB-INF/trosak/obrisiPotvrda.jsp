<%-- 
    Document   : obrisiPotvrda
    Created on : Jun 12, 2026, 11:15:51 PM
    Author     : Filip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <label>Naziv: ${sessionScope.trosakZaBrisanje.naziv}</label>
        <label>Iznos: ${sessionScope.trosakZaBrisanje.iznos}</label>
        <label>Status: ${sessionScope.trosakZaBrisanje.statusTroska}</label>
        <div>
            <a href="trosak?action=obrisi">Potvrdi brisanje</a>
        </div>
    </body>
</html>

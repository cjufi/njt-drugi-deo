<%-- 
    Document   : potvrda
    Created on : Jun 10, 2026, 12:14:44 AM
    Author     : Filip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stranica za potvrdu</title>
    </head>
    <body>
        <label>Naziv: ${sessionScope.noviTrosak.naziv}</label>
        <label>Iznos: ${sessionScope.noviTrosak.iznos}</label>
        <label>Iznos: ${sessionScope.noviTrosak.statusTroska}</label>
        <div>
            <a href="trosak?action=sacuvaj">Potvrdi akciju</a>
        </div>
    </body>
</html>

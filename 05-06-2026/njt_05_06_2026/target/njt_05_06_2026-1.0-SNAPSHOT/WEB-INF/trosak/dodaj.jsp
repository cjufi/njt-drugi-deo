<%-- 
    Document   : dodaj
    Created on : Jun 9, 2026, 8:29:36 AM
    Author     : Filip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>S</title>
    </head>
    <body>
        <form action="trosak?action=dodaj" method="POST">
            <div>
                <label>Naziv</label>
                <input type="text" name="naziv" value="" />
            </div>
            <div>
                <label>Iznos</label>
                <input type="number" name="iznos" value="" />
            </div>

            <button type="submit">Dodaj Trosak</button>
        </form>
    </body>
</html>

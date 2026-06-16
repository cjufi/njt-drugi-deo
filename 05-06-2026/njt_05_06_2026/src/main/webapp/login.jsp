<%-- 
    Document   : login
    Created on : Jun 8, 2026, 6:35:49 PM
    Author     : Filip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Stranica</title>
    </head>
    <body>
        <form action="korisnik?action=login" method="POST">
            <div>
                <label>Email</label>
                <input type="text" name="email" value="" />
            </div>
            <div>
                <label>Sifra</label>
                <input type="password" name="sifra" value="" />
            </div>

            <button type="submit">Uloguj se</button>

            <div>
                ${requestScope.greska}
            </div>
        </form> 
    </body>
</html>

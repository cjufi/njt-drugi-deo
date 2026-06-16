<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : main
    Created on : Jun 8, 2026, 7:08:40 PM
    Author     : Filip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Glavna Stranica</title>
    </head>
    <body>

        <h3>Svi korisnici:
            <jsp:include page="/WEB-INF/fragment/korisnici.jsp" flush="true"></jsp:include>
        </h3>
        <h3>Iznos realizovanih troskova: ${sessionScope.realizovaniTroskovi}</h3>
        <h3>Troskovi korisnika:</h3>
        <table border="1" cellspacing="1" cellpadding="10">
            <thead>
                <tr>
                    <th>Naziv</th>
                    <th>Iznos</th>
                    <th>Status</th>
                    <th>Akcije</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="trosak" items="${sessionScope.ulogovanKorisnik.troskovi}">
                    <tr>
                        <td>${trosak.naziv}</td>
                        <td>${trosak.iznos}</td>
                        <td>${trosak.statusTroska}</td>
                        <td>
                            <a href="trosak?action=obrisiForma&naziv=${trosak.naziv}">Obrisi</a>
                            <a href="trosak?action=izmeni&naziv=${trosak.naziv}">Promeni Status</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="trosak?action=dodajForma">Dodaj Trosak</a>
        <a href="korisnik?action=logout">Izloguj se</a>
    </body>
</html>

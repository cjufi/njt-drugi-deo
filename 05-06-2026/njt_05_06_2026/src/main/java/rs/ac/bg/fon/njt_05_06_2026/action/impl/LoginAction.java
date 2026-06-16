package rs.ac.bg.fon.njt_05_06_2026.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.njt_05_06_2026.action.Action;
import rs.ac.bg.fon.njt_05_06_2026.dto.KorisnikDto;
import rs.ac.bg.fon.njt_05_06_2026.dto.StatusKorisnika;
import rs.ac.bg.fon.njt_05_06_2026.dto.StatusTroska;
import rs.ac.bg.fon.njt_05_06_2026.dto.TrosakDto;

/**
 *
 * @author Filip
 */
public class LoginAction implements Action {

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String sifra = request.getParameter("sifra");

        List<KorisnikDto> korisnici = (List<KorisnikDto>) request.getServletContext().getAttribute("korisnici");

        String page = "login.jsp";
        boolean postojiKorisnik = false;
        for (KorisnikDto korisnikDto : korisnici) {
            if (korisnikDto.getEmail().equals(email) && korisnikDto.getSifra().equals(sifra)) {
                postojiKorisnik = true;
                page = "/WEB-INF/main.jsp";
                if (korisnikDto.getStatus().equals(StatusKorisnika.ONLINE)) {
                    request.setAttribute("greska", "Greska, korisnik je vec ulogovan");
                    break;
                }

                korisnikDto.setStatus(StatusKorisnika.ONLINE);

                HttpSession s = request.getSession(true);
                s.setAttribute("ulogovanKorisnik", korisnikDto);

                double iznosRealTroskova = 0;
                for (TrosakDto trosakDto : korisnikDto.getTroskovi()) {
                    if (trosakDto.getStatusTroska().equals(StatusTroska.REALIZOVAN)) {
                        iznosRealTroskova += trosakDto.getIznos();
                    }
                }
                s.setAttribute("realizovaniTroskovi", iznosRealTroskova);

                break;
            }
        }

        if (!postojiKorisnik) {
            request.setAttribute("greska", "Greska, korisnik ne postoji");
        }

        return page;
    }

}

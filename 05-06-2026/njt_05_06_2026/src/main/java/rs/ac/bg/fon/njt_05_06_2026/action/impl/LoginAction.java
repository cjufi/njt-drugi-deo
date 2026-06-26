package rs.ac.bg.fon.njt_05_06_2026.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
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

        String page = "/login.jsp";
        List<KorisnikDto> korisnici = (List<KorisnikDto>) request.getServletContext().getAttribute("korisnici");
        Map<String, List<TrosakDto>> troskoviPoKorisniku = (Map<String, List<TrosakDto>>) request.getServletContext().getAttribute("troskoviPoKorisniku");

        boolean postoji = false;
        for (KorisnikDto korisnikDto : korisnici) {
            if (email.equals(korisnikDto.getEmail()) && sifra.equals(korisnikDto.getSifra())) {

                if (korisnikDto.getStatus().equals(StatusKorisnika.ONLINE)) {
                    request.setAttribute("greskica", "Ej vec si ulogovan");
                    return "/login.jsp";
                }

                page = "/WEB-INF/main.jsp";
                postoji = true;
                korisnikDto.setStatus(StatusKorisnika.ONLINE);

                List<TrosakDto> ulogovaniTroskovi = troskoviPoKorisniku.get(korisnikDto.getEmail());

                HttpSession session = request.getSession(true);
                double iznosRealTroskova = 0;
                for (TrosakDto trosakDto : ulogovaniTroskovi) {
                    if (trosakDto.getStatusTroska().equals(StatusTroska.REALIZOVAN)) {
                        iznosRealTroskova += trosakDto.getIznos();
                    }
                }
                session.setAttribute("realizovaniTroskovi", iznosRealTroskova);

                session.setAttribute("ulogovaniTroskovi", ulogovaniTroskovi);
                session.setAttribute("ulogovaniKorisnik", korisnikDto);
            }
        }

        if (!postoji) {
            request.setAttribute("greska", "Greska, korisnik ne postoji");
        }

        return page;
    }

}

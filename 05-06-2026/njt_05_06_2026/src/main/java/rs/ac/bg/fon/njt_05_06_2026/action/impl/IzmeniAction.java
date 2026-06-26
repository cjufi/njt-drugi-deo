/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njt_05_06_2026.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import rs.ac.bg.fon.njt_05_06_2026.action.Action;
import rs.ac.bg.fon.njt_05_06_2026.dto.KorisnikDto;
import rs.ac.bg.fon.njt_05_06_2026.dto.StatusTroska;
import rs.ac.bg.fon.njt_05_06_2026.dto.TrosakDto;

/**
 *
 * @author Filip
 */
public class IzmeniAction implements Action {

    @Override
    public String execute(HttpServletRequest request) {
        String naziv = request.getParameter("naziv");

        HttpSession session = request.getSession(false);

        KorisnikDto korisnikDto = (KorisnikDto) session.getAttribute("ulogovaniKorisnik");
//        Mogu i ovako troskovi da se uzmu
        Map<String, List<TrosakDto>> troskovi = (Map<String, List<TrosakDto>>) request.getServletContext().getAttribute("troskoviPoKorisniku");
        List<TrosakDto> troskoviPoKorisniku = troskovi.get(korisnikDto.getEmail());

        for (TrosakDto trosak : troskoviPoKorisniku) {
            if (trosak.getNaziv().equals(naziv)) {
                if (trosak.getStatusTroska().equals(StatusTroska.PLANIRAN)) {
                    trosak.setStatusTroska(StatusTroska.REALIZOVAN);
                } else if (trosak.getStatusTroska().equals(StatusTroska.REALIZOVAN)) {
                    trosak.setStatusTroska(StatusTroska.PLANIRAN);
                }
                break;
            }
        }

        double iznosRealTroskova = 0;
        for (TrosakDto trosakDto : troskoviPoKorisniku) {
            if (trosakDto.getStatusTroska().equals(StatusTroska.REALIZOVAN)) {
                iznosRealTroskova += trosakDto.getIznos();
            }
        }
        session.setAttribute("realizovaniTroskovi", iznosRealTroskova);

        return "WEB-INF/main.jsp";
    }
}

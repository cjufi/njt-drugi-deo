/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njt_05_06_2026.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

        KorisnikDto korisnikDto = (KorisnikDto) session.getAttribute("ulogovanKorisnik");
        double realizovaniTroskovi = (double) session.getAttribute("realizovaniTroskovi");

        for (TrosakDto trosak : korisnikDto.getTroskovi()) {
            if (trosak.getNaziv().equals(naziv)) {
                if (trosak.getStatusTroska().equals(StatusTroska.PLANIRAN)) {
                    trosak.setStatusTroska(StatusTroska.REALIZOVAN);
                    realizovaniTroskovi += trosak.getIznos();
                } else if (trosak.getStatusTroska().equals(StatusTroska.REALIZOVAN)) {
                    trosak.setStatusTroska(StatusTroska.PLANIRAN);
                    realizovaniTroskovi -= trosak.getIznos();
                }
                break;
            }
        }
        
        session.setAttribute("realizovaniTroskovi", realizovaniTroskovi);
        return "WEB-INF/main.jsp";
    }
}

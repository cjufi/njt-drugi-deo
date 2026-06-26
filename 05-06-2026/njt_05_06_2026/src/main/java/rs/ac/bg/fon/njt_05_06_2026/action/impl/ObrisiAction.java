/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njt_05_06_2026.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import rs.ac.bg.fon.njt_05_06_2026.action.Action;
import rs.ac.bg.fon.njt_05_06_2026.dto.KorisnikDto;
import rs.ac.bg.fon.njt_05_06_2026.dto.StatusTroska;
import rs.ac.bg.fon.njt_05_06_2026.dto.TrosakDto;

/**
 *
 * @author Filip
 */
public class ObrisiAction implements Action {

    @Override
    public String execute(HttpServletRequest request) {
        TrosakDto trosakZaBrisanje = (TrosakDto) request.getSession(false).getAttribute("trosakZaBrisanje");

        HttpSession s = request.getSession(false);
        List<TrosakDto> ulogovaniTroskovi = (List<TrosakDto>) request.getSession(false).getAttribute("ulogovaniTroskovi");

        for (TrosakDto trosakDto : ulogovaniTroskovi) {
            if (trosakZaBrisanje.getNaziv().equals(trosakDto.getNaziv())) {
                ulogovaniTroskovi.remove(trosakDto);
                break;
            }
        }

        double iznosRealTroskova = 0;
        for (TrosakDto trosakDto : ulogovaniTroskovi) {
            if (trosakDto.getStatusTroska().equals(StatusTroska.REALIZOVAN)) {
                iznosRealTroskova += trosakDto.getIznos();
            }
        }
        s.setAttribute("realizovaniTroskovi", iznosRealTroskova);

        return "WEB-INF/main.jsp";
    }
}

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
import rs.ac.bg.fon.njt_05_06_2026.dto.TrosakDto;

/**
 *
 * @author Filip
 */
public class ObrisiPotvrdaAction implements Action {

    @Override
    public String execute(HttpServletRequest request) {

        String naziv = request.getParameter("naziv");

        HttpSession s = request.getSession(false);

        List<TrosakDto> ulogovaniTroskovi = (List<TrosakDto>) request.getSession(false).getAttribute("ulogovaniTroskovi");

        for (TrosakDto trosak : ulogovaniTroskovi) {
            if (trosak.getNaziv().equals(naziv)) {
                request.getSession(false).setAttribute("trosakZaBrisanje", trosak);
                break;
            }
        }
        return "/WEB-INF/trosak/obrisiPotvrda.jsp";
    }

}

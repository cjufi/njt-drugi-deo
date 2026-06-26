/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njt_05_06_2026.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import rs.ac.bg.fon.njt_05_06_2026.action.Action;
import rs.ac.bg.fon.njt_05_06_2026.dto.KorisnikDto;
import rs.ac.bg.fon.njt_05_06_2026.dto.TrosakDto;

/**
 *
 * @author Filip
 */
public class SacuvajAction implements Action {

    @Override
    public String execute(HttpServletRequest request) {
        List<TrosakDto> ulogovaniTroskovi = (List<TrosakDto>) request.getSession(false).getAttribute("ulogovaniTroskovi");

        TrosakDto noviTrosak = (TrosakDto) request.getSession(false).getAttribute("noviTrosak");
        
        ulogovaniTroskovi.add(noviTrosak);
        return "WEB-INF/main.jsp";
    }

}

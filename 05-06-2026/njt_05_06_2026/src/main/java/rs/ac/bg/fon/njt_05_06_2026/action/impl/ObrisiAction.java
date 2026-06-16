/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njt_05_06_2026.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import rs.ac.bg.fon.njt_05_06_2026.action.Action;
import rs.ac.bg.fon.njt_05_06_2026.dto.KorisnikDto;
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
        
        KorisnikDto korisnikDto = (KorisnikDto) s.getAttribute("ulogovanKorisnik");
        
        for(TrosakDto trosak : korisnikDto.getTroskovi()) {
            if(trosak.getNaziv().equals(trosakZaBrisanje.getNaziv())) {
                korisnikDto.getTroskovi().remove(trosak);
                break;
            }
        }        
        
        return "WEB-INF/main.jsp";
    }
}

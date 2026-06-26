/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njt_05_06_2026.action.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import rs.ac.bg.fon.njt_05_06_2026.action.Action;
import rs.ac.bg.fon.njt_05_06_2026.dto.KorisnikDto;
import rs.ac.bg.fon.njt_05_06_2026.dto.StatusKorisnika;

/**
 *
 * @author Filip
 */
public class LogoutAction implements Action {

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        KorisnikDto korisnikDto = (KorisnikDto) session.getAttribute("ulogovaniKorisnik");
        korisnikDto.setStatus(StatusKorisnika.OFFLINE);
        
        session.invalidate();
        
        return "login.jsp";
    }
    
}

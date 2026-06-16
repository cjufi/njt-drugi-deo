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
public class DodajAction implements Action {

    @Override
    public String execute(HttpServletRequest request) {
        String page = "WEB-INF/trosak/dodajPotvrda.jsp";
                
        String naziv = request.getParameter("naziv");
        double iznos = Double.parseDouble(request.getParameter("iznos"));
        
        TrosakDto noviTrosak = new TrosakDto(naziv, iznos);
        
        HttpSession session = request.getSession(false);
        session.setAttribute("noviTrosak", noviTrosak);
                
        return page;
    }
    
}

package rs.ac.bg.fon.njt_05_06_2026.servlet;

import jakarta.servlet.ServletConfig;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import rs.ac.bg.fon.njt_05_06_2026.action.Action;

/**
 *
 * @author Filip
 */
@WebServlet(name = "TrosakServlet", urlPatterns = {"/trosak"})
public class TrosakServlet extends HttpServlet {

    @Autowired
    @Qualifier("dodaj")
    private Action dodajAction;

    @Autowired
    @Qualifier("sacuvaj")
    private Action sacuvajAction;

    @Autowired
    @Qualifier("obrisi")
    private Action obrisiAction;

    @Autowired
    @Qualifier("izmeni")
    private Action izmeniAction;

    @Autowired
    @Qualifier("obrisiPotvrda")
    private Action obrisiPotvrda;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getSession(false).getAttribute("ulogovaniKorisnik") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String page = "WEB-INF/main.jsp";
        if (request.getParameter("action").equals("dodaj")) {
            page = dodajAction.execute(request);
        } else if (request.getParameter("action").equals("sacuvaj")) {
            page = sacuvajAction.execute(request);
        } else if (request.getParameter("action").equals("dodajForma")) {
            page = "WEB-INF/trosak/dodaj.jsp";
        } else if (request.getParameter("action").equals("obrisiForma")) {
            page = obrisiPotvrda.execute(request);
        } else if (request.getParameter("action").equals("obrisi")) {
            page = obrisiAction.execute(request);
        } else if (request.getParameter("action").equals("izmeni")) {
            page = izmeniAction.execute(request);
        }

        request.getRequestDispatcher(page).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

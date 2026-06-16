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
@WebServlet(name = "KorisnikServlet", urlPatterns = {"/korisnik"})
public class KorisnikServlet extends HttpServlet {

    @Autowired
    @Qualifier("login")
    private Action loginAction;

    @Autowired
    @Qualifier("logout")
    private Action logoutAction;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("applicationContext");
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String page = "login.jsp";

        if (request.getParameter("action").equals("login")) {
            page = loginAction.execute(request);
        }
        if (request.getParameter("action").equals("logout")) {
            page = logoutAction.execute(request);
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

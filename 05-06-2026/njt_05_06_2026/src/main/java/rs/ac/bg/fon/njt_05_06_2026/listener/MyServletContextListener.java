package rs.ac.bg.fon.njt_05_06_2026.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rs.ac.bg.fon.njt_05_06_2026.config.AppConfig;
import rs.ac.bg.fon.njt_05_06_2026.dto.KorisnikDto;
import rs.ac.bg.fon.njt_05_06_2026.dto.TrosakDto;

/**
 * Web application lifecycle listener.
 *
 * @author Filip
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        sce.getServletContext().setAttribute("applicationContext", context);

        List<TrosakDto> troskovi1 = new ArrayList<>();
        TrosakDto t1 = new TrosakDto("t1", 1000);
        TrosakDto t2 = new TrosakDto("t2", 2000);
        troskovi1.add(t1);
        troskovi1.add(t2);

        List<TrosakDto> troskovi2 = new ArrayList<>();
        TrosakDto t3 = new TrosakDto("t3", 3000);
        TrosakDto t4 = new TrosakDto("t4", 4000);
        troskovi2.add(t3);
        troskovi2.add(t4);

        KorisnikDto korisnik1 = new KorisnikDto("1", "1", troskovi1);
        KorisnikDto korisnik2 = new KorisnikDto("2", "2", troskovi2);

        List<KorisnikDto> korisnici = new ArrayList<>();
        korisnici.add(korisnik1);
        korisnici.add(korisnik2);

        sce.getServletContext().setAttribute("korisnici", korisnici);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}

package rs.ac.bg.fon.njt_05_06_2026.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        KorisnikDto korisnik1 = new KorisnikDto("1", "1");
        KorisnikDto korisnik2 = new KorisnikDto("2", "2");

        List<KorisnikDto> korisnici = new ArrayList<>();
        korisnici.add(korisnik1);
        korisnici.add(korisnik2);

        Map<String, List<TrosakDto>> troskoviPoKorisniku = new HashMap<>();

        List<TrosakDto> troskovi1 = new ArrayList<>();
        troskovi1.add(new TrosakDto("t1", 1000));
        troskovi1.add(new TrosakDto("t2", 2000));

        List<TrosakDto> troskovi2 = new ArrayList<>();
        troskovi2.add(new TrosakDto("t3", 3000));
        troskovi2.add(new TrosakDto("t4", 4000));

        troskoviPoKorisniku.put("1", troskovi1);
        troskoviPoKorisniku.put("2", troskovi2);

        sce.getServletContext().setAttribute("korisnici", korisnici);
        sce.getServletContext().setAttribute("troskoviPoKorisniku", troskoviPoKorisniku);

        sce.getServletContext().setAttribute("korisnici", korisnici);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}

package rs.ac.bg.fon.njt_05_06_2026.config;

import org.springframework.context.annotation.Bean;
import rs.ac.bg.fon.njt_05_06_2026.action.Action;
import rs.ac.bg.fon.njt_05_06_2026.action.impl.DodajAction;
import rs.ac.bg.fon.njt_05_06_2026.action.impl.IzmeniAction;
import rs.ac.bg.fon.njt_05_06_2026.action.impl.LoginAction;
import rs.ac.bg.fon.njt_05_06_2026.action.impl.LogoutAction;
import rs.ac.bg.fon.njt_05_06_2026.action.impl.ObrisiAction;
import rs.ac.bg.fon.njt_05_06_2026.action.impl.ObrisiPotvrdaAction;
import rs.ac.bg.fon.njt_05_06_2026.action.impl.SacuvajAction;
import rs.ac.bg.fon.njt_05_06_2026.dto.TrosakDto;
import rs.ac.bg.fon.njt_05_06_2026.validator.Validator;
import rs.ac.bg.fon.njt_05_06_2026.validator.impl.TrosakValidator;

/**
 *
 * @author Filip
 */
public class AppConfig {

    @Bean("login")
    public Action loginAction() {
        return new LoginAction();
    }

    @Bean("logout")
    public Action logoutAction() {
        return new LogoutAction();
    }

    @Bean("dodaj")
    public Action dodajAction() {
        return new DodajAction(trosakValidator());
    }

    @Bean("sacuvaj")
    public Action sacuvajAction() {
        return new SacuvajAction();
    }

    @Bean("obrisi")
    public Action obrisiAction() {
        return new ObrisiAction();
    }

    @Bean("obrisiPotvrda")
    public Action obrisiPotvrdaAction() {
        return new ObrisiPotvrdaAction();
    }

    @Bean("izmeni")
    public Action izmeniAction() {
        return new IzmeniAction();
    }

    @Bean("trosakValidator")
    public Validator<TrosakDto> trosakValidator() {
        return new TrosakValidator();
    }

}

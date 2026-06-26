package rs.ac.bg.fon.njt_05_06_2026.dto;

import java.util.List;

/**
 *
 * @author Filip
 */
public class KorisnikDto {

    private String email;
    private String sifra;
    StatusKorisnika status = StatusKorisnika.OFFLINE;

    public KorisnikDto() {
    }

    public KorisnikDto(String email, String sifra) {
        this.email = email;
        this.sifra = sifra;
//        this.troskovi = troskovi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public StatusKorisnika getStatus() {
        return status;
    }

    public void setStatus(StatusKorisnika status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "KorisnikDto{" + "email=" + email + ", status=" + status + '}';
    }
}

package rs.ac.bg.fon.njt_05_06_2026.dto;

/**
 *
 * @author Filip
 */
public class TrosakDto {
    String naziv;
    double iznos;
    StatusTroska statusTroska = StatusTroska.PLANIRAN;

    public TrosakDto() {
    }

    public TrosakDto(String naziv, double iznos) {
        this.naziv = naziv;
        this.iznos = iznos;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public StatusTroska getStatusTroska() {
        return statusTroska;
    }

    public void setStatusTroska(StatusTroska statusTroska) {
        this.statusTroska = statusTroska;
    }

    @Override
    public String toString() {
        return "TrosakDto{" + "naziv=" + naziv + ", iznos=" + iznos + ", statusTroska=" + statusTroska + '}';
    }    
}

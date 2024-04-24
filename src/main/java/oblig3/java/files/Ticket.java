package oblig3.java.files;

public class Ticket {
    private long id;
    private String etternavn;
    private String fornavn;
    private String film;
    private int antall;
    private String telefon;
    private String epost;

    public Ticket() {
        // Default constructor
    }

    public Ticket(String etternavn, String fornavn, String film, int antall, String telefon, String epost) {
        this.etternavn = etternavn;
        this.fornavn = fornavn;
        this.film = film;
        this.antall = antall;
        this.telefon = telefon;
        this.epost = epost;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
}

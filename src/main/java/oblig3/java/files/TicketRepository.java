package oblig3.java.files;

        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.BeanPropertyRowMapper;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(TicketRepository.class);

    public boolean lagreBillett(Ticket ticket) {
        String sql = "INSERT INTO Billetter(film, antall, fornavn, etternavn, telefon, epost) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            db.update(sql, ticket.getFilm(), ticket.getAntall(), ticket.getFornavn(), ticket.getEtternavn(), ticket.getTelefon(), ticket.getEpost());
            return true;
        } catch (Exception e) {
            logger.error("Kunne ikke lagre billett " + e);
            return false;
        }
    }

    public List<Ticket> hentAlle() {
        String sql = "SELECT film, antall, fornavn, etternavn, telefon, epost FROM Ticket ORDER BY etternavn";
        try {
            List<Ticket> tickets = db.query(sql, new BeanPropertyRowMapper(Ticket.class));
            return tickets;
        } catch (Exception e) {
            logger.error("Kunne ikke hente billetter " + e);
            return null;
        }
    }

    public boolean slettAlle() {
        String sql = "DELETE FROM Ticket;";
        try {
            db.update(sql);
            return true;
        } catch (Exception e) {
            logger.error("Kunne ikke slette billetter " + e);
            return false;
        }
    }
}
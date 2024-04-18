package oblig3.java.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketRepository rep;

    @PostMapping("/lagre")
    public void lagreBillett(Ticket ticket, HttpServletResponse res) throws IOException {
        boolean ok = rep.lagreBillett(ticket);
        if (!ok) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde noe feil, prøv igjen senere");
        }
    }

    @GetMapping("/hentAlle")
    public List<Ticket> hentAlle(HttpServletResponse res) throws IOException {
        List<Ticket> tickets = rep.hentAlle();
        if (tickets == null) {
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Det skjedde noe feil, prøv igjen senere");
        }
        return tickets;
    }
    @GetMapping("/slettAlle")
    public void slettAlle(HttpServletResponse res) throws IOException {
        boolean ok = rep.slettAlle();
        if (!ok){
            res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Feil i Database -prøv igjen senere");
        }
    }
        }
    }
}

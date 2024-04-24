package oblig3.java.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketRepository rep;

    @PostMapping("/lagre")
    public void lagreBillett(Ticket ticket) {
        rep.lagreBillett(billetter);
    }

    @GetMapping("/hentAlle")
    public List<Ticket> hentAlle() {
        return rep.hentAlle();
    }

    @GetMapping("/slettAlle")
    public void slettAlle() {
        rep.slettAlle();
    }
}
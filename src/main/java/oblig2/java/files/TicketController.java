package oblig2.java.files;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketController {

    public final List<Ticket> ticketList = new ArrayList<>();

    @PostMapping("/lagre")
    public void lagreBillett(Ticket ticket){
        ticketList.add(ticket);
    }

    @GetMapping("/hentAlle")
    public List<Ticket> hentAlle(){
        return ticketList;
    }

    @GetMapping("/slettAlle")
    public void slettAlle(){
        ticketList.clear();
    }
}
package MyApp.Service;

import MyApp.Model.Ticket;
import MyApp.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class TicketService {
    TicketRepository ticketRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
        /**
         * PreparedStatement ps = conn.prepareStatement("select * from ticket");
         * ResultSet rs = ps.executeQuery();
         * while(rs.next){
         *  //
         * }
         */
    }
    public Ticket getTicketById(long id){
        return ticketRepository.findById(id).get();
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTicketsOfResolutionType(boolean resolved) {
        return ticketRepository.getTicketsByResolved(resolved);
    }

    public Ticket changeTicketStatus(long id, Ticket ticket) {
        Ticket ticket1 = ticketRepository.findById(id).get();
        ticket1.setResolved(ticket.isResolved());
        ticketRepository.save(ticket1);
        return ticket1;
    }

}
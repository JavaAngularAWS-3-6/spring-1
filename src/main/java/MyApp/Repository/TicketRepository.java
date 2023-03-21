package MyApp.Repository;

import MyApp.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> getTicketsByResolved(boolean resolved);
}
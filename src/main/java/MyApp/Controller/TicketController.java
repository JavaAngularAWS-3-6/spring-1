package MyApp.Controller;

import MyApp.Model.Ticket;
import MyApp.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (projects of Spring)
 * Spring Core
 * Spring MVC
 * Spring Data JPA
 * Spring ORM
 * Spring AOP
 * Spring Boot
 */
@RestController
@CrossOrigin
public class TicketController {
    TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    @GetMapping("ticket")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
    @PostMapping("user/{id}/ticket")
    public Ticket postTicket(@PathVariable long id, @RequestBody Ticket ticket){
//        TODO: grab the user id and JTW token from the request headers / cookies, and verify that they
//        match what's in the userRepository
        return ticketService.addTicket(id, ticket);
    }
    @GetMapping(value = "ticket", params = {"resolved"})
    public List<Ticket> getAllTicketsOfResolutionType(@RequestParam(name = "resolved") boolean resolved){
        return ticketService.getAllTicketsOfResolutionType(resolved);
    }
    @PatchMapping("ticket/{id}")
    public Ticket changeTicketStatus(@RequestBody Ticket ticket, @PathVariable long id){
//        TODO: grab the user id and JTW token from the request headers / cookies, and verify that they
//        match what's in the userRepository
        return ticketService.changeTicketStatus(id, ticket);
    }
    /**
     * 1. As a user, I should be able to submit a ticket
     * POST localhost:9000/ticket
     *
     * 2. As a user, I should be able to view all my resolved/unresolved tickets
     * GET localhost:9000/user/{id}/ticket?resolved={true/false}
     * GET localhost:9000/user/{id}/ticket/resolved/{true/false}
     *
     * that means that I'll also need to be able to get a user's id? and implement a user model, controller, service,
     * repository (later)
     *
     * 3. As a tech support agent, I should be able to view all unresolved tickets
     * GET localhost:9000/ticket?resolved={true/false}
     *
     * 4. As a tech support agent, I should be able to change a ticket's status to resolved
     * PATCH localhost:9000/ticket/{id} - with a request body containing {resolved="true"}
     *
     * 5. As a user or tech support agent, I should be able to log in, and this login should be "secure",
     * granting a pretend JWT for validating all secure transactions
     *
     * another good way to manage user stories: it's generally good to divide work
     * between user stories, fulfilled where a single person does both the front and back end, rather
     * than having strict frontend/backend teams
     */

    /**
     * Security aspects
     * 1. JWT's - encrypted tokens, provided to the frontend when the user logs in,
     * that verified the user's identity whenever they send an additional request
     * (eg, we shouldn't be able to purchase items on another user's money - we need to validate
     * them by checking if the JWT the frontend sends on the 'purchase' endpoint matches the
     * JWT the backend has stored for the user - can be sent as a cookie
     * 2. Salting/hashing passwords, and other sensitive info
     */
}
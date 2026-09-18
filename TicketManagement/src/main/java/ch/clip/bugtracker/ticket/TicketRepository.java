package ch.clip.bugtracker.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket, Integer> {


}

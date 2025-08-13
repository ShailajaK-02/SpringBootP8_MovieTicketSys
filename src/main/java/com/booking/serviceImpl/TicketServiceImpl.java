package com.booking.serviceImpl;

import com.booking.entity.Ticket;
import com.booking.repository.TicketRepository;
import com.booking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService
{
    //inject repository in this
    @Autowired
    private TicketRepository repository;

    @Override
    //save method implemented
    public String saveTicket(Ticket ticket) {
        repository.save(ticket);
        return "Ticket Booked";
    }

    @Override
    public List<Ticket> getAllTicketData() {
        List<Ticket> ticketList = repository.findAll();
        return ticketList;
    }

    @Override
    public Ticket getTicketById(int id) {
        Ticket ticketById = repository.findById(id).orElseThrow(()->new NullPointerException("Data not found"+id));
        return ticketById;
    }

    @Override
    public String deleteTicket(int id) {
        repository.deleteById(id);
        return "Ticket deleted";
    }

    @Override
    public Ticket updateTicket(int id, Ticket newTicket) {
        Ticket ticket = repository.findById(id).orElseThrow(()-> new NullPointerException("Data not found"));

        ticket.setSeatsBooked(newTicket.getSeatsBooked());

        Ticket updatedTicket = repository.save(ticket);
        return updatedTicket;
    }

    @Override
    public String saveListTicket(List<Ticket> ticketList) {
        repository.saveAll(ticketList);
        return "List saved";
    }
}

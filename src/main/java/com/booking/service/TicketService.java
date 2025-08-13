package com.booking.service;

import com.booking.entity.Ticket;

import java.util.List;

public interface TicketService
{
    String saveTicket(Ticket ticket);

    List<Ticket> getAllTicketData();

    Ticket getTicketById(int id);

    String deleteTicket(int id);

    Ticket updateTicket(int id, Ticket newTicket);

    String saveListTicket(List<Ticket> ticketList);
}

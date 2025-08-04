package com.booking.service;

import com.booking.entity.Ticket;

import java.util.List;

public interface TicketService
{
    String saveTicket(Ticket ticket);

    List<Ticket> getAllTicketData();

    Ticket getTicketById(int id);
}

package com.booking.controller;

import com.booking.entity.Ticket;
import com.booking.service.TicketService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController
{
    //inject service in this class
    @Autowired
    private TicketService ticketService;

    //add data
    @PostMapping("/addTicket")
    public ResponseEntity<String> addData(@RequestBody Ticket ticket){
        ticketService.saveTicket(ticket);
        return new ResponseEntity<>("Ticket Booked", HttpStatus.CREATED);
    }

    //get all data
    @GetMapping("/getAllData")
    public ResponseEntity<List<Ticket>> getAllTicket(){
        List<Ticket> ticketList = ticketService.getAllTicketData();
        return new ResponseEntity<>(ticketList,HttpStatus.OK);
    }

    //get data by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Ticket> getDataById(@PathVariable int id){
        Ticket ticketbyid = ticketService.getTicketById(id);
        return new ResponseEntity<>(ticketbyid,HttpStatus.OK);
    }
}

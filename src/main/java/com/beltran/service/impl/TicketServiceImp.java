package com.beltran.service.impl;

import com.beltran.models.Ticket;
import com.beltran.repository.IGenericRepo;
import com.beltran.repository.ITicketRepo;
import com.beltran.service.ITicketService;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImp extends CRUDImpl<Ticket,Integer> implements ITicketService{

    private final ITicketRepo repo;

    @Override
    protected IGenericRepo<Ticket, Integer> getRepo() {
        return repo;
    }


}

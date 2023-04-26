package com.beltran.repository;


import com.beltran.models.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepo extends IGenericRepo<Ticket,Integer>{
	

}

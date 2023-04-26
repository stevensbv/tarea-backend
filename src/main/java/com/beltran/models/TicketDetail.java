package com.beltran.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TicketDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idTicketDetail;
    
    @ManyToOne
    @JoinColumn(name = "id_ticket",nullable = false, foreignKey=@ForeignKey(name = "FK_TICKET_DETAIL"))
    private Ticket ticket;
    
    @ManyToOne
    @JoinColumn(name = "id_movie",nullable = false, foreignKey=@ForeignKey(name = "FK_MOVIE_DETAIL"))
    private Movie movie;
    
    @Column(nullable = false)
    private Integer quantity;





}

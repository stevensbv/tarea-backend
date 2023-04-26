package com.beltran.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ticket {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTicket;
    
    @Column(nullable = false)
    private LocalDateTime dateTime;
    
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_person", foreignKey = @ForeignKey(name = "FK_TICKET_PERSON"))
    private Person person;
    
    @Column(nullable = false)
    private double total;
    
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL , orphanRemoval = true) // tabla mestro detalle;
    private List<TicketDetail> details;
}

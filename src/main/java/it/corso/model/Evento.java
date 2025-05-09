package it.corso.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "evento")
public class Evento {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String foto;
    private String nome;
    private LocalDateTime ricezione;
    private Integer costo;
    private String campo;
    private String descrizione;
    private Integer partecipanti;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_indirizzo",referencedColumnName="id")
    private Indirizzo indirizzo;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name= "id_sport", referencedColumnName = "id")
    private Sport sport;
}

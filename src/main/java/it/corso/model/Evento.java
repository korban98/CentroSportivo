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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
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

    @Pattern(regexp = "[a-zA-Z0-9\\s-]{1,50}", message = "Caratteri non ammessi in username")
    private String nome;

    private LocalDateTime ricezione;

    @Min(1)
    private Double costo;

    @Pattern(regexp = "[a-zA-Z0-9\\s-]{1,10}", message = "Caratteri non ammessi in campo")
    private String campo;

    @Pattern(regexp = "[a-zA-Z0-9'\",.;:\\ssàèìòùáéíóú!?-]{1,255}", message = "Caratteri non ammessi in descrizione")
    private String descrizione;

    @Min(1)
    private Integer partecipanti;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_indirizzo",referencedColumnName="id")
    private Indirizzo indirizzo;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name= "id_sport", referencedColumnName = "id")
    private Sport sport;
}

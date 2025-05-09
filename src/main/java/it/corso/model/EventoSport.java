package it.corso.model;

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
@Table(name = "eventosport")
public class EventoSport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_evento", referencedColumnName = "id")
    private Evento evento;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_sport", referencedColumnName = "id")
    private Sport sport;

}

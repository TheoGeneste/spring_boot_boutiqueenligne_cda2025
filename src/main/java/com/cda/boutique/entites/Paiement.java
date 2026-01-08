package com.cda.boutique.entites;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="paiements")
@Entity
public class Paiement {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PA_ID")
    private Integer id;

    @Column(name="PA_Montant")
    private BigDecimal montant;

    @Column(name="PA_Date")
    private LocalDate date;

    @Column(name="PA_Methode")
    private String method;

    @OneToMany(mappedBy="paiement", targetEntity=Commande.class)
    List<Commande> commandes;
}

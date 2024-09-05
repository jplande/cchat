package com.incchat.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Destinataire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmetteur;

    @ManyToOne
    private Message message;
}

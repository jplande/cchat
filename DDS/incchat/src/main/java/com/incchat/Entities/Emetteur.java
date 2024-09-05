package com.incchat.Entities;

import jakarta.persistence.Entity;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
public class Emetteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmetteur;

    @ManyToOne
    private Message message;

    // Getters and setters
}

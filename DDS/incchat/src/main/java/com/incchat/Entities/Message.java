package com.incchat.Entities;

import java.util.Date;
//import java.util.HashSet;
// import java.util.List;
//import java.util.Set;
// import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;

//import jakarta.persistence.Column;
// import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
// import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idMessage;
    
    String type;

    String content;

    // Temporal -> Date, on prend la date sans l'heure
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateDiffusion;
    
    @ManyToOne
    @JoinColumn(name = "sender_organization_id")
    private Entreprise senderOrganization;

    @ManyToOne
    @JoinColumn(name = "receiver_organization_id")
    private Entreprise receiverOrganization;
    
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateExpiration;
    

    @ManyToOne
    @JoinColumn(name = "fk_conversation_id")
    private Conversation conversation;

    
    public Message(){

    }

    // public Message(String email){
    //     this.email = email;
    // }

    /*Constructor used in case a client is only a visitor and doesn't want to be a member */
    public Message(String content){
        this.content = content;
        // this.lastname = lastname;
    }

    // public Message(String email, String password, List<String> roles){
    //     this.email = email;
    //     this.password = password;
    //     this.roles.addAll(roles.stream().map(UserRole::valueOf).collect(Collectors.toList()));
    // }

    /*Constructor used in case a client wants to become a member */
    // public Message(String name, String lastname, String email, String password, List<String> roles){
    //     this.content = name;
    //     this.lastname = lastname;
    //     this.email = email;
    //     this.password = password;
    //     this.roles.addAll(roles.stream().map(UserRole::valueOf).collect(Collectors.toList()));
    // }

}

package com.incchat.Entities;

import java.util.HashSet;
import java.util.Set;

// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;
// import java.util.stream.Collectors;

//import jakarta.persistence.Column;
// import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data

public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long conversationId;
    
    
    String name;

    @OneToMany(mappedBy = "conversation")
    private Set<Message> messages = new HashSet<>();

    public Conversation(){

    }

    public Conversation(String name){
        this.name = name;
    }

}

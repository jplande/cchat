package com.incchat.Repositories;

//import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.incchat.Entities.Conversation;

public interface ConversationRepo extends CrudRepository<Conversation,Long>{
    
}

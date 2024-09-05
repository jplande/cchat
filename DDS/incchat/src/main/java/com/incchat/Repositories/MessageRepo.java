package com.incchat.Repositories;

//import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.incchat.Entities.Message;

public interface MessageRepo extends CrudRepository<Message,Long>{

}
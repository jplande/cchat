package com.incchat.Repositories;

//import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.incchat.Entities.Entreprise;

public interface EntrepriseRepo extends CrudRepository<Entreprise,Long>{
    
}

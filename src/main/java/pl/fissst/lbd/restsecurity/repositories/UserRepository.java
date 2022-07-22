package pl.fissst.lbd.restsecurity.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.fissst.lbd.restsecurity.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {


    Optional<User> findUserByUsername(String username);
}

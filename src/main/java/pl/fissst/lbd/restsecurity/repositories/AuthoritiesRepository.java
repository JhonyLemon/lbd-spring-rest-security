package pl.fissst.lbd.restsecurity.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.fissst.lbd.restsecurity.entities.Authority;

public interface AuthoritiesRepository extends CrudRepository<Authority,Long> {



}

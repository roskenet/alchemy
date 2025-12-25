package playground.flxredis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtokollRepository extends CrudRepository<Protokoll, String> {
}

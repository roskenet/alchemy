package applications.example_C;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {

    Artist findByName(String michaelJackson);
}

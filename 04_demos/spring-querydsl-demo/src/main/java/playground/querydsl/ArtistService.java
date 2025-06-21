package playground.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArtistService {

    public record SearchParams(String name) {}

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getFiltered(SearchParams params) {
        QArtist qArtist = QArtist.artist;

//        BooleanBuilder predicate = new BooleanBuilder();
//        if (params.name != null) {
//            predicate.and(qArtist.name.eq(params.name));
//        }

        BooleanExpression predicate = Optional.ofNullable(params.name)
            .map(qArtist.name::eq)
            .orElse(null);

        // Recommended and commonly accepted way:
        return (List<Artist>) artistRepository.findAll(predicate);

        // If you feel uncomfortable in the strongly typed world:

//        return StreamSupport
//                .stream(artistRepository
//                        .findAll(predicate)
//                        .spliterator(), false)
//                .collect(Collectors.toList());
    }
}

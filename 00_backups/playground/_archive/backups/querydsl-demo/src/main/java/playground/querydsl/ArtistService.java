package playground.querydsl;

import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getFiltered() {
        BooleanBuilder builder = new BooleanBuilder();

        QArtist qArtist = QArtist.artist;

        builder.and(qArtist.name.eq("Prince"));

        return StreamSupport
                .stream(artistRepository
                        .findAll(builder.getValue())
                        .spliterator(), false)
                .collect(Collectors.toList());
    }
}

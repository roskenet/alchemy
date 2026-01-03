package de.roskenet.arsenic;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chemelement {

    @Id
    private UUID id;
    private String name;
    private String symbol;
    private int atomnr;

}

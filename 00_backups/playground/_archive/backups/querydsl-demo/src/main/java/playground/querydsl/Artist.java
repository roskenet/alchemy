package playground.querydsl;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Artist {

    private UUID id;
    private String name;
    private LocalDate activeFrom;
    private LocalDate activeTo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(LocalDate activeFrom) {
        this.activeFrom = activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(LocalDate activeTo) {
        this.activeTo = activeTo;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Id
    public UUID getId() {
        return id;
    }


}

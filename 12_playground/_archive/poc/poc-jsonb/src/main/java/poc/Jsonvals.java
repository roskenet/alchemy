package poc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

@Entity
public class Jsonvals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String item;

    // Java enums work out of the box:
    @Enumerated(EnumType.STRING) // I prefer String
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Jsonvals{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", status=" + status +
                '}';
    }
}

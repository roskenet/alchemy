package applications.commons;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShoppingItem {

    @Id
    private int id;
    private String item;

    public ShoppingItem() {}
    public ShoppingItem(int id, String item) {
       this.id=id;
       this.item=item;
    }

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

}

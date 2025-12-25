package applications.example_B;

import applications.commons.ShoppingItem;
import applications.commons.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ServiceB {
    @Autowired
    private ShoppingItemRepository repository;

    @Transactional
    public void doSomething() {

        persistThings();
        doOtherThings();

    }

    public void persistThings() {
        persistBlueShirt();
        persistRedShirt();
    }


    public void persistBlueShirt() {

        ShoppingItem blueShirt = new ShoppingItem(1, "BlueShirt");
        repository.save(blueShirt);

    }

    public void persistRedShirt() {

        ShoppingItem redShirt = new ShoppingItem(2, "RedShirt");
        repository.save(redShirt);

    }

    public void doOtherThings() {
        // Here we do very complex business logic
//        throw new RuntimeException();
    }
}

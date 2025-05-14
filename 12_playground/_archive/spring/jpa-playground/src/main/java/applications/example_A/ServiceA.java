package applications.example_A;

import applications.commons.ShoppingItem;
import applications.commons.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ServiceA {

    @Autowired
    private ShoppingItemRepository repository;

    @Transactional
    public void doSomething() {

        ShoppingItem brownShoe = new ShoppingItem(1, "BrownShoe");
        repository.saveAndFlush(brownShoe);

        System.out.println("What Do you think?");

        ShoppingItem redShoe = new ShoppingItem(2, "RedShoe");
        repository.save(redShoe);

        System.out.println("What Do you think?");

//        throw new RuntimeException();
    }
}

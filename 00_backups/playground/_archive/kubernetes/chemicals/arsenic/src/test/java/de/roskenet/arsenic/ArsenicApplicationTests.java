package de.roskenet.arsenic;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArsenicApplicationTests {

    @Autowired
    private ChemelementRepository repository;

    @Test
    void testChemelementRepository() {
        List<Chemelement> list = new ArrayList<>();
        repository.findAll().forEach(list::add);

        assertThat(list.size()).isEqualTo(1);
    }

}

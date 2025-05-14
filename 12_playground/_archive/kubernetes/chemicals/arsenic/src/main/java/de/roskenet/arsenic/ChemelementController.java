package de.roskenet.arsenic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChemelementController {

    private final ChemelementRepository repository;

    public ChemelementController(ChemelementRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/elements")
    public Iterable<Chemelement> getChemelements() {
        return repository.findAll();
    }
}

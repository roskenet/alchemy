package de.roskenet.christmastree.webservice;


import de.roskenet.christmastree.ChristmasTreeNursery;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreeService {

    @Autowired
    private ChristmasTreeNursery nursery;

    @Operation(summary = "Get a christmas tree with the given height")
    @GetMapping("/tree")
    public TreeResponse tree(@RequestParam("height") int height) {
        return new TreeResponse(nursery.tree(height));
    }
}

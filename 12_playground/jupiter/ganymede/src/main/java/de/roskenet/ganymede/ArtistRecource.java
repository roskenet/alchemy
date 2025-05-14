package de.roskenet.ganymede;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistRecource {

    @GetMapping("/artist/{id}")
    @PreAuthorize( "hasAuthority('SCOPE_profile')")
    public Artist getArtist(@PathVariable String id) {
       return new Artist("Fleetwood Mac", "Classic Rock");
    }
}

package ar.com.xeven.universostarwarsapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class StarWarsController {

    @GetMapping(value="/personaje/{id}", produces = "application/json")
    public String getPersonajeComoString(@PathVariable Integer id){
        RestTemplate apiStarWars = new RestTemplate();
        return apiStarWars.getForObject("https://swapi.dev/api/people/"+id+"/", String.class);
    }

    @GetMapping(value="/personajeAPI/{id}")
    public Personaje getPersonaje(@PathVariable Integer id){
        RestTemplate apiStarWars = new RestTemplate();
        ResponseEntity<Personaje> personaje = apiStarWars.getForEntity("https://swapi.dev/api/people/"+id+"/", Personaje.class);
        return personaje.getBody();
    }

    @GetMapping(value="/personajeAPI/{id}/nombre")
    public String getNombrePersonaje(@PathVariable Integer id){
        RestTemplate apiStarWars = new RestTemplate();
        ResponseEntity<Personaje> personaje = apiStarWars.getForEntity("https://swapi.dev/api/people/"+id+"/", Personaje.class);
        return personaje.getBody().getName();
    }


}


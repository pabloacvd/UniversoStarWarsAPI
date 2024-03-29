package ar.com.xeven.universostarwarsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonajeService {

    private final PersonajeRepo personajeRepo;

    @Autowired
    public PersonajeService(PersonajeRepo personajeRepo) {
        this.personajeRepo = personajeRepo;
    }


    public Personaje save(Personaje personaje) {
        personaje.corregirID();
        return personajeRepo.save(personaje);
    }

    public Optional<Personaje> findPersonajeById(Integer id) {
        return personajeRepo.findById(id);
    }
}

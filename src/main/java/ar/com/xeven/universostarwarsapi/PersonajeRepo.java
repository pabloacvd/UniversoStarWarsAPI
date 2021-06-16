package ar.com.xeven.universostarwarsapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepo extends JpaRepository<Personaje, Integer> {
}

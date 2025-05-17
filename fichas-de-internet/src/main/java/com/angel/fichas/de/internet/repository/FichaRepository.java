package com.angel.fichas.de.internet.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.angel.fichas.de.internet.model.Fichas;


public interface FichaRepository extends JpaRepository<Fichas, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar fichas por algún campo específico
    // List<Fichas> findBySomeField(String someField);
    //Fichas findByUsuario(String usuario);
    Optional<Fichas> findByUsuario(String usuario);
}

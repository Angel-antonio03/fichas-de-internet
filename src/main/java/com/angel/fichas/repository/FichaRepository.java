package com.angel.fichas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angel.fichas.model.Fichas;


public interface FichaRepository extends JpaRepository<Fichas, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar fichas por algún campo específico
    // List<Fichas> findBySomeField(String someField);

}

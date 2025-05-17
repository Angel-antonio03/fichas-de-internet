package com.angel.fichas.de.internet.controllers;
  import java.util.Optional;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angel.fichas.de.internet.model.Fichas;
import com.angel.fichas.de.internet.repository.FichaRepository;

@RestController
@RequestMapping("/fichas")
@CrossOrigin(origins = "*")
public class fichasController {
@Autowired
    private FichaRepository fichaRepository;
    //METODOS
    //metodo para traer todas las fichas
    @GetMapping ("/TraerFichas")
    public List <Fichas> TraerFichas() {
        return fichaRepository.findAll();
        
    }
    @ GetMapping ("/TraerFicha/{id}")
    public ResponseEntity<Fichas> TraerUnFicha(@PathVariable long id) {
        return fichaRepository.findById(id)
            .map(ficha -> ResponseEntity.ok(ficha))
            .orElse(ResponseEntity.notFound().build());
        
    }
    //metodo para crear una ficha
    @PostMapping ("/CrearFichas")
    public Fichas CrearFichas(@RequestBody Fichas ficha) {
        return fichaRepository.save(ficha);
    }
    //metodo para modificar una ficha
    @PutMapping("/ModificarFichas/{id}")
public ResponseEntity<Fichas> ModificarFichas(@PathVariable long id, @RequestBody Fichas ficha) {
    return fichaRepository.findById(id).map(existingFicha -> {
        existingFicha.setContraseña(ficha.getContraseña());
        existingFicha.setTiempo(ficha.getTiempo());
        existingFicha.setVelocidadInternet(ficha.getVelocidadInternet());
        existingFicha.setUsuario(ficha.getUsuario());
        existingFicha.setFechaInicio(ficha.getFechaInicio());
        existingFicha.setDatosDescargados(ficha.getDatosDescargados());
        existingFicha.setDatosSubidos(ficha.getDatosSubidos());
        existingFicha.setVelocidadActual(ficha.getVelocidadActual());
        existingFicha.setEstabilidad(ficha.getEstabilidad());
        existingFicha.setPais(ficha.getPais());
        existingFicha.setIpPublica(ficha.getIpPublica());
        existingFicha.setEstadoSeguridad(ficha.getEstadoSeguridad());
        existingFicha.setHttpsActivo(ficha.getHttpsActivo());

        Fichas updatedFicha = fichaRepository.save(existingFicha);
        return ResponseEntity.ok(updatedFicha);
    }).orElse(ResponseEntity.notFound().build());
}

    //metodo para eliminar una ficha
    @DeleteMapping ("/EliminarFichas/{id}")
    public void EliminarFichas(@PathVariable long id) {
        fichaRepository.deleteById(id);
    }
    // ✅ Método para login
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
    try {
        String usuario = loginData.get("usuario");
        String contraseña = loginData.get("contraseña");

        if (usuario == null || contraseña == null) {
            return ResponseEntity.badRequest().body("Faltan datos de usuario o contraseña");
        }

        // Nota: usa el nombre correcto de tu entidad, que debería ser 'Fichas' (con mayúscula)
        Optional<Fichas> fichaOpt = fichaRepository.findByUsuario(usuario);

        if (fichaOpt.isPresent()) {
            Fichas ficha = fichaOpt.get();
            if (ficha.getContraseña().equals(contraseña)) {
                return ResponseEntity.ok(ficha);
            } else {
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }
        } else {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }

    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Error en la solicitud");
    }
}




}

package com.angel.fichas.de.internet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fichas {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    private String contraseña;
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    private String tiempo;
    public String getTiempo() {
        return tiempo;
    }
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    private String velocidadInternet;
    public String getVelocidadInternet() {
        return velocidadInternet;
    }
    public void setVelocidadInternet(String velocidadInternet) {
        this.velocidadInternet = velocidadInternet;
    }
    private String usuario;
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String Usuario) {
        this.usuario = Usuario;
    }
    
}

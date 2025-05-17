package com.angel.fichas.de.internet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fichas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;
    private String contraseña;
    private String tiempo;
    private String velocidadInternet;

    // NUEVOS CAMPOS PARA EL RESUMEN
    private String fechaInicio;
    private String datosDescargados;
    private String datosSubidos;
    private String velocidadActual;
    private String estabilidad;
    private String pais;
    private String ipPublica;
    private String estadoSeguridad;
    private String httpsActivo;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getVelocidadInternet() {
        return velocidadInternet;
    }

    public void setVelocidadInternet(String velocidadInternet) {
        this.velocidadInternet = velocidadInternet;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDatosDescargados() {
        return datosDescargados;
    }

    public void setDatosDescargados(String datosDescargados) {
        this.datosDescargados = datosDescargados;
    }

    public String getDatosSubidos() {
        return datosSubidos;
    }

    public void setDatosSubidos(String datosSubidos) {
        this.datosSubidos = datosSubidos;
    }

    public String getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(String velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public String getEstabilidad() {
        return estabilidad;
    }

    public void setEstabilidad(String estabilidad) {
        this.estabilidad = estabilidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIpPublica() {
        return ipPublica;
    }

    public void setIpPublica(String ipPublica) {
        this.ipPublica = ipPublica;
    }

    public String getEstadoSeguridad() {
        return estadoSeguridad;
    }

    public void setEstadoSeguridad(String estadoSeguridad) {
        this.estadoSeguridad = estadoSeguridad;
    }

    public String getHttpsActivo() {
        return httpsActivo;
    }

    public void setHttpsActivo(String httpsActivo) {
        this.httpsActivo = httpsActivo;
    }
}

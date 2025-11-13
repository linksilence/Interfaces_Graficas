package edu.pucgoias.topicos_avancados.java_swing.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;


public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String genero;
    private String tipoUsuario;
    private LocalDateTime dataRegistro;
    
    // Construtor completo
    public Usuario(String nome, String genero, String tipoUsuario, LocalDateTime dataRegistro) {
        this.nome = nome;
        this.genero = genero;
        this.tipoUsuario = tipoUsuario;
        this.dataRegistro = dataRegistro;
    }
    
    // Construtor com data atual
    public Usuario(String nome, String genero, String tipoUsuario) {
        this(nome, genero, tipoUsuario, LocalDateTime.now());
    }
    
    // Getters
    public String getNome() {
        return nome;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    
    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }
    
    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return nome + "|" + genero + "|" + tipoUsuario + "|" + 
               dataRegistro.format(formatter);
    }
}

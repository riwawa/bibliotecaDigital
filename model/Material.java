/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecadigital.model;

/**
 *
 * @author bialcna
 */
public abstract class Material implements Emprestavel {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;
    
    public Material(String titulo, String autor, int anoPublicacao) {
        this.autor = autor;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }
    
    // getters
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public int getAnoPublicacao(){
        return anoPublicacao;
    }
    public boolean getDisponivel(){
        return disponivel;
    }
    // setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setAnoPublicacao(int anoPublicacao){
        if (anoPublicacao < 0) {
            throw new IllegalArgumentException("Ano de publicação não pode ser negativo");
        } 
        this.anoPublicacao = anoPublicacao;
        
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    
}

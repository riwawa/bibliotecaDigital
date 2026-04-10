package com.mycompany.bibliotecadigital.model;

public class Livro extends Material {
    private int numeroPaginas;
    
    public Livro(String titulo, String autor, int anoPublicacao, int numeroPaginas){
        super(titulo, autor, anoPublicacao);
        this.numeroPaginas = numeroPaginas;
    }
    
    // getter 
    public int getNumeroPaginas(){
        return numeroPaginas;
    }
    // setter
    public void setNumeroPaginas(int numeroPaginas){
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
        }
        this.numeroPaginas = numeroPaginas;
    }
     
    @Override
    public void emprestar(String nomeUsuario) {
        if (getDisponivel() == true) {
            System.out.println("Livro " + getTitulo() + " emprestado para " + nomeUsuario);
            setDisponivel(false);
        } else{
            System.out.println("Livro indisponível para empréstimo.");
        }
    }
}

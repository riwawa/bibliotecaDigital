package com.mycompany.bibliotecadigital.model;

public class Revista extends Material {
    private int edicao;
    
    public Revista(String titulo, String autor, int anoPublicacao, int edicao){
        super(titulo, autor, anoPublicacao);
        this.edicao = edicao;
    }
    
    public int getEdicao(){
        return edicao;
    }
    
    public void setEdicao(int edicao){
        if (edicao <= 0) {
            throw new IllegalArgumentException("Edição inválido");
        }
        this.edicao = edicao;
    }
    
    @Override
    public void emprestar(String nomeUsuario) {
        if (getDisponivel() == true) {
            System.out.println("Revista " + getTitulo() + " emprestado para " + nomeUsuario);
            setDisponivel(false);
        } else{
            System.out.println("Revista indisponível para empréstimo.");
        }
    }
}

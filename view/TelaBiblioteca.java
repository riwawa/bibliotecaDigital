package com.mycompany.bibliotecadigital.view;

import com.mycompany.bibliotecadigital.database.ConexaoBanco;
import com.mycompany.bibliotecadigital.model.Livro;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaBiblioteca extends JFrame {

    private JLabel lblTitulo;
    private JLabel lblUsuario;
    private JTextField txtUsuario;
    private JButton btnEmprestar;

    
    public TelaBiblioteca() {
        // criar a janela
        setTitle("Biblioteca Digital");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // componentes
        lblTitulo = new JLabel("Biblioteca Digital");
        lblTitulo.setBounds(130, 20, 200, 30);
        add(lblTitulo);

        lblUsuario = new JLabel("Nome do usuário:");
        lblUsuario.setBounds(40, 70, 120, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(160, 70, 160, 25);
        add(txtUsuario);

        btnEmprestar = new JButton("Emprestar Livro");
        btnEmprestar.setBounds(110, 130, 160, 35);
        add(btnEmprestar);

        // click
        btnEmprestar.addActionListener(e -> {
            try {
                String nomeUsuario = txtUsuario.getText();

                if (nomeUsuario.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digite o nome do usuário.");
                    return;
                }

                Livro livro = new Livro("Java Básico", "Deitel", 2020, 350);

                livro.emprestar(nomeUsuario);

                ConexaoBanco banco = new ConexaoBanco();
                banco.salvarMaterial(livro);

                JOptionPane.showMessageDialog(null,
                        "Livro emprestado e salvo no banco com sucesso!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Erro: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
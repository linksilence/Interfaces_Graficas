package edu.pucgoias.topicos_avancados.java_swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AppSwingDemo extends JFrame {

    public AppSwingDemo() {
        setTitle("Aplicação de Teste - Java Swing");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // IMPORTANT
        setLocationRelativeTo(null); // Centraliza a janela

        // Painel principal com layout gerenciado
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        add(painelPrincipal);

        // ====== MENU SUPERIOR ======
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> System.exit(0));
        menuArquivo.add(itemSair);
        menuBar.add(menuArquivo);
        setJMenuBar(menuBar);

        // ====== PAINEL SUPERIOR ======
        JPanel painelSuperior = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Demonstração de Componentes Swing");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        painelSuperior.add(lblTitulo);
        painelPrincipal.add(painelSuperior, BorderLayout.NORTH);

        // ====== PAINEL CENTRAL ======
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new GridLayout(6, 2, 5, 5));

        painelCentral.add(new JLabel("Nome:"));
        JTextField txtNome = new JTextField();
        painelCentral.add(txtNome);

        painelCentral.add(new JLabel("Gênero:"));
        String[] generos = {"Masculino", "Feminino", "Outro"};
        JComboBox<String> cbGenero = new JComboBox<>(generos);
        painelCentral.add(cbGenero);

        painelCentral.add(new JLabel("Preferência:"));
        JCheckBox chkEmail = new JCheckBox("Receber e-mails");
        painelCentral.add(chkEmail);

        painelCentral.add(new JLabel("Tipo de usuário:"));
        JPanel painelRadios = new JPanel();
        JRadioButton rbAluno = new JRadioButton("Aluno XPTO");
        JRadioButton rbProfessor = new JRadioButton("Professor XPTO");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbAluno);
        grupo.add(rbProfessor);
        painelRadios.add(rbAluno);
        painelRadios.add(rbProfessor);
        painelCentral.add(painelRadios);

        painelCentral.add(new JLabel("Comentários:"));
        JTextArea txtComentarios = new JTextArea(3, 20);
        painelCentral.add(new JScrollPane(txtComentarios));

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        // ====== TABELA ======
        String[] colunas = {"Nome", "Gênero", "Tipo"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);
        JScrollPane scrollTabela = new JScrollPane(tabela);

        // ====== PAINEL INTERMEDIÁRIO ======
        JPanel painelConteudo = new JPanel();
        painelConteudo.setLayout(new BoxLayout(painelConteudo, BoxLayout.Y_AXIS));
        painelConteudo.add(painelCentral);
        painelConteudo.add(scrollTabela);

        painelPrincipal.add(painelConteudo, BorderLayout.CENTER);

        // ====== PAINEL DE BOTÕES ======
        JPanel painelBotoes = new JPanel();
        JButton btnSalvar = new JButton("Adicionar");
        JButton btnLimpar = new JButton("Limpar Campos");
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnLimpar);
        painelPrincipal.add(painelBotoes, BorderLayout.PAGE_END);

        // ====== EVENTOS ======
        btnSalvar.addActionListener((ActionEvent e) -> {
            String nome = txtNome.getText();
            String genero = (String) cbGenero.getSelectedItem();
            String tipo = rbAluno.isSelected() ? "Aluno" :
                    rbProfessor.isSelected() ? "Professor" : "Não informado";

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor, informe o nome.",
                        "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            modelo.addRow(new Object[]{nome, genero, tipo});
            JOptionPane.showMessageDialog(this, "Registro adicionado com sucesso!");
        });

        btnLimpar.addActionListener(e -> {
            txtNome.setText("");
            cbGenero.setSelectedIndex(0);
            grupo.clearSelection();
            chkEmail.setSelected(false);
            txtComentarios.setText("");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppSwingDemo().setVisible(true));
    }
}
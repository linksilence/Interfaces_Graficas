package edu.pucgoias.topicos_avancados.java_swing.model;

import edu.pucgoias.topicos_avancados.java_swing.util.FormatadorData;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;


public class UsuarioTableModel extends DefaultTableModel {
    
    private static final String[] COLUNAS = {"Nome", "Gênero", "Tipo", "Data de Registro"};
    private List<Usuario> usuarios;
    private List<Usuario> usuariosOriginais;
    
    public UsuarioTableModel() {
        super(COLUNAS, 0);
        this.usuarios = new ArrayList<>();
        this.usuariosOriginais = new ArrayList<>();
    }
    

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        usuariosOriginais.add(usuario);
        adicionarLinha(usuario);
    }
    

    public void removerUsuarioPorLinha(int linha) {
        if (linha >= 0 && linha < usuarios.size()) {
            Usuario usuarioRemovido = usuarios.get(linha);
            usuarios.remove(linha);
            usuariosOriginais.remove(usuarioRemovido);
            removeRow(linha);
        }
    }
    

    public void filtrarPorNome(String nomeFiltro) {
        // Limpa a tabela
        while (getRowCount() > 0) {
            removeRow(0);
        }
        
        usuarios.clear();
        
        // Adiciona usuários que correspondem ao filtro
        String nomeFiltroLower = nomeFiltro.toLowerCase();
        for (Usuario usuario : usuariosOriginais) {
            if (usuario.getNome().toLowerCase().contains(nomeFiltroLower)) {
                usuarios.add(usuario);
                adicionarLinha(usuario);
            }
        }
    }
    

    public void limparFiltro() {
        while (getRowCount() > 0) {
            removeRow(0);
        }
        
        usuarios.clear();
        for (Usuario usuario : usuariosOriginais) {
            usuarios.add(usuario);
            adicionarLinha(usuario);
        }
    }
    

    public List<Usuario> obterTodosUsuarios() {
        return new ArrayList<>(usuariosOriginais);
    }
    

    private void adicionarLinha(Usuario usuario) {
        addRow(new Object[]{
            usuario.getNome(),
            usuario.getGenero(),
            usuario.getTipoUsuario(),
            FormatadorData.formatarCompleto(usuario.getDataRegistro())
        });
    }
    

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Tabela somente leitura
    }
}

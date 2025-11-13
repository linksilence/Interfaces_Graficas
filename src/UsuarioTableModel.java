package edu.pucgoias.topicos_avancados.java_swing.model;

import edu.pucgoias.topicos_avancados.java_swing.util.FormatadorData;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo customizado para tabela de usuários.
 */
public class UsuarioTableModel extends DefaultTableModel {
    
    private static final String[] COLUNAS = {"Nome", "Gênero", "Tipo", "Data de Registro"};
    private List<Usuario> usuarios;
    private List<Usuario> usuariosOriginais;
    
    public UsuarioTableModel() {
        super(COLUNAS, 0);
        this.usuarios = new ArrayList<>();
        this.usuariosOriginais = new ArrayList<>();
    }
    
    /**
     * Adiciona um novo usuário ao modelo.
     */
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        usuariosOriginais.add(usuario);
        adicionarLinha(usuario);
    }
    
    /**
     * Remove usuário pela linha da tabela.
     */
    public void removerUsuarioPorLinha(int linha) {
        if (linha >= 0 && linha < usuarios.size()) {
            Usuario usuarioRemovido = usuarios.get(linha);
            usuarios.remove(linha);
            usuariosOriginais.remove(usuarioRemovido);
            removeRow(linha);
        }
    }
    
    /**
     * Filtra usuários pelo nome.
     */
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
    
    /**
     * Limpa filtro e exibe todos os usuários.
     */
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
    
    /**
     * Retorna todos os usuários (para salvar em arquivo).
     */
    public List<Usuario> obterTodosUsuarios() {
        return new ArrayList<>(usuariosOriginais);
    }
    
    /**
     * Adiciona linha à tabela a partir de um usuário.
     */
    private void adicionarLinha(Usuario usuario) {
        addRow(new Object[]{
            usuario.getNome(),
            usuario.getGenero(),
            usuario.getTipoUsuario(),
            FormatadorData.formatarCompleto(usuario.getDataRegistro())
        });
    }
    
    /**
     * Define se as células podem ser editadas.
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Tabela somente leitura
    }
}

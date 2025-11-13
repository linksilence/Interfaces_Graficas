package edu.pucgoias.topicos_avancados.java_swing.util;

/**
 * Utilitário para validação de formulários.
 */
public class ValidadorFormulario {
    
    /**
     * Valida se o nome não está vazio e tem comprimento mínimo.
     */
    public static String validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return "O nome não pode estar vazio.";
        }
        
        if (nome.trim().length() < 3) {
            return "O nome deve ter pelo menos 3 caracteres.";
        }
        
        return null; // Sem erros
    }
    
    /**
     * Valida se foi selecionado um tipo de usuário.
     */
    public static String validarTipoUsuario(String tipo) {
        if (tipo == null || tipo.equals("Não informado")) {
            return "Selecione um tipo de usuário.";
        }
        return null;
    }
    
    /**
     * Valida formulário completo.
     */
    public static String validarFormularioCompleto(String nome, String tipo) {
        String erro = validarNome(nome);
        if (erro != null) return erro;
        
        erro = validarTipoUsuario(tipo);
        return erro;
    }
}

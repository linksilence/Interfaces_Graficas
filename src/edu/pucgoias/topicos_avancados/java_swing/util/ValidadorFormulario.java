package edu.pucgoias.topicos_avancados.java_swing.util;


public class ValidadorFormulario {
    

    public static String validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return "O nome não pode estar vazio.";
        }
        
        if (nome.trim().length() < 3) {
            return "O nome deve ter pelo menos 3 caracteres.";
        }
        
        return null; // Sem erros
    }
    

    public static String validarTipoUsuario(String tipo) {
        if (tipo == null || tipo.equals("Não informado")) {
            return "Selecione um tipo de usuário.";
        }
        return null;
    }
    

    public static String validarFormularioCompleto(String nome, String tipo) {
        String erro = validarNome(nome);
        if (erro != null) return erro;
        
        erro = validarTipoUsuario(tipo);
        return erro;
    }
}

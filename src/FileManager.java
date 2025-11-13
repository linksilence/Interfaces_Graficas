package edu.pucgoias.topicos_avancados.java_swing.util;

import edu.pucgoias.topicos_avancados.java_swing.model.Usuario;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Gerenciador de persistência de dados em arquivo.
 */
public class FileManager {
    
    /**
     * Salva lista de usuários em arquivo.
     */
    public static void salvarUsuarios(List<Usuario> usuarios, String caminhoArquivo) 
            throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Usuario usuario : usuarios) {
                writer.write(usuario.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Erro ao salvar arquivo: " + e.getMessage(), e);
        }
    }
    
    /**
     * Carrega usuários de um arquivo.
     */
    public static List<Usuario> carregarUsuarios(String caminhoArquivo) 
            throws IOException {
        List<Usuario> usuarios = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);
        
        if (!arquivo.exists()) {
            throw new FileNotFoundException("Arquivo não encontrado: " + caminhoArquivo);
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Usuario usuario = parseLinhaUsuario(linha);
                if (usuario != null) {
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            throw new IOException("Erro ao carregar arquivo: " + e.getMessage(), e);
        }
        
        return usuarios;
    }
    
    /**
     * Parse de uma linha do arquivo para objeto Usuario.
     */
    private static Usuario parseLinhaUsuario(String linha) {
        String[] partes = linha.split("\\|");
        
        if (partes.length != 4) {
            return null; // Linha com formato inválido
        }
        
        try {
            String nome = partes[0];
            String genero = partes[1];
            String tipo = partes[2];
            LocalDateTime dataRegistro = FormatadorData.parseCompleto(partes[3]);
            
            return new Usuario(nome, genero, tipo, dataRegistro);
        } catch (Exception e) {
            System.err.println("Erro ao fazer parse da linha: " + linha);
            return null;
        }
    }
}

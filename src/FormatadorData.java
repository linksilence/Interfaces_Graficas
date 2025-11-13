package edu.pucgoias.topicos_avancados.java_swing.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utilitário para formatação de data e hora.
 */
public class FormatadorData {
    
    private static final DateTimeFormatter FORMATO_COMPLETO = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    private static final DateTimeFormatter FORMATO_DATA = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /**
     * Formata LocalDateTime para string com data e hora completa.
     */
    public static String formatarCompleto(LocalDateTime dataHora) {
        return dataHora.format(FORMATO_COMPLETO);
    }
    
    /**
     * Formata LocalDateTime para string com apenas a data.
     */
    public static String formatarData(LocalDateTime dataHora) {
        return dataHora.format(FORMATO_DATA);
    }
    
    /**
     * Parse de string para LocalDateTime.
     */
    public static LocalDateTime parseCompleto(String dataHoraStr) {
        return LocalDateTime.parse(dataHoraStr, FORMATO_COMPLETO);
    }
}

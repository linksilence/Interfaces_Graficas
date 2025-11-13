package edu.pucgoias.topicos_avancados.java_swing.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FormatadorData {
    
    private static final DateTimeFormatter FORMATO_COMPLETO = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    private static final DateTimeFormatter FORMATO_DATA = 
        DateTimeFormatter.ofPattern("dd/MM/yyyy");
    

    public static String formatarCompleto(LocalDateTime dataHora) {
        return dataHora.format(FORMATO_COMPLETO);
    }
    

    public static String formatarData(LocalDateTime dataHora) {
        return dataHora.format(FORMATO_DATA);
    }
    

    public static LocalDateTime parseCompleto(String dataHoraStr) {
        return LocalDateTime.parse(dataHoraStr, FORMATO_COMPLETO);
    }
}

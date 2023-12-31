package br.com.digimon.exeptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponce implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;
    
    /**
     * Construtor da classe ExceptionResponse.
     * @param timestamp Timestamp que indica o momento em que a exceção ocorreu.
     * @param message Mensagem de erro associada à exceção.
     * @param details Detalhes adicionais sobre a exceção.
     */
    
    public ExceptionResponce(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
    
    
    
}

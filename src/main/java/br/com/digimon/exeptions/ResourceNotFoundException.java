package br.com.digimon.exeptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	 /**
     * Construtor que recebe uma mensagem de erro e a repassa para o construtor da classe pai (RuntimeException).
     * @param ex Mensagem de erro que descreve a exceção.
     */
	 public ResourceNotFoundException(String ex) {
	        super(ex);
	    }

}

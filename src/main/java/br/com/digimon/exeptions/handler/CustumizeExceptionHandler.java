package br.com.digimon.exeptions.handler;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.digimon.exeptions.ExceptionResponce;
import br.com.digimon.exeptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustumizeExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
    public final  ResponseEntity <ExceptionResponce> handleAllExcepitons(
        Exception ex,WebRequest request) {
		/* Cria uma instância de ExceptionResponse com o timestamp atual, 
		mensagem de erro e detalhes da requisição*/
            ExceptionResponce exceptionResponce = new ExceptionResponce(
                new Date(),
                 ex.getMessage(),
                 request.getDescription(false));
         // Retorna uma resposta com o ExceptionResponse e status HTTP 500 (INTERNAL_SERVER_ERROR)
                 return new ResponseEntity<>(exceptionResponce,HttpStatus.INTERNAL_SERVER_ERROR);
                
        
    }
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public final  ResponseEntity <ExceptionResponce> handleNotFoundtExcepitons(
        Exception ex,WebRequest request) {
            ExceptionResponce exceptionResponce = new ExceptionResponce(
                new Date(),
                 ex.getMessage(),
                 request.getDescription(false));
         // Retorna uma resposta com o ExceptionResponse e status HTTP 404 (NOT_FOUND)
                 return new ResponseEntity<>(exceptionResponce,HttpStatus.NOT_FOUND);
        
    }

}

package br.com.digimon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digimon.data.vo.v1.DigimonVO;
import br.com.digimon.services.DigimonServices;
import br.com.digimon.util.MediaType;

@RestController
@RequestMapping("/digimon")
public class DigimonController {
	
	@Autowired
	private DigimonServices service;
	
	// Método para buscar todos os Digimons
	@GetMapping(produces = {MediaType.APPLICATION_JSON, 
			MediaType.APPLICATION_XML ,
			MediaType.APPLICATION_YML})
	public List<DigimonVO>findAll(){
		return service.findAll();
	}
	
	// Método para buscar um Digimon por ID
	@GetMapping(value ="/{id}",
			produces = {MediaType.APPLICATION_JSON,
					MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	public DigimonVO findById(@PathVariable(value= "id")Long id){
		return service.findById(id);
	}
	
	// Método para criar um novo Digimon
	@PostMapping(produces = {MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML},
			consumes = {MediaType.APPLICATION_JSON,
					MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	public DigimonVO create(@RequestBody DigimonVO DigimonVO){
		return service.create(DigimonVO);
	}
	
	// Método para atualizar um Digimon existente
	@PutMapping(produces = {MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML},
			consumes = {MediaType.APPLICATION_JSON, 
					MediaType.APPLICATION_XML,
					MediaType.APPLICATION_YML})
	public DigimonVO update(@RequestBody DigimonVO DigimonVO){
		return service.update(DigimonVO);
	}
	
	// Método para deletar um Digimon por ID
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<?> delete(@PathVariable(value= "id")Long id){
		 service.delete(id);
		// Retorna uma resposta de sucesso sem conteúdo (No Content) após a exclusão bem-sucedida.
		 return ResponseEntity.noContent().build();
	}
	
	

}

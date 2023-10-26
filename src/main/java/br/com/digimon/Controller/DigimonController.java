package br.com.digimon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.digimon.model.Digimon;
import br.com.digimon.services.DigimonServices;

@RestController
@RequestMapping("/digimon")
public class DigimonController {
	
	@Autowired
	private DigimonServices service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Digimon>findAll(){
		return service.findAll();
	}
	
	@GetMapping(value ="/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Digimon findById(@PathVariable(value= "id")Long id){
		return service.findById(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Digimon create(@RequestBody Digimon digimon){
		return service.create(digimon);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Digimon update(@RequestBody Digimon digimon){
		return service.update(digimon);
	}
	
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<?> delete(@PathVariable(value= "id")Long id){
		 service.delete(id);
		 return ResponseEntity.noContent().build();
	}
	
	

}

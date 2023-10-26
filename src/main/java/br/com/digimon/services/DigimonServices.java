package br.com.digimon.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digimon.exeptions.ResourceNotFoundException;
import br.com.digimon.model.Digimon;
import br.com.digimon.repository.DigimonRepository;


@Service
public class DigimonServices {
	
	private Logger logger = Logger.getLogger(DigimonServices.class.getName());
	
	@Autowired
	DigimonRepository repository;
	
	public List<Digimon> findAll() {
		logger.info("Finding all digimons!");
		
		return repository.findAll();
	}


	public Digimon findById(Long id) {
		
		logger.info("Finding one digimon!");
					
		return repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID") );
	}
	
	public Digimon create(Digimon digimon) {
		logger.info("Create one digimon!");
		
		return repository.save(digimon);
	}
	
	public Digimon update(Digimon digimon) {
		logger.info("Update one digimon!");
		
		var entity = repository.findById(digimon.getId())
		.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID") );
		
		entity.setName(digimon.getName());
		entity.setLevel(digimon.getLevel());
		
		return repository.save(digimon);
	}
	
	
	public void delete(Long id) {
		logger.info("Delete one digimon!");
		
		var entity = repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID") );
		
		repository.delete(entity);
	}

}

package br.com.digimon.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digimon.data.vo.v1.DigimonVO;
import br.com.digimon.exeptions.ResourceNotFoundException;
import br.com.digimon.mapper.DozerMapper;
import br.com.digimon.model.Digimon;
import br.com.digimon.repository.DigimonRepository;


@Service
public class DigimonServices {
	
	// Instância de Logger para registrar mensagens do serviço Digimon
	private Logger logger = Logger.getLogger(DigimonServices.class.getName());
	
	@Autowired
	DigimonRepository repository;
	
	public List<DigimonVO> findAll() {
		logger.info("Finding all digimons!");
		
		// Converte a lista de entidades Digimon para uma lista de objetos DigimonVO usando o DozerMapper
		return DozerMapper.parseListObjects(repository.findAll(), DigimonVO.class) ;
	}


	public DigimonVO findById(Long id) {
		
		logger.info("Finding one digimon!");
		
		// Busca a entidade Digimon pelo ID no banco de dados		
		var entity = repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID") );
		
		// Converte a entidade Digimon para um objeto DigimonVO usando o DozerMapper
		return DozerMapper.parseObject(entity, DigimonVO.class);
	}
	
	
	
	public DigimonVO create(DigimonVO digimon) {
		logger.info("Create one digimon!");
		
		// Converte o objeto DigimonVO para uma entidade Digimon usando o DozerMapper
		var entity = DozerMapper.parseObject(digimon, Digimon.class);
		
		// Salva a entidade Digimon no banco de dados e converte de volta para um objeto DigimonVO
		var vo = DozerMapper.parseObject(repository.save(entity), DigimonVO.class);
		return vo;
	}
	
	
	
	public DigimonVO update(DigimonVO digimon) {
		logger.info("Update one digimon!");
		// Busca a entidade Digimon pelo ID no banco de dados
		
		var entity = repository.findById(digimon.getId())
		.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID") );
		
		// Atualiza os campos da entidade com base nos dados do objeto DigimonVO
		entity.setName(digimon.getName());
		entity.setLevel(digimon.getLevel());
		
		 // Salva a entidade Digimon atualizada no banco de dados e converte de volta para um objeto DigimonVO
		var vo = DozerMapper.parseObject(repository.save(entity), DigimonVO.class);
		return vo;
	}
	
	
	public void delete(Long id) {
		logger.info("Delete one digimon!");
		
		var entity = repository.findById(id)
				.orElseThrow( () -> new ResourceNotFoundException("No records found for this ID") );
		
		repository.delete(entity);
	}

}

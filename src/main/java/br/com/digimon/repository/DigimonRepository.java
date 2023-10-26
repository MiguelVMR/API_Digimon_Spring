package br.com.digimon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digimon.model.Digimon;

@Repository
public interface DigimonRepository extends JpaRepository<Digimon, Long>{

}

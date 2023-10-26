package br.com.digimon.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

// Classe para converter mensagens entre YAML e objetos Java usando Jackson
public class YamlJackson2HttpMesageConverter extends AbstractJackson2HttpMessageConverter {

	/* Construtor da classe, configura o conversor para trabalhar com YAML 
	e define o tipo de mídia como application/x-yaml*/
	public YamlJackson2HttpMesageConverter() {
		// Cria um novo mapeador YAML com configurações específicas
		super(new YAMLMapper().
				setSerializationInclusion(JsonInclude.Include.NON_NULL), // Configuração para incluir propriedades não nulas
				MediaType.parseMediaType("application/x-yaml"));// Define o tipo de mídia como application/x-yaml
    }
		
	}



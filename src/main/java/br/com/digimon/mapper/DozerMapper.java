package br.com.digimon.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerMapper {
	
	// Instância do Mapper Dozer para realizar a conversão de objetos
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	/**
     * Converte um objeto de origem (origin) para um objeto de destino (destination) usando o DozerMapper.
     * @param origin Objeto de origem a ser convertido.
     * @param destination Classe do objeto de destino.
     * @param <O> Tipo do objeto de origem.
     * @param <D> Tipo do objeto de destino.
     * @return Objeto de destino convertido.
     */
	  public static <O,D> D parseObject(O origin,Class <D> destination){
	        return mapper.map(origin, destination);
	    }
	
	  /**
	     * Converte uma lista de objetos de origem para uma lista de objetos de destino usando o DozerMapper.
	     * @param origin Lista de objetos de origem a serem convertidos.
	     * @param destination Classe do objeto de destino.
	     * @param <O> Tipo do objeto de origem.
	     * @param <D> Tipo do objeto de destino.
	     * @return Lista de objetos de destino convertidos.
	     */
	 public static <O,D> List <D> parseListObjects(List< O >origin,Class <D> destination){
	       List <D> destinationObejects = new ArrayList<D>();
	       for (O o : origin) {
	        destinationObejects.add(mapper.map(o , destination));
	       }
	       
	        return destinationObejects;
	    }

}

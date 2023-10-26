package br.com.digimon.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.digimon.serialization.converter.YamlJackson2HttpMesageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	
	// Definindo o tipo de mídia YAML
	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
	
	// Adiciona um conversor para mensagens YAML ao contexto da aplicação
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
	
		converters.add(new YamlJackson2HttpMesageConverter());
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		configurer.favorParameter(false) // Ignora o parâmetro de favor de mídia (ex: ?mediaType=xml)
		.ignoreAcceptHeader(false) // Não ignora o cabeçalho Accept
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
	}
	

}

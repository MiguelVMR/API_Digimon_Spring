package br.com.digimon.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","name","level"})
public class DigimonVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	
	@JsonProperty("name_digimon")
	private String name;
	
	@JsonProperty("level_digimon")
	private String level;
	
	
	public DigimonVO() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, level, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DigimonVO other = (DigimonVO) obj;
		return Objects.equals(id, other.id) && Objects.equals(level, other.level) && Objects.equals(name, other.name);
	}



	
	
	

	
}

package br.com.botapi.bot.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.botapi.bot.entity.Bots;

public class BotsDto {

	private Long idBost;
	private String nameBost;

	public BotsDto(Bots bots) {
		this.idBost = bots.getIdBost();
		this.nameBost = bots.getNameBost();
	}

	public Long getIdBost() {
		return idBost;
	}

	public void setIdBost(Long idBost) {
		this.idBost = idBost;
	}

	public String getNameBost() {
		return nameBost;
	}

	public void setNameBost(String nameBost) {
		this.nameBost = nameBost;
	}

	public static List<BotsDto> convert(List<Bots> bots) {
		return  bots.stream().map(BotsDto::new).collect(Collectors.toList());
	}

}

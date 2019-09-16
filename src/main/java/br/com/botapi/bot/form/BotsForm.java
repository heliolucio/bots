package br.com.botapi.bot.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.botapi.bot.entity.Bots;

public class BotsForm {

	@NotNull
	@NotEmpty
	private Long idBost;

	@NotNull
	@NotBlank
	private String nameBost;

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

	public Bots convert() {
		return new Bots(idBost, nameBost);
	}

}

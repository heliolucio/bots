package br.com.botapi.bot.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.botapi.bot.entity.Bots;
import br.com.botapi.bot.repository.BotsRepository;

public class AtualizarBotsForm {

	@NotNull
	@NotBlank
	private String nameBost;

	public String getNameBost() {
		return nameBost;
	}

	public void setNameBost(String nameBost) {
		this.nameBost = nameBost;
	}

	public Bots atualizar(Long id, BotsRepository botsRepository) {
		Bots bots = botsRepository.getOne(id);

		bots.setNameBost(this.getNameBost());
		return bots;
	}

}

package br.com.botapi.bot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_bots")
public class Bots implements Serializable {

	private static final long serialVersionUID = -3838032641234848663L;

	private Long idBost;
	private String nameBost;
	private List<Mensagem> mensagem = new ArrayList<>();

	public Bots() {
		super();
	}

	public Bots(Long idBost, String nameBost) {
		this.idBost = idBost;
		this.nameBost = nameBost;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bost")
	public Long getIdBost() {
		return idBost;
	}

	public void setIdBost(Long idBost) {
		this.idBost = idBost;
	}

	@Column(name = "name_bost")
	public String getNameBost() {
		return nameBost;
	}

	public void setNameBost(String nameBost) {
		this.nameBost = nameBost;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "from")
	public List<Mensagem> getMensagem() {
		return mensagem;
	}

	public void setMensagem(List<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}

}

package br.com.botapi.bot.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.botapi.bot.entity.Mensagem;

public class MensagemDto {

	private Long idMessage;
	private Long conversationId;
	private Date timestamp;
	private Long from;
	private Long to;
	private String text;
	
	

	public MensagemDto(Mensagem mensagens) {
		this.idMessage = mensagens.getIdMessage();
		this.conversationId = mensagens.getConversationId();
		this.timestamp = mensagens.getTimestamp();
		this.from = mensagens.getFrom().getIdBost();
		this.to = mensagens.getTo();
		this.text = mensagens.getText();
	}

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	public Long getConversationId() {
		return conversationId;
	}

	public void setConversationId(Long conversationId) {
		this.conversationId = conversationId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static List<MensagemDto> convert(List<Mensagem> mensagem) {
		return mensagem.stream().map(MensagemDto::new).collect(Collectors.toList());
	}

}

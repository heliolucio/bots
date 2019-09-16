package br.com.botapi.bot.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.botapi.bot.entity.Bots;
import br.com.botapi.bot.entity.Mensagem;

public class MensagemForm {

	@NotNull
	@NotEmpty
	private Long conversationId;
	@NotNull
	@NotEmpty
	private Date timestamp;
	@NotNull
	@NotEmpty
	private Bots from;
	@NotNull
	@NotEmpty
	private Long to;
	@NotNull
	@NotEmpty
	private String text;

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

	public Bots getFrom() {
		return from;
	}

	public void setFrom(Bots from) {
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

	public Mensagem convert() {
		return new Mensagem(conversationId, timestamp, from, to, text);
	}

}

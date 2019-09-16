package br.com.botapi.bot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_message")
public class Mensagem implements Serializable {

	private static final long serialVersionUID = -3489720754328134454L;

	private Long idMessage;
	private Long conversationId;
	private Date timestamp;
	private Bots from;
	private Long to;
	private String text;

	public Mensagem() {
		super();
	}

	public Mensagem(Long conversationId, Date timestamp, Bots from, Long to, String text) {
		this.conversationId = conversationId;
		this.timestamp = timestamp;
		this.from = from;
		this.to = to;
		this.text = text;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_message")
	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	@Column(name = "conversation_id")
	public Long getConversationId() {
		return conversationId;
	}

	public void setConversationId(Long conversationId) {
		this.conversationId = conversationId;
	}

	@Column(name = "timestamp_message")
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "to_message")
	public Long getTo() {
		return to;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_bost")
	public Bots getFrom() {
		return from;
	}

	public void setFrom(Bots from) {
		this.from = from;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	@Column(name = "text_message")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}

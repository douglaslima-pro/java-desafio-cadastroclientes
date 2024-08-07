package edu.douglaslima.cadastroclientes.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cliente_telefone")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telefone_id")
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	@JsonIgnoreProperties("telefones")
	private Cliente cliente; // chave estrangeira da entidade Cliente
	@Column(columnDefinition = "CHAR(2) NOT NULL")
	private String ddd;
	@Column(length = 5, nullable = false)
	private String prefixo;
	@Column(columnDefinition = "CHAR(4) NOT NULL")
	private String sufixo;
	
	public Telefone() {
		
	}
	
	public Telefone(String ddd, String prefixo, String sufixo) {
		this.ddd = ddd;
		this.prefixo = prefixo;
		this.sufixo = sufixo;
	}
	
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", cliente=" + cliente + ", ddd=" + ddd + ", prefixo=" + prefixo + ", sufixo="
				+ sufixo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}

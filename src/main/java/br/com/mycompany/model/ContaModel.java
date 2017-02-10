package br.com.mycompany.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="tb_conta")
@Entity
public class ContaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="cpf")
	private long cpf;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nroconta")
	private int nroconta;
	
	@Column(name="saldo")
	private BigDecimal saldo;
	
	@Transient 
	private int nrocontadest;
	
	@Transient 
	private BigDecimal valtransf;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNroconta() {
		return nroconta;
	}

	public void setNroconta(int nroconta) {
		this.nroconta = nroconta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public int getNrocontadest() {
		return nrocontadest;
	}

	public void setNrocontacest(int nrocontadest) {
		this.nrocontadest = nrocontadest;
	}

	public BigDecimal getValtransf() {
		return valtransf;
	}

	public void setValtransf(BigDecimal valtransf) {
		this.valtransf = valtransf;
	}

}

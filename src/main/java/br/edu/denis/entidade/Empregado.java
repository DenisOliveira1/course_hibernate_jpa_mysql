package br.edu.denis.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_EMPREGADOS")

public class Empregado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//variaveis
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)//gera id automaticamente. mysql usa identity..na tabela deve ter esse atributo com auto increment e primary key
	@Column(name = "COD_EMPREGADO")
	private int codigo;
	
	@Column(name = "SOBRENOME")
	private String sobrenome;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DATA_NASCIMENTO")
	private Date dataNascimento;
	
	//construtor
	public Empregado(){
		
	}
	
	public Empregado(String sobrenome, String nome, Date dataNascimento) {
		super();
		this.sobrenome = sobrenome;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	//getters e setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Empregado [codigo=" + codigo + ", sobrenome=" + sobrenome + ", nome=" + nome + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
	
	
	
}

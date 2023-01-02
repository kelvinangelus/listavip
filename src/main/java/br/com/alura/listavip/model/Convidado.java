package br.com.alura.listavip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "convidados") //Nome da tabela
public class Convidado {

	//É necessário ter o construtor padrão (não sei por quê)
	public Convidado() {
		
	}
	
	public Convidado(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	@Id 			 //Chave primária
	@GeneratedValue  //Autoincrementado
	private long id; 
	
	private  String nome;
	
	private String email;
	
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}

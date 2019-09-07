/**
 * 
 */
package br.edu.jati5.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario")
public class Usuario extends Entidade{

	@Column(nullable = false)
	private String nome;
	@Column(unique = true, nullable = false)
	private String login;
	@Column(nullable = false)
	private String senha;
	
	@Transient
	private List<Pesquisa> pesquisas;

	public String getNome() {return nome;}
	public String getLogin() {return login;}
	public String getSenha() {return senha;}
	public List<Pesquisa> getPesquisas() {return pesquisas;}

	public void setNome(String nome) {this.nome = nome;}
	public void setLogin(String login) {this.login = login;}
	public void setSenha(String senha) {this.senha = senha;}
	public void setPesquisas(List<Pesquisa> pesquisas) {this.pesquisas = pesquisas;}
		
}

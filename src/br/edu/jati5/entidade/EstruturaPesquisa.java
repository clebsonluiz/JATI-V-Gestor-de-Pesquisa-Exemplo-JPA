
package br.edu.jati5.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "estrutura_pesquisa")
@NamedQuery(name = "Estrutura.pesquisa", query = "select e from EstruturaPesquisa as e where e.ativado = true and e.pesquisa = :pesquisa")
public class EstruturaPesquisa extends Entidade{

	@Column(nullable = false)
	private String titulo_estrutura;
	@Column(nullable = true)
	private String col_1_nome_familia;
	@Column(nullable = false)
	private String col_2_nome;
	@Column(nullable = false)
	private String col_3_valor;
	@Column(nullable = false)
	private String categoria_dados;
	@ManyToOne
	@JoinColumn(name = "pesquisa_id", nullable = false)
	private Pesquisa pesquisa;
	
	@Transient
	private List<Dado> dados;
	
	public String getCol_1_nome_familia() {return col_1_nome_familia;}
	public String getCol_2_nome() {return col_2_nome;}
	public String getCol_3_valor() {return col_3_valor;}
	public String getCategoria_dados() {return categoria_dados;}
	public String getTitulo_estrutura() {return titulo_estrutura;}
	public List<Dado> getDados() {return dados;}

	public Pesquisa getPesquisa() {return pesquisa;}
	
	public void setPesquisa(Pesquisa pesquisa) {this.pesquisa = pesquisa;}
	public void setCol_1_nome_familia(String col_1_nome_familia) {this.col_1_nome_familia = col_1_nome_familia;}
	public void setCol_2_nome(String col_2_nome) {this.col_2_nome = col_2_nome;}
	public void setCol_3_valor(String col_3_valor) {this.col_3_valor = col_3_valor;}
	public void setCategoria_dados(String categoria_dados) {this.categoria_dados = categoria_dados;}
	public void setTitulo_estrutura(String titulo_estrutura) {this.titulo_estrutura = titulo_estrutura;}
	public void setDados(List<Dado> dados) {this.dados = dados;}
	
}


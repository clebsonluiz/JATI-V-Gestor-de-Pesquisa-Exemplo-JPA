package br.edu.jati5.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "dado")
@NamedQuery(name = "Dado.estrutura", query = "select d from Dado as d where d.ativado = true and d.estruturaPesquisa = :estrutura")
public class Dado extends Entidade{

	@Column
	private String col_1_nome_familia;
	
	@Column
	private String col_2_nome;
	
	@Column
	private String col_3_valor;
	
	@ManyToOne
	@JoinColumn(name = "estrutura_pesquisa_id")
	private EstruturaPesquisa estruturaPesquisa;
	
	public String getCol_1_nome_familia() {return col_1_nome_familia;}
	public String getCol_2_nome() {return col_2_nome;}
	public String getCol_3_valor() {return col_3_valor;}

	public EstruturaPesquisa getEstruturaPesquisa() {return estruturaPesquisa;}
	
	public void setCol_1_nome_familia(String col_1_nome_familia) {this.col_1_nome_familia = col_1_nome_familia;}
	public void setCol_2_nome(String col_2_nome) {this.col_2_nome = col_2_nome;}
	public void setCol_3_valor(String col_3_valor) {this.col_3_valor = col_3_valor;}
	public void setEstruturaPesquisa(EstruturaPesquisa estruturaPesquisa) {this.estruturaPesquisa = estruturaPesquisa;}
	
	
	
}

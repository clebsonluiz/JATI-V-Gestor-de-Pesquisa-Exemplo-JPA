package br.edu.jati5.entidade;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pesquisa")
@NamedQuery(name = "Pesquisa.pessoa", query = "select p from Pesquisa as p where p.ativado = true and p.usuario = :usuario")
public class Pesquisa extends Entidade{

	@Column(nullable = false)
	private String titulo;
	@Column
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	@Column(name = "data_inicio", nullable = false)
	private LocalDate dataInicio;
	@Column(name = "data_fim", nullable = false)
	private LocalDate dataFim;
	
	@Transient
	private List<EstruturaPesquisa> estruturaPesquisas;
	
	public String getTitulo() {return titulo;}
	public String getDescricao() {return descricao;}
	public Usuario getUsuario() {return usuario;}
	public LocalDate getDataInicio() {return dataInicio;}
	public LocalDate getDataFim() {return dataFim;}
	public List<EstruturaPesquisa> getEstruturaPesquisas() {return estruturaPesquisas;}

	public void setTitulo(String titulo) {this.titulo = titulo;}
	public void setDescricao(String descricao) {this.descricao = descricao;}
	public void setUsuario(Usuario usuario) {this.usuario = usuario;}
	public void setDataInicio(LocalDate dataInicio) {this.dataInicio = dataInicio;}
	public void setDataFim(LocalDate dataFim) {this.dataFim = dataFim;}
	public void setEstruturaPesquisas(List<EstruturaPesquisa> estruturaPesquisas) {this.estruturaPesquisas = estruturaPesquisas;}
	
}

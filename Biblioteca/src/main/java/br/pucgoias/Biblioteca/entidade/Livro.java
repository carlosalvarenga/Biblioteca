package br.pucgoias.Biblioteca.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que representa os dados persistentes do livro
 * 
 * @author Carlos
 *
 */

/*
 * Entity-> é utilizado para informar que uma classe também é uma entidade, onde os dados serão persistidos.
 * Id -> Marca o atributo como identificador.
 * GeneratedValue-> é utilizado para informar que a geração do valor do identificador único será gerenciada pelo provedor persistencia.
 *Column -> é utilizado para especificar os detalhes da coluna que um campo será mapeado.
 */
@Entity
@Table(name = "Livro")

public class Livro implements Serializable {

	private static final long serialVersionUID = 6487849002108370775L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome_livro")
	private String nome_livro;

	@Column(name = "assunto")
	private String assunto;

	@Column(name = "numero_pagina")
	private int numero_pagina;

	@Column(name = "data_inicio ")
	private Date data_inicio;

	@Column(name = "data_entrega")
	private Date data_entrega;

	@Column(name = "preco")
	private float preco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_livro() {
		return nome_livro;
	}

	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public int getNumero_pagina() {
		return numero_pagina;
	}

	public void setNumero_pagina(int numero_pagina) {
		this.numero_pagina = numero_pagina;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(Date data_entrega) {
		this.data_entrega = data_entrega;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

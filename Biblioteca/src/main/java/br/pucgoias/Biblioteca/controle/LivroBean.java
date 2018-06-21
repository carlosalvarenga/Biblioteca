package br.pucgoias.Biblioteca.controle;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * Classe que representa o formulario web de Livro
 * 
 * @author Carlos
 * 
 * 
 */

/*
Component-> serve para indicar ao framework que  essa classe é um bean e deverá ser administrado pela implementação do contener.
*/
@Component
public class LivroBean {

	private Integer id;
	private String nome_livro;
	private String assunto;
	private int numero_pagina;
	private Date data_inicio;
	private Date data_entrega;
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

}

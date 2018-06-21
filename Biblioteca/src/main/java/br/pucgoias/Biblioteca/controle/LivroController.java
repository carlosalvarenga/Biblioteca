package br.pucgoias.Biblioteca.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.pucgoias.Biblioteca.controle.LivroBean;
import br.pucgoias.Biblioteca.entidade.Livro;
import br.pucgoias.Biblioteca.controle.LivroBean;
import br.pucgoias.Biblioteca.negocio.LivroService;
import br.pucgoias.Biblioteca.controle.LivroBean;
import br.pucgoias.Biblioteca.entidade.Livro;
import br.pucgoias.Biblioteca.util.BibliotecaException;

import br.pucgoias.Biblioteca.controle.LivroBean;

/**
 * Classe que controla as requisicoes do cliente web
 * 
 * @author Carlos
 *
 */
/**/
 
/* ManagedBean-> Delega a função  para o controller trabalhar com o bean e trabalhar com a view(alterar, deletar,salvar).
* RequestScoped -> server para criar um novo objeto  a cada requisição  relizado pelo úsuario.
* Controller -> essa anotação fará com que o spring reconheça a  classe como um controlador 
*Autowired ->  essa anotação que fornece controle sobre onde e como a ligação entre a bean deve ser realizada */

@ManagedBean(name = "livroController")
@RequestScoped
@Controller

public class LivroController {

	@Autowired
	private LivroBean livroBean;
	@Autowired
	private List<LivroBean> listaLivroBean;
	@Autowired
	private LivroService livroService;

	/**
	 * Construtor da classe de Livro
	 */
	@SuppressWarnings("unchecked")
	public LivroController() {
		livroBean = new LivroBean();
	}

	/**
	 * Inclui um livro na base de dados
	 * 
	 * @return
	 */
	public String incluir() {
		try {
			Livro livro = new Livro();

			// preenche os dados da tela no objeto persistente
			livro.setId(livroBean.getId());
			livro.setNome_livro(livroBean.getNome_livro());
			livro.setAssunto(livroBean.getAssunto());
			livro.setNumero_pagina(livroBean.getNumero_pagina());
			livro.setData_inicio(livroBean.getData_inicio());
			livro.setData_entrega(livroBean.getData_entrega());
			livro.setPreco(livroBean.getPreco());

			getLivroService().incluir(livro);

			return "sucesso";
		} catch (Exception e) {
			String msg = "Inclusao nao realizada. Motivo: " + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Lista os filmes cadastrados
	 * 
	 * @return
	 */
	public String listar() {
		try {

			List<Livro> listaLivro = getLivroService().listar();

			if (listaLivro == null || listaLivro.size() == 0) {
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
			}

			// preeche a lista de Livros da tela
			listaLivroBean = new ArrayList<LivroBean>();
			for (Livro livro : listaLivro) {
				LivroBean livroBean = new LivroBean();
				livroBean.setId(livro.getId());
				livroBean.setNome_livro(livro.getNome_livro());
				livroBean.setAssunto(livro.getAssunto());
				livroBean.setNumero_pagina(livro.getNumero_pagina());
				livroBean.setData_inicio(livro.getData_inicio());
				livroBean.setData_entrega(livro.getData_entrega());
				livroBean.setPreco(livro.getPreco());

				listaLivroBean.add(livroBean);
			}

			return "listar";
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Listagem nao realizada. Movito: "
					+ ((e instanceof BibliotecaException ? ((BibliotecaException) e).getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Consulta um livro cadastrado
	 * 
	 * @return
	 */
	public String consultar() {
		try {

			String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

			Livro livro = getLivroService().consultar(Integer.valueOf(id));
			if (livro == null || livro.getId() == null) {
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}

			// preenche os dados do bean da tela
			
			livroBean.setId(livro.getId());
			livroBean.setNome_livro(livro.getNome_livro());
			livroBean.setAssunto(livro.getAssunto());
			livroBean.setNumero_pagina(livro.getNumero_pagina());
			livroBean.setData_inicio(livro.getData_inicio());
			livroBean.setData_entrega(livro.getData_entrega());
			livroBean.setPreco(livro.getPreco());

			return "editar";
		} catch (Exception e) {
			String msg = "Consulta nao realizada. Movito: " + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Cria um  novo livro
	 * 
	 * @return
	 */
	public String criar() {
		try {

			livroBean = new LivroBean();

			return "criar";
		} catch (Exception e) {
			String msg = "Criacao nao realizada. Movito: " + e.getMessage();
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Exclui um livro cadastrado
	 * 
	 * @return
	 */
	public String excluir() {
		try {

			String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

			Livro Livro = getLivroService().consultar(Integer.valueOf(id));

			if (Livro == null || Livro.getId() == null) {
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);
				return "listar";
			}
			getLivroService().excluir(Livro.getId());

			return "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "Exclusao nao realizada. Movito: "
					+ ((e instanceof BibliotecaException ? ((BibliotecaException) e).getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	/**
	 * Exclui um livro cadastrado
	 * 
	 * @return
	 */
	public String alterar() {
		try {

			Livro livro = getLivroService().consultar(livroBean.getId());

			if (livro == null || livro.getId() == null) {
				FacesMessage message = new FacesMessage("Nenhum registro encontrado.");
				this.getFacesContext().addMessage("formulario", message);

				return "listar";
			}

			// preenche os dados da tela no objeto persistente

			
			livro.setId(livroBean.getId());
			livro.setNome_livro(livroBean.getNome_livro());
			livro.setAssunto(livroBean.getAssunto());
			livro.setNumero_pagina(livroBean.getNumero_pagina());
			livro.setData_inicio(livroBean.getData_inicio());
			livro.setData_entrega(livroBean.getData_entrega());
			livro.setPreco(livroBean.getPreco());

			getLivroService().alterar(livro);
			return "sucesso";

		} catch (Exception e) {
			String msg = "Alteracao nao realizada. Movito: "
					+ ((e instanceof BibliotecaException ? ((BibliotecaException) e).getEx().getMessage() : ""));
			FacesMessage message = new FacesMessage(msg);
			this.getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}

	public LivroBean getLivroBean() {
		return livroBean;
	}

	public void setLivroBean(LivroBean livroBean) {
		this.livroBean = livroBean;
	}

	public List<LivroBean> getListaLivroBean() {
		return listaLivroBean;
	}

	public void setListaLivroBean(List<LivroBean> listaLivroBean) {
		this.listaLivroBean = listaLivroBean;
	}

	public LivroService getLivroService() {
		return livroService;
	}

	public void setLivroService(LivroService livroService) {
		this.livroService = livroService;
	}

	private Object getSession(String variavel) {
		return this.getFacesContext().getExternalContext().getSessionMap().get(variavel);
	}

	private FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	private void setSession(String variavel, Object objeto) {
		this.getFacesContext().getExternalContext().getSessionMap().put(variavel, objeto);
	}
}

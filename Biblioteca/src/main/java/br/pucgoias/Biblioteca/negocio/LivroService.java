package br.pucgoias.Biblioteca.negocio;

import java.util.List;

import br.pucgoias.Biblioteca.entidade.Livro;
import br.pucgoias.Biblioteca.util.BibliotecaException;

/**
 * Interface que define as operacoes da camada de negocio de Livro
 * 
 * @author Carlos
 *
 */
public interface LivroService {

	/**
	 * Inclui um Livro
	 * 
	 * @param Livro
	 * @return
	 * @throws BibliotecaException
	 */
	public Livro incluir(Livro livro) throws BibliotecaException;

	/**
	 * Altera um Livro
	 * 
	 * @param Livro
	 * @return
	 * @throws AgendaException
	 */
	public Livro alterar(Livro livro) throws BibliotecaException;

	/**
	 * Exclui um Livro
	 * 
	 * @param id
	 * @throws BibliotecaException
	 */
	public void excluir(Integer id) throws BibliotecaException;

	/**
	 * Consulta um Livro pelo identificador
	 * 
	 * @param id
	 * @return
	 * @throws BibliotecaException
	 */
	public Livro consultar(Integer id) throws BibliotecaException;

	/**
	 * Lista todos os Livros cadastrados
	 * 
	 * @return
	 * @throws AgendaException
	 */
	public List<Livro> listar() throws BibliotecaException;

}

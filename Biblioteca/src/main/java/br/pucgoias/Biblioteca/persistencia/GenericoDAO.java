package br.pucgoias.Biblioteca.persistencia;

import java.io.Serializable;
import java.util.List;

import br.pucgoias.Biblioteca.util.BibliotecaException;

/**
 * Interface que define as operacoes da camada de persistencia generica
 * 
 * @author Carlos
 *
 */
public interface GenericoDAO<T, ID extends Serializable> {

	/**
	 * Retorna a classe a ser persistida
	 * 
	 * @return
	 */
	public Class<T> getObjectClass();

	/**
	 * Inclui um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws AgendaException
	 */
	public T incluir(T object) throws BibliotecaException;

	/**
	 * Altera um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws AgendaException
	 */
	public T alterar(T object) throws BibliotecaException;

	/**
	 * Consulta um objeto T da base de dados
	 * 
	 * @param id
	 * @return
	 * @throws AgendaException
	 */
	public T consultar(Integer id) throws BibliotecaException;

	/**
	 * Exclui um objeto T da base de dados
	 * 
	 * @param id
	 * @throws AgendaException
	 */
	public void excluir(Integer id) throws BibliotecaException;

	/**
	 * Lista os objetos T da base de dados
	 * 
	 * @return
	 * @throws AgendaException
	 */
	public List<T> listar() throws BibliotecaException;
}

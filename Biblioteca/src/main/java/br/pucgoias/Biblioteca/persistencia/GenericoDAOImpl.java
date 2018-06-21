package br.pucgoias.Biblioteca.persistencia;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.pucgoias.Biblioteca.util.BibliotecaException;

/**
 * Classe que define as operacoes da camada de persistencia generica
 * 
 * @author Carlos
 *
 */
public class GenericoDAOImpl<T, ID extends Serializable> implements GenericoDAO<T, ID> {

	private EntityManager entityManager;
	private final Class<T> oClass;

	// Classe a ser persistida
	public Class<T> getObjectClass() {
		return this.oClass;
	}

	// Gerenciador de persistencia
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(unitName = "Biblioteca")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public GenericoDAOImpl() {
		this.oClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Inclui um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws AgendaException
	 */
	public T incluir(T object) throws BibliotecaException {
		try {
			getEntityManager().merge(object);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BibliotecaException(e, "Não foi possível realizar a inclusão.");
		}
		return object;
	}

	/**
	 * Altera um objeto T na base de dados
	 * 
	 * @param object
	 * @return
	 * @throws AgendaException
	 */
	public T alterar(T object) throws BibliotecaException {
		try {
			getEntityManager().merge(object);
		} catch (Exception e) {
			throw new BibliotecaException(e, "Não foi possível realizar a alteração.");
		}
		return object;
	}

	/**
	 * Consulta um objeto T da base de dados
	 * 
	 * @param id
	 * @return
	 * @throws AgendaException
	 */
	public T consultar(Integer id) throws BibliotecaException {
		T object = null;
		try {
			object = getEntityManager().find(getObjectClass(), id);
		} catch (EntityNotFoundException e) {
			throw new BibliotecaException(e, "Registro não encontrado.");
		} catch (Exception e) {
			throw new BibliotecaException(e, "Não foi possível realizar a consulta.");
		}
		return object;
	}

	/**
	 * Exclui um objeto T da base de dados
	 * 
	 * @param id
	 * @throws AgendaException
	 */
	public void excluir(Integer id) throws BibliotecaException {
		try {
			getEntityManager().remove(getEntityManager().getReference(getObjectClass(), id));
		} catch (EntityNotFoundException e) {
			throw new BibliotecaException(e, "Registro não encontrado para exclusão.");
		} catch (Exception e) {
			throw new BibliotecaException(e, "Não foi possível realizar a exclusão.");
		}

	}

	/**
	 * Lista os objetos T da base de dados
	 * 
	 * @return
	 * @throws AgendaException
	 */
	@SuppressWarnings("unchecked")
	public List<T> listar() throws BibliotecaException {
		List<T> lista = null;
		try {
			Query query = getEntityManager()
					.createQuery("SELECT object(o) FROM " + getObjectClass().getSimpleName() + " AS o");
			lista = query.getResultList();
		} catch (Exception e) {
			throw new BibliotecaException(e, "Problemas na localização dos objetos");
		}
		return lista;
	}

}

package br.pucgoias.Biblioteca.negocio;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.pucgoias.Biblioteca.entidade.Livro;
import br.pucgoias.Biblioteca.persistencia.LivroDAO;

import br.pucgoias.Biblioteca.util.BibliotecaException;

/**
 * Classe que define as operacoes da camada de negocio de Livro
 * 
 * @author Carlos
 *
 */
@Service
@Transactional
public class LivroServiceImpl implements LivroService {

	// Interface da persistencia
	private LivroDAO livroDAO;

	public LivroDAO getLivroDAO() {
		return livroDAO;
	}

	@Autowired
	public void setLivroDAO(LivroDAO livroDAO) {
		this.livroDAO = livroDAO;
	}

	/**
	 * Inclui um livro
	 * 
	 * @param livro
	 * @return
	 * @throws AgendaException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Livro incluir(Livro livro) throws BibliotecaException {
		return getLivroDAO().incluir(livro);
	}

	/**
	 * Altera um livro
	 * 
	 * @param livro
	 * @return
	 * @throws AgendaException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Livro alterar(Livro livro) throws BibliotecaException {

		// exclui os itens da base que foram removidos da tela
		Livro livroExistente = this.consultar(livro.getId());

		return getLivroDAO().alterar(livro);
	}

	/**
	 * Exclui um livro
	 * 
	 * @param livro
	 * @throws AgendaException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excluir(Integer id) throws BibliotecaException {

		// exclui todos os itens antes de excluir a pessoa
		Livro livroExistente = this.consultar(id);

		getLivroDAO().excluir(id);
	}

	/**
	 * Lista todos os livros cadastrados
	 * 
	 * @return
	 * @throws AgendaException
	 */
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Livro> listar() throws BibliotecaException {
		return getLivroDAO().listar();
	}

	@Override
	public Livro consultar(Integer id) throws BibliotecaException {
		Livro livro = getLivroDAO().consultar(id);
		return livro;
	}

}

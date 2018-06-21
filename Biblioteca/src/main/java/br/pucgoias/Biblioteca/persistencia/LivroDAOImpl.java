package br.pucgoias.Biblioteca.persistencia;

import org.springframework.stereotype.Repository;

import br.pucgoias.Biblioteca.entidade.Livro;

/**
 * Classe que define as operacoes da camada de persistencia de Livro
 * 
 * @author Gilcimar
 *
 */
@Repository
public class LivroDAOImpl extends GenericoDAOImpl<Livro, Integer> implements LivroDAO {

}

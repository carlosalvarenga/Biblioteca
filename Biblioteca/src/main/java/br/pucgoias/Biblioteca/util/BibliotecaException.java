package br.pucgoias.Biblioteca.util;

/**
 * Classe que encapsula as excecoes da aplicacao Agenda
 * @author Carlos
 *
 */
public class BibliotecaException extends Exception {
	
	private static final long serialVersionUID = 1189188521388183949L;
	private Exception ex;
	private String msg;

	public BibliotecaException(Exception e){
		ex = e;
		msg = e.getMessage();
	}

	public BibliotecaException(Exception e, String mensagem){
		e.printStackTrace();
		ex = e;
		msg = mensagem;
	}

	public Exception getEx() {
		return ex;
	}

	public String getMsg() {
		return msg;
	}
	
}

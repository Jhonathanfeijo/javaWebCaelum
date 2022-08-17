package br.com.caelum.agenda.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.agenda.Contato;
import br.com.caelum.agenda.ContatoDAO;

public class TesteAdicionaDAO {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("nome");
		contato.setEndereco("endereco");
		contato.setEmail("email");
		contato.setDataNascimento(Calendar.getInstance());
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		System.out.println("Teste efetivado com sucesso!");
	}
}

package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.Contato;
import br.com.caelum.agenda.ContatoDAO;

public class RemoveContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		ContatoDAO dao = new ContatoDAO();
		dao.remove(contato);
		System.out.println("Excluindo Contato....");
		return "lista-contatos.jsp";
	}
	
}

package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
			System.out.println("Executando logica...");
			System.out.println("Retomando o nome da Pagina JSP....");
			return "primeira-logica.jsp";
	}

}

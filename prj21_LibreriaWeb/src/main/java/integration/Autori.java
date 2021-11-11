package integration;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AutoreDAOImpl;
import model.Autore;

/**
 * Servlet implementation class Autori
 */
@WebServlet("/api/autori")
public class Autori extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AutoreDAOImpl repo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autori() {
        super();
        repo = new AutoreDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Autore> autori = this.repo.getAutori();
		
		if (request.getParameter("id") != null) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			/*
			 * operatore ternario - if in una sola riga
			 * (condizione) ? true : false;
			 */
			
			id = (id > 0 && id < repo.getAutori().size()) ? id : 1;
			Autore autore = repo.getAutoreByID(id);
			response.getWriter().append(autore.toString());	
			
		} else {
			response.getWriter().append(autori.toString());			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("nome") != null) {
			
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String nazionalita = request.getParameter("nazionalita");
			
			Autore autore = new Autore();
			autore.setNome(nome);
			autore.setCognome(cognome);
			autore.setNazionalita(nazionalita);
			
			this.repo.addAutore(autore);
		}
		
		doGet(request, response);
	}

}

package integration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BabboDAO;
import dao.BabboDAOImpl;
import dao.ConsegnaDAO;
import dao.ConsegnaDAOImpl;
import dao.DonoDAO;
import dao.DonoDAOImpl;
import model.Babbo;
import model.Consegna;
import model.Dono;

/**
 * Servlet implementation class Babbi
 */
@WebServlet("/api/babbi")
public class Babbi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BabboDAO repo;
    private DonoDAO repoDono;
    private ConsegnaDAO repoConsegna;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Babbi() {
        super();
        this.repo = new BabboDAOImpl();
        this.repoDono = new DonoDAOImpl();
        this.repoConsegna = new ConsegnaDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<Babbo> babbi = this.repo.getBabbi();
			response.getWriter().append(babbi.toString());
			
			response.getWriter().append(this.repoDono.getDoni().toString());
			
			response.getWriter().append(this.repoConsegna.getConsegne().toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Dono d = new Dono();
		d.setDesc("ps4");
		
		Dono d2 = new Dono();
		d2.setDesc("switch");
		
		Babbo b = new Babbo();
		b.setNome("babbo1");
		b.setPassword("password");
		
		Babbo b2 = new Babbo();
		b2.setNome("babbo2");
		b2.setPassword("password2");
		
		Consegna consegna1 = new Consegna();
		consegna1.setBabbo(b);
		consegna1.setDono(d);
		consegna1.setBambino("ali");
		

		Consegna consegna2 = new Consegna();
		consegna2.setBabbo(b2);
		consegna2.setDono(d);
		consegna2.setBambino("ali");

		
		Consegna consegna3 = new Consegna();
		consegna3.setBabbo(b);
		consegna3.setDono(d2);
		consegna3.setBambino("pippo");

		Consegna consegna4 = new Consegna();
		consegna4.setBabbo(b);
		consegna4.setDono(d);
		consegna4.setBambino("ali");

		try {
			this.repo.addBabbo(b);
			this.repo.addBabbo(b2);
			
			
			this.repoDono.addDono(d);
			this.repoDono.addDono(d2);
			
			this.repoConsegna.addConsegna(consegna1);
			this.repoConsegna.addConsegna(consegna2);
			this.repoConsegna.addConsegna(consegna3);
			this.repoConsegna.addConsegna(consegna4);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}

}

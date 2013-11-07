

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionEtudiant
 */
public class GestionEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	  manage.ManageEtudiantRemote me;
    public GestionEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String go = request.getParameter("formu");
		
		Date date = new Date();
		if(go.equals("formu")){
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String motDePass = request.getParameter("motDePass");
			int mois = Integer.parseInt(request.getParameter("mois"));
			int annee = Integer.parseInt(request.getParameter("annee"));
			int jour = Integer.parseInt(request.getParameter("jour"));
			date.setMonth(mois);
			date.setYear(annee);
			date.setDate(jour);
			try{
				Map<String, Object> result = me.create(nom, prenom, date, motDePass);
				System.out.println(result.get("code"));
				request.setAttribute("etat", "ok");
                request.getRequestDispatcher("/formEtudiant.jsp").forward(request, response);
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
			
		}
	}

}
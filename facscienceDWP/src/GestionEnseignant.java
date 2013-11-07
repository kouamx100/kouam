

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class GestionEnseignant
 */
public class GestionEnseignant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	 manage.ManageEnsRemote me;
    public GestionEnseignant() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String go = request.getParameter("formu");
		if(go.equals("formu")){
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String motDePass = request.getParameter("motDePass");
			String libelefil = request.getParameter("libelefil");
			
			try{
				Map<String, Object> result = me.create(nom, prenom, libelefil, motDePass);
				System.out.println(result.get("code"));
				request.setAttribute("etat", "ok");
                request.getRequestDispatcher("/formEnseignant.jsp").forward(request, response);
			}catch(Exception ex){
				
			}
		}
		
	}

}
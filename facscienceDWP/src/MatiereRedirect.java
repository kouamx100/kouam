

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Etudiant;
import entity.Matiere;

import manage.ManageEtudiantRemote;
import manage.ManageMatiereRemote;

/**
 * Servlet implementation class MatiereRedirect
 */
public class MatiereRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	  ManageEtudiantRemote me;
	@EJB
	  ManageMatiereRemote mm;
	  
    public MatiereRedirect() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String go=request.getParameter("formu");
		if(go.equals("formu")){
			String code = request.getParameter("matiere");
			try{
				HashMap<String, Object> result = me.findAll();
				HashMap<String, Object> result2 = mm.findByCode(code);
				Matiere matiere = (Matiere) result2.get("data");
				List<Etudiant> etudiants = (List<Etudiant>) result.get("data");
				request.setAttribute("etudiants", etudiants);
				request.setAttribute("matiere", matiere);
				request.getRequestDispatcher("/inscription.jsp").forward(request, response);
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
	}

}
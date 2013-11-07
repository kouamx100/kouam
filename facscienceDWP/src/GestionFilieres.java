
import java.io.IOException;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionFilieres
 */
public class GestionFilieres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@EJB
	manage.ManageFiliereRemote fi;

	public GestionFilieres() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String go = request.getParameter("formu");

		if (go.equals("formu")) {
			String libele = request.getParameter("libele");
			String departement = request.getParameter("departement");
			try {
				
				HashMap<String, Object> result = fi.create(libele, departement);
				System.out.println(result.get("code"));
	
					  System.out.println(result.get("code"));
                      request.setAttribute("etat", "ok");
                      request.getRequestDispatcher("/formFiliere.jsp").forward(request, response);
                      
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
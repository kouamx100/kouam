

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestionMatiere
 */
public class GestionMatiere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	  manage.ManageMatiereRemote ma;
	
    public GestionMatiere() {
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
		String go =request.getParameter("formu");
		if(go.equals("formu")){
			String code = request.getParameter("code");
			String intitule = request.getParameter("intitule");
			int credit = Integer.parseInt(request.getParameter("nombre"));
			String matricule=request.getParameter("matricule");
			System.out.println(matricule);
			try{
			   Map<String, Object>result = ma.create(code, intitule, credit, matricule);
			   System.out.println(result.get("code"));
			   request.setAttribute("etat", "ok");
               request.getRequestDispatcher("/formMatiere.jsp").forward(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

}
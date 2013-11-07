

import java.io.IOException;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageRequetteRemote;

/**
 * Servlet implementation class GestionRequettes
 */
public class GestionRequettes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionRequettes() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB
     ManageRequetteRemote ma;

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
			 String objet = request.getParameter("objet");
			 String matricule = request.getParameter("matricule");
			 String description = request.getParameter("description");
			 String code = request.getParameter("code");
			 
			 try{
				 HashMap<String, Object> result = ma.create(objet, description, matricule, code);
				 System.out.println(result.get("code"));
				 request.setAttribute("etat", "ok");
                 request.getRequestDispatcher("/formRequette.jsp").forward(request, response);
			 }catch(Exception ex){
				 
			 }
		}
	}

}
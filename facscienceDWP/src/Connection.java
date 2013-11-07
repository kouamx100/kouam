

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import entity.Enseignant;

import manage.ManageEnsRemote;


/**
 * Servlet implementation class Connection
 */
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connection() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB
     ManageEnsRemote me;

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
		
		String go = request.getParameter("connection");
		if(go.equals("connection")){
		HttpSession session = request.getSession();	
		String matricule = request.getParameter("matricule");
		String passwd = request.getParameter("passwd");
		
		// S'il n'y a aucun tulisateur dans la bdd, ajouter un utilisateur par défaut
		if (me.count()<=0) {
			me.addDefaultEnseignant();
		}
		if (matricule==null && passwd==null){
			
		}
		// On recherche l'utilisateur dont on a le login et le password
		Map<String, Object> result = me.findEnseignant(matricule, passwd);
		//int etat = Integer.parseInt((String) result.get("code"));
		int etat = Integer.parseInt(result.get("code").toString());
		if(etat==1){
			System.out.println(result.get("code"));
			Enseignant enseignant = (Enseignant)result.get("data");
			session.setAttribute("enseignant", enseignant);
			try{
				request.getRequestDispatcher("/text.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			System.out.println(result.get("code")+"code");
			System.out.println(result.get("errormessage"));
			session.setAttribute("enseignant", -1);
			try{
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}	
	}

}
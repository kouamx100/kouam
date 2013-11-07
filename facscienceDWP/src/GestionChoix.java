

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Matiere;

import manage.ManageMatiereRemote;

/**
 * Servlet implementation class GestionChoix
 */
public class GestionChoix extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	 ManageMatiereRemote ma;
	
    public GestionChoix() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = ma.findAll();
		/*int code = (Integer) result.get("code");
		if(code==1){
		try{*/
			List<Matiere> matieres = (List<Matiere>) result.get("data");
			System.out.println(result.get("code"));
			request.setAttribute("matieres", matieres);
			request.getRequestDispatcher("/choixnote.jsp").forward(request, response);
			
		/*}catch(Exception e){
			e.printStackTrace();
		}
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
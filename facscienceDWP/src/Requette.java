

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageRequetteRemote;

import entity.Requettes;

/**
 * Servlet implementation class Requette
 */
public class Requette extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	 ManageRequetteRemote mr;
    public Requette() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = mr.findAll();
		/*int code = (Integer) result.get("code");
		if(code==1){
		try{*/
			List<Requettes> requettes= (List<Requettes>) result.get("data");
			System.out.println(result.get("code"));
			request.setAttribute("requettes", requettes);
			request.getRequestDispatcher("/requette.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request, response);
	}

}
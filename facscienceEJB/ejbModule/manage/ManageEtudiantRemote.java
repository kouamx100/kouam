package manage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Remote;



@Remote
public interface ManageEtudiantRemote {
	
	public Map<String,Object> create(String nom, String prenom, Date dateNais, String motDePasse);
	public HashMap<String, Object> findAll();
	

}
package manage;
import java.util.HashMap;

import javax.ejb.Remote;

import entity.Filiere;

@Remote
public interface ManageFiliereRemote {
	
	public HashMap<String,Object> create(String libele, String departement);
	public HashMap<String,Object> edit (Filiere filiere);
	public HashMap<String, Object> destroy(String libele);
	public HashMap<String,Object> findByLibele(String libele, String dataresult);
	public HashMap<String, Object> findAll(String dataResult);
	public HashMap<String, Object> count();

}
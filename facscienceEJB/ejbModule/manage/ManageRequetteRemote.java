package manage;
import java.util.HashMap;

import javax.ejb.Remote;

import entity.Requettes;

@Remote
public interface ManageRequetteRemote {
	
	public HashMap<String, Object> create(String objet, String description,
			String matricule, String codeMatiere);
	public HashMap<String, Object> edit(Requettes requette);
	public HashMap<String, Object> destroy(long id);
	public HashMap<String, Object> findAll();
	public HashMap<String,Object> findBycodeMatiere(String code, String dataresult);

}
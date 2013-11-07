package manage;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Remote;

import entity.Matiere;


@Remote
public interface ManageMatiereRemote {
	
	public Map<String,Object> create(String code, String intitule, int credit, String matricule);
	public Map<String, Object> edit(Matiere matiere);
	public HashMap<String, Object> findAll();
	public HashMap<String, Object> destroy(String code);
	public HashMap<String, Object> findByCode(String code);
	public HashMap<String,Object> findByIntitule(String intitule, String dataresult);
	public HashMap<String, Object> count();

}
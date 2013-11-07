package manage;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Remote;

import entity.Enseignant;


@Remote
public interface ManageEnsRemote {

	public Map<String,Object> create(String nom, String prenom,String libelefil,String motDePass);
	public int count();
	public boolean addDefaultEnseignant();
	public HashMap<String,Object> edit (Enseignant enseignant);
	public HashMap<String, Object> destroy(long id);
	public HashMap<String, Object> findAll(String dataresult);
	public HashMap<String, Object> findEnseignant(String matricule,
			String motDePass);
	public HashMap<String,Object> findById(long id, String dataresult);
	
}
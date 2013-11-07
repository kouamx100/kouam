package manage;
import java.util.HashMap;

import javax.ejb.Remote;

@Remote
public interface ManageExamenRemote {
	
	public HashMap<String,Object> create(int note, String session, String codeMatiere, String matriculeEtudiant);

}
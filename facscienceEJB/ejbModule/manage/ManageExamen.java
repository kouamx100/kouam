package manage;


import java.util.HashMap;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Etudiant;
import entity.Examen;
import entity.Matiere;


/**
 * Session Bean implementation class ManageExamen
 */
@Stateless
public class ManageExamen implements ManageExamenRemote {

    /**
     * Default constructor. 
     */
    public ManageExamen() {
        
    }
    @PersistenceContext
     EntityManager em;

	@Override
	public HashMap<String,Object> create(int note, String session, String codeMatiere, String matriculeEtudiant) {
		HashMap<String,Object> result = new HashMap<String, Object>();
		
		Examen examen = new Examen();
		try{
			
			Etudiant etudiant = (Etudiant)em.createQuery("select e from etudiant where e.matricule="+matriculeEtudiant).getSingleResult();
			Matiere matiere = em .find(Matiere.class, codeMatiere);
			examen.setNote(note);
			examen.setSession(session);
			examen.setEtudiant(etudiant);
			examen.setMatiere(matiere);
			examen.setDateExam(new java.util.Date());
			em.persist(examen);
			result.put("code", 1);
		}catch(Exception ex){
			result.put("code", 2);
    		result.put("message", "error when create Examen");
    		result.put("errormessage", ex.getMessage());
			
		}
		return result;
	}

}
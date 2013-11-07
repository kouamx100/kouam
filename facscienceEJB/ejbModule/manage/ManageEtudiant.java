package manage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Etudiant;
import entity.Examen;
import entity.Matiere;
import entity.Requettes;

/**
 * Session Bean implementation class ManageEtudiant
 */
@Stateless
public class ManageEtudiant implements ManageEtudiantRemote {

	/**
	 * Default constructor.
	 */
	public ManageEtudiant() {
	}

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("deprecation")
	public Map<String,Object> create(String nom, String prenom, Date dateNais, String motDePasse) {
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		Collection<Examen> examens = new ArrayList<Examen>();
		Collection<Requettes> requettes = new ArrayList<Requettes>();
		Etudiant etudiant = new Etudiant();
		Date date = new Date();

		try {
			etudiant.setDateNais(dateNais);
			etudiant.setNom(nom);
			etudiant.setMotDePasse(motDePasse);
			etudiant.setPrenom(prenom);
			etudiant.setExament(examens);
			etudiant.setRequettes(requettes);
			
			long id =  (Long) em.createQuery(
					"select count(a) from Etudiant as a ").getSingleResult();
			id+=1;
			//getFirstResult()
			int date1 = date.getYear() + 1900;
			String matricule = "uds-" + date1+"-" + id;
			etudiant.setMatricule(matricule);

			em.persist(etudiant);
			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when create Etudiant");
			result.put("errormessage", ex.getMessage());
		}
		return result;

	}
	
	public HashMap<String, Object> findAll() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unchecked")
			List<Matiere> matieres = em.createQuery(
					"select object(e) from Etudiant as e").getResultList();

			result.put("data", matieres);

			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when finding Etudiant");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}
	

}
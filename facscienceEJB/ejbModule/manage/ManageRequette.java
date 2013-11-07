package manage;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;

import entity.Etudiant;
import entity.Requettes;

/**
 * Session Bean implementation class ManageRequette
 */
@Stateless
public class ManageRequette implements ManageRequetteRemote {

	/**
	 * Default constructor.
	 */
	public ManageRequette() {

	}

	@PersistenceContext
	EntityManager em;

	@Override
	public HashMap<String, Object> create(String objet, String description,
			String matricule, String codeMatiere) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		Requettes requettes = new Requettes();

		try {
			
			Query query = em.createQuery("select object(e) from Etudiant as e where e.matricule = :matricule");
			query.setParameter("matricule", matricule);
			Etudiant etudiant = (Etudiant)query.getSingleResult();
			/*
			 * Matiere matiere =
			 * (Matiere)em.createQuery("select m from Etudiant where m.code="
			 * +codeMatiere).getSingleResult();
			 */
			requettes.setEtudiant(etudiant);
			requettes.setCodeMatiere(codeMatiere);
			requettes.setDescription(description);
			requettes.setObjet(objet);

			em.persist(requettes);
			result.put("code", "1");
		} catch (Exception ex) {
			result.put("code", "2");
			result.put("message", "Error when create a Requette");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	public HashMap<String, Object> edit(Requettes requette) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			em.getTransaction().begin();
			em.merge(requette);
			result.put("code", 1);
			em.getTransaction().commit();
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when editing a requette");
			result.put("errormessage", ex.getMessage());
			em.getTransaction().rollback();
		}
		return result;
	}

	public HashMap<String, Object> destroy(long id) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			em.getTransaction().begin();
			Requettes requette = em.find(Requettes.class, id);
			em.remove(requette);
			result.put("code", 1);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			result.put("code", 2);
			result.put("message", "error when destroy a matiere");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Object> findAll() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			List<Requettes> requettes  = em.createQuery(
					"select object(e) from Matiere as e").getResultList();

			result.put("data", requettes);

			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when finding requettes");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}
	
	public HashMap<String,Object> findBycodeMatiere(String code, String dataresult){
		HashMap<String,Object> result = new HashMap<String, Object>();
		 try{
			 Query query= em.createQuery("select object(o) from Requettes as o where o.codeMatiere= :codeMatiere");
			 query.setParameter("codeMatiere", code);
			 Requettes requette = (Requettes)query.getSingleResult();
			 if("gson".equals(dataresult)){
				 String json = new Gson().toJson(requette);
				 result.put("data", json);
			 }else{
				 result.put("data", requette);
			 }
			 result.put("code", 1);
		 }catch(Exception ex){
			 result.put("code", 2);
			 result.put("message", "error when finding Requette by code matiere");
			 result.put("errormessage", ex.getMessage());
		 }
		 return result;
	}

}
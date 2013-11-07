package manage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;

import entity.Enseignant;
import entity.Filiere;

/**
 * Session Bean implementation class ManageFaculte
 */
@Stateless
public class ManageFiliere implements ManageFiliereRemote {

	public ManageFiliere() {

	}

	@PersistenceContext
	EntityManager em;

	public HashMap<String, Object> create(String libele, String departement) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		Collection<Enseignant> enseignants = new ArrayList<Enseignant>();
		Filiere faculte = new Filiere();

		try {
			faculte.setLibele(libele);
			faculte.setDepartement(departement);
			faculte.setDateCreation(new java.util.Date());
			faculte.setEnseignant(enseignants);
			em.persist(faculte);
			result.put("code", 1);
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when create a faculty");
			result.put("errormessage", ex.getMessage());
		}
		return result;

	}

	public HashMap<String, Object> edit(Filiere filiere) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			em.getTransaction().begin();
			em.merge(filiere);
			result.put("code", 1);
			em.getTransaction().commit();
		} catch (Exception ex) {
			result.put("code", 2);
			result.put("message", "error when editing a filiere");
			result.put("errormessage", ex.getMessage());
			em.getTransaction().rollback();
		}
		return result;
	}

	public HashMap<String, Object> destroy(String libele) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			em.getTransaction().begin();
			Filiere filiere = em.find(Filiere.class, libele);
			em.remove(filiere);
			result.put("code", 1);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			result.put("code", 2);
			result.put("message", "error when destroy a filiere");
			result.put("errormessage", ex.getMessage());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, Object> findAll(String dataResult){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	
    	try{
    		Query query = em.createQuery("select object(o) from Filiere as o");
			List<Filiere> resultList = query.getResultList();
			resultList.size();
			if("gson".equals(resultList)){
				String json = new Gson().toJson(resultList);
				result.put("data", json);
			}else{
				result.put("data", resultList);
			}
			result.put("code", 1);
    	}catch(Exception ex){
    		result.put("code", 2);
    		result.put("massage", "error when finding all filieres");
    		result.put("errormessage", ex.getMessage());
    	}
    	return result;
    }
	
	public HashMap<String,Object> findByLibele(String libele, String dataresult){
		HashMap<String,Object> result = new HashMap<String, Object>();
		 try{
			 Filiere filiere = em.find(Filiere.class, libele);
			 if("gson".equals(dataresult)){
				 String json = new Gson().toJson(filiere);
				 result.put("data", json);
			 }else{
				 result.put("data", filiere);
			 }
			 result.put("code", 1);
		 }catch(Exception ex){
			 result.put("code", 2);
			 result.put("message", "error when finding Filiere by libele");
			 result.put("errormessage", ex.getMessage());
		 }
		 return result;
	}
	
	public HashMap<String, Object> count(){
		HashMap<String, Object> result = new HashMap<String, Object>();
		try{
			int nbre=((Long) em.createQuery(
			"select count(o) from Filiere as o").getSingleResult())
			.intValue();
			result.put("code", 1);
			result.put("data", nbre);
		}catch(Exception Ex){
			result.put("code", 2);
			result.put("message", "error when counting Filiere");
		}
		return result;
	   }
}
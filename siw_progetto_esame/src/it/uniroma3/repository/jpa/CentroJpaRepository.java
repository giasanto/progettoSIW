package it.uniroma3.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import it.uniroma3.model.Centro;
import it.uniroma3.repository.CentroRepository;

public class CentroJpaRepository implements CentroRepository{
	
	EntityManager em;
	
	@Override
	public Centro save(Centro centro) {
		if(centro.getId()==null) {
			em.persist(centro);
		} else {
			Centro centro2= findByPrimaryKey(centro.getId());
			if(centro2==null) {
				em.persist(centro);
			} else {
				em.merge(centro);
			}
		}
		return centro;
	}

	@Override
	public Centro findByPrimaryKey(Long id) {
		return em.find(Centro.class, id);
	}

	@Override
	public List<Centro> findAll() {
		return em.createNamedQuery("SELECT * FROM Centro", Centro.class).getResultList();
	}

	@Override
	public void delete(Centro centro) {
		em.remove(centro);		
	}

	@Override
	public void update(Centro centro) {
		em.merge(centro);
	}
}

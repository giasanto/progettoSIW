package it.uniroma3.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import it.uniroma3.model.Azienda;
import it.uniroma3.repository.AziendaRepository;

public class AziendaJpaRepository implements AziendaRepository {

	EntityManager em;
	
	@Override
	public Azienda save(Azienda azienda) {
		if(azienda.getId()==null) {
			em.persist(azienda);
		} else {
			Azienda azienda2= findByPrimaryKey(azienda.getId());
			if(azienda2==null) {
				em.persist(azienda);
			} else {
				em.merge(azienda);
			}
		}
		return azienda;
	}

	@Override
	public Azienda findByPrimaryKey(Long id) {
		return em.find(Azienda.class, id);
	}

	@Override
	public List<Azienda> findAll() {
		return em.createNamedQuery("SELECT * FROM Azienda", Azienda.class).getResultList();
	}

	@Override
	public void delete(Azienda azienda) {
		em.remove(azienda);		
	}

	@Override
	public void update(Azienda azienda) {
		em.merge(azienda);
	}
}

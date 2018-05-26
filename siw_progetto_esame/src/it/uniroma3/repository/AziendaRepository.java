package it.uniroma3.repository;

import java.util.List;

import it.uniroma3.model.Azienda;

public interface AziendaRepository {
	public Azienda save(Azienda azienda);
	public Azienda findByPrimaryKey(Long id);
	public List<Azienda> findAll();
	public void delete(Azienda azienda);
	public void update(Azienda azienda);
}

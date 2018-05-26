package it.uniroma3.repository;

import java.util.List;

import it.uniroma3.model.Centro;

public interface CentroRepository {
	public Centro save(Centro centro);
	public Centro findByPrimaryKey(Long id);
	public List<Centro> findAll();
	public void delete(Centro centro);
	public void update(Centro centro);
}

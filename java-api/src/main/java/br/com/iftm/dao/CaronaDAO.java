package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.Carona;

public interface CaronaDAO {

	Carona create(Carona carona);

	List<Carona> read();

	Carona update(Carona carona);

	void delete(Integer id);

	Carona readById(Integer id);

	List<Carona> readByCidade(String cidade);

}

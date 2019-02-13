package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.Cidade;

public interface CidadeDAO {

	Cidade create(Cidade cidade);

	List<Cidade> read();

	Cidade update(Cidade cidade);

	void delete(Integer id);

}

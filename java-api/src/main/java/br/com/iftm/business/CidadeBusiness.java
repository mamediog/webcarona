package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.Cidade;

public interface CidadeBusiness {

	Cidade create(Cidade cidade) throws BusinessException;

	List<Cidade> read() throws BusinessException;

	Cidade update(Cidade cidade) throws BusinessException;

	void delete(Integer id) throws BusinessException;

}

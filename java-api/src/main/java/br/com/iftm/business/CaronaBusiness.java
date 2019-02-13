package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.Carona;

public interface CaronaBusiness {

	Carona create(Carona carona) throws BusinessException;

	List<Carona> read() throws BusinessException;

	void delete(Integer id) throws BusinessException;

	List<Carona> readByCidade(String cidade) throws BusinessException;

	Carona readById(Integer id) throws BusinessException;

	Carona update(Integer id, Carona carona) throws BusinessException;

}

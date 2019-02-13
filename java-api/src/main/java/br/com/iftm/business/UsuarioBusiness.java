package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.Usuario;

public interface UsuarioBusiness {

	Usuario create(Usuario usuario) throws BusinessException;

	List<Usuario> read() throws BusinessException;

	Usuario update(Usuario usuario) throws BusinessException;

	void delete(Integer id) throws BusinessException;

	Usuario readById(Integer id) throws BusinessException;

}

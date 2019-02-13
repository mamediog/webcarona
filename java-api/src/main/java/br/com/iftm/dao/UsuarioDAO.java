package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.Usuario;

public interface UsuarioDAO {

	Usuario create(Usuario usuario);

	List<Usuario> read();

	Usuario update(Usuario usuario);

	void delete(Integer id);

	Usuario readById(Integer id);

}

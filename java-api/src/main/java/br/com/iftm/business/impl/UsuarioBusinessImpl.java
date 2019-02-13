package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.UsuarioBusiness;
import br.com.iftm.dao.UsuarioDAO;
import br.com.iftm.entity.Carona;
import br.com.iftm.entity.Usuario;

@Service
public class UsuarioBusinessImpl implements UsuarioBusiness {

	@Autowired
	private UsuarioDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Usuario create(Usuario usuario) throws BusinessException {

		if (StringUtils.isEmpty(usuario.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}

		if (StringUtils.isEmpty(usuario.getEmail())) {
			throw new BusinessException("Email Requerido!");
		}

		if (StringUtils.isEmpty(usuario.getSenha())) {
			throw new BusinessException("Senha Requerida!");
		}

		if (StringUtils.isEmpty(usuario.getCpf())) {
			throw new BusinessException("CPF Requerido!");
		}

		if (usuario.getTelefones() == null) {
			throw new BusinessException("Pelo menos um Telefone é Requerido!");
		}
		
		if(usuario.getTelefones().getDdd().isEmpty() || usuario.getTelefones().getDdd() == null) {
			throw new BusinessException("DDD Requerido!");
		}
		
		if(usuario.getTelefones().getNumero().isEmpty()) {
			throw new BusinessException("Número Telefone Requerido!");
		}
		usuario.getTelefones().setUsuario(usuario);

		return dao.create(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> read() throws BusinessException {

		return dao.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Usuario update(Usuario usuario) throws BusinessException {

		if (StringUtils.isEmpty(usuario.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}

		if (StringUtils.isEmpty(usuario.getEmail())) {
			throw new BusinessException("Email Requerido!");
		}

		if (StringUtils.isEmpty(usuario.getSenha())) {
			throw new BusinessException("Senha Requerida!");
		}

		if (StringUtils.isEmpty(usuario.getCpf())) {
			throw new BusinessException("CPF Requerido!");
		}

		if (usuario.getTelefones() == null) {
			throw new BusinessException("Pelo menos um Telefone é Requerido!");
		}
		
		if(usuario.getTelefones().getDdd().isEmpty()) {
			throw new BusinessException("DDD Requerido!");
		}
		
		if(usuario.getTelefones().getNumero().isEmpty()) {
			throw new BusinessException("Número Telefone Requerido!");
		}else {
			usuario.getTelefones().setUsuario(usuario);
		}
		
		return dao.update(usuario);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws BusinessException {

		if (id == null) {

			throw new BusinessException("Id Requerido!");
		}
		dao.delete(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario readById(Integer id) throws BusinessException {
		if (id == null) {

			throw new BusinessException("Id Requerido!");
		}

		return dao.readById(id);
	}
}

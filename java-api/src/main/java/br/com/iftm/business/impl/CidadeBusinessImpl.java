package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.CidadeBusiness;
import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.entity.Cidade;

@Service
@Transactional
public class CidadeBusinessImpl implements CidadeBusiness {

	@Autowired
	private CidadeDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Cidade create(Cidade cidade) throws BusinessException {

		if (StringUtils.isEmpty(cidade.getNome())) {

			throw new BusinessException("Nome Requerido!");
		}

		if (cidade.getEstado() == null) {

			throw new BusinessException("Estado Requerido!");
		}

		return dao.create(cidade);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cidade> read() throws BusinessException {

		return dao.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Cidade update(Cidade cidade) throws BusinessException {

		if (cidade.getId() == null) {

			throw new BusinessException("Id Requerido!");
		}

		if (StringUtils.isEmpty(cidade.getNome())) {

			throw new BusinessException("Nome Requerido!");
		}

		if (cidade.getEstado() == null) {

			throw new BusinessException("Estado Requerido!");
		}

		return dao.update(cidade);
	}

	@Override

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws BusinessException {

		if (id == null) {

			throw new BusinessException("Id Requerido!");
		}
		dao.delete(id);
	}

}

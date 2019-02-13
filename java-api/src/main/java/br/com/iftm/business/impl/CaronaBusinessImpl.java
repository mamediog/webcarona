package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.CaronaBusiness;
import br.com.iftm.dao.CaronaDAO;
import br.com.iftm.entity.Carona;

@Service
@Transactional
public class CaronaBusinessImpl implements CaronaBusiness {
	@Autowired
	private CaronaDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Carona create(Carona carona) throws BusinessException {

		if (StringUtils.isEmpty(carona.getCidadeOrigem())) {

			throw new BusinessException("Cidade de Origem Requerida!");
		}

		if (StringUtils.isEmpty(carona.getCidadeDestino())) {

			throw new BusinessException("Cidade de Destino Requerida!");
		}

		if (carona.getVagas() == null) {

			throw new BusinessException("Vagas Requerida!");
		}

		if (carona.getPreco() == null) {

			throw new BusinessException("Preco Requerida!");
		}

		if (carona.getData() == null) {

			throw new BusinessException("Data Requerida!");
		}

		if (StringUtils.isEmpty(carona.getHora())) {

			throw new BusinessException("Horas Requerida!");
		}

		if (carona.getStatus() == null) {

			throw new BusinessException("Status Requerido!");
		}

		if (carona.getUsuario() == null || carona.getUsuario().getId() == null) {

			throw new BusinessException("Usuario Requerido!");
		}

		return dao.create(carona);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Carona> read() throws BusinessException {

		return dao.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Carona update(Integer id, Carona carona) throws BusinessException {
		Carona encontrado = readById(id);
		if (StringUtils.isEmpty(carona.getCidadeOrigem())) {

			throw new BusinessException("Cidade de Origem Requerida!");
		}

		if (StringUtils.isEmpty(carona.getCidadeDestino())) {

			throw new BusinessException("Cidade de Destino Requerida!");
		}

		if (carona.getVagas() == null) {

			throw new BusinessException("Vagas Requerida!");
		}

		if (carona.getPreco() == null) {

			throw new BusinessException("Preco Requerida!");
		}

		if (carona.getData() == null) {

			throw new BusinessException("Data Requerida!");
		}

		if (StringUtils.isEmpty(carona.getHora())) {

			throw new BusinessException("Horas Requerida!");
		}

		if (carona.getStatus() == null) {

			throw new BusinessException("Status Requerido!");
		}

		if (carona.getUsuario() == null || carona.getUsuario().getId() == null) {

			throw new BusinessException("Usuario Requerido!");
		}
		if (encontrado != null) {
			encontrado.setCidadeOrigem(carona.getCidadeOrigem());
			encontrado.setCidadeDestino(carona.getCidadeDestino());
			encontrado.setVagas(carona.getVagas());
			encontrado.setPreco(carona.getPreco());
			encontrado.setData(carona.getData());
			encontrado.setStatus(carona.getStatus());
			encontrado.setUsuario(carona.getUsuario());
			encontrado.setDescricao(carona.getDescricao());
			return dao.update(encontrado);
		}
		return dao.update(carona);
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
	public List<Carona> readByCidade(String cidade) throws BusinessException {

		if (cidade == null) {

			throw new BusinessException("Cidade Requerida!");

		}

		return dao.readByCidade(cidade);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Carona readById(Integer id) throws BusinessException {
		if (id == null) {

			throw new BusinessException("Id Requerido!");
		}

		return dao.readById(id);
	}
}

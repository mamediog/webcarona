package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.entity.Cidade;

@Repository
public class CidadeDAOImpl implements CidadeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param cidade
	 * @return
	 */
	@Override
	public Cidade create(Cidade cidade) {

		sessionFactory.getCurrentSession().save(cidade);
		sessionFactory.getCurrentSession().flush();

		return cidade;
	}

	@Override
	public List<Cidade> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cidade.class);

		return criteria.list();
	}

	@Override
	public Cidade update(Cidade cidade) {

		sessionFactory.getCurrentSession().update(cidade);
		sessionFactory.getCurrentSession().flush();

		return cidade;

	}

	@Override
	public void delete(Integer id) {

		Cidade cidade = new Cidade();
		cidade.setId(id);

		sessionFactory.getCurrentSession().delete(cidade);

	}

}

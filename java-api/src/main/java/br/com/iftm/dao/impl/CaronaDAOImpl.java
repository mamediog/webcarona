package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.CaronaDAO;
import br.com.iftm.entity.Carona;

@Repository
public class CaronaDAOImpl implements CaronaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Carona create(Carona carona) {

		sessionFactory.getCurrentSession().save(carona);
		sessionFactory.getCurrentSession().flush();

		return carona;
	}

	@Override
	public List<Carona> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Carona.class);

		return criteria.list();
	}

	@Override
	public Carona update(Carona carona) {

		sessionFactory.getCurrentSession().update(carona);
		sessionFactory.getCurrentSession().flush();

		return carona;

	}

	@Override
	public void delete(Integer id) {

		Carona carona = sessionFactory.getCurrentSession().get(Carona.class, id);
		carona.setId(id);

		sessionFactory.getCurrentSession().delete(carona);
	}

	@Override
	public List<Carona> readByCidade(String cidade) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Carona.class);
		criteria.add(Restrictions.or(
				Restrictions.like("cidadeDestino", cidade, MatchMode.ANYWHERE).ignoreCase(), 
				Restrictions.like("cidadeOrigem", cidade, MatchMode.ANYWHERE).ignoreCase())
		);
		
		return criteria.list();
	}
	
	@Override
	public Carona readById(Integer id) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Carona.class);

		criteria.add(Restrictions.eq("id", id));

		return (Carona) criteria.uniqueResult();
	}

}

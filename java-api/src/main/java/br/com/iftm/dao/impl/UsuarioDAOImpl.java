package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.UsuarioDAO;
import br.com.iftm.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Usuario create(Usuario usuario) {

		sessionFactory.getCurrentSession().save(usuario);
		sessionFactory.getCurrentSession().flush();

		return usuario;
	}

	@Override
	public List<Usuario> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		return criteria.list();
	}

	@Override
	public Usuario update(Usuario usuario) {

		sessionFactory.getCurrentSession().update(usuario);
		sessionFactory.getCurrentSession().flush();

		return usuario;
	}

	@Override
	public void delete(Integer id) {

		Usuario usuario = sessionFactory.getCurrentSession().get(Usuario.class, id);
		usuario.setId(id);

		sessionFactory.getCurrentSession().delete(usuario);
	}
	
	@Override
	public Usuario readById(Integer id) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Usuario.class);

		criteria.add(Restrictions.eq("id", id));

		return (Usuario) criteria.uniqueResult();
	}
}

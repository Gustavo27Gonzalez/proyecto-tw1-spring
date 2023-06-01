package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.compra.Compra;
import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Repository("repositorioExcursion")
public class RepositorioExcursionImpl implements RepositorioExcursion{

	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioExcursionImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Excursiones> listarExcursiones() {
		return (List<Excursiones>)sessionFactory.getCurrentSession().createCriteria(Excursiones.class).list();
	}

	@Override
	public void guardar(Excursiones excursion) {
		sessionFactory.getCurrentSession().save(excursion);
	}

	@Override
	public Excursiones tieneCupo(Long idExcursion) {
		return (Excursiones) sessionFactory.getCurrentSession().createCriteria(Excursiones.class)
		.add(Restrictions.eq("disponible", true))
		.uniqueResult();
	}

	@Override
	public void comprar(Excursiones excursion) {
		this.sessionFactory.getCurrentSession().save(excursion);
	}
	
	@Override
	public Compra comprar(Compra compra) {
		return (Compra)this.sessionFactory.getCurrentSession().save(compra);
	}
	
}

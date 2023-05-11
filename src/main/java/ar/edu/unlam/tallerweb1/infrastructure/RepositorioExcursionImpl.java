package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.excursiones.RepositorioExcursion;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Repository("repositorioUsuario")
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
	
}

package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public Boolean tieneCupo(Long idExcursion) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Boolean> query = session.createQuery("SELECT CASE WHEN e.cupo <> 0 THEN true ELSE false END "
                + "FROM excursiones e WHERE e.id_excursion = :id", Boolean.class);
        query.setParameter("id", idExcursion);
		
		Boolean result = query.getSingleResult();
		
		session.getTransaction().commit();
		
		return result;
	}
	
}

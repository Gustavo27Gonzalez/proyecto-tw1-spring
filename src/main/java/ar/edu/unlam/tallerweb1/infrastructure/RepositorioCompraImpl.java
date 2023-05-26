package ar.edu.unlam.tallerweb1.infrastructure;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.compra.Compra;
import ar.edu.unlam.tallerweb1.domain.compra.RepositorioCompra;

@Repository("repositorioCompra")
public class RepositorioCompraImpl implements RepositorioCompra{

	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioCompraImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void guardar(Compra compra) {
		sessionFactory.getCurrentSession().save(compra);
	}

}

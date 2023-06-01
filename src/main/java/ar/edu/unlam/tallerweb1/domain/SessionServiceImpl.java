package ar.edu.unlam.tallerweb1.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;

@Service("SessionService")
@Transactional
public class SessionServiceImpl implements SessionService{

	Excursiones excursionActual = null;
	
	@Override
	public void setExcursionActual(Excursiones excursion) {
		this.excursionActual = excursion;
	}

	@Override
	public Excursiones getExcursionActual() {
		return this.excursionActual;
	}

}

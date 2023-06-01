package ar.edu.unlam.tallerweb1.domain;

import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;

public interface SessionService {

	public void setExcursionActual(Excursiones excursion);
	public Excursiones getExcursionActual();
	
}

package ar.edu.unlam.tallerweb1.delivery;

import java.util.Date;

import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public class DatosCompra {
	
	private Long idExcursion;
	//private Date fechaCompra;
	//private Date fechaExcursion;
	private Double precio;
	private Long idUsuario;
	
	public Long getIdExcursion() {
		return idExcursion;
	}
	
	public void setIdExcursion(Long idExcursion) {
		this.idExcursion = idExcursion;
	}
	/*
	public Date getFechaCompra() {
		return fechaCompra;
	}
	
	public void setFechaCompra(Date fecha) {
		this.fechaCompra = fecha;
	}
	
	public Date getFechaExcursion() {
		return fechaExcursion;
	}
	
	public void setFechaExcursion(Date fecha) {
		this.fechaExcursion = fecha;
	}
	*/
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	public DatosCompra() {}
	
	public DatosCompra(Long idExcursion, Date fechaCompra, Date fechaExcursion, Double precio, Long idUsuario) {
		setIdExcursion(idExcursion);
		//setFechaCompra(fechaCompra);
		//setFechaExcursion(fechaExcursion);
		setPrecio(precio);
		setIdUsuario(idUsuario);
	}
	
	public DatosCompra(Long idExcursion, Double precio, Long idUsuario) {
		setIdExcursion(idExcursion);
		setPrecio(precio);
		setIdUsuario(idUsuario);
	}

	public DatosCompra(Excursiones e, Usuario u) {
		setIdExcursion(e.getId());
		setPrecio(e.getPrecio());
		setIdUsuario(u.getId());
	}

}

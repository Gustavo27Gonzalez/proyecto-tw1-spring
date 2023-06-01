package ar.edu.unlam.tallerweb1.domain.compra;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.delivery.DatosCompra;
import ar.edu.unlam.tallerweb1.domain.excursiones.Excursiones;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Entity (name="compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Long id;
	//private Date fechaCompra;
	//private Date fechaExcursion;
	private Double precio;
	private Long idUsuario;
	private Long idExcursion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdExcursion() {
		return idExcursion;
	}

	public void setIdExcursion(Long idExcursion) {
		this.idExcursion = idExcursion;
	}

	public Compra() {}
	
	public Compra(DatosCompra datosCompra) {
		//setFechaExcursion(datosCompra.getFechaExcursion());
		setPrecio(datosCompra.getPrecio());
		setIdUsuario(datosCompra.getIdUsuario());
		setIdExcursion(datosCompra.getIdExcursion());
	}

	public Compra(Excursiones e, Usuario u) {
		setIdUsuario(u.getId());
		setIdExcursion(e.getId());	
		}
	

}

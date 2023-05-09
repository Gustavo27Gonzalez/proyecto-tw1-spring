package ar.edu.unlam.tallerweb1.domain.excursiones;

import java.util.Date;

import ar.edu.unlam.tallerweb1.delivery.DatosRegistro;

public class Excursiones {
	
	private String nombre;
	private  Date fecha;
	private Double precio;
	private Integer cupo;
	private String descripcion;
	
	 public Excursiones() {}
	 
	 public Excursiones(String nombre,  Date fecha, Double precio, Integer cupo, String descripcion) {
		 }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
	 }

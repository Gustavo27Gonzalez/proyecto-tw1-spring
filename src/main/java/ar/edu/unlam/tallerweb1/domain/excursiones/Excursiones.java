package ar.edu.unlam.tallerweb1.domain.excursiones;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ar.edu.unlam.tallerweb1.delivery.DatosRegistro;

@Entity (name="excursiones")
public class Excursiones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_excursion")
	private Long id;
	private String nombre;
	private Date fecha;
	private Double precio;
	private Integer cupo;
	private String descripcion;
	
	public Excursiones() {}
	 
	public Excursiones(String nombre,  Date fecha, Double precio, Integer cupo, String descripcion) {
		setNombre(nombre);
		setFecha(fecha);
		setPrecio(precio);
		setCupo(cupo);
		setDescripcion(descripcion);
	}
	 
	public Long getId() {
		 return id;
	}
	 
	public void setId(Long id) {
		 this.id = id;
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

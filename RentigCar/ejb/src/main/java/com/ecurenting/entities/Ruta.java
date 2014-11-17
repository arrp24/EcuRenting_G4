package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ruta database table.
 * 
 */
@Entity
@NamedQuery(name="Ruta.findAll", query="SELECT r FROM Ruta r")
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rutCodigo")
	private Integer rutCodigo;

	@Column(name="rutDireccion")
	private String rutDireccion;

	@Column(name="rutFecha")
	private Date rutFecha;

	@Column(name="rutTiempo")
	private Date rutTiempo;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="vehCodigo")
	private Vehiculo vehiculo;

	public Ruta() {
	}

	public int getRutCodigo() {
		return this.rutCodigo;
	}

	public void setRutCodigo(int rutCodigo) {
		this.rutCodigo = rutCodigo;
	}

	public String getRutDireccion() {
		return this.rutDireccion;
	}

	public void setRutDireccion(String rutDireccion) {
		this.rutDireccion = rutDireccion;
	}

	public Date getRutFecha() {
		return this.rutFecha;
	}

	public void setRutFecha(Date rutFecha) {
		this.rutFecha = rutFecha;
	}

	public Date getRutTiempo() {
		return this.rutTiempo;
	}

	public void setRutTiempo(Date rutTiempo) {
		this.rutTiempo = rutTiempo;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the mantenimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Mantenimiento.findAll", query="SELECT m FROM Mantenimiento m")
public class Mantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="manCodigo")
	private Integer manCodigo;

	@Column(name="manDescripcion")
	private String manDescripcion;

	@Column(name="manFecha")
	private Date manFecha;

	@Column(name="manPrecio")
	private BigDecimal manPrecio;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="vehCodigo")
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to Taller
	@ManyToOne
	@JoinColumn(name="tlrCodigo")
	private Taller taller;


	public Mantenimiento() {
	}

	public int getManCodigo() {
		return this.manCodigo;
	}

	public void setManCodigo(int manCodigo) {
		this.manCodigo = manCodigo;
	}

	public String getManDescripcion() {
		return this.manDescripcion;
	}

	public void setManDescripcion(String manDescripcion) {
		this.manDescripcion = manDescripcion;
	}

	public Date getManFecha() {
		return this.manFecha;
	}

	public void setManFecha(Date manFecha) {
		this.manFecha = manFecha;
	}

	public BigDecimal getManPrecio() {
		return this.manPrecio;
	}

	public void setManPrecio(BigDecimal manPrecio) {
		this.manPrecio = manPrecio;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Taller getTaller() {
		return this.taller;
	}

	public void setTaller(Taller taller) {
		this.taller = taller;
	}

}
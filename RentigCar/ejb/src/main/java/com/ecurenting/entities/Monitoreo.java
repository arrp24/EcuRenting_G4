package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the monitoreo database table.
 * 
 */
@Entity
@NamedQuery(name="Monitoreo.findAll", query="SELECT m FROM Monitoreo m")
public class Monitoreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="monCodigo")
	private Integer monCodigo;

	@Column(name="monFecha")
	private Date monFecha;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="monitoreo")
	private List<Vehiculo> vehiculos;
	
	public Monitoreo() {
	}

	public int getMonCodigo() {
		return this.monCodigo;
	}

	public void setMonCodigo(int monCodigo) {
		this.monCodigo = monCodigo;
	}

	public Date getMonFecha() {
		return this.monFecha;
	}

	public void setMonFecha(Date monFecha) {
		this.monFecha = monFecha;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setMonitoreo(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setMonitoreo(null);

		return vehiculo;
	}

}
package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the alquiler database table.
 * 
 */
@Entity
@NamedQuery(name="Alquiler.findAll", query="SELECT a FROM Alquiler a")
public class Alquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="alqCodigo")
	private Integer alqCodigo;

	@Column(name="alqEstado")
	private String alqEstado;

	@Column(name="alqFecha")
	private Date alqFecha;

	//bi-directional many-to-one association to Tipocontrato
	@ManyToOne
	@JoinColumn(name="tipCodigo")
	private Tipocontrato tipocontrato;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="alquiler")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="alquiler")
	private List<Vehiculo> vehiculos;

	public Alquiler() {
	}

	public int getAlqCodigo() {
		return this.alqCodigo;
	}

	public void setAlqCodigo(int alqCodigo) {
		this.alqCodigo = alqCodigo;
	}

	public String getAlqEstado() {
		return this.alqEstado;
	}

	public void setAlqEstado(String alqEstado) {
		this.alqEstado = alqEstado;
	}

	public Date getAlqFecha() {
		return this.alqFecha;
	}

	public void setAlqFecha(Date alqFecha) {
		this.alqFecha = alqFecha;
	}

	public Tipocontrato getTipocontrato() {
		return this.tipocontrato;
	}

	public void setTipocontrato(Tipocontrato tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setAlquiler(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setAlquiler(null);

		return reserva;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setAlquiler(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setAlquiler(null);

		return vehiculo;
	}

}
package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resCodigo")
	private Integer resCodigo;

	@Column(name="resEstado")
	private String resEstado;

	@Column(name="resFecha")
	private Date resFecha;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="clicodigo")
	private Cliente cliente;

	//bi-directional many-to-one association to Alquiler
	@ManyToOne
	@JoinColumn(name="alqCodigo")
	private Alquiler alquiler;
	
	public Reserva() {
	}

	public int getResCodigo() {
		return this.resCodigo;
	}

	public void setResCodigo(int resCodigo) {
		this.resCodigo = resCodigo;
	}

	public String getResEstado() {
		return this.resEstado;
	}

	public void setResEstado(String resEstado) {
		this.resEstado = resEstado;
	}

	public Date getResFecha() {
		return this.resFecha;
	}

	public void setResFecha(Date resFecha) {
		this.resFecha = resFecha;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Alquiler getAlquiler() {
		return this.alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

}
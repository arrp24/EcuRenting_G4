package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usrCodigo")
	private Integer usrCodigo;
	
	@Column(name="usrCedula")
	private BigDecimal usrCedula;

	@Column(name="usrApellido")
	private String usrApellido;

	@Column(name="usrFchNac")
	private Date usrFchNac;

	@Column(name="usrNombre")
	private String usrNombre;

	@Column(name="usrTelefono")
	private BigDecimal usrTelefono;

	@Column(name="usrTipLicencia")
	private String usrTipLicencia;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="vehCodigo")
	private Vehiculo vehiculo;

	public Usuario() {
	}

	public int getUsrCodigo() {
		return this.usrCodigo;
	}

	public void setUsrCodigo(int usrCodigo) {
		this.usrCodigo = usrCodigo;
	}

	public String getUsrApellido() {
		return this.usrApellido;
	}

	public void setUsrApellido(String usrApellido) {
		this.usrApellido = usrApellido;
	}

	public BigDecimal getUsrCedula() {
		return this.usrCedula;
	}

	public void setUsrCedula(BigDecimal usrCedula) {
		this.usrCedula = usrCedula;
	}

	public Date getUsrFchNac() {
		return this.usrFchNac;
	}

	public void setUsrFchNac(Date usrFchNac) {
		this.usrFchNac = usrFchNac;
	}

	public String getUsrNombre() {
		return this.usrNombre;
	}

	public void setUsrNombre(String usrNombre) {
		this.usrNombre = usrNombre;
	}

	public BigDecimal getUsrTelefono() {
		return this.usrTelefono;
	}

	public void setUsrTelefono(BigDecimal usrTelefono) {
		this.usrTelefono = usrTelefono;
	}

	public String getUsrTipLicencia() {
		return this.usrTipLicencia;
	}

	public void setUsrTipLicencia(String usrTipLicencia) {
		this.usrTipLicencia = usrTipLicencia;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
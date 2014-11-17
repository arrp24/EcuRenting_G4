package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the taller database table.
 * 
 */
@Entity
@NamedQuery(name="Taller.findAll", query="SELECT t FROM Taller t")
public class Taller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tlrCodigo")
	private Integer tlrCodigo;
	
	@Column(name="tlrDireccion")
	private String tlrDireccion;

	@Column(name="tlrFecha")
	private Date tlrFecha;

	@Column(name="tlrNombre")
	private String tlrNombre;

	//bi-directional many-to-one association to Mantenimiento
	@OneToMany(mappedBy="taller")
	private List<Mantenimiento> mantenimientos;
	
	public Taller() {
	}

	public int getTlrCodigo() {
		return this.tlrCodigo;
	}

	public void setTlrCodigo(int tlrCodigo) {
		this.tlrCodigo = tlrCodigo;
	}

	public String getTlrDireccion() {
		return this.tlrDireccion;
	}

	public void setTlrDireccion(String tlrDireccion) {
		this.tlrDireccion = tlrDireccion;
	}

	public Date getTlrFecha() {
		return this.tlrFecha;
	}

	public void setTlrFecha(Date tlrFecha) {
		this.tlrFecha = tlrFecha;
	}

	public String getTlrNombre() {
		return this.tlrNombre;
	}

	public void setTlrNombre(String tlrNombre) {
		this.tlrNombre = tlrNombre;
	}

	public List<Mantenimiento> getMantenimientos() {
		return this.mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public Mantenimiento addMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().add(mantenimiento);
		mantenimiento.setTaller(this);

		return mantenimiento;
	}

	public Mantenimiento removeMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().remove(mantenimiento);
		mantenimiento.setTaller(null);

		return mantenimiento;
	}

}
package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tipocontrato database table.
 * 
 */
@Entity
@NamedQuery(name="Tipocontrato.findAll", query="SELECT t FROM Tipocontrato t")
public class Tipocontrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipCodigo")
	private Integer tipCodigo;

	@Column(name="tipDiaFinal")
	private Date tipDiaFinal;

	@Column(name="tipDiaInicio")
	private Date tipDiaInicio;

	//bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy="tipocontrato")
	private List<Alquiler> alquilers;

	public Tipocontrato() {
	}

	public int getTipCodigo() {
		return this.tipCodigo;
	}

	public void setTipCodigo(int tipCodigo) {
		this.tipCodigo = tipCodigo;
	}

	public Date getTipDiaFinal() {
		return this.tipDiaFinal;
	}

	public void setTipDiaFinal(Date tipDiaFinal) {
		this.tipDiaFinal = tipDiaFinal;
	}

	public Date getTipDiaInicio() {
		return this.tipDiaInicio;
	}

	public void setTipDiaInicio(Date tipDiaInicio) {
		this.tipDiaInicio = tipDiaInicio;
	}

	public List<Alquiler> getAlquilers() {
		return this.alquilers;
	}

	public void setAlquilers(List<Alquiler> alquilers) {
		this.alquilers = alquilers;
	}

	public Alquiler addAlquiler(Alquiler alquiler) {
		getAlquilers().add(alquiler);
		alquiler.setTipocontrato(this);

		return alquiler;
	}

	public Alquiler removeAlquiler(Alquiler alquiler) {
		getAlquilers().remove(alquiler);
		alquiler.setTipocontrato(null);

		return alquiler;
	}

}
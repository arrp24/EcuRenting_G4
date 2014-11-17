package com.ecurenting.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the practica database table.
 * 
 */
@Entity
@NamedQuery(name="Practica.findAll", query="SELECT p FROM Practica p")
public class Practica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpractica")
	private int idpractica;
	
	@Column(name="apellido")
	private String apellido;

	@Column(name="nombre")
	private String nombre;

	public Practica() {
	}

	public int getIdpractica() {
		return this.idpractica;
	}

	public void setIdpractica(int idpractica) {
		this.idpractica = idpractica;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
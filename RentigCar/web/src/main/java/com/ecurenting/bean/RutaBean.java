package com.ecurenting.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ecurenting.ejb.RutaEjb;
import com.ecurenting.entities.Ruta;
import com.ecurenting.entities.Vehiculo;

@ManagedBean(name="rutaBean")
@SessionScoped
public class RutaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7969692272597215467L;
	
	private Ruta ruta = new Ruta();
	private Ruta rutaBus = new Ruta();
	private Vehiculo vehiculo = new Vehiculo();
	private Vehiculo vehiculoBus = new Vehiculo();
	private List<Vehiculo> vehiculoLista = new ArrayList<Vehiculo>();
	private List<Ruta> rutaLista = new ArrayList<Ruta>();
	
	@EJB
	RutaEjb rutaAction;

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Ruta getRutaBus() {
		return rutaBus;
	}

	public void setRutaBus(Ruta rutaBus) {
		this.rutaBus = rutaBus;
	}

	public List<Ruta> getRutaLista() {
		return rutaLista;
	}

	public void setRutaLista(List<Ruta> rutaLista) {
		this.rutaLista = rutaLista;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Vehiculo getVehiculoBus() {
		return vehiculoBus;
	}

	public void setVehiculoBus(Vehiculo vehiculoBus) {
		this.vehiculoBus = vehiculoBus;
	}

	public List<Vehiculo> getVehiculoLista() {
		return vehiculoLista;
	}

	public void setVehiculoLista(List<Vehiculo> vehiculoLista) {
		this.vehiculoLista = vehiculoLista;
	}

}

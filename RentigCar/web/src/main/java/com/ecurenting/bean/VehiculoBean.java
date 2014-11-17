package com.ecurenting.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.ecurenting.ejb.VehiculoEjb;
import com.ecurenting.entities.Vehiculo;

@ManagedBean(name="vehiculoBean")
@SessionScoped
public class VehiculoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8878660558297920132L;
	
	private Vehiculo vehiculo = new Vehiculo();
	private Vehiculo vehiculoBus = new Vehiculo();
	private List<Vehiculo> vehiculoLista = new ArrayList<Vehiculo>();
	private Boolean esnuevo = new Boolean(Boolean.TRUE);

	@EJB
	VehiculoEjb vehiculoAction;
	
	public void guardar(){
		
		if(esnuevo){
			try {
				vehiculoAction.persist(vehiculo);
				vehiculo = new Vehiculo();
				RequestContext.getCurrentInstance().update("vehiculoForm:ed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				vehiculoAction.merge(vehiculo);
				esnuevo = Boolean.TRUE;
				vehiculo = new Vehiculo();
				RequestContext.getCurrentInstance().update("vehiculoForm:ed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			vehiculoLista = vehiculoAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("vehiculoForm:tablaVehiculo");
	}
	
	
	
	public void buscar(){
		
		if(vehiculoBus.getVehPlaca().equals(new String(""))&&vehiculoBus.getVehMarca().equals(new String(""))){
			try {
				vehiculoLista = vehiculoAction.findAll();
				RequestContext.getCurrentInstance().update("vehiculoForm:tablaVehiculo");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			if(!vehiculoBus.getVehPlaca().equals(null)||!vehiculoBus.getVehMarca().equals(null)){
				vehiculoLista = vehiculoAction.buscarPorPlacaMarca(vehiculoBus);
				RequestContext.getCurrentInstance().update("vehiculoForm:tablaVehiculo");
			}
		}
		
		
	}
	
	public void eliminar(Vehiculo veh){
		try {
			vehiculoAction.remove(veh);
			vehiculoLista = vehiculoAction.findAll();
			RequestContext.getCurrentInstance().update("vehiculoForm:tablaVehiculo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpiar(){
		vehiculoLista = new ArrayList<Vehiculo>();
		RequestContext.getCurrentInstance().update("vehiculoForm:tablaVehiculo");
	}
	
	public void editar(Vehiculo veh){
		esnuevo = Boolean.FALSE;
		vehiculo = new Vehiculo();
		vehiculo = veh;
		RequestContext.getCurrentInstance().update("vehiculoForm:ed");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public List<Vehiculo> getVehiculoLista() {
		return vehiculoLista;
	}
	public void setVehiculoLista(List<Vehiculo> vehiculoLista) {
		this.vehiculoLista = vehiculoLista;
	}


	public Boolean getEsnuevo() {
		return esnuevo;
	}



	public void setEsnuevo(Boolean esnuevo) {
		this.esnuevo = esnuevo;
	}



	public Vehiculo getVehiculoBus() {
		return vehiculoBus;
	}



	public void setVehiculoBus(Vehiculo vehiculoBus) {
		this.vehiculoBus = vehiculoBus;
	}
	

}

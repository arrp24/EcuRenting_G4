package com.ecurenting.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ecurenting.ejb.TipocontratoEjb;
import com.ecurenting.entities.Tipocontrato;

@ManagedBean(name="tipoContratoBean")
@SessionScoped
public class TipocontratoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3207017062662755556L;
	private Tipocontrato tipoContrato = new Tipocontrato();
	private List<Tipocontrato> list = new ArrayList<Tipocontrato>();

	@EJB
	TipocontratoEjb tipoAction;
	
	
	public void guardar(){
		System.out.println("entro");
		try {
			tipoAction.persist(tipoContrato);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Tipocontrato getTipoContrato() {
		return tipoContrato;
	}


	public void setTipoContrato(Tipocontrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}


	public List<Tipocontrato> getList() {
		return list;
	}


	public void setList(List<Tipocontrato> list) {
		this.list = list;
	}
	
}

package com.ecurenting.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.ecurenting.ejb.PracticaEjb;
import com.ecurenting.entities.Practica;

@ManagedBean(name="practicaBean")
@SessionScoped
public class PracticaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8878660558297920132L;
	
	private Practica practica = new Practica();
	private Practica practicaBus = new Practica();
	private List<Practica> practicaLista = new ArrayList<Practica>();
	private Boolean esnuevo = new Boolean(Boolean.TRUE);

	@EJB
	PracticaEjb practicaAction;
	
	public void guardar(){
		
		if(esnuevo){
			try {
				practicaAction.persist(practica);
				practica = new Practica();
				RequestContext.getCurrentInstance().update("practicaForm:ed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				practicaAction.merge(practica);
				esnuevo = Boolean.TRUE;
				practica = new Practica();
				RequestContext.getCurrentInstance().update("practicaForm:ed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			practicaLista = practicaAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("practicaForm:tablaPractica");
	}
	
	
	
	public void buscar(){
		
		if(practicaBus.getNombre().equals(new String(""))&&practicaBus.getApellido().equals(new String(""))){
			try {
				practicaLista = practicaAction.findAll();
				RequestContext.getCurrentInstance().update("practicaForm:tablaPractica");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			if(!practicaBus.getNombre().equals(null)||!practicaBus.getApellido().equals(null)){
				practicaLista = practicaAction.buscarPorNombre(practicaBus);
				RequestContext.getCurrentInstance().update("PracticaForm:tablaPractica");
			}
		}
		
		
	}
	
	public void eliminar(Practica prac){
		try {
			practicaAction.remove(prac);
			practicaLista = practicaAction.findAll();
			RequestContext.getCurrentInstance().update("practicaForm:tablaPractica");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpiar(){
		practicaLista = new ArrayList<Practica>();
		RequestContext.getCurrentInstance().update("practicaForm:tablaPractica");
	}
	
	public void editar(Practica prac){
		esnuevo = Boolean.FALSE;
		practica = new Practica();
		practica = prac;
		RequestContext.getCurrentInstance().update("practicaForm:ed");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public Practica getPractica() {
		return practica;
	}
	public void setPractica(Practica practica) {
		this.practica = practica;
	}
	public List<Practica> getPracticaLista() {
		return practicaLista;
	}
	public void setPracticaLista(List<Practica> practicaLista) {
		this.practicaLista = practicaLista;
	}


	public Boolean getEsnuevo() {
		return esnuevo;
	}


	public void setEsnuevo(Boolean esnuevo) {
		this.esnuevo = esnuevo;
	}


	public Practica getPracticaBus() {
		return practicaBus;
	}


	public void setPracticaBus(Practica practicaBus) {
		this.practicaBus = practicaBus;
	}
	

}

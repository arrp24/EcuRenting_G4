package com.ecurenting.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.ecurenting.ejb.ClienteEjb;
import com.ecurenting.entities.Cliente;

@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1717371644415119641L;
	private Cliente cliente = new Cliente();
	private Cliente clienteBus = new Cliente();
	private List<Cliente> clienteLista = new ArrayList<Cliente>();
	private Boolean esnuevo = new Boolean(Boolean.TRUE);

	@EJB
	ClienteEjb clienteAction;
	
	public void guardar(){
		
		if(esnuevo){
			try {
				clienteAction.persist(cliente);
				cliente = new Cliente();
				RequestContext.getCurrentInstance().update("clienteForm:edd");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				clienteAction.merge(cliente);
				esnuevo = Boolean.TRUE;
				cliente = new Cliente();
				RequestContext.getCurrentInstance().update("clienteForm:edd");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			clienteLista = clienteAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("clienteForm:tabla");
	}
	
	
	
	public void buscar(){
		
		if(clienteBus.getCliCedula().equals(new BigDecimal("0"))&&clienteBus.getCliNombre().equals(new String(""))){
			try {
				clienteLista = clienteAction.findAll();
				RequestContext.getCurrentInstance().update("clienteForm:tabla");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			if(!clienteBus.getCliCedula().equals(null)||!clienteBus.getCliNombre().equals(null)){
				clienteLista = clienteAction.buscarPorCedulaNombre(clienteBus);
				RequestContext.getCurrentInstance().update("clienteForm:tabla");
			}
		}
		
	}
	
	public void eliminar(Cliente usr){
		try {
			clienteAction.remove(usr);
			clienteLista = clienteAction.findAll();
			RequestContext.getCurrentInstance().update("clienteForm:tabla");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpiar(){
		clienteLista = new ArrayList<Cliente>();
		RequestContext.getCurrentInstance().update("clienteForm:tabla");
	}
	
	public void editar(Cliente usr){
		esnuevo = Boolean.FALSE;
		cliente = new Cliente();	
		cliente = usr;
		RequestContext.getCurrentInstance().update("clienteForm:edd");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClienteLista() {
		return clienteLista;
	}
	public void setClienteLista(List<Cliente> clienteLista) {
		this.clienteLista = clienteLista;
	}


	public Boolean getEsnuevo() {
		return esnuevo;
	}



	public void setEsnuevo(Boolean esnuevo) {
		this.esnuevo = esnuevo;
	}



	public Cliente getClienteBus() {
		return clienteBus;
	}



	public void setClienteBus(Cliente clienteBus) {
		this.clienteBus = clienteBus;
	}
	
	
	
}

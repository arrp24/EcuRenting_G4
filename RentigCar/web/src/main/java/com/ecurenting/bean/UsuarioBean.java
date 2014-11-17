package com.ecurenting.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.ecurenting.ejb.UsuarioEjb;
import com.ecurenting.entities.Usuario;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1717371644415119641L;
	private Usuario usuario = new Usuario();
	private Usuario usuarioBus = new Usuario();
	private List<Usuario> usuarioLista = new ArrayList<Usuario>();
	private Boolean esnuevo = new Boolean(Boolean.TRUE);

	@EJB
	UsuarioEjb usuarioAction;
	
	public void guardar(){
		
		if(esnuevo){
			try {
				usuarioAction.persist(usuario);
				usuario = new Usuario();
				RequestContext.getCurrentInstance().update("usuarioForm:ed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				usuarioAction.merge(usuario);
				esnuevo = Boolean.TRUE;
				usuario = new Usuario();
				RequestContext.getCurrentInstance().update("usuarioForm:ed");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			usuarioLista = usuarioAction.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().update("usuarioForm:tablaUsuario");
	}
	
	
	
	public void buscar(){
		
		if(usuarioBus.getUsrCedula().equals(new BigDecimal("0"))&&usuarioBus.getUsrNombre().equals(new String(""))){
			try {
				usuarioLista = usuarioAction.findAll();
				RequestContext.getCurrentInstance().update("usuarioForm:tablaUsuario");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			if(!usuarioBus.getUsrCedula().equals(null)||!usuarioBus.getUsrNombre().equals(null)){
				usuarioLista = usuarioAction.buscarPorCedulaNombre(usuarioBus);
				RequestContext.getCurrentInstance().update("usuarioForm:tablaUsuario");
			}
		}
		
		
	}
	
	public void eliminar(Usuario usr){
		try {
			usuarioAction.remove(usr);
			usuarioLista = usuarioAction.findAll();
			RequestContext.getCurrentInstance().update("usuarioForm:tablaUsuario");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpiar(){
		usuarioLista = new ArrayList<Usuario>();
		RequestContext.getCurrentInstance().update("usuarioForm:tablaUsuario");
	}
	
	public void editar(Usuario usr){
		esnuevo = Boolean.FALSE;
		usuario = new Usuario();
		usuario = usr;
		RequestContext.getCurrentInstance().update("usuarioForm:ed");
		RequestContext.getCurrentInstance().execute("PF('dlg2').show();");
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarioLista() {
		return usuarioLista;
	}
	public void setUsuarioLista(List<Usuario> usuarioLista) {
		this.usuarioLista = usuarioLista;
	}


	public Boolean getEsnuevo() {
		return esnuevo;
	}



	public void setEsnuevo(Boolean esnuevo) {
		this.esnuevo = esnuevo;
	}



	public Usuario getUsuarioBus() {
		return usuarioBus;
	}



	public void setUsuarioBus(Usuario usuarioBus) {
		this.usuarioBus = usuarioBus;
	}
	
	
	
}

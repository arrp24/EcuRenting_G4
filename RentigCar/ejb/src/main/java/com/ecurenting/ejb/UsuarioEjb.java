package com.ecurenting.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ecurenting.entities.Usuario;
import com.ecurenting.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class UsuarioEjb extends GenericDAOImpl<Usuario, Integer>{

	
	
	public UsuarioEjb(){
		
	}
	
	public List<Usuario> buscarPorCedulaNombre(Usuario usr){
		List<Usuario> list = new ArrayList<Usuario>();
		String query = "SELECT u FROM Usuario u where ";
		if(!usr.getUsrCedula().equals(null))
			query+= "u.usrCedula = " +usr.getUsrCedula();
		
		
		try {
			list = find(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}

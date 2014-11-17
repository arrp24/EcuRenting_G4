package com.ecurenting.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ecurenting.entities.Cliente;
import com.ecurenting.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class ClienteEjb extends GenericDAOImpl<Cliente, Integer>{

	
	
	public ClienteEjb(){
		
	}
	
	public List<Cliente> buscarPorCedulaNombre(Cliente cli){
		List<Cliente> list = new ArrayList<Cliente>();
		String query = "SELECT c FROM Cliente c where ";
		if(!cli.getCliCedula().equals(null))
			query+= "c.cliCedula = " +cli.getCliCedula();
		
		
		try {
			list = find(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}

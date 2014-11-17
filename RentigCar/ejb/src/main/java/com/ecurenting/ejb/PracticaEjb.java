package com.ecurenting.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ecurenting.entities.Cliente;
import com.ecurenting.entities.Practica;
import com.ecurenting.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class PracticaEjb extends GenericDAOImpl<Practica, Integer>{

	public PracticaEjb(){
		
	}
	
	public List<Practica> buscarPorNombre(Practica prac){
		List<Practica> list = new ArrayList<Practica>();
		String query = "SELECT c FROM Practica c where ";
		if(!prac.getNombre().equals(null))
			query+= "c.nombre = " +prac.getNombre();
		
		
		try {
			list = find(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}


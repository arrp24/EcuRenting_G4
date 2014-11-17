package com.ecurenting.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ecurenting.entities.Ruta;
import com.ecurenting.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class RutaEjb extends GenericDAOImpl<Ruta, Integer>{

	public RutaEjb(){
		
	}
}

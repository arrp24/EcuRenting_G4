package com.ecurenting.ejb;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.ecurenting.entities.Vehiculo;
import com.ecurenting.utils.GenericDAOImpl;

@Stateless
@LocalBean
public class VehiculoEjb extends GenericDAOImpl<Vehiculo, Integer>{

	public VehiculoEjb(){
		
	}
	
	public List<Vehiculo> buscarPorPlacaMarca(Vehiculo veh){
		List<Vehiculo> list = new ArrayList<Vehiculo>();
		String query = "SELECT v FROM Vehiculo v where ";
		if(!veh.getVehPlaca().equals(null))
			query+= "v.vehPlaca = " +veh.getVehPlaca();
		
		
		try {
			list = find(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}

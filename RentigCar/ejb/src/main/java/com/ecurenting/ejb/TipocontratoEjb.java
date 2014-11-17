package com.ecurenting.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;



import com.ecurenting.entities.Tipocontrato;
import com.ecurenting.utils.GenericDAOImpl;

/**
 * Session Bean implementation class AlquilerAction
 */
@Stateless
@LocalBean
public class TipocontratoEjb extends GenericDAOImpl<Tipocontrato, Long>{

    /**
     * Default constructor. 
     */
    public TipocontratoEjb() {
        // TODO Auto-generated constructor stub
    }

}
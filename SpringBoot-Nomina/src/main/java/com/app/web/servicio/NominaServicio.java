package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Empleado;
import com.app.web.entidad.Nomina;

public interface NominaServicio {
	
	public List<Empleado> listarNominas();
	public Nomina obtenerEmpleadoPorDni(String dni);
}

package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Empleado;

public interface EmpleadoServicio {
	
	public List<Empleado> listarEmpleados();
	public Empleado guardarEmpleado(Empleado empleado);
	public Empleado obtenerEmpleadoPorDni(String dni);
	public Empleado actualizarEmpleado(Empleado empleado);
	public void eliminarEmpleado(String dni);
}

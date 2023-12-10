package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Empleado;
import com.app.web.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio{

	@Autowired
	private EmpleadoRepositorio repositorio;
	
	@Override
	public List<Empleado> listarEmpleados() {
		System.out.println("Lista de empleados: ");
		return repositorio.findAll();
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
	    System.out.println("Empleado guardado: " + empleado);
	    return repositorio.save(empleado);
	}

	@Override
	public Empleado obtenerEmpleadoPorDni(String dni) {
	return repositorio.findById(dni).get();
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public void eliminarEmpleado(String dni) {
		repositorio.deleteById(dni);
	}

	

}

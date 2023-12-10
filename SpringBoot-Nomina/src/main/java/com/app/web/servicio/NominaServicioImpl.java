package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Empleado;
import com.app.web.entidad.Nomina;
import com.app.web.repositorio.EmpleadoRepositorio;
import com.app.web.repositorio.NominaRepositorio;

@Service
public class NominaServicioImpl implements NominaServicio{
	
	@Autowired
	private NominaRepositorio repositorio;
	
	@Autowired
	private EmpleadoRepositorio repositorio2;

	@Override
	public Nomina obtenerEmpleadoPorDni(String dni) {
		return repositorio.findById(dni).get();
	}

	public List<Empleado> listarNominas() {
		return repositorio2.findAll();
	}

}

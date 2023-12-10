package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Empleado;
import com.app.web.servicio.EmpleadoServicio;
import com.app.web.servicio.NominaServicio;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoServicio servicio;
	
	@Autowired
	private NominaServicio servicioNom;

	@GetMapping({ "/index", "/" }) // Cuando se accede a esa URL, se invocará este método.
	public String index() {
		return "index"; // nos va a este archivo
	}

	@GetMapping("/empleados")
	public String mostrarEmpleados(Model modelo) {
		modelo.addAttribute("empleados", servicio.listarEmpleados());
		return "mostrarEmp";
	}

	@GetMapping("/crearEmp")
	public String FormularioCrearEmpleado(Model modelo) {
		Empleado empleado = new Empleado();
		modelo.addAttribute("empleado", empleado);
		return "crearEmp";
	}

	@PostMapping("/mostrarEmp")
	public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado) {
		servicio.guardarEmpleado(empleado);
		return "redirect:/empleados";
	}

	@GetMapping("/mostrarNom")
	public String mostrarNom(Model modelo) {
		modelo.addAttribute("nominas", servicioNom.listarNominas());
		return "mostrarNom";
	}

	@GetMapping("/empleados/editar/{dni}")
	public String editarEmpleado(@PathVariable String dni, Model modelo) {
		modelo.addAttribute("empleado", servicio.obtenerEmpleadoPorDni(dni));
		return "editarEmp";
	}

	@PostMapping("/empleados/{dni}")
	public String actualizarEmpleado(@PathVariable String dni, @ModelAttribute("empleado") Empleado empleado,
			Model modelo) {
		Empleado empleadoExistente = servicio.obtenerEmpleadoPorDni(dni);
		empleadoExistente.setDni(dni);
		empleadoExistente.setNombre(empleado.getNombre());
		empleadoExistente.setSexo(empleado.getSexo());
		empleadoExistente.setCategoria(empleado.getCategoria());
		empleadoExistente.setAnyos(empleado.getAnyos());
		
		servicio.actualizarEmpleado(empleadoExistente);
		return "redirect:/empleados";
	}

	@GetMapping("/empleados/{dni}")
	public String eliminarEmpleado(@PathVariable String dni) {
		servicio.eliminarEmpleado(dni);
		return "redirect:/empleados";
	}

}

package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, String>{

}

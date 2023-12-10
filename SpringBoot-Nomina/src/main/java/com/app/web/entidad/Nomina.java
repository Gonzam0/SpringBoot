package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nominas")
public class Nomina {
	
	@Id
	@Column(name = "dni", nullable = false, length = 9, unique = true)
	private String dni;
	
	@Column(name = "sueldo",  nullable = false)
	private double sueldo;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Nomina(String dni, double sueldo) {
		super();
		this.dni = dni;
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Nomina [dni=" + dni + ", sueldo=" + sueldo + "]";
	}
	
	public void calcularSueldo(Empleado e) {
        int[] SUELDO_BASE = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};
        this.sueldo = SUELDO_BASE[e.getCategoria() - 1] + 5000 * e.getAnyos();
    }

}

package com.app.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootNominaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNominaApplication.class, args);
		
		abrirEnNavegador();
	}
	
	private static void abrirEnNavegador() {
        try {
            String url = "http://localhost:8090/index";
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void run(String... args) throws Exception {
		/*
		Empleado emp1 = new Empleado("Yo", "M", 1, 1);
		repositorio.save(emp1);
		
		Empleado emp2 = new Empleado("Puede que sea yo", "M", 2, 2);
		repositorio.save(emp2);*/
	}

}

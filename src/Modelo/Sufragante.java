package Modelo;

import Modelo.Persona.egenero;

public class Sufragante extends Persona{
	
	int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	public Sufragante() {
		
	}
	
	public Sufragante(int du, String nombre, String apellido, egenero genero, int edad, String domicilio, int status) {
		
		this.du = du;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
		this.domicilio = domicilio;
		this.status = status;
		
	}
	
	
}

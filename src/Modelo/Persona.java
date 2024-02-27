package Modelo;

import Modelo.Persona.egenero;

public class Persona {
	
	int du, edad;
	String nombre, apellido, domicilio;
	egenero genero;
	
	
	public enum egenero {
	masculino,
	femenino,
	otro;
	}

	public int getDu() {
		return du;
	}

	public void setDu(int du) {
		this.du = du;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public egenero getGenero() {
		return genero;
	}

	public void setGenero(egenero genero) {
		this.genero = genero;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Persona(int du, int edad, String nombre, String apellido, String domicilio, egenero genero) {
		super();
		this.du = du;
		this.edad = edad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.genero = genero;
	}

	public Persona() {
		super();
	}
	
	
}


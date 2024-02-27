package Modelo;

import Modelo.Candidato.epartido;
import Modelo.Persona.egenero;

public class Candidato extends Persona{
	
	epartido partido;
	String lema;
	int vecesvotado;
	
	public enum epartido {
	    FRENTE_DE_TODOS,
	    JUNTOS_POR_EL_CAMBIO,
	    REVOLUCIÓN_CIVIL,
	    LIBRES_DEL_SUR,
	    PODEMOS;
	}

	public epartido getPartido() {
		return partido;
	}

	public void setPartido(epartido partido) {
		this.partido = partido;
	}

	public String getLema() {
		return lema;
	}

	public void setLema(String lema) {
		this.lema = lema;
	}

	public int getVecesvotado() {
		return vecesvotado;
	}

	public void setVecesvotado(int vecesvotado) {
		this.vecesvotado = vecesvotado;
	}

	public Candidato(int du, String nombre, String apellido, egenero genero, int edad, String domicilio, epartido partido, String lema, int vecesvotado) {
		
		this.du = du;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
		this.domicilio = domicilio;
		this.partido = partido;
		this.lema = lema;
		this.vecesvotado = vecesvotado;
	
	}

	public Candidato() {
			}
	
	  public void incrementarvotos() {
	        vecesvotado++;
	    }
	
}

package Modelo;

public class Voto {

	int sumavoto;
	int sumavotacion;
	int sumapartido;
	Candidato candidato;
	public int getSumavoto() {
		return sumavoto;
	}
	public void setSumavoto(int sumavoto) {
		this.sumavoto = sumavoto;
	}
	public int getSumavotacion() {
		return sumavotacion;
	}
	public void setSumavotacion(int sumavotacion) {
		this.sumavotacion = sumavotacion;
	}
	public int getSumapartido() {
		return sumapartido;
	}
	public void setSumapartido(int sumapartido) {
		this.sumapartido = sumapartido;
	}
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public Voto(int sumavoto, int sumavotacion, int sumapartido, Candidato candidato) {
		super();
		this.sumavoto = sumavoto;
		this.sumavotacion = sumavotacion;
		this.sumapartido = sumapartido;
		this.candidato = candidato;
	}
	public Voto() {
		super();
	}
	
}


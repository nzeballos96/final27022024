package Controlador;

import Modelo.Voto;

public class CVoto extends Voto {
	
	static int votoblanco = 0;
	static int votonulo = 0;
	static int votosTotales = 0;
	static int votosrealizados = 0;
	static int asistencias = 0;
	
	public static void votoenblanco() {
		
		votoblanco++;
	}
	public static void votoennulo() {
		
		votonulo++;
	}
	
	public static void muestravotosenblanco() {		
	 System.out.println("Votos en blanco: " + votoblanco);
	    }
	public static void muestravotosennulo() {		
		 System.out.println("Votos en nulo: " + votonulo);
		    }
	
	public static int sumarVotosTotalesvoto() {

		votosTotales =  CCandidato.sumarVotosTotales();

	    return votosTotales;
	}
	
	public static int sumarVotosrealizadosvoto() {

	 asistencias = CSufragante.sumarVotosrealizados();
	    

	    return asistencias;
	}
	
	public static void validarvotacion() {

		votosrealizados = votosTotales	+	votoblanco	+votonulo;
		
		System.out.println("VOTOS REALIZADOS CANTIDAD: " + votosrealizados );
		
		System.out.println("ASISTENCIA DE VOTANTES: " + asistencias );

		int margendeerror = 0;
		
		margendeerror = votosrealizados   -  asistencias;
	
		System.out.println("MARGEN DE ERROR EN VOTOS: " + margendeerror );
	
	}
}


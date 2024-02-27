package Controlador;

import java.util.*;
import Modelo.Candidato;
import Modelo.ExcepcionVotanteNoEncontrado;

public class CCandidato extends Candidato {

	static Scanner sc = new Scanner(System.in);

	private static HashMap<Integer, Candidato> candidatos = new HashMap<>();
	private static HashMap<epartido, Integer> partidosVotos = new HashMap<>();
	private static HashMap<Candidato, Integer> candidatosVotos = new HashMap<>();
	static List<Map.Entry<Candidato, Integer>> entradasOrdenadascan = new ArrayList<>(candidatosVotos.entrySet());
	static List<Map.Entry<epartido, Integer>> entradasOrdenadas = new ArrayList<>(partidosVotos.entrySet());
	// COMPARADOR
	private static Comparator<Candidato> ordenarPorPartido = Comparator.comparing(Candidato::getPartido);

	static int votosTotales = 0;

	public static Void cargarcandidato(int du, String nombre, String apellido, egenero genero, int edad,
			String domicilio, epartido partido, String lema, int vecesvotado) {

		Candidato candidato = new Candidato(du, nombre, apellido, genero, edad, domicilio, partido, lema, vecesvotado);

		candidatos.put(du, candidato);

		System.out.println("CANDIDATO CARGADO");

		return null;
	}

	// VALIDO EXISTENCIAS
	public static boolean validarcandidato(int du) {

		if (candidatos.containsKey(du)) {
			return false;
		}
		return true;
	}

	// MUESTREO DE LISTA
	public static void mostrarcandidatos() {

		// CREO LISTA POR PARTIDO
		List<Candidato> candidatosOrdenados = new ArrayList<>(candidatos.values());
		candidatosOrdenados.sort(ordenarPorPartido);

		for (Candidato candidato : candidatosOrdenados) {
			System.out.println("DU: " + candidato.getDu() + " - " + "NOMBRE: " + candidato.getNombre() + " - "
					+ "APELLIDO: " + candidato.getApellido() + " - " + "GENERO: " + candidato.getGenero() + " - "
					+ "EDAD: " + candidato.getEdad() + " - " + "DOMICILIO: " + candidato.getDomicilio() + " - "
					+ " PARTIDO: " + candidato.getPartido() + " - " + "LEMA: " + candidato.getLema());
			System.out.println("-----------------------------------------------------------------------------------");
		}
	}

	public static boolean sumarvoto(int du) {

		if (candidatos.containsKey(du)) {
			candidatos.get(du).incrementarvotos();
			epartido partidoCandidato = candidatos.get(du).getPartido();
			// INCREMENTO VOTOS DEL PARTIDO DEL CANDIDATO
			if (partidosVotos.containsKey(partidoCandidato)) {
				partidosVotos.put(partidoCandidato, partidosVotos.get(partidoCandidato) + 1);
			} else {
				partidosVotos.put(partidoCandidato, 1);
			}
			return true;
		} else {
			return false;
		}
	}

	public static void mostrarvotoscandidatos() {

		// CREAR LISTA CON TODOS LOS CANDIDATOS
		List<Candidato> candidatosOrdenados2 = new ArrayList<>(candidatos.values());

		// ORDENAR CANDIDATOS POR VOTOS (MAYOR A MENOR)
		Collections.sort(candidatosOrdenados2, new VotosComparator());

		for (Candidato candidato : candidatos.values()) {
			System.out.println("VOTOS RECIBIDOS: " + candidato.getVecesvotado() + " - DU: " + candidato.getDu() + " - "
					+ "NOMBRE: " + candidato.getNombre() + " - " + "APELLIDO: " + candidato.getApellido() + " - "
					+ " - " + " PARTIDO: " + candidato.getPartido());
			System.out.println("-----------------------------------------------------------------------------------");
		}
	}

	public static int sumarVotosTotales() {

		for (Candidato candidato : candidatos.values()) {
			votosTotales += candidato.getVecesvotado();

			System.out.println("-----------------------------------------------------------------------------------");
		}

		return votosTotales;
	}

	public static Candidato buscarCandidato(int du) throws ExcepcionVotanteNoEncontrado {
		if (candidatos.containsKey(du)) {
			throw new ExcepcionVotanteNoEncontrado("Votante con DU " + du + " es un candidato.");
		}
		return candidatos.get(du);
	}

	public static void mostrarVotosdePartidos() {

		// ORDENAR PARTIDOS POR VOTOS
		List<Map.Entry<epartido, Integer>> partidosOrdenadosPorVotos = new ArrayList<>(partidosVotos.entrySet());
		partidosOrdenadosPorVotos.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		// IMPRIMIR VOTOS DE LOS PARTIDOS
		for (Map.Entry<epartido, Integer> partidoVotos : partidosOrdenadosPorVotos) {
			System.out.println("PARTIDO: " + partidoVotos.getKey() + " - " + "VOTOS: " + partidoVotos.getValue());
		}
	}

	// CREO UN COMPARADOR
	public static class VotosComparator implements Comparator<Candidato> {

		@Override
		public int compare(Candidato candidato1, Candidato candidato2) {
			// COMPARA LOS VOTOS DE LOS CANDIDATOS EN ORDEN DESCENDENTE
			return Integer.compare(candidato2.getVecesvotado(), candidato1.getVecesvotado());
		}
	}
}
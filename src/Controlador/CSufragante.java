package Controlador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import Modelo.Consola;
import Modelo.ExcepcionVotanteNoEncontrado;
import Modelo.ExcepcionVotanteReincidente;
import Modelo.Sufragante;

public class CSufragante extends Sufragante {

	static Consola opciones = new Consola();

//	static Scanner sc = new Scanner(System.in);

	private static HashMap<Integer, Sufragante> sufragantes = new HashMap<>();

	static int votantesasistencia = 0;

	// CARGA DE SUFRAGANTE
	public static Void cargarsufragante(int du, String nombre, String apellido, egenero genero, int edad,
			String domicilio, int status) {

		Sufragante sufragante = new Sufragante(du, nombre, apellido, genero, edad, domicilio, status);

		sufragantes.put(du, sufragante);

		System.out.println("SUFRAGANTE CARGADO");

		return null;
	}

	// VALIDO EXISTENCIAS
	public static boolean validarsufragante(int du) {

		if (sufragantes.containsKey(du)) {
			return false;
		}
		return true;
	}

	public static boolean validargenero(egenero genero) {

		if (sufragantes.containsKey(genero)) {
			return false;
		}
		return true;
	}

	// MUESTRO LISTA
	public static void mostrarSufragantes() {
		List<Sufragante> sufragantesOrdenados = new ArrayList<>(sufragantes.values());
		sufragantesOrdenados.sort(new ComparadorSufragantes());

		for (Sufragante sufragante : sufragantesOrdenados) {
			System.out.println("DU: " + sufragante.getDu() + " - " + "APELLIDO: " + sufragante.getApellido() + " - "
					+ "NOMBRE: " + sufragante.getNombre() + " - " + "GENERO: " + sufragante.getGenero() + " - "
					+ "EDAD: " + sufragante.getEdad() + " - " + "DOMICILIO: " + sufragante.getDomicilio());
			System.out.println("-----------------------------------------------------------------------------------");
		}
	}

	// CAMBIO ESTADO DEL SUFRAGANTE
	public static void cambiarStatus(int du) throws ExcepcionVotanteNoEncontrado {

		// VALIDO SUFRAGANTE
		if (!sufragantes.containsKey(du)) {
			// System.out.println("Sufragante con DNI " + du + " no encontrado.");
			return;
		}

		Sufragante sufragante = sufragantes.get(du);

		// VERIFICO QUE NO VOTO
		if (sufragante.getStatus() == 1) {
			// INSTANCION LA EXCEPCION
			ExcepcionVotanteReincidente.votantereincidente(du);
			// System.out.println("El sufragante con DNI " + du + " ya ha votado.");
			Consola.Menu();
			return;
		}

		// MODIFICO EL ESTADO
		sufragante.setStatus(1);
		// System.out.println("El estado del sufragante con DNI " + du + " se ha
		// cambiado a 'Votado'.");
	}

	public static int sumarVotosrealizados() {

		for (Sufragante sufragante : sufragantes.values()) {
			votantesasistencia += sufragante.getStatus();
		}

		return votantesasistencia;
	}

	// CREO UN COMPARADOR
	public static class ComparadorSufragantes implements Comparator<Sufragante> {
		@Override
		public int compare(Sufragante s1, Sufragante s2) {
			int comparacionNombre = s1.getApellido().compareTo(s2.getApellido());
			if (comparacionNombre == 0) {
				int comparacionApellido = s1.getNombre().compareTo(s2.getNombre());
				if (comparacionApellido == 0) {
					return Integer.compare(s1.getEdad(), s2.getEdad());
				} else {
					return comparacionApellido;
				}
			} else {
				return comparacionNombre;
			}
		}
	}

	public static Sufragante buscarSufragante(int du) throws ExcepcionVotanteNoEncontrado {
		if (!sufragantes.containsKey(du)) {
			throw new ExcepcionVotanteNoEncontrado("Votante con DU " + du + " no encontrado.");
		} else {

		}
		return sufragantes.get(du);
	}

}

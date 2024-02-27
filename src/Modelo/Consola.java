package Modelo;

import java.util.Scanner;

import Controlador.CCandidato;
import Controlador.CSufragante;
import Controlador.CVoto;
import Modelo.Candidato.epartido;
import Modelo.Persona.egenero;

public class Consola {

	static Scanner sc = new Scanner(System.in);

	public Consola() {}
	
	public static void Menu() throws ExcepcionVotanteNoEncontrado {

		sc = new Scanner(System.in);

		System.out.println("Bienvenido al menú");
		
		System.out.println("1. --> ALTA SUFRAGANTE");
		
		System.out.println("2. --> ALTA CANDIDATO");
		
		System.out.println("3. --> VOTAR");
		
		System.out.println("4. --> PADRON");
		
		System.out.println("5. --> CANDIDATOS");
		
		System.out.println("6. --> GENERAR ESCRUTINIO");
				
		System.out.println("7. --> VALIDACION DE VOTOS");
		
		System.out.println("8. --< Acerca de >--");

		int opcion = sc.nextInt();

		switch (opcion) {
		
		case 1:

			System.out.println("Bienvenido a carga de sufragante");
			
			System.out.println("--------------------------------");

			System.out.println("INGRESE DNI");

			int du1 = sc.nextInt();

			boolean validos1 = CSufragante.validarsufragante(du1);
			
			boolean validoc1 = CCandidato.validarcandidato(du1);

			if (!validoc1) {
				
				System.out.println("El DNI " + du1 + " ya está registrado como sufragante. Volviendo al menu.");
			
				Menu();
				
			}else {
			
			if (!validos1) {
				
				System.out.println("El DNI " + du1 + " ya está registrado. Volviendo al menu.");
				
				Menu();
				
				break;
			}

			System.out.println("INGRESE NOMBRE");

			String nombre1 = sc.next();

			System.out.println("INGRESE APELLIDO");

			String apellido1 = sc.next();

			System.out.println("INGESE GENERO");

			for (int i = 0; i < egenero.values().length; i++) {
			
				System.out.println(i + 1 + " - " + egenero.values()[i].name());
			}
			
			int opgenero1 = sc.nextInt();
			
			while (opgenero1 < 1 || opgenero1 > egenero.values().length) {
			    System.out.println("INGESE GENERO (Opción válida entre 1 y " + egenero.values().length + "):");
			    for (int i = 0; i < egenero.values().length; i++) {
			        System.out.println(i + 1 + " - " + egenero.values()[i].name());
			    }
			    opgenero1 = sc.nextInt();
			}

			egenero genero1 = Persona.egenero.values()[opgenero1 - 1];

			System.out.println("INGRESE EDAD");

			int edad1 = sc.nextInt();

			System.out.println("INGRESE DOMICILIO");

			String domicilio1 = sc.next();

			int status = 0;

			CSufragante.cargarsufragante(du1, nombre1, apellido1, genero1, edad1, domicilio1, status);

			}
			
			Menu();
			
			break;

		case 2:

			System.out.println("Bienvenido a carga de candidato");
			
			System.out.println("--------------------------------");

			System.out.println("INGRESE DNI");
			
			int du2 = sc.nextInt();

			boolean validos2 = CSufragante.validarsufragante(du2);
			
			boolean validoc2 = CCandidato.validarcandidato(du2);

//        	    String mensaje = "DNI "+ du + " YA CARGADO.";

			if (!validos2) {
				
				System.out.println("El DNI " + du2 + " ya está registrado como sufragante. Volviendo al menu.");
			
				Menu();
				
			}else {
			
			if (!validoc2) {
				
				System.out.println("El DNI " + du2 + " ya está registrado como candidato. Volviendo al menu.");
			
				Menu();
				
			}

			System.out.println("INGRESE NOMBRE");

			String nombre2 = sc.next();

			System.out.println("INGRESE APELLIDO");

			String apellido2 = sc.next();

			System.out.println("INGESE GENERO");

			for (int i = 0; i < egenero.values().length; i++) {
			
				System.out.println(i + 1 + " - " + egenero.values()[i].name());
			
			}

			int opgenero2 = sc.nextInt();
			
			while (opgenero2 < 1 || opgenero2 > egenero.values().length) {
			    System.out.println("INGESE GENERO (Opción válida entre 1 y " + egenero.values().length + "):");
			    for (int i = 0; i < egenero.values().length; i++) {
			        System.out.println(i + 1 + " - " + egenero.values()[i].name());
			    }
			    opgenero2 = sc.nextInt();
			}
			
			egenero genero2 = Persona.egenero.values()[opgenero2 - 1];
			
			System.out.println("INGRESE EDAD");

			int edad2 = sc.nextInt();

			System.out.println("INGRESE DOMICILIO");

			String domicilio2 = sc.next();

			System.out.println("INGESE PARTIDO");

			for (int i = 0; i < epartido.values().length; i++) {
			
				System.out.println(i + 1 + " - " + epartido.values()[i].name());
			
			}

			int oppartido = sc.nextInt();

			while (oppartido < 1 || oppartido > epartido.values().length) {
			    System.out.println("INGESE PARTIDO VALIDO (Opción válida entre 1 y " + epartido.values().length + "):");
			    for (int i = 0; i < epartido.values().length; i++) {
			        System.out.println(i + 1 + " - " + epartido.values()[i].name());
			    }
			    oppartido = sc.nextInt();
			}
			epartido partido = Candidato.epartido.values()[oppartido - 1];

			System.out.println("INGRESE LEMA");

			String lema = sc.next();

			int vecesvotado = 0;

			CCandidato.cargarcandidato(du2, nombre2, apellido2, genero2, edad2, domicilio2, partido, lema, vecesvotado);

			}
			
			Menu();
			
			break;
			
		case 3:
			
			System.out.println("SELECCIONE UNA OPCION");
			
			System.out.println("1- Votar candidato");
			
			System.out.println("2- Votar nulo");
			
			System.out.println("3- Votar en blanco");
			
			System.out.println("0- Volver al menu");

			int votacion = sc.nextInt();

			switch (votacion) {
			
			case 1:

				System.out.println("Bienvenido a votar");
				
				System.out.println("--------------------------------");

				System.out.println("INGRESE SU DU");
				
				int dus3 = sc.nextInt();

				boolean validos3 = CSufragante.validarsufragante(dus3);
				
				CSufragante.cambiarStatus(dus3);
				
		//		try {
				
				if (!validos3) {

					System.out.println("INGRESE EL DU DE CANDIDATO ELEGIDO");
				
					CCandidato.mostrarcandidatos();
					
					int du3 = sc.nextInt();

					boolean valido3 = CCandidato.sumarvoto(du3);

					if (!valido3) {
						
						System.out.println("El DNI " + du3 + " no está registrado.");
						
						System.out.println("El VOTO SE CARGARA COMO NULO");
						
						System.out.println("Volviendo al menu.");
						
						CVoto.votoennulo();
						
						Menu();
						
					} else {
						
						System.out.println("VOTO EMITIDO.");
					
						Menu();
					
					}
					
				} else {
				
					//INSTANCIO LA EXCEPCION
					ExcepcionVotanteNoEncontrado.votantenoencontrado(dus3); 
					
				}
				
				Menu();
								
				break;
				
			case 2:
				
				CVoto.votoennulo();
				
				break;
				
			case 3:
				
				CVoto.votoenblanco();
				
				break;
				
			default:
				
				System.out.println("OPCION INVALIDA, VOLVIENDO AL MENU");
				
				System.out.println("VUELVA A REALIZAR LOS PASOS ANTERIORES");
				
				break;
			}
			
			Menu();
			
			break;
		case 4:
			
			CSufragante.mostrarSufragantes();
			
			Menu();
			
			break;
		case 5:

			CCandidato.mostrarcandidatos();
			
			Menu();
			
			break;
		case 6:

			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------");
			System.out.println("------------------------------------------------");
			
			CCandidato.mostrarvotoscandidatos();		
			CVoto.muestravotosenblanco();		
			CVoto.muestravotosennulo();
			CCandidato.mostrarVotosdePartidos();
			
			CSufragante.sumarVotosrealizados();
			CCandidato.sumarVotosTotales();
			CVoto.sumarVotosrealizadosvoto();
			CVoto.sumarVotosTotalesvoto();
			CVoto.validarvotacion();
			
			System.exit(0);
			
			Menu();

			break;

		case 7:

			CSufragante.sumarVotosrealizados();
			CCandidato.sumarVotosTotales();
			CVoto.sumarVotosrealizadosvoto();
			CVoto.sumarVotosTotalesvoto();
			CVoto.validarvotacion();
			
			Menu();

			break;
			
		case 8:

			System.out.println( "ZEBALLOS NICOLAS, 27/02/2024");
			
			Menu();

			break;
			
		case 99999:
			// CARGAS PARA PRUEBA 
			CCandidato.cargarcandidato(98765432, "Pedro", "Gómez", egenero.masculino, 40, "Calle 789", epartido.FRENTE_DE_TODOS, "Un nuevo camino", 0);
			CCandidato.cargarcandidato(10987654, "Ana", "Fernández", egenero.femenino, 35, "Calle 1011", epartido.FRENTE_DE_TODOS, "Por la unidad", 0);
			CCandidato.cargarcandidato(12131415, "Sofía", "López", egenero.femenino, 22, "Calle 1415", epartido.PODEMOS, "Hacia un futuro mejor", 0);
			CCandidato.cargarcandidato(13141516, "Diego", "Rodríguez", egenero.masculino, 50, "Calle 1617", epartido.LIBRES_DEL_SUR, "Por la justicia social", 0);
			CCandidato.cargarcandidato(14151617, "Camila", "Sánchez", egenero.femenino, 45, "Calle 1819", epartido.JUNTOS_POR_EL_CAMBIO, "Un cambio con progreso", 0);
			CCandidato.cargarcandidato(16171819, "Laura", "Pérez", egenero.femenino, 25, "Calle 2223", epartido.REVOLUCIÓN_CIVIL, "Por la igualdad", 0);
			
			
			CSufragante.cargarsufragante(10000000, "Juan", "Pérez", egenero.masculino, 30, "Calle 123", 0);
			CSufragante.cargarsufragante(10000001, "María", "González", egenero.femenino, 25, "Calle 456", 0);
			CSufragante.cargarsufragante(10000002, "Pedro", "Gómez", egenero.masculino, 40, "Calle 789", 0);
			CSufragante.cargarsufragante(10000003, "Ana", "Fernández", egenero.femenino, 35, "Calle 1011", 0);
			CSufragante.cargarsufragante(10000004, "Luis", "Martínez", egenero.masculino, 20, "Calle 1213", 0);
			CSufragante.cargarsufragante(10000005, "Sofía", "López", egenero.femenino, 22, "Calle 1415", 0);
			CSufragante.cargarsufragante(10000006, "Diego", "Rodríguez", egenero.masculino, 50, "Calle 1617", 0);
			CSufragante.cargarsufragante(10000007, "Camila", "Sánchez", egenero.femenino, 45, "Calle 1819", 0);
			CSufragante.cargarsufragante(10000008, "Martín", "Díaz", egenero.masculino, 30, "Calle 2021", 0);
			CSufragante.cargarsufragante(10000009, "Laura", "Pérez", egenero.femenino, 25, "Calle 2223", 0);
			
			CCandidato.sumarvoto(98765432);
			CCandidato.sumarvoto(98765432);
			CCandidato.sumarvoto(98765432);
			CCandidato.sumarvoto(16171819);
			CCandidato.sumarvoto(98765432);
			CCandidato.sumarvoto(16171819);
			CCandidato.sumarvoto(16171819);
			CCandidato.sumarvoto(14151617);
			
			Menu();
			break;
		
		default:
			
			System.out.println("Opción inválida");
			
			Menu();
			
			break;
		}
	}

}

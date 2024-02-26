package Modelo;

import java.util.Scanner;

public class Consola {

	static Scanner sc = new Scanner(System.in);

	public Consola() {}
	
	public static void Menu() {

			sc = new Scanner(System.in);

			System.out.println("Bienvenido al menú");
			
			System.out.println("1. --> ");
			
			System.out.println("2. --> ");
			
			System.out.println("3. --> ");
			
			System.out.println("4. --> ");
			
			System.out.println("5. --> ");
			
			System.out.println("6. --> ");
			
			System.out.println("7. --> ");
			
			System.out.println("8. --> ");
			
			System.out.println("9. --< Acerca de >--");
			
			System.out.println("0. --> Salir <--");

			int opcion = sc.nextInt();

			switch (opcion) {
			
			case 1:

				Menu();
				
				break;

			case 2:

				Menu();
				
				break;
				
			case 3:
				
				Menu();
				
				break;
			case 4:
				
				Menu();
				
				break;
			case 5:

				Menu();
				
				break;
			case 6:
				
				Menu();

				break;

			case 7:

				Menu();

				break;

			case 8:
				
				Menu();

				break;
				
			case 9:

				System.out.println( "ZEBALLOS NICOLAS, 27/02/2024");
				
				Menu();

				break;

			case 0:
				
				System.out.println("Gracias por usar el menú");
				
				System.exit(0);
			
			default:
				
				System.out.println("Opción inválida");
				
				Menu();
				
				break;
			}
	}
}


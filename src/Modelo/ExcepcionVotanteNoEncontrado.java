package Modelo;

public class ExcepcionVotanteNoEncontrado extends Exception{

	public ExcepcionVotanteNoEncontrado(String mensaje) {
		super(mensaje);
	}

	public static void votantenoencontrado(int du) {
		
		try {
			throw new ExcepcionVotanteNoEncontrado ("El DU " + du + " no está registrado en el sistema o es un candidato.");
			
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
		
		}
	}
}

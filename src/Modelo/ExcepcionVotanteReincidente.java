package Modelo;

public class ExcepcionVotanteReincidente extends Exception{

		public ExcepcionVotanteReincidente (String mensaje){
			super(mensaje);
		}
		public static void votantereincidente(int du) {
			
			try {
				throw new ExcepcionVotanteReincidente ("El DU " + du + " ya ah emitido su voto");
				
			}catch (Exception e) {
				
				System.out.println(e.getMessage());
			
			}
		}
}

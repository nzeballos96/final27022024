package Modelo;

public class Principal {

	public static void main(String[] args) throws ExcepcionVotanteNoEncontrado {
		// TODO Auto-generated method stub

		Consola con = new Consola();
		
		con.Menu();
		
		Conect c = new Conect();
		c.conexion();
	}

}

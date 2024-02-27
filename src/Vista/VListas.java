package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Modelo.Conect;

import javax.swing.JTable;

public class VListas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tlista;

	/**
	 * Create the panel.
	 */
	public VListas() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTA DE CANDIDATOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(92, 34, 1143, 56);
		add(lblNewLabel);
		
		tlista = new JTable();
		tlista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tlista.setBounds(52, 109, 1182, 571);
		add(tlista);

		cargalista();
		
	}

        
   public void llenarPadron(int id_elec) {
        String sqlmc = "SELECT p.DU, p.APELLIDO, p.NOMBRE, p.DOMICILIO, p.GENERO, p.EDAD, c.PARTIDO, c.LEMA FROM tpersona AS p JOIN tcandidato AS c on p.DU = c.DU_PER WHERE c.ID_ELEC= ? ORDER BY p.DU, p.APELLIDO, p.NOMBRE, p.EDAD";
        Conect conexion = new Conect();
        try (
           
            PreparedStatement ps = conexion.conexion().prepareStatement(sqlmc);
        ) {
        	
        	DefaultTableModel tpad = new DefaultTableModel();
        	tpad.addColumn("DU");
        	tpad.addColumn("APELLIDO");
        	tpad.addColumn("NOMBRE");
        	tpad.addColumn("DOMICILIO");
        	tpad.addColumn("GENERO");
        	tpad.addColumn("EDAD");
        	tpad.addColumn("PARTIDO");
        	tpad.addColumn("LEMA");
        	tlista.setModel(tpad);

        	        String[] datos = new String[8];
            ps.setInt(1, id_elec);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                tpad.addRow(datos);
            }
                }catch (SQLException e) {
        String mensaje = "Error al cargar datos: " + e.getMessage();
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
            
        } 
            
        }
        
    public void cargalista() {

			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			int id_elec = 0;

			Conect cn = new Conect();
			
			try {

				PreparedStatement statementrc = null;
				String id_elecc = "SELECT MAX(ID_ELEC) FROM teleccion WHERE STATUS = 0;";

				statementrc = cn.conexion().prepareStatement(id_elecc);
				resultSet = statementrc.executeQuery(id_elecc);

				if (resultSet.next()) {

					id_elec = resultSet.getInt(1);

					llenarPadron(id_elec);

				} else {
					System.out.println("No se encontraron elecciones con STATUS = 0.");
				}
			} catch (SQLException e1) {

			}

		}
}
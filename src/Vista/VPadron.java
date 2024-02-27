package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Modelo.Conect;

import javax.swing.JTable;

public class VPadron extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JTable tpadron;

	/**
	 * Create the panel.
	 */
	public VPadron() {
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("PADRON ELECTORAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(151, 49, 1006, 52);
		add(lblNewLabel);
		
		tpadron = new JTable();
		tpadron.setBounds(53, 111, 1169, 603);
		add(tpadron);
		
		cargapadron();
		
	}

        
   public void llenarPadron(int id_elec) {
        String sqlmc = "SELECT p.DU, p.APELLIDO, p.NOMBRE, p.DOMICILIO, p.GENERO, p.EDAD, s.STATUS FROM tpersona AS p JOIN tsufragante AS s on p.DU = s.DU_PER WHERE s.ID_ELEC = ? ";
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
        	tpad.addColumn("STATUS");
        	tpadron.setModel(tpad);

        	        String[] datos = new String[7];
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
                tpad.addRow(datos);
            }
                }catch (SQLException e) {
        String mensaje = "Error al cargar datos: " + e.getMessage();
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
            
        } 
            
        }
        
    public void cargapadron() {

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

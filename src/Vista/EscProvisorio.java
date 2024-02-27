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

public class EscProvisorio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable candidatos;
	private JTable partidos;

	/**
	 * Create the panel.
	 */
	public EscProvisorio() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANDIDATOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(71, 58, 1059, 40);
		add(lblNewLabel);
		
		candidatos = new JTable();
		candidatos.setBounds(101, 108, 1073, 176);
		add(candidatos);
		
		JLabel lblPartidos = new JLabel("PARTIDOS");
		lblPartidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartidos.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPartidos.setBounds(90, 332, 1059, 40);
		add(lblPartidos);
		
		partidos = new JTable();
		partidos.setBounds(101, 430, 1073, 200);
		add(partidos);

		cargalistaCAN();
		cargalistaCpar();
	}
	
	 public void llenarPadronCAN(int id_elec) {
	        String sqlmc = "SELECT p.DU, p.APELLIDO, p.NOMBRE, c.PARTIDO, c.LEMA, c.cvoto FROM tpersona AS p JOIN tcandidato AS c on p.DU = c.DU_PER WHERE c.ID_ELEC= ? ORDER BY p.DU, p.APELLIDO, p.NOMBRE, p.EDAD";
	        Conect conexion = new Conect();
	        try (
	           
	            PreparedStatement ps = conexion.conexion().prepareStatement(sqlmc);
	        ) {
	        	
	        	DefaultTableModel tpad = new DefaultTableModel();
	        	tpad.addColumn("DU");
	        	tpad.addColumn("APELLIDO");
	        	tpad.addColumn("NOMBRE");
	        	tpad.addColumn("PARTIDO");
	        	tpad.addColumn("LEMA");
	        	tpad.addColumn("VOTOS");
	        	
	        	candidatos.setModel(tpad);

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
	                tpad.addRow(datos);
	            }
	                }catch (SQLException e) {
	        String mensaje = "Error al cargar datos: " + e.getMessage();
	        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	            
	        } 
	            
	        }
	        
	    public void cargalistaCAN() {

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

						llenarPadronCAN(id_elec);

					} else {
						System.out.println("No se encontraron elecciones con STATUS = 0.");
					}
				} catch (SQLException e1) {

				}

			}
	    
	    public void llenarPadronCpar(int id_elec) {
	        String sqlmc = "SELECT PARTIDO, SUM(CVOTO) FROM tcandidato WHERE ID_ELEC = ? ORDER by PARTIDO";
	        Conect conexion = new Conect();
	        try (
	           
	            PreparedStatement ps = conexion.conexion().prepareStatement(sqlmc);
	        ) {
	        	
	        	DefaultTableModel tpad = new DefaultTableModel();
	        	tpad.addColumn("PARTIDO");
	        	tpad.addColumn("VOTOS");
	        	
	        	partidos.setModel(tpad);

	        	        String[] datos = new String[2];
	            ps.setInt(1, id_elec);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                datos[0] = rs.getString(1);
	                datos[1] = rs.getString(2);
	            
	                tpad.addRow(datos);
	            }
	                }catch (SQLException e) {
	        String mensaje = "Error al cargar datos: " + e.getMessage();
	        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	            
	        } 
	            
	        }
	        
	    public void cargalistaCpar() {

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

						llenarPadronCpar(id_elec);

					} else {
						System.out.println("No se encontraron elecciones con STATUS = 0.");
					}
				} catch (SQLException e1) {

				}

			}
}

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EscDefinitivo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable GANADO;
	private JTable PAR;
	private JTable SUMA;

	/**
	 * Create the panel.
	 */
	public EscDefinitivo() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANDIDATOS GANADORES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(80, 0, 1078, 69);
		add(lblNewLabel);
		
		GANADO = new JTable();
		GANADO.setBounds(132, 107, 1026, 158);
		add(GANADO);
		
		JLabel lblVotosDePartidos = new JLabel("VOTOS DE PARTIDOS");
		lblVotosDePartidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotosDePartidos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblVotosDePartidos.setBounds(91, 275, 1078, 69);
		add(lblVotosDePartidos);
		
		PAR = new JTable();
		PAR.setBounds(132, 335, 1026, 119);
		add(PAR);
		
		SUMA = new JTable();
		SUMA.setBounds(132, 489, 1026, 119);
		add(SUMA);
		
		JButton btnNewButton = new JButton("CERRAR ELECCION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CARGARELECCION();
				cargalistaCAN();
				cargalistaCpar();
				
			}
		});
		btnNewButton.setBounds(132, 650, 1026, 21);
		add(btnNewButton);


	}
	 public void llenarPadronCAN(int id_elec) {
	        String sqlmc = "SELECT p.DU, p.APELLIDO, p.NOMBRE, c.PARTIDO, c.LEMA, c.cvoto FROM tpersona AS p JOIN tcandidato AS c on p.DU = c.DU_PER WHERE c.ID_ELEC= ? ORDER BY C.CVOTO LIMIT 3";
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
	        	
	        	GANADO.setModel(tpad);

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
	        	
	        	PAR.setModel(tpad);

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

	    public void CARGARELECCION() {

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

						CerrarElec(id_elec);
		
					} else {
						System.out.println("No se encontraron elecciones con STATUS = 0.");
					}
				} catch (SQLException e1) {

				}

			}
	    
	    public static void CerrarElec(int id_elec) {
	    	
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
		

			Conect cn = new Conect();
	    
	    try {

	    	
	    	PreparedStatement statementrc = null;

			String sqlins = "UPDATE teleccion SET status = status + 1 WHERE id_elec = ?";
			statementrc = cn.conexion().prepareStatement(sqlins);

			statementrc.setInt(1, id_elec);

			int sta = statementrc.executeUpdate();

	        if (sta == 1) {

	            JOptionPane.showMessageDialog(null, "registrado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            throw new SQLException("ERROR " + sta);
	        }

		} catch (SQLException e) {
			// System.err.println("Error al insertar sufragante: " + e.getMessage());
		}
	    }
	    
}

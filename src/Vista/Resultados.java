package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelo.Conect;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Resultados extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable ELECCIONS;
	private static JTable ganadores;
	private static JTable partido;
	private static JTable blanco;
	private static JTable nulo;
	private static JTable afirma;
	private static JTable total;
	private JTextField id_elecc;

	/**
	 * Create the panel.
	 */
	public Resultados() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ELECCION");
		lblNewLabel.setBounds(52, 69, 102, 32);
		add(lblNewLabel);
		
		ELECCIONS = new JTable();
		ELECCIONS.setBounds(189, 69, 565, 32);
		add(ELECCIONS);
		
		JLabel lblGanadores = new JLabel("GANADORES");
		lblGanadores.setBounds(52, 137, 102, 32);
		add(lblGanadores);
		
		ganadores = new JTable();
		ganadores.setBounds(189, 137, 866, 32);
		add(ganadores);
		
		JLabel lblNewLabel_1_1 = new JLabel("VOTOS PARTIDOS");
		lblNewLabel_1_1.setBounds(52, 199, 102, 32);
		add(lblNewLabel_1_1);
		
		partido = new JTable();
		partido.setBounds(189, 199, 866, 32);
		add(partido);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("VOTOS BLANCOS");
		lblNewLabel_1_1_1.setBounds(52, 261, 102, 32);
		add(lblNewLabel_1_1_1);
		
		blanco = new JTable();
		blanco.setBounds(189, 261, 866, 32);
		add(blanco);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("VOTOS NULOS");
		lblNewLabel_1_1_1_1.setBounds(52, 324, 102, 32);
		add(lblNewLabel_1_1_1_1);
		
		nulo = new JTable();
		nulo.setBounds(189, 324, 866, 32);
		add(nulo);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("VOTOS AFIRMATIVOS");
		lblNewLabel_1_1_1_1_1.setBounds(52, 380, 102, 32);
		add(lblNewLabel_1_1_1_1_1);
		
		afirma = new JTable();
		afirma.setBounds(189, 380, 866, 32);
		add(afirma);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("TOTAL VOTOS");
		lblNewLabel_1_1_1_1_1_1.setBounds(52, 438, 102, 32);
		add(lblNewLabel_1_1_1_1_1_1);
		
		total = new JTable();
		total.setBounds(189, 438, 866, 32);
		add(total);
		
		JButton buscar = new JButton("BUSCAR");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			int	id_elec = Integer.parseInt(id_elecc.getText());
			
			ganadores(id_elec);
			partidos( id_elec);
				
			}
		});
		buscar.setBounds(1108, 75, 102, 21);
		add(buscar);
		
		id_elecc = new JTextField();
		id_elecc.setBounds(873, 69, 182, 26);
		add(id_elecc);
		id_elecc.setColumns(10);

		llenar();
	}
	public void llenar() {
        String sqlmc = "SELECT * FROM teleccion WHERE ID_ELEC <> 0";
        Conect conexion = new Conect();
        try (
           
            PreparedStatement ps = conexion.conexion().prepareStatement(sqlmc);
        ) {
        	
        	DefaultTableModel tpad = new DefaultTableModel();
        	tpad.addColumn("ID");
        	tpad.addColumn("DIA");
        	tpad.addColumn("MES");
        	tpad.addColumn("AÑO");
        	tpad.addColumn("DETALLE");
        	tpad.addColumn("STATUS");
        	
        	ELECCIONS.setModel(tpad);

        	        String[] datos = new String[6];
            //ps.setInt(1, id_elec);
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
	       

	  public static void ganadores(int id_elec) {
		
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
			        	
			        	ganadores.setModel(tpad);

			        	        String[] datos = new String[6];
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
	  
	  public static void partidos(int id_elec) {

		        String sqlmc = "SELECT PARTIDO, SUM(CVOTO) FROM tcandidato WHERE ID_ELEC = ? ORDER by PARTIDO";
		        Conect conexion = new Conect();
		        try (
		           
		            PreparedStatement ps = conexion.conexion().prepareStatement(sqlmc);
		        ) {
		        	
		        	DefaultTableModel tpad = new DefaultTableModel();
		        	tpad.addColumn("PARTIDO");
		        	tpad.addColumn("VOTOS");
		        	
		        	partido.setModel(tpad);

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
}

package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Modelo.Conect;
import Modelo.ExcepcionVotanteReincidente;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class VVotar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField idsuf;
	private JTable tlista;
	private JTextField idcan;
	private JTextField apecan;
	private JTextField pcand;
	Conect cn = new Conect();
	/**
	 * Create the panel.
	 */
	public VVotar() {
		setLayout(null);
				
		JLabel lblNewLabel = new JLabel("ACCESO A LA VOTACION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(108, 10, 1074, 46);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INGRESE DU");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(22, 75, 129, 36);
		add(lblNewLabel_1);
		
		idsuf = new JTextField();
		idsuf.setBounds(187, 72, 591, 39);
		add(idsuf);
		idsuf.setColumns(10);
		
		JButton bvalidarsuf = new JButton("VALIDAR DATOS");
		bvalidarsuf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;
				int id_elec = 0;

				try {

					PreparedStatement statementrc = null;
					String id_elecc = "SELECT MAX(ID_ELEC) FROM teleccion WHERE STATUS = 0;";

					statementrc = cn.conexion().prepareStatement(id_elecc);
					resultSet = statementrc.executeQuery(id_elecc);

					if (resultSet.next()) {

						id_elec = resultSet.getInt(1);

					} else {
						System.out.println("No se encontraron elecciones con STATUS = 0.");
					}
				} catch (SQLException e1) {

				}
				
				int du = Integer.parseInt(idsuf.getText());
				 PreparedStatement statement1 = null;
				    ResultSet resultSet1 = null;

				    try {
			    
				    	Conect cn = new Conect();

				        String sql = "SELECT DU FROM tpersona JOIN tsufragante on tpersona.DU = tsufragante.DU_PER JOIN teleccion ON teleccion.ID_ELEC= tsufragante.ID_ELEC WHERE tpersona.DU = ? AND teleccion.ID_ELEC = ?";

				        statement1 = cn.conexion().prepareStatement(sql);

				        statement1.setInt(1, du);
				        statement1.setInt(2, id_elec);

				        resultSet1 = statement1.executeQuery();
				        
						if(resultSet.next() == true) {			
							JOptionPane.showMessageDialog(null, "Persona no existente", "Error", JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "votante encontrado", "Alert", JOptionPane.WARNING_MESSAGE);
						}
						
				    }catch(SQLException e1){ }
					
				}
				
			
		});
		bvalidarsuf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bvalidarsuf.setBounds(897, 66, 235, 45);
		add(bvalidarsuf);
		
		tlista = new JTable();
		tlista.setBounds(75, 183, 1120, 281);
		add(tlista);
		
		idcan = new JTextField();
		idcan.setEditable(false);
		idcan.setBounds(187, 505, 211, 46);
		add(idcan);
		idcan.setColumns(10);
		
		apecan = new JTextField();
		apecan.setEditable(false);
		apecan.setColumns(10);
		apecan.setBounds(556, 505, 222, 46);
		add(apecan);
		
		pcand = new JTextField();
		pcand.setEditable(false);
		pcand.setColumns(10);
		pcand.setBounds(930, 505, 187, 46);
		add(pcand);
		
		JLabel lblNewLabel_1_1 = new JLabel("DU CANDIDATO");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(22, 505, 155, 36);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("APELLIDO");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_2.setBounds(428, 505, 129, 36);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PARTIDO");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_3.setBounds(802, 505, 129, 36);
		add(lblNewLabel_1_3);
		
		JButton bvotarrcan = new JButton("CONFIRMAR VOTO");
		bvotarrcan.setFont(new Font("Tahoma", Font.PLAIN, 21));
		bvotarrcan.setBounds(187, 591, 945, 36);
		add(bvotarrcan);
		
		JButton bblanco = new JButton("VOTAR EN BLANCO");
		bblanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bblanco.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bblanco.setBounds(125, 669, 269, 36);
		add(bblanco);
		
		JButton bnulo = new JButton("IMPUGNAR VOTO");
		bnulo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		bnulo.setBounds(908, 669, 269, 36);
		add(bnulo);
		
		cargalista();
		
	}
	
	public boolean validarCampos() {
		boolean valido = true;

		// Lista de mensajes de error
		String[] mensajesError = new String[1];

		if (idcan.getText().isEmpty()) {
			valido = false;
			mensajesError[0] = "EROR DEBE SELECCIONAR UN CANDIDATO";
		}

		return valido;
}
	
	 public void llenarPadron(int id_elec) {
	        String sqlmc = "SELECT p.DU, p.APELLIDO, p.NOMBRE, c.PARTIDO, c.LEMA FROM tpersona AS p JOIN tcandidato AS c on p.DU = c.DU_PER WHERE c.ID_ELEC= ? ORDER BY p.DU, p.APELLIDO, p.NOMBRE , c.PARTIDO";
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
	        	tlista.setModel(tpad);

	        	        String[] datos = new String[5];
	            ps.setInt(1, id_elec);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                datos[0] = rs.getString(1);
	                datos[1] = rs.getString(2);
	                datos[2] = rs.getString(3);
	                datos[3] = rs.getString(4);
	                datos[4] = rs.getString(5);

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

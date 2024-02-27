package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Modelo.Persona.egenero;
import Modelo.Conect;
import Modelo.Candidato.epartido;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VCandidato extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JTextField txducan;
	private static JTextField txnomcan;
	private static JTextField txapcan;
	private static JTextField txedcan;
	private static JTextField txlemcan;
	private static JTextField txdomcan;
	private static JTextField txpartido;
	private static JTextField txgencan;
	Conect cn = new Conect();
	/**
	 * Create the panel.
	 */
	public VCandidato() {

		Conect cn = new Conect();

		setLayout(null);

		JLabel lblNewLabel = new JLabel("ACCESO A CARGA DE CANDIDATOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(142, 29, 1019, 36);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("DU");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(25, 78, 160, 36);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(25, 138, 160, 36);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("APELLIDO");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(25, 204, 160, 36);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("EDAD");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(25, 271, 160, 36);
		add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("GENERO");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(25, 336, 160, 36);
		add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("DOMICILIO");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_5.setBounds(25, 394, 160, 36);
		add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("PARTIDO");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_6.setBounds(25, 451, 160, 36);
		add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_7 = new JLabel("LEMA");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_7.setBounds(25, 509, 160, 36);
		add(lblNewLabel_1_7);

		txducan = new JTextField();
		txducan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txducan.setBounds(195, 75, 878, 39);
		add(txducan);
		txducan.setColumns(10);

		txnomcan = new JTextField();
		txnomcan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txnomcan.setColumns(10);
		txnomcan.setBounds(195, 138, 878, 39);
		add(txnomcan);

		txapcan = new JTextField();
		txapcan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txapcan.setColumns(10);
		txapcan.setBounds(195, 204, 878, 39);
		add(txapcan);

		txedcan = new JTextField();
		txedcan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txedcan.setColumns(10);
		txedcan.setBounds(195, 271, 878, 39);
		add(txedcan);

		txlemcan = new JTextField();
		txlemcan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txlemcan.setColumns(10);
		txlemcan.setBounds(195, 507, 878, 39);
		add(txlemcan);

		txdomcan = new JTextField();
		txdomcan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txdomcan.setColumns(10);
		txdomcan.setBounds(195, 392, 878, 39);
		add(txdomcan);

		JComboBox cxgencan = new JComboBox();
		cxgencan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String genero = cxgencan.getSelectedItem().toString();
				txgencan.setText(genero);
			}
		});
		cxgencan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cxgencan.setModel(new DefaultComboBoxModel(egenero.values()));
		cxgencan.setBounds(195, 336, 148, 32);
		add(cxgencan);

		JComboBox cxparcan = new JComboBox();
		cxparcan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String partido = cxparcan.getSelectedItem().toString();
				txpartido.setText(partido);

			}
		});
		cxparcan.setModel(new DefaultComboBoxModel(epartido.values()));
		cxparcan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cxparcan.setBounds(195, 451, 229, 32);
		add(cxparcan);

		JButton bvalcan = new JButton("VALIDAR DU");
		bvalcan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int du = Integer.parseInt(txducan.getText());

			    PreparedStatement statement = null;
			    ResultSet resultSet = null;


			  
			    try {
		    
			    	Conect cn = new Conect();

			        String sql = "SELECT * FROM `tpersona` WHERE du = ?";

			        statement = cn.conexion().prepareStatement(sql);

			        statement.setInt(1, du);

			        resultSet = statement.executeQuery();
			        
					if(resultSet.next() == true) {			
						JOptionPane.showMessageDialog(null, "Persona ya existente", "Error", JOptionPane.ERROR_MESSAGE);
							bloquear();
					}else {
					desbloquear();	
					}
					
			    }catch(SQLException e1){ }
				
			}
		});
		bvalcan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bvalcan.setBounds(1098, 75, 148, 39);
		add(bvalcan);

		JButton bcarcan = new JButton("CARGAR CANDIDATO");
		bcarcan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validarCampos()) {

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

							cargarcandidato(id_elec);

						} else {
							System.out.println("No se encontraron elecciones con STATUS = 0.");
						}
					} catch (SQLException e1) {

					}

				}

			}
		});
		bcarcan.setFont(new Font("Tahoma", Font.PLAIN, 21));
		bcarcan.setBounds(195, 642, 878, 47);
		add(bcarcan);

		JLabel lblNewLabel_2 = new JLabel("GENERO SELECCIONADO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(376, 324, 264, 48);
		add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("PARTIDO SELECCIONADO");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2_1.setBounds(464, 441, 264, 48);
		add(lblNewLabel_2_1);

		txpartido = new JTextField();
		txpartido.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txpartido.setEditable(false);
		txpartido.setBounds(706, 451, 367, 36);
		add(txpartido);
		txpartido.setColumns(10);

		txgencan = new JTextField();
		txgencan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txgencan.setEditable(false);
		txgencan.setColumns(10);
		txgencan.setBounds(706, 332, 367, 36);
		add(txgencan);

		bloquear();

	}
	// BLOQUEAR Y DESBLOQUEAR COMPONENTES

	public void bloquear() {

		for (Component a : this.getComponents()) {
			a.setEnabled(true);

			txnomcan.setEnabled(false);
			txapcan.setEnabled(false);
			txedcan.setEnabled(false);
			txdomcan.setEnabled(false);
		}
	}

	public void desbloquear() {

		for (Component a : this.getComponents()) {
			a.setEnabled(true);

			txnomcan.setEnabled(true);
			txapcan.setEnabled(true);
			txedcan.setEnabled(true);
			txdomcan.setEnabled(true);

		}
	}
//VALIDACION DE CAMPOS EN BLANCO

	public boolean validarCampos() {
		boolean valido = true;

		// Lista de mensajes de error
		String[] mensajesError = new String[5];

		if (txnomcan.getText().isEmpty()) {
			valido = false;
			mensajesError[0] = "El nombre no puede estar vacío";
		}

		if (txapcan.getText().isEmpty()) {
			valido = false;
			mensajesError[1] = "El apellido no puede estar vacío";
		}

		if (txedcan.getText().isEmpty()) {
			valido = false;
			mensajesError[2] = "La edad no puede estar vacía";
		}

		if (txdomcan.getText().isEmpty()) {
			valido = false;
			mensajesError[3] = "El domicilio no puede estar vacío";
		}

		if (txgencan.getText().isEmpty()) {
			valido = false;
			mensajesError[4] = "El genero no puede estar vacío";
		}
		return valido;
}
		

	public static Void cargarcandidato(int id_elec) {

		int du = Integer.parseInt(txducan.getText());
		String nombre = txnomcan.getText();
		String apellido = txapcan.getText();
		int edad = Integer.parseInt(txedcan.getText());
		String domicilio = txapcan.getText();
		String genero = txgencan.getText();
		String partido = txpartido.getText();
		String lema = txlemcan.getText();

		try {

			// String sqlinsuf = "" ;
			Conect cn = new Conect();
			PreparedStatement statementrc = null;

			String sqlinsuf = "INSERT INTO tpersona (du, nombre, apellido, edad, domicilio, genero) VALUES (?, ?, ?, ?, ?, ?)";
			statementrc = cn.conexion().prepareStatement(sqlinsuf);

			statementrc.setInt(1, du);
			statementrc.setString(2, nombre);
			statementrc.setString(3, apellido);
			statementrc.setInt(4, edad);
			statementrc.setString(5, domicilio);
			statementrc.setString(6, genero);

			statementrc.executeUpdate();

			PreparedStatement statementrc1 = null;

			String sqlinsu = "INSERT INTO `tcandidato` (`ID_CAN`, `DU_PER`, `PARTIDO`, `LEMA`, CVOTO, ID_ELEC) VALUES (?, ?,? , ?, ?, ?)";
			statementrc1 = cn.conexion().prepareStatement(sqlinsu);

			int id_can = 0;
			int cvoto = 0;

			statementrc1.setInt(1, id_can);
			statementrc1.setInt(2, du);
			statementrc1.setString(3, partido);
			statementrc1.setString(4, lema);
			statementrc1.setInt(5, cvoto);
			statementrc1.setInt(6, id_elec);

			statementrc1.executeUpdate();

			System.out.println("Sufragante insertado exitosamente!");

		} catch (SQLException e) {
			// System.err.println("Error al insertar sufragante: " + e.getMessage());
		}

		return null;
	}
}
	


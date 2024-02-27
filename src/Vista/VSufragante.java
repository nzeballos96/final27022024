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

import Modelo.Conect;
import Modelo.Sufragante;
import Modelo.Persona.egenero;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VSufragante extends JPanel {

	private static final long serialVersionUID = 1L;
	private static JTextField txdusuf;
	private static JTextField txnomsuf;
	private static JTextField txapsuf;
	private static JTextField txedsuf;
	private static JTextField txdomsuf;
	private static JTextField jtgensuf;

	/**
	 * Create the panel.
	 */
	public VSufragante () {
		
		Conect cn = new Conect();
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCESO A CARGA DE SUFRAGANTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(120, 28, 1041, 37);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DU");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(35, 75, 148, 37);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(35, 138, 148, 37);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("APELLIDO");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_2.setBounds(35, 208, 148, 37);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("EDAD");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_3.setBounds(35, 277, 148, 37);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("GENERO");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_4.setBounds(35, 343, 148, 37);
		add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("DOMICILIO");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_5.setBounds(35, 415, 148, 37);
		add(lblNewLabel_1_5);
		
		txdusuf = new JTextField();
		txdusuf.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txdusuf.setBounds(193, 75, 830, 37);
		add(txdusuf);
		txdusuf.setColumns(10);
		
		txnomsuf = new JTextField();
		txnomsuf.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txnomsuf.setColumns(10);
		txnomsuf.setBounds(193, 138, 830, 37);
		add(txnomsuf);
		
		txapsuf = new JTextField();
		txapsuf.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txapsuf.setColumns(10);
		txapsuf.setBounds(193, 208, 830, 37);
		add(txapsuf);
		
		txedsuf = new JTextField();
		txedsuf.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txedsuf.setColumns(10);
		txedsuf.setBounds(193, 277, 830, 37);
		add(txedsuf);
		
		txdomsuf = new JTextField();
		txdomsuf.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txdomsuf.setColumns(10);
		txdomsuf.setBounds(193, 415, 830, 37);
		add(txdomsuf);
		
		JComboBox cxgensuf = new JComboBox();
		cxgensuf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String genero = cxgensuf.getSelectedItem().toString();
				jtgensuf.setText(genero);
				
			}
		});
		cxgensuf.setModel(new DefaultComboBoxModel(egenero.values()));
		cxgensuf.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cxgensuf.setBounds(193, 343, 193, 48);
		add(cxgensuf);
		
		JButton btnNewButton = new JButton("VALIDAR DU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			desbloquear();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(1072, 75, 124, 37);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CARGAR SUFRAGANTE");
		btnNewButton_1.addActionListener(new ActionListener() {
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
				                
				                cargarsufragante(id_elec);
				                
				            } else {
				                System.out.println("No se encontraron elecciones con STATUS = 0.");
				            }
			}catch(SQLException e1) {
				
			}
			
				
			}	}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_1.setBounds(193, 563, 830, 48);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("GENERO SELECCIONADO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(402, 343, 264, 48);
		add(lblNewLabel_2);
		
		jtgensuf = new JTextField();
		jtgensuf.setEditable(false);
		jtgensuf.setBounds(676, 343, 347, 48);
		add(jtgensuf);
		jtgensuf.setColumns(10);

		
		bloquear();
		
	}
	
	
	
	//BLOQUEAR Y DESBLOQUEAR COMPONENTES
	
	public void bloquear() {
		
		for (Component a : this.getComponents()) {
		  a.setEnabled(true);
		
		  txnomsuf.setEnabled(false);
		  txapsuf.setEnabled(false);
		  txedsuf.setEnabled(false);
		  txdomsuf.setEnabled(false);
		}			
}
public void desbloquear() {
	
	for (Component a : this.getComponents()) { 
	  a.setEnabled(true);
	
	  txnomsuf.setEnabled(true);
	  txapsuf.setEnabled(true);
	  txedsuf.setEnabled(true);
	  txdomsuf.setEnabled(true);
	  
	}		
}

//VALIDACION DE CAMPOS EN BLANCO

public boolean validarCampos() {
	  boolean valido = true;

	  // Lista de mensajes de error
	  String[] mensajesError = new String [5];

	  if (txnomsuf.getText().isEmpty()) {
	    valido = false;
	    mensajesError[0] = "El nombre no puede estar vacío";
	  }

	  if (txapsuf.getText().isEmpty()) {
	    valido = false;
	    mensajesError[1] = "El apellido no puede estar vacío";
	  }

	  if (txedsuf.getText().isEmpty()) {
	    valido = false;
	    mensajesError[2] = "La edad no puede estar vacía";
	  }

	  if (txdomsuf.getText().isEmpty()) {
	    valido = false;
	    mensajesError[3] = "El domicilio no puede estar vacío";
	  }
	  
	  if (jtgensuf.getText().isEmpty()) {
		    valido = false;
		    mensajesError[4] = "El genero no puede estar vacío";
		  }

	  // Mostrar mensajes de error
	  if (!valido) {
	    for (String mensaje : mensajesError) {
	      if (mensaje != null) {
	        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	      }
	    }
	  }

	  return valido;
	}

public static Void cargarsufragante  (int id_elec) {
	
	 int	du = Integer.parseInt(txdusuf.getText());
	 String	nombre = txnomsuf.getText();
	 String	apellido = txapsuf.getText();
	 int	edad= Integer.parseInt(txedsuf.getText());
	 String	domicilio = txapsuf.getText();
	 String	gnero = jtgensuf.getText();		
	 int	status = 0;

		try {        
	
    //    String sqlinsuf = "" ;
		Conect cn = new Conect();	
		PreparedStatement statementrc = null;
        

        String sqlinsuf = "INSERT INTO tpersona (du, nombre, apellido, edad, domicilio, genero) VALUES (?, ?, ?, ?, ?, ?)";
        statementrc = cn.conexion().prepareStatement(sqlinsuf);

        statementrc.setInt(1, du);
        statementrc.setString(2, nombre);
        statementrc.setString(3, apellido);
        statementrc.setInt(4, edad);
        statementrc.setString(5, domicilio);
        statementrc.setString(6, gnero);

        
        statementrc.executeUpdate();
        
        PreparedStatement statementrc1 = null;
        
        String sqlinsu = "INSERT INTO Tsufragante (id_suf, du_per, status, id_elec) VALUES (?, ?, ?, ?)";
        statementrc1 = cn.conexion().prepareStatement(sqlinsu);

int id_suf = 0;        
        
        
        statementrc1.setInt(1, id_suf);
        statementrc1.setInt(2, du);
        statementrc1.setInt(3, status);
        statementrc1.setInt(4, id_elec);

        statementrc1.executeUpdate();

        System.out.println("Sufragante insertado exitosamente!");

    } catch (SQLException e) {
       // System.err.println("Error al insertar sufragante: " + e.getMessage());
    }
	
return null;

}

}

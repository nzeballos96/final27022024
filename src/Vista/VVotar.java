package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class VVotar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		textField = new JTextField();
		textField.setBounds(187, 72, 591, 39);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("VALIDAR DATOS");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(897, 66, 235, 45);
		add(btnNewButton);
		
		table = new JTable();
		table.setBounds(75, 183, 1120, 352);
		add(table);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(187, 582, 211, 46);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(562, 582, 222, 46);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(945, 582, 187, 46);
		add(textField_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("DU CANDIDATO");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(22, 598, 155, 36);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("APELLIDO");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_2.setBounds(428, 598, 129, 36);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PARTIDO");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_3.setBounds(806, 598, 129, 36);
		add(lblNewLabel_1_3);
		
		JButton btnNewButton_1 = new JButton("CONFIRMAR VOTO");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_1.setBounds(187, 644, 945, 36);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VOTAR EN BLANCO");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_2.setBounds(129, 713, 269, 36);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("IMPUGNAR VOTO");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_2_1.setBounds(911, 713, 269, 36);
		add(btnNewButton_2_1);

	}
}

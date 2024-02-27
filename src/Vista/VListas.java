package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class VListas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

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
		
		table = new JTable();
		table.setBounds(52, 109, 1182, 600);
		add(table);

	}

}

package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class VPadron extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

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
		
		table = new JTable();
		table.setBounds(53, 111, 1169, 603);
		add(table);

	}

}

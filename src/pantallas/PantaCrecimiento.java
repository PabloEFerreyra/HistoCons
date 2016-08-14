package pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PantaCrecimiento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9029247028477584699L;
	private JPanel contentPane;
	private JTextField txtEdad;
	private JTextField txtEdad2;
	private JTextField txtEdad3;
	private JTextField txtEdad4;
	private JTextField txtEdad5;

	public PantaCrecimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{87, 55, 0};
		gbl_contentPane.rowHeights = new int[]{17, 20, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEdad = new JLabel("Edad");
		GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridheight = 2;
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 0;
		contentPane.add(lblEdad, gbc_lblEdad);
		
		JLabel lblTiempo = new JLabel("Tiempo");
		GridBagConstraints gbc_lblTiempo = new GridBagConstraints();
		gbc_lblTiempo.anchor = GridBagConstraints.SOUTH;
		gbc_lblTiempo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTiempo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTiempo.gridx = 1;
		gbc_lblTiempo.gridy = 0;
		contentPane.add(lblTiempo, gbc_lblTiempo);
		
		txtEdad = new JTextField();
		GridBagConstraints gbc_txtEdad = new GridBagConstraints();
		gbc_txtEdad.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtEdad.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad.gridx = 0;
		gbc_txtEdad.gridy = 1;
		contentPane.add(txtEdad, gbc_txtEdad);
		txtEdad.setColumns(10);
		
		JComboBox<String> cmbTiempo = new JComboBox<String>();
		cmbTiempo.setModel(new DefaultComboBoxModel<String>(new String[] {"meses", "a\u00F1os"}));
		GridBagConstraints gbc_cmbTiempo = new GridBagConstraints();
		gbc_cmbTiempo.insets = new Insets(0, 0, 5, 0);
		gbc_cmbTiempo.anchor = GridBagConstraints.NORTHWEST;
		gbc_cmbTiempo.gridx = 1;
		gbc_cmbTiempo.gridy = 1;
		contentPane.add(cmbTiempo, gbc_cmbTiempo);
		
		txtEdad2 = new JTextField();
		txtEdad2.setColumns(10);
		GridBagConstraints gbc_txtEdad2 = new GridBagConstraints();
		gbc_txtEdad2.anchor = GridBagConstraints.WEST;
		gbc_txtEdad2.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad2.gridx = 0;
		gbc_txtEdad2.gridy = 2;
		contentPane.add(txtEdad2, gbc_txtEdad2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Meses", "A\u00F1os"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		txtEdad3 = new JTextField();
		txtEdad3.setColumns(10);
		GridBagConstraints gbc_txtEdad3 = new GridBagConstraints();
		gbc_txtEdad3.anchor = GridBagConstraints.WEST;
		gbc_txtEdad3.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad3.gridx = 0;
		gbc_txtEdad3.gridy = 3;
		contentPane.add(txtEdad3, gbc_txtEdad3);
		
		txtEdad4 = new JTextField();
		txtEdad4.setColumns(10);
		GridBagConstraints gbc_txtEdad4 = new GridBagConstraints();
		gbc_txtEdad4.anchor = GridBagConstraints.WEST;
		gbc_txtEdad4.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad4.gridx = 0;
		gbc_txtEdad4.gridy = 4;
		contentPane.add(txtEdad4, gbc_txtEdad4);
		
		txtEdad5 = new JTextField();
		txtEdad5.setColumns(10);
		GridBagConstraints gbc_txtEdad5 = new GridBagConstraints();
		gbc_txtEdad5.anchor = GridBagConstraints.WEST;
		gbc_txtEdad5.insets = new Insets(0, 0, 0, 5);
		gbc_txtEdad5.gridx = 0;
		gbc_txtEdad5.gridy = 5;
		contentPane.add(txtEdad5, gbc_txtEdad5);
	}
}

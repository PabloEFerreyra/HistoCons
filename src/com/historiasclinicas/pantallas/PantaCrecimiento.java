package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.historiasclinicas.ejecucion.CanConvert;
import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Crecimiento;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorPacientes;

public class PantaCrecimiento extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -9029247028477584699L;
	private final JButton btnPesoA_4;
	private final JButton btnRecargarTabla;
	private final String[] columnNames = { "Edad", "Tiempo", "Peso -Kgrs", "Perc.", "Talla -cm", "Perc.", "Per. Cef. -cm", "Perc.", "IMC" };
	private final JPanel contentPane;
	@SuppressWarnings("unused")
	private final DefaultTableModel df = new DefaultTableModel();
	private List<Crecimiento> listaCrecimiento = null;
	private final Integer paciente;
	private final JTable table;
	private final JTextField txtEdad;
	private final JTextField txtImc;
	private final JTextField txtPerCef;
	private final JTextField txtPeso;
	private final JTextField txtTalla;
	public PantaCrecimiento(Paciente pacientes) {
		setResizable(false);
		paciente = pacientes.getDni();
		setTitle("Crecimiento paciente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaCrecimiento.class.getResource("/imagenes/logotipo.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 825, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 87, 87, 87, 87, 87, 87, 87, 87, 87, 0 };
		gbl_contentPane.rowHeights = new int[] { 17, 20, 0, 0, 0, 21, 21, 81, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Edad", "Tiempo", "Peso -Kgrs", "Perc.", "Talla -cm", "Perc.", "Per. Cef. -cm", "Perc.", "IMC"
				}
				));
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		final JLabel lblEdad = new JLabel("Edad");
		final GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 0;
		gbc_lblEdad.gridy = 1;
		contentPane.add(lblEdad, gbc_lblEdad);

		final JLabel lblTiempo = new JLabel("Tiempo");
		final GridBagConstraints gbc_lblTiempo = new GridBagConstraints();
		gbc_lblTiempo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTiempo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTiempo.gridx = 1;
		gbc_lblTiempo.gridy = 1;
		contentPane.add(lblTiempo, gbc_lblTiempo);

		final JLabel lblPeso = new JLabel("Peso");
		final GridBagConstraints gbc_lblPeso = new GridBagConstraints();
		gbc_lblPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeso.gridx = 2;
		gbc_lblPeso.gridy = 1;
		contentPane.add(lblPeso, gbc_lblPeso);

		final JLabel lblPerc = new JLabel("Perc");
		final GridBagConstraints gbc_lblPerc = new GridBagConstraints();
		gbc_lblPerc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPerc.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerc.gridx = 3;
		gbc_lblPerc.gridy = 1;
		contentPane.add(lblPerc, gbc_lblPerc);

		final JLabel lblTalla = new JLabel("Talla");
		final GridBagConstraints gbc_lblTalla = new GridBagConstraints();
		gbc_lblTalla.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTalla.insets = new Insets(0, 0, 5, 5);
		gbc_lblTalla.gridx = 4;
		gbc_lblTalla.gridy = 1;
		contentPane.add(lblTalla, gbc_lblTalla);

		final JLabel lblPerc_1 = new JLabel("Perc");
		final GridBagConstraints gbc_lblPerc_1 = new GridBagConstraints();
		gbc_lblPerc_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPerc_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerc_1.gridx = 5;
		gbc_lblPerc_1.gridy = 1;
		contentPane.add(lblPerc_1, gbc_lblPerc_1);

		final JLabel lblPerCef = new JLabel("Per Cef");
		final GridBagConstraints gbc_lblPerCef = new GridBagConstraints();
		gbc_lblPerCef.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPerCef.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerCef.gridx = 6;
		gbc_lblPerCef.gridy = 1;
		contentPane.add(lblPerCef, gbc_lblPerCef);

		final JLabel lblPerc_2 = new JLabel("Perc");
		final GridBagConstraints gbc_lblPerc_2 = new GridBagConstraints();
		gbc_lblPerc_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPerc_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerc_2.gridx = 7;
		gbc_lblPerc_2.gridy = 1;
		contentPane.add(lblPerc_2, gbc_lblPerc_2);

		final JLabel lblImc = new JLabel("IMC");
		final GridBagConstraints gbc_lblImc = new GridBagConstraints();
		gbc_lblImc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblImc.insets = new Insets(0, 0, 5, 0);
		gbc_lblImc.gridx = 8;
		gbc_lblImc.gridy = 1;
		contentPane.add(lblImc, gbc_lblImc);

		txtEdad = new JTextField();
		txtEdad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEdad.getText().length() != 0)
				{
					final boolean canConvert = CanConvert.Convert(txtEdad.getText());
					if (!canConvert)
					{
						JOptionPane.showMessageDialog(new JDialog(), Errores.sinNumero(), "Error", JOptionPane.ERROR_MESSAGE);
						txtEdad.requestFocus();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(new JDialog(), "no tiene edad?", "Error", JOptionPane.ERROR_MESSAGE);
					txtEdad.requestFocus();
				}

			}
		});
		final GridBagConstraints gbc_txtEdad = new GridBagConstraints();
		gbc_txtEdad.insets = new Insets(0, 0, 5, 5);
		gbc_txtEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEdad.gridx = 0;
		gbc_txtEdad.gridy = 2;
		contentPane.add(txtEdad, gbc_txtEdad);
		txtEdad.setColumns(10);

		final JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Meses", "A\u00F1os"}));
		final GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);

		txtPeso = new JTextField();
		txtPeso.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPeso.getText().length() != 0)
				{
					final boolean canConvert = CanConvert.FloatConvert(txtPeso.getText());
					if(!canConvert)
					{
						JOptionPane.showMessageDialog(new JDialog(), Errores.sinNumero(), "Error", JOptionPane.ERROR_MESSAGE);
						txtPeso.requestFocus();
					}
				}
				else
					txtPeso.setText("0");
			}
		});
		final GridBagConstraints gbc_txtPeso = new GridBagConstraints();
		gbc_txtPeso.insets = new Insets(0, 0, 5, 5);
		gbc_txtPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPeso.gridx = 2;
		gbc_txtPeso.gridy = 2;
		contentPane.add(txtPeso, gbc_txtPeso);
		txtPeso.setColumns(10);

		final JComboBox<Object> comboBox_1 = new JComboBox<>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"92", "90", "75", "50", "25", "10", "3"}));
		final GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 2;
		contentPane.add(comboBox_1, gbc_comboBox_1);

		txtTalla = new JTextField();
		txtTalla.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTalla.getText().length() != 0)
				{
					final boolean canConvert = CanConvert.FloatConvert(txtTalla.getText());
					if(!canConvert)
					{
						JOptionPane.showMessageDialog(new JDialog(), Errores.sinNumero(), "Error", JOptionPane.ERROR_MESSAGE);
						txtTalla.requestFocus();
					}
					else
					{
						final Integer imc = Integer.parseInt(txtPeso.getText()) /(Integer.parseInt(txtTalla.getText())*2);
						txtImc.setText(imc.toString());
					}
				}
				else
					txtTalla.setText("0");
			}
		});
		final GridBagConstraints gbc_txtTalla = new GridBagConstraints();
		gbc_txtTalla.insets = new Insets(0, 0, 5, 5);
		gbc_txtTalla.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTalla.gridx = 4;
		gbc_txtTalla.gridy = 2;
		contentPane.add(txtTalla, gbc_txtTalla);
		txtTalla.setColumns(10);

		final JComboBox<Object> comboBox_2 = new JComboBox<>();
		comboBox_2.setModel(new DefaultComboBoxModel<Object>(new String[] {"92", "90", "75", "50", "25", "10", "3"}));
		final GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 5;
		gbc_comboBox_2.gridy = 2;
		contentPane.add(comboBox_2, gbc_comboBox_2);

		txtPerCef = new JTextField();
		txtPerCef.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPerCef.getText().length() != 0)
				{
					final boolean canConvert = CanConvert.FloatConvert(txtPerCef.getText());
					if(!canConvert)
					{
						JOptionPane.showMessageDialog(new JDialog(), Errores.sinNumero(), "Error", JOptionPane.ERROR_MESSAGE);
						txtPerCef.requestFocus();
					}
				}
				else
				{
					txtPerCef.setText("0");
				}
			}
		});
		final GridBagConstraints gbc_txtPerCef = new GridBagConstraints();
		gbc_txtPerCef.insets = new Insets(0, 0, 5, 5);
		gbc_txtPerCef.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPerCef.gridx = 6;
		gbc_txtPerCef.gridy = 2;
		contentPane.add(txtPerCef, gbc_txtPerCef);
		txtPerCef.setColumns(10);

		final JComboBox<Object> comboBox_3 = new JComboBox<>();
		comboBox_3.setModel(new DefaultComboBoxModel<Object>(new String[] {"92", "90", "75", "50", "25", "10", "3"}));
		final GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 7;
		gbc_comboBox_3.gridy = 2;
		contentPane.add(comboBox_3, gbc_comboBox_3);

		txtImc = new JTextField();
		txtImc.setEditable(false);
		final GridBagConstraints gbc_txtImc = new GridBagConstraints();
		gbc_txtImc.insets = new Insets(0, 0, 5, 0);
		gbc_txtImc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtImc.gridx = 8;
		gbc_txtImc.gridy = 2;
		contentPane.add(txtImc, gbc_txtImc);
		txtImc.setColumns(10);

		btnRecargarTabla = new JButton("Recargar Tabla");
		btnRecargarTabla.setHorizontalAlignment(SwingConstants.LEFT);
		btnRecargarTabla.addActionListener(e -> LlenaLista());
		final GridBagConstraints gbc_btnRecargarTabla = new GridBagConstraints();
		gbc_btnRecargarTabla.fill = GridBagConstraints.VERTICAL;
		gbc_btnRecargarTabla.anchor = GridBagConstraints.WEST;
		gbc_btnRecargarTabla.gridwidth = 2;
		gbc_btnRecargarTabla.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecargarTabla.gridx = 5;
		gbc_btnRecargarTabla.gridy = 3;
		contentPane.add(btnRecargarTabla, gbc_btnRecargarTabla);

		final JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(e -> {
			final Integer edad = Integer.parseInt(txtEdad.getText());
			final String tiempo = comboBox.getSelectedItem().toString();
			final Float peso = Float.parseFloat(txtPeso.getText());
			final Integer percPeso = Integer.parseInt(comboBox_1.getSelectedItem().toString());
			final Float talla = Float.parseFloat(txtTalla.getText());
			final Integer percTalla = Integer.parseInt(comboBox_2.getSelectedItem().toString());
			final Float perCef = Float.parseFloat(txtPerCef.getText());
			final Integer percPerCef = Integer.parseInt(comboBox_3.getSelectedItem().toString());
			final String imc = txtImc.getText();
			final boolean guardado = GestorPacientes.GuardaCrecimiento(paciente, edad, tiempo, peso, percPeso, talla, percTalla, perCef, percPerCef, imc);
			if(guardado)
			{
				JOptionPane.showMessageDialog(new JDialog(), "Guardado Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				LlenaLista();
			}
			else
				JOptionPane.showMessageDialog(new JDialog(), "Error Interno", "Error", JOptionPane.ERROR_MESSAGE);
		});
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setIcon(new ImageIcon(PantaCrecimiento.class.getResource("/imagenes/iconos/twentytwo/save.png")));
		final GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.VERTICAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 7;
		gbc_btnGuardar.gridy = 3;
		contentPane.add(btnGuardar, gbc_btnGuardar);

		final JLabel lblPercentilos = new JLabel("Percentilos");
		lblPercentilos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPercentilos.setIcon(new ImageIcon(PantaCrecimiento.class.getResource("/imagenes/iconos/twentytwo/area-chart.png")));
		final GridBagConstraints gbc_lblPercentilos = new GridBagConstraints();
		gbc_lblPercentilos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPercentilos.gridwidth = 2;
		gbc_lblPercentilos.insets = new Insets(0, 0, 5, 5);
		gbc_lblPercentilos.gridx = 0;
		gbc_lblPercentilos.gridy = 4;
		contentPane.add(lblPercentilos, gbc_lblPercentilos);

		final JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		final GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 3;
		gbc_tabbedPane.gridwidth = 4;
		gbc_tabbedPane.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 5;
		contentPane.add(tabbedPane, gbc_tabbedPane);

		final JPanel panel = new JPanel();
		tabbedPane.addTab("Curvas SAP", null, panel, null);
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		final JButton btnPesoA = new JButton("Peso 0 a 6 A\u00F1os");
		btnPesoA.setHorizontalAlignment(SwingConstants.LEFT);
		btnPesoA.setForeground(Color.MAGENTA);
		btnPesoA.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\Imagenes\\1.pdf"));
		final GridBagConstraints gbc_btnPesoA = new GridBagConstraints();
		gbc_btnPesoA.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesoA.fill = GridBagConstraints.BOTH;
		gbc_btnPesoA.gridx = 0;
		gbc_btnPesoA.gridy = 0;
		panel.add(btnPesoA, gbc_btnPesoA);

		final JButton btnPesoA_1 = new JButton("Peso 0 a 6 A\u00F1os");
		btnPesoA_1.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\2.pdf"));

		final JButton btnTallaA = new JButton("Talla 0 a 6 A\u00F1os");
		btnTallaA.setForeground(Color.MAGENTA);
		btnTallaA.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\3.pdf"));
		btnTallaA.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnTallaA = new GridBagConstraints();
		gbc_btnTallaA.fill = GridBagConstraints.BOTH;
		gbc_btnTallaA.insets = new Insets(0, 0, 5, 5);
		gbc_btnTallaA.gridx = 1;
		gbc_btnTallaA.gridy = 0;
		panel.add(btnTallaA, gbc_btnTallaA);

		final JButton btnPerCef = new JButton("Per Cef 0 a 6 A\u00F1os");
		btnPerCef.setHorizontalAlignment(SwingConstants.LEFT);
		btnPerCef.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\5.pdf"));
		btnPerCef.setForeground(Color.MAGENTA);
		final GridBagConstraints gbc_btnPerCef = new GridBagConstraints();
		gbc_btnPerCef.fill = GridBagConstraints.BOTH;
		gbc_btnPerCef.insets = new Insets(0, 0, 5, 0);
		gbc_btnPerCef.gridx = 2;
		gbc_btnPerCef.gridy = 0;
		panel.add(btnPerCef, gbc_btnPerCef);
		btnPesoA_1.setForeground(Color.BLUE);
		btnPesoA_1.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnPesoA_1 = new GridBagConstraints();
		gbc_btnPesoA_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesoA_1.fill = GridBagConstraints.BOTH;
		gbc_btnPesoA_1.gridx = 0;
		gbc_btnPesoA_1.gridy = 1;
		panel.add(btnPesoA_1, gbc_btnPesoA_1);

		final JButton btnTallaA_1 = new JButton("Talla 0 a 6 A\u00F1os");
		btnTallaA_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnTallaA_1.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\4.pdf"));
		btnTallaA_1.setForeground(Color.BLUE);
		final GridBagConstraints gbc_btnTallaA_1 = new GridBagConstraints();
		gbc_btnTallaA_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnTallaA_1.fill = GridBagConstraints.BOTH;
		gbc_btnTallaA_1.gridx = 1;
		gbc_btnTallaA_1.gridy = 1;
		panel.add(btnTallaA_1, gbc_btnTallaA_1);

		final JButton btnPerCef_1 = new JButton("Per Cef 0 a 6 A\u00F1os");
		btnPerCef_1.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\6.pdf"));
		btnPerCef_1.setForeground(Color.BLUE);
		btnPerCef_1.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnPerCef_1 = new GridBagConstraints();
		gbc_btnPerCef_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnPerCef_1.fill = GridBagConstraints.BOTH;
		gbc_btnPerCef_1.gridx = 2;
		gbc_btnPerCef_1.gridy = 1;
		panel.add(btnPerCef_1, gbc_btnPerCef_1);

		final JButton btnPesoA_2 = new JButton("Peso 0 a 19 A\u00F1os");
		btnPesoA_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnPesoA_2.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\7.pdf"));
		btnPesoA_2.setForeground(Color.MAGENTA);
		final GridBagConstraints gbc_btnPesoA_2 = new GridBagConstraints();
		gbc_btnPesoA_2.fill = GridBagConstraints.BOTH;
		gbc_btnPesoA_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesoA_2.gridx = 0;
		gbc_btnPesoA_2.gridy = 2;
		panel.add(btnPesoA_2, gbc_btnPesoA_2);

		final JButton btnPesoA_3 = new JButton("Peso 0 a 19 A\u00F1os");
		btnPesoA_3.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\8.pdf"));

		final JButton btnTallaA_2 = new JButton("Talla 0 a 19 A\u00F1os");
		btnTallaA_2.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\9.pdf"));
		btnTallaA_2.setForeground(Color.MAGENTA);
		btnTallaA_2.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnTallaA_2 = new GridBagConstraints();
		gbc_btnTallaA_2.fill = GridBagConstraints.BOTH;
		gbc_btnTallaA_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnTallaA_2.gridx = 1;
		gbc_btnTallaA_2.gridy = 2;
		panel.add(btnTallaA_2, gbc_btnTallaA_2);
		btnPesoA_3.setForeground(Color.BLUE);
		btnPesoA_3.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnPesoA_3 = new GridBagConstraints();
		gbc_btnPesoA_3.fill = GridBagConstraints.BOTH;
		gbc_btnPesoA_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnPesoA_3.gridx = 0;
		gbc_btnPesoA_3.gridy = 3;
		panel.add(btnPesoA_3, gbc_btnPesoA_3);

		final JButton btnTallaA_3 = new JButton("Talla 0 a 19 A\u00F1os");
		btnTallaA_3.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\10.pdf"));
		btnTallaA_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnTallaA_3.setForeground(Color.BLUE);
		final GridBagConstraints gbc_btnTallaA_3 = new GridBagConstraints();
		gbc_btnTallaA_3.fill = GridBagConstraints.BOTH;
		gbc_btnTallaA_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnTallaA_3.gridx = 1;
		gbc_btnTallaA_3.gridy = 3;
		panel.add(btnTallaA_3, gbc_btnTallaA_3);

		final JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Curvas OMS", null, panel_1, null);
		final GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		btnPesoA_4 = new JButton("Peso 0 a 5 A\u00F1os");
		btnPesoA_4.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\13.pdf"));
		btnPesoA_4.setForeground(Color.MAGENTA);
		btnPesoA_4.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnPesoA_4 = new GridBagConstraints();
		gbc_btnPesoA_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesoA_4.fill = GridBagConstraints.BOTH;
		gbc_btnPesoA_4.gridx = 0;
		gbc_btnPesoA_4.gridy = 0;
		panel_1.add(btnPesoA_4, gbc_btnPesoA_4);

		final JButton btnPesoA_5 = new JButton("Peso 0 a 5 A\u00F1os");
		btnPesoA_5.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\14.pdf"));

		final JButton btnTallaA_4 = new JButton("Talla 0 a 5 A\u00F1os");
		btnTallaA_4.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\15.pdf"));
		btnTallaA_4.setForeground(Color.MAGENTA);
		btnTallaA_4.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnTallaA_4 = new GridBagConstraints();
		gbc_btnTallaA_4.fill = GridBagConstraints.BOTH;
		gbc_btnTallaA_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnTallaA_4.gridx = 1;
		gbc_btnTallaA_4.gridy = 0;
		panel_1.add(btnTallaA_4, gbc_btnTallaA_4);

		final JButton btnPerCef_2 = new JButton("Per Cef 0 a 5 A\u00F1os");
		btnPerCef_2.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\17.pdf"));
		btnPerCef_2.setForeground(Color.MAGENTA);
		btnPerCef_2.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnPerCef_2 = new GridBagConstraints();
		gbc_btnPerCef_2.fill = GridBagConstraints.BOTH;
		gbc_btnPerCef_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnPerCef_2.gridx = 2;
		gbc_btnPerCef_2.gridy = 0;
		panel_1.add(btnPerCef_2, gbc_btnPerCef_2);
		btnPesoA_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnPesoA_5.setForeground(Color.BLUE);
		final GridBagConstraints gbc_btnPesoA_5 = new GridBagConstraints();
		gbc_btnPesoA_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnPesoA_5.fill = GridBagConstraints.BOTH;
		gbc_btnPesoA_5.gridx = 0;
		gbc_btnPesoA_5.gridy = 1;
		panel_1.add(btnPesoA_5, gbc_btnPesoA_5);

		final JButton btnTallaA_5 = new JButton("Talla 0 a 5 A\u00F1os");
		btnTallaA_5.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\16.pdf"));
		btnTallaA_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnTallaA_5.setForeground(Color.BLUE);
		final GridBagConstraints gbc_btnTallaA_5 = new GridBagConstraints();
		gbc_btnTallaA_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnTallaA_5.fill = GridBagConstraints.BOTH;
		gbc_btnTallaA_5.gridx = 1;
		gbc_btnTallaA_5.gridy = 1;
		panel_1.add(btnTallaA_5, gbc_btnTallaA_5);

		final JButton btnPerCef_3 = new JButton("Per Cef 0 a 5 A\u00F1os");
		btnPerCef_3.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\18.pdf"));
		btnPerCef_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnPerCef_3.setForeground(Color.BLUE);
		final GridBagConstraints gbc_btnPerCef_3 = new GridBagConstraints();
		gbc_btnPerCef_3.fill = GridBagConstraints.BOTH;
		gbc_btnPerCef_3.gridx = 2;
		gbc_btnPerCef_3.gridy = 1;
		panel_1.add(btnPerCef_3, gbc_btnPerCef_3);

		final JButton btnImcA = new JButton("IMC 0 a 5 A\u00F1os");
		btnImcA.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\11.pdf"));
		btnImcA.setForeground(Color.MAGENTA);
		btnImcA.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnImcA = new GridBagConstraints();
		gbc_btnImcA.gridwidth = 2;
		gbc_btnImcA.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnImcA.insets = new Insets(0, 0, 5, 5);
		gbc_btnImcA.gridx = 4;
		gbc_btnImcA.gridy = 6;
		contentPane.add(btnImcA, gbc_btnImcA);

		final JButton btnImcA_1 = new JButton("IMC 0 a 5 A\u00F1os");
		btnImcA_1.addActionListener(e -> abrirarchivo("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\12.pdf"));
		btnImcA_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnImcA_1.setForeground(Color.BLUE);
		final GridBagConstraints gbc_btnImcA_1 = new GridBagConstraints();
		gbc_btnImcA_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnImcA_1.gridwidth = 2;
		gbc_btnImcA_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnImcA_1.gridx = 4;
		gbc_btnImcA_1.gridy = 7;
		contentPane.add(btnImcA_1, gbc_btnImcA_1);
	}

	public void abrirarchivo(String archivo){
		try {

			final File objetofile = new File (archivo);
			Desktop.getDesktop().open(objetofile);

		}catch (final IOException ex) {

			System.out.println(ex);

		}
	}

	public void LlenaLista(){
		final DefaultTableModel df = new DefaultTableModel();
		listaCrecimiento = GestorPacientes.TraeCrecimiento(paciente);
		if (listaCrecimiento.isEmpty())
			JOptionPane.showMessageDialog(new JDialog(), "Paciente sin registros", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		else
		{
			df.setColumnIdentifiers(columnNames);
			final Object[] fila = new Object[df.getColumnCount()];
			for (int i = 0; i < listaCrecimiento.size(); i++) {
				fila[0] = listaCrecimiento.get(i).getEdad().toString();
				fila[1] = listaCrecimiento.get(i).getTiempo();
				fila[2] = listaCrecimiento.get(i).getPeso().toString();
				fila[3] = listaCrecimiento.get(i).getPercPeso();
				fila[4] = listaCrecimiento.get(i).getTalla();
				fila[5] = listaCrecimiento.get(i).getPerTalla();
				fila[6] = listaCrecimiento.get(i).getPerCef();
				fila[7] = listaCrecimiento.get(i).getPerPerCef();
				fila[8] = listaCrecimiento.get(i).getImc();
				df.addRow(fila);
			}
			table.setModel(df);
		}
	}
}

package com.historiasclinicas.pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.entidades.Errorescongenitos;
import com.historiasclinicas.entidades.Paciente;

public class PantaMuestraErroresCongenitos extends JFrame {

	private static final long serialVersionUID = 253201960935703236L;
	private final JButton btnGuardar;
	private final JCheckBox chckbxBiotidinasa;
	private final JCheckBox chckbxFenilcetonuria;
	private final JCheckBox chckbxFqp;
	private final JCheckBox chckbxGalactosemia;
	private final JCheckBox chckbxHidroxi;
	private final JCheckBox chckbxHipotiroidismoCong;
	private final JComboBox<String> cmbNormalA1;
	private final JComboBox<String> cmbNormalA2;
	private final JComboBox<String> cmbNormalA3;
	private final JComboBox<String> cmbNormalA4;
	private final JComboBox<String> cmbNormalA5;
	private final JComboBox<String> cmbNormalA6;
	private final JPanel contentPane;
	private final JLabel lblOtrosEc;
	private final JScrollPane scrollPane;
	private final JTextField txtPaciente;
	private final JTextArea txtrOtros;
	public PantaMuestraErroresCongenitos(Errorescongenitos ec, Paciente paciente) {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Errores Congenitos (Solo Lectura)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaMuestraErroresCongenitos.class.getResource("/imagenes/logotipo.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 456, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{217, 28, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		chckbxHipotiroidismoCong = new JCheckBox("Hipotiroidismo Congenito");
		chckbxHipotiroidismoCong.setSelected(ec.getHipotCong());
		chckbxHipotiroidismoCong.setEnabled(false);
		final GridBagConstraints gbc_chckbxHipotiroidismoCong = new GridBagConstraints();
		gbc_chckbxHipotiroidismoCong.gridwidth = 2;
		gbc_chckbxHipotiroidismoCong.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxHipotiroidismoCong.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHipotiroidismoCong.gridx = 0;
		gbc_chckbxHipotiroidismoCong.gridy = 0;
		contentPane.add(chckbxHipotiroidismoCong, gbc_chckbxHipotiroidismoCong);

		cmbNormalA1 = new JComboBox<>();
		cmbNormalA1.setEnabled(false);
		cmbNormalA1.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
		cmbNormalA1.setSelectedIndex(ec.getHipotNorm());
		final GridBagConstraints gbc_cmbNormalA1 = new GridBagConstraints();
		gbc_cmbNormalA1.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA1.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA1.gridx = 2;
		gbc_cmbNormalA1.gridy = 0;
		contentPane.add(cmbNormalA1, gbc_cmbNormalA1);

		chckbxFenilcetonuria = new JCheckBox("Fenilcetonuria");
		chckbxFenilcetonuria.setEnabled(false);
		chckbxFenilcetonuria.setSelected(ec.getFenilcetonuria());

		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setIcon(new ImageIcon(PantaMuestraErroresCongenitos.class.getResource("/imagenes/iconos/twentytwo/save.png")));
		final GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridx = 3;
		gbc_btnGuardar.gridy = 0;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		final GridBagConstraints gbc_chckbxFenilcetonuria = new GridBagConstraints();
		gbc_chckbxFenilcetonuria.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxFenilcetonuria.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxFenilcetonuria.gridx = 0;
		gbc_chckbxFenilcetonuria.gridy = 1;
		contentPane.add(chckbxFenilcetonuria, gbc_chckbxFenilcetonuria);

		cmbNormalA2 = new JComboBox<>();
		cmbNormalA2.setEnabled(false);
		cmbNormalA2.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
		cmbNormalA2.setSelectedIndex(ec.getFenilcetNorm());
		final GridBagConstraints gbc_cmbNormalA2 = new GridBagConstraints();
		gbc_cmbNormalA2.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA2.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA2.gridx = 2;
		gbc_cmbNormalA2.gridy = 1;
		contentPane.add(cmbNormalA2, gbc_cmbNormalA2);

		chckbxFqp = new JCheckBox("FQP");
		chckbxFqp.setEnabled(false);
		chckbxFqp.setSelected(ec.getFqp());
		final GridBagConstraints gbc_chckbxFqp = new GridBagConstraints();
		gbc_chckbxFqp.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxFqp.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxFqp.gridx = 0;
		gbc_chckbxFqp.gridy = 2;
		contentPane.add(chckbxFqp, gbc_chckbxFqp);

		cmbNormalA3 = new JComboBox<>();
		cmbNormalA3.setEnabled(false);
		cmbNormalA3.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
		cmbNormalA3.setSelectedIndex(ec.getFqpNorm());
		final GridBagConstraints gbc_cmbNormalA3 = new GridBagConstraints();
		gbc_cmbNormalA3.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA3.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA3.gridx = 2;
		gbc_cmbNormalA3.gridy = 2;
		contentPane.add(cmbNormalA3, gbc_cmbNormalA3);

		chckbxBiotidinasa = new JCheckBox("Biotidinasa");
		chckbxBiotidinasa.setEnabled(false);
		chckbxBiotidinasa.setSelected(ec.getBiotidinasa());
		final GridBagConstraints gbc_chckbxBiotidinasa = new GridBagConstraints();
		gbc_chckbxBiotidinasa.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxBiotidinasa.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxBiotidinasa.gridx = 0;
		gbc_chckbxBiotidinasa.gridy = 3;
		contentPane.add(chckbxBiotidinasa, gbc_chckbxBiotidinasa);

		cmbNormalA4 = new JComboBox<>();
		cmbNormalA4.setEnabled(false);
		cmbNormalA4.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
		cmbNormalA4.setSelectedIndex(ec.getBiotNorm());
		final GridBagConstraints gbc_cmbNormalA4 = new GridBagConstraints();
		gbc_cmbNormalA4.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA4.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA4.gridx = 2;
		gbc_cmbNormalA4.gridy = 3;
		contentPane.add(cmbNormalA4, gbc_cmbNormalA4);

		chckbxGalactosemia = new JCheckBox("Galactosemia");
		chckbxGalactosemia.setEnabled(false);
		chckbxGalactosemia.setSelected(ec.getGalactosemia());
		final GridBagConstraints gbc_chckbxGalactosemia = new GridBagConstraints();
		gbc_chckbxGalactosemia.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxGalactosemia.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGalactosemia.gridx = 0;
		gbc_chckbxGalactosemia.gridy = 4;
		contentPane.add(chckbxGalactosemia, gbc_chckbxGalactosemia);

		cmbNormalA5 = new JComboBox<>();
		cmbNormalA5.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
		cmbNormalA5.setSelectedIndex(ec.getGalacNom());
		cmbNormalA5.setEnabled(false);
		final GridBagConstraints gbc_cmbNormalA5 = new GridBagConstraints();
		gbc_cmbNormalA5.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA5.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA5.gridx = 2;
		gbc_cmbNormalA5.gridy = 4;
		contentPane.add(cmbNormalA5, gbc_cmbNormalA5);

		chckbxHidroxi = new JCheckBox("17 - OH Hidroxiprogesterona Neo");
		chckbxHidroxi.setEnabled(false);
		chckbxHidroxi.setSelected(ec.getHidroxiprogres());
		final GridBagConstraints gbc_chckbxHidroxi = new GridBagConstraints();
		gbc_chckbxHidroxi.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxHidroxi.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHidroxi.gridx = 0;
		gbc_chckbxHidroxi.gridy = 5;
		contentPane.add(chckbxHidroxi, gbc_chckbxHidroxi);

		cmbNormalA6 = new JComboBox<>();
		cmbNormalA6.setEnabled(false);
		cmbNormalA6.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
		cmbNormalA6.setSelectedIndex(ec.getHidroNorm());
		final GridBagConstraints gbc_cmbNormalA6 = new GridBagConstraints();
		gbc_cmbNormalA6.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA6.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA6.gridx = 2;
		gbc_cmbNormalA6.gridy = 5;
		contentPane.add(cmbNormalA6, gbc_cmbNormalA6);

		lblOtrosEc = new JLabel("Otros EC");
		final GridBagConstraints gbc_lblOtrosEc = new GridBagConstraints();
		gbc_lblOtrosEc.gridwidth = 3;
		gbc_lblOtrosEc.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOtrosEc.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtrosEc.gridx = 0;
		gbc_lblOtrosEc.gridy = 6;
		contentPane.add(lblOtrosEc, gbc_lblOtrosEc);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		contentPane.add(scrollPane, gbc_scrollPane);

		txtrOtros = new JTextArea();
		txtrOtros.setEditable(false);
		scrollPane.setViewportView(txtrOtros);
		txtrOtros.setText(ec.getOtrosErrores());

		txtPaciente = new JTextField();
		txtPaciente.setEditable(false);
		txtPaciente.setText(paciente.getApellido() + " " + paciente.getNombre());
		final GridBagConstraints gbc_txtPaciente = new GridBagConstraints();
		gbc_txtPaciente.insets = new Insets(0, 0, 0, 5);
		gbc_txtPaciente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPaciente.gridx = 0;
		gbc_txtPaciente.gridy = 8;
		contentPane.add(txtPaciente, gbc_txtPaciente);
		txtPaciente.setColumns(10);
	}

}

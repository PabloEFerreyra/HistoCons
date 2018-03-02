package com.historiasclinicas.pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorPacientes;
import com.historiasclinicas.log.Log;

public class PantaErroresCongenitos extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 253201960935703236L;
	private Boolean biotidinasa = false;
	private Integer biotNorm = 0;
	private JButton btnGuardar;
	private JCheckBox chckbxBiotidinasa;
	private JCheckBox chckbxFenilcetonuria;
	private JCheckBox chckbxFqp;
	private JCheckBox chckbxGalactosemia;
	private JCheckBox chckbxHidroxi;
	private JCheckBox chckbxHipotiroidismoCong;
	private JComboBox<String> cmbNormalA1;
	private JComboBox<String> cmbNormalA2;
	private JComboBox<String> cmbNormalA3;
	private JComboBox<String> cmbNormalA4;
	private JComboBox<String> cmbNormalA5;
	private JComboBox<String> cmbNormalA6;
	private JPanel contentPane;
	private Integer fenilcetNorm = 0;
	private Boolean fenilcetonuria = false;
	private Boolean fqp = false;
	private Integer fqpNorm = 0;
	private Integer galacNom = 0;
	private Boolean galactosemia = false;
	private Integer hidroNorm = 0;
	private Boolean hidroxiprogres = false;
	private Boolean hipotCong = false;
	private Integer hipotNorm = 0;
	private JLabel lblOtrosEc;
	private String otrosErrores = "";
	private Integer paciente = 0;
	private JScrollPane scrollPane;
	private JTextArea txtrOtros;
	public PantaErroresCongenitos(Paciente pacientes) {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Errores Congenitos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaErroresCongenitos.class.getResource("/imagenes/logotipo.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 456, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{217, 28, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		chckbxHipotiroidismoCong = new JCheckBox("Hipotiroidismo Congenito");
		chckbxHipotiroidismoCong.addChangeListener(e -> {
			if (chckbxHipotiroidismoCong.isSelected())
			{
				hipotCong = true;
				cmbNormalA1.setEnabled(true);
			}
			else
			{
				hipotCong = false;
				cmbNormalA1.setEnabled(false);
			}
		});
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
		final GridBagConstraints gbc_cmbNormalA1 = new GridBagConstraints();
		gbc_cmbNormalA1.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA1.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA1.gridx = 2;
		gbc_cmbNormalA1.gridy = 0;
		contentPane.add(cmbNormalA1, gbc_cmbNormalA1);

		chckbxFenilcetonuria = new JCheckBox("Fenilcetonuria");
		chckbxFenilcetonuria.addChangeListener(e -> {
			if (chckbxFenilcetonuria.isSelected())
			{
				fenilcetonuria = true;
				cmbNormalA2.setEnabled(true);
			}
			else
			{
				fenilcetonuria = false;
				cmbNormalA2.setEnabled(false);
			}
		});

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				txtrOtros.setEditable(false);
				chckbxBiotidinasa.setEnabled(false);
				chckbxFenilcetonuria.setEnabled(false);
				chckbxFqp.setEnabled(false);
				chckbxGalactosemia.setEnabled(false);
				chckbxHidroxi.setEnabled(false);
				chckbxHipotiroidismoCong.setEnabled(false);
				final SwingWorker worker = new SwingWorker(){
					@Override
					protected Object doInBackground() throws Exception {
						paciente = pacientes.getDni();
						otrosErrores = txtrOtros.getText();
						hipotNorm = cmbNormalA1.getSelectedIndex();
						fenilcetNorm = cmbNormalA2.getSelectedIndex();
						fqpNorm = cmbNormalA3.getSelectedIndex();
						biotNorm = cmbNormalA4.getSelectedIndex();
						galacNom = cmbNormalA5.getSelectedIndex();
						hidroNorm = cmbNormalA6.getSelectedIndex();
						final boolean res = GestorPacientes.GuardaErrorescongenitos(hipotCong, hipotNorm, fenilcetonuria, fenilcetNorm, fqp,
								fqpNorm, biotidinasa, biotNorm, galactosemia, galacNom,
								hidroxiprogres, hidroNorm, otrosErrores, paciente);
						if (res)
						{
							Log.CreaLog("Ingresados Errores Congenitos para paciente");
							JOptionPane.showMessageDialog(new JDialog(), "Carga Correcta", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
						{
							Log.crearLog("Error Interno");
							JOptionPane.showMessageDialog(new JDialog(), "Error Interno, intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
						}
						txtrOtros.setEditable(true);
						chckbxBiotidinasa.setEnabled(true);
						chckbxFenilcetonuria.setEnabled(true);
						chckbxFqp.setEnabled(true);
						chckbxGalactosemia.setEnabled(true);
						chckbxHidroxi.setEnabled(true);
						chckbxHipotiroidismoCong.setEnabled(true);
						return null;
					}
				};
				worker.execute();
			}
		});
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setIcon(new ImageIcon(PantaErroresCongenitos.class.getResource("/imagenes/iconos/twentytwo/save.png")));
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
		final GridBagConstraints gbc_cmbNormalA2 = new GridBagConstraints();
		gbc_cmbNormalA2.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA2.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA2.gridx = 2;
		gbc_cmbNormalA2.gridy = 1;
		contentPane.add(cmbNormalA2, gbc_cmbNormalA2);

		chckbxFqp = new JCheckBox("FQP");
		chckbxFqp.addChangeListener(e -> {
			if (chckbxFqp.isSelected())
			{
				fqp = true;
				cmbNormalA3.setEnabled(true);
			}
			else
			{
				cmbNormalA3.setEnabled(false);
				fqp = false;
			}
		});
		final GridBagConstraints gbc_chckbxFqp = new GridBagConstraints();
		gbc_chckbxFqp.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxFqp.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxFqp.gridx = 0;
		gbc_chckbxFqp.gridy = 2;
		contentPane.add(chckbxFqp, gbc_chckbxFqp);

		cmbNormalA3 = new JComboBox<>();
		cmbNormalA3.setEnabled(false);
		cmbNormalA3.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
		final GridBagConstraints gbc_cmbNormalA3 = new GridBagConstraints();
		gbc_cmbNormalA3.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA3.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA3.gridx = 2;
		gbc_cmbNormalA3.gridy = 2;
		contentPane.add(cmbNormalA3, gbc_cmbNormalA3);

		chckbxBiotidinasa = new JCheckBox("Biotidinasa");
		chckbxBiotidinasa.addChangeListener(e -> {
			if(chckbxBiotidinasa.isSelected())
			{
				biotidinasa = true;
				cmbNormalA4.setEnabled(true);
			}
			else
			{
				biotidinasa = false;
				cmbNormalA4.setEnabled(false);
			}
		});
		final GridBagConstraints gbc_chckbxBiotidinasa = new GridBagConstraints();
		gbc_chckbxBiotidinasa.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxBiotidinasa.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxBiotidinasa.gridx = 0;
		gbc_chckbxBiotidinasa.gridy = 3;
		contentPane.add(chckbxBiotidinasa, gbc_chckbxBiotidinasa);

		cmbNormalA4 = new JComboBox<>();
		cmbNormalA4.setEnabled(false);
		cmbNormalA4.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
		final GridBagConstraints gbc_cmbNormalA4 = new GridBagConstraints();
		gbc_cmbNormalA4.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA4.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA4.gridx = 2;
		gbc_cmbNormalA4.gridy = 3;
		contentPane.add(cmbNormalA4, gbc_cmbNormalA4);

		chckbxGalactosemia = new JCheckBox("Galactosemia");
		chckbxGalactosemia.addChangeListener(e -> {
			if (chckbxGalactosemia.isSelected())
			{
				galactosemia = true;
				cmbNormalA5.setEnabled(true);
			}
			else
			{
				galactosemia = false;
				cmbNormalA5.setEnabled(false);
			}
		});
		final GridBagConstraints gbc_chckbxGalactosemia = new GridBagConstraints();
		gbc_chckbxGalactosemia.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxGalactosemia.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGalactosemia.gridx = 0;
		gbc_chckbxGalactosemia.gridy = 4;
		contentPane.add(chckbxGalactosemia, gbc_chckbxGalactosemia);

		cmbNormalA5 = new JComboBox<>();
		cmbNormalA5.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
		cmbNormalA5.setEnabled(false);
		final GridBagConstraints gbc_cmbNormalA5 = new GridBagConstraints();
		gbc_cmbNormalA5.insets = new Insets(0, 0, 5, 5);
		gbc_cmbNormalA5.anchor = GridBagConstraints.WEST;
		gbc_cmbNormalA5.gridx = 2;
		gbc_cmbNormalA5.gridy = 4;
		contentPane.add(cmbNormalA5, gbc_cmbNormalA5);

		chckbxHidroxi = new JCheckBox("17 - OH Hidroxiprogesterona Neo");
		chckbxHidroxi.addChangeListener(e -> {
			if(chckbxHidroxi.isSelected())
			{
				hidroxiprogres = true;
				cmbNormalA6.setEnabled(true);
			}
			else
			{
				hidroxiprogres = false;
				cmbNormalA6.setEnabled(false);
			}
		});
		final GridBagConstraints gbc_chckbxHidroxi = new GridBagConstraints();
		gbc_chckbxHidroxi.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxHidroxi.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHidroxi.gridx = 0;
		gbc_chckbxHidroxi.gridy = 5;
		contentPane.add(chckbxHidroxi, gbc_chckbxHidroxi);

		cmbNormalA6 = new JComboBox<>();
		cmbNormalA6.setEnabled(false);
		cmbNormalA6.setModel(new DefaultComboBoxModel<>(new String[] {"", "Normal", "Anormal"}));
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
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		contentPane.add(scrollPane, gbc_scrollPane);

		txtrOtros = new JTextArea();
		scrollPane.setViewportView(txtrOtros);
	}

}

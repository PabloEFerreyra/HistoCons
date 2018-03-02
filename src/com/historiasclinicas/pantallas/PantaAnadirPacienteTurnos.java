package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.historiasclinicas.ejecucion.AdministrarPaciente;
import com.historiasclinicas.ejecucion.Ejecucion;
import com.historiasclinicas.entidades.Ciudad;
import com.historiasclinicas.gestores.GestorCiudad;
import com.historiasclinicas.gestores.GestorOS;
import com.historiasclinicas.gestores.GestorProvincia;
import com.historiasclinicas.gestores.LostFocus;
import com.historiasclinicas.log.Log;
import com.toedter.calendar.JDateChooser;

public class PantaAnadirPacienteTurnos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnAadir;
	private JButton btnCerrar;
	private JComboBox<Ciudad> cmbCiudad;
	private JComboBox<String> cmbObraSocial;
	private JComboBox<String> cmbProvincia;
	private JComboBox<String> cmbSexo;
	private JPanel contentPane;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblCorregirApellido;
	private JLabel lblcorregirNombre;
	private JLabel lblDni;
	private JLabel lblGuardandoPaciente;
	private JLabel lblNuevoPaciente;
	private JLabel lblSexo;
	private String[] listaCiudad;
	private String[] listaOS;
	private String[] listaProvincia;
	private JMenuItem mntmSalir;
	private JTextField txtAdminapellido;
	private JTextField txtAdmincelular;
	private JTextField txtAdmincorreo;
	private JTextField txtAdmindomicilio;
	private JTextField txtAdminnombre;
	private JTextField txtAdminnroafiliado;
	private JTextField txtAdminplan;
	private JTextField txtAdmintelefono;
	private JTextField txtDni;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PantaAnadirPacienteTurnos(String paciente) {

		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaAnadirPaciente.class.getResource("/imagenes/logotipo.png")));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		final String dni = paciente;
		listaOS = GestorOS.ConsultarOS();
		listaCiudad = GestorCiudad.ConsultarCiudad();
		listaProvincia = GestorProvincia.ConsultarProvincia();
		setTitle("Ver/Modificar Paciente");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 727, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, -115, 0, 68, 0 };
		gbl_contentPane.columnWidths = new int[] { -16, 95, 218, 0, 0, 219, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(
				new ImageIcon(PantaAnadirPaciente.class.getResource("/imagenes/iconos/twentytwo/archive.png")));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(PantaAnadirPaciente.class.getResource("/imagenes/iconos/twentytwo/close.png")));
		mntmSalir.addActionListener(arg0 -> System.exit(0));
		mnArchivo.add(mntmSalir);

		lblNuevoPaciente = new JLabel("Nuevo Paciente");
		lblNuevoPaciente.setFont(new Font("Georgia", Font.BOLD, 12));
		lblNuevoPaciente
		.setIcon(new ImageIcon(PantaAnadirPaciente.class.getResource("/imagenes/iconos/user-plus.png")));
		final GridBagConstraints gbc_lblNuevoPaciente = new GridBagConstraints();
		gbc_lblNuevoPaciente.gridwidth = 2;
		gbc_lblNuevoPaciente.anchor = GridBagConstraints.WEST;
		gbc_lblNuevoPaciente.fill = GridBagConstraints.VERTICAL;
		gbc_lblNuevoPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevoPaciente.gridx = 1;
		gbc_lblNuevoPaciente.gridy = 0;
		contentPane.add(lblNuevoPaciente, gbc_lblNuevoPaciente);

		label = new JLabel("Datos Personales");
		label.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		contentPane.add(label, gbc_label);

		lblDni = new JLabel("Dni");
		final GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.fill = GridBagConstraints.BOTH;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 2;
		contentPane.add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		txtDni.setText(dni);
		txtDni.setEditable(false);
		lblDni.setLabelFor(txtDni);
		txtDni.setToolTipText("Ingrese Solo Numero de DNI");
		final GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.BOTH;
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 2;
		contentPane.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);

		final JLabel lblApellido = new JLabel("Apellido");
		final GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.fill = GridBagConstraints.BOTH;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 4;
		gbc_lblApellido.gridy = 2;
		contentPane.add(lblApellido, gbc_lblApellido);
		lblApellido.setLabelFor(txtAdminapellido);

		txtAdminapellido = new JTextField();
		txtAdminapellido.setToolTipText("Ingrese Apellido de paciente");
		final GridBagConstraints gbc_txtAdminapellido = new GridBagConstraints();
		gbc_txtAdminapellido.fill = GridBagConstraints.BOTH;
		gbc_txtAdminapellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminapellido.gridx = 5;
		gbc_txtAdminapellido.gridy = 2;
		contentPane.add(txtAdminapellido, gbc_txtAdminapellido);
		txtAdminapellido.setColumns(10);
		txtAdminapellido.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					final boolean valido = LostFocus.ValidaApellidoyNombre(txtAdminapellido.getText());
					if (valido) {
						lblCorregirApellido.setVisible(true);
						txtAdminapellido.requestFocus();
					}
					lblCorregirApellido.setVisible(false);
				}
			}
		});

		lblCorregirApellido = new JLabel("* Corregir");
		lblCorregirApellido.setForeground(Color.RED);
		final GridBagConstraints gbc_lblCorregirApellido = new GridBagConstraints();
		gbc_lblCorregirApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorregirApellido.gridx = 6;
		gbc_lblCorregirApellido.gridy = 2;
		contentPane.add(lblCorregirApellido, gbc_lblCorregirApellido);
		lblCorregirApellido.setVisible(false);

		final JLabel lblNombre = new JLabel("Nombre");
		final GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		contentPane.add(lblNombre, gbc_lblNombre);
		lblNombre.setLabelFor(txtAdminnombre);

		txtAdminnombre = new JTextField();
		txtAdminnombre.setToolTipText("Ingrese Nombre Paciente");
		final GridBagConstraints gbc_txtAdminnombre = new GridBagConstraints();
		gbc_txtAdminnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnombre.gridx = 2;
		gbc_txtAdminnombre.gridy = 3;
		contentPane.add(txtAdminnombre, gbc_txtAdminnombre);
		txtAdminnombre.setColumns(10);
		txtAdminnombre.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					final boolean valido = LostFocus.ValidaApellidoyNombre(txtAdminnombre.getText());
					if (valido) {
						lblcorregirNombre.setVisible(true);
						txtAdminnombre.requestFocus();
					}
					lblcorregirNombre.setVisible(false);
				}
			}
		});

		lblcorregirNombre = new JLabel("*Corregir");
		lblcorregirNombre.setForeground(Color.RED);
		final GridBagConstraints gbc_lblcorregirNombre = new GridBagConstraints();
		gbc_lblcorregirNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblcorregirNombre.gridx = 3;
		gbc_lblcorregirNombre.gridy = 3;
		contentPane.add(lblcorregirNombre, gbc_lblcorregirNombre);
		lblcorregirNombre.setVisible(false);

		lblSexo = new JLabel("Sexo");
		final GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 4;
		gbc_lblSexo.gridy = 3;
		contentPane.add(lblSexo, gbc_lblSexo);

		cmbSexo = new JComboBox<>();
		final GridBagConstraints gbc_cmbSexo = new GridBagConstraints();
		gbc_cmbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSexo.gridx = 5;
		gbc_cmbSexo.gridy = 3;
		contentPane.add(cmbSexo, gbc_cmbSexo);
		cmbSexo.addItem("Masculino");
		cmbSexo.addItem("Femenino");

		final Calendar c2 = new GregorianCalendar();

		final JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		final GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.fill = GridBagConstraints.BOTH;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 4;
		contentPane.add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setCalendar(c2);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 4;
		contentPane.add(dateChooser, gbc_dateChooser);
		dateChooser.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { dateChooser.getCalendarButton() }));

		label_1 = new JLabel("Contacto");
		label_1.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.VERTICAL;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 5;
		contentPane.add(label_1, gbc_label_1);

		final JLabel lblProvincia = new JLabel("Provincia");
		final GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.fill = GridBagConstraints.BOTH;
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 1;
		gbc_lblProvincia.gridy = 6;
		contentPane.add(lblProvincia, gbc_lblProvincia);

		cmbProvincia = new JComboBox<>();
		final GridBagConstraints gbc_cmbProvincia = new GridBagConstraints();
		gbc_cmbProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_cmbProvincia.fill = GridBagConstraints.BOTH;
		gbc_cmbProvincia.gridx = 2;
		gbc_cmbProvincia.gridy = 6;
		contentPane.add(cmbProvincia, gbc_cmbProvincia);
		cmbProvincia.setModel(new DefaultComboBoxModel(listaProvincia));

		final JLabel lblCiudad = new JLabel("Ciudad");
		final GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.EAST;
		gbc_lblCiudad.fill = GridBagConstraints.VERTICAL;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 4;
		gbc_lblCiudad.gridy = 6;
		contentPane.add(lblCiudad, gbc_lblCiudad);
		lblCiudad.setLabelFor(cmbCiudad);

		cmbCiudad = new JComboBox();
		cmbCiudad.setModel(new DefaultComboBoxModel(listaCiudad));
		final GridBagConstraints gbc_cmbCiudad = new GridBagConstraints();
		gbc_cmbCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbCiudad.gridx = 5;
		gbc_cmbCiudad.gridy = 6;
		contentPane.add(cmbCiudad, gbc_cmbCiudad);

		final JLabel lblDomicilio = new JLabel("Domicilio");
		final GridBagConstraints gbc_lblDomicilio = new GridBagConstraints();
		gbc_lblDomicilio.fill = GridBagConstraints.BOTH;
		gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomicilio.gridx = 1;
		gbc_lblDomicilio.gridy = 7;
		contentPane.add(lblDomicilio, gbc_lblDomicilio);
		lblDomicilio.setLabelFor(txtAdmindomicilio);

		txtAdmindomicilio = new JTextField();
		txtAdmindomicilio.setToolTipText("Domicilio de Residencia del paciente");
		final GridBagConstraints gbc_txtAdmindomicilio = new GridBagConstraints();
		gbc_txtAdmindomicilio.fill = GridBagConstraints.BOTH;
		gbc_txtAdmindomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmindomicilio.gridx = 2;
		gbc_txtAdmindomicilio.gridy = 7;
		contentPane.add(txtAdmindomicilio, gbc_txtAdmindomicilio);
		txtAdmindomicilio.setColumns(10);
		txtAdmindomicilio.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					final String domicilioVer = txtAdmindomicilio.getText();
					txtAdmindomicilio.setText(Ejecucion.EvaluaNoAplica(domicilioVer));
				}
			}
		});
		final JLabel lblTelefono = new JLabel("Telefono");
		final GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.fill = GridBagConstraints.BOTH;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 8;
		contentPane.add(lblTelefono, gbc_lblTelefono);
		lblTelefono.setLabelFor(txtAdmintelefono);

		txtAdmintelefono = new JTextField(10);
		txtAdmintelefono.setToolTipText("Nro de telefono del paciente");
		final GridBagConstraints gbc_txtAdmintelefono = new GridBagConstraints();
		gbc_txtAdmintelefono.fill = GridBagConstraints.BOTH;
		gbc_txtAdmintelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmintelefono.gridx = 2;
		gbc_txtAdmintelefono.gridy = 8;
		contentPane.add(txtAdmintelefono, gbc_txtAdmintelefono);
		txtAdmintelefono.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					final String telefonoE = txtAdmintelefono.getText();
					txtAdmintelefono.setText(Ejecucion.EvaluaCero(telefonoE));
				}
			}
		});

		final JLabel lblCelular = new JLabel("Celular");
		final GridBagConstraints gbc_lblCelular = new GridBagConstraints();
		gbc_lblCelular.fill = GridBagConstraints.BOTH;
		gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelular.gridx = 4;
		gbc_lblCelular.gridy = 8;
		contentPane.add(lblCelular, gbc_lblCelular);
		lblCelular.setLabelFor(txtAdmincelular);

		txtAdmincelular = new JTextField(10);
		txtAdmincelular.setToolTipText("Numero de celular del paciente");
		final GridBagConstraints gbc_txtAdmincelular = new GridBagConstraints();
		gbc_txtAdmincelular.fill = GridBagConstraints.BOTH;
		gbc_txtAdmincelular.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmincelular.gridx = 5;
		gbc_txtAdmincelular.gridy = 8;
		contentPane.add(txtAdmincelular, gbc_txtAdmincelular);
		txtAdmincelular.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					final String celularE = txtAdmincelular.getText();
					txtAdmincelular.setText(Ejecucion.EvaluaCero(celularE));
				}
			}
		});

		label_2 = new JLabel("Correo Electronico");
		label_2.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.VERTICAL;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 9;
		contentPane.add(label_2, gbc_label_2);

		final JLabel lblCorreo = new JLabel("Correo");
		final GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.fill = GridBagConstraints.BOTH;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 10;
		contentPane.add(lblCorreo, gbc_lblCorreo);
		lblCorreo.setLabelFor(txtAdmincorreo);

		txtAdmincorreo = new JTextField();
		txtAdmincorreo.setToolTipText("Correo electronico, si no tiene, escribir \"-\"");
		final GridBagConstraints gbc_txtAdmincorreo = new GridBagConstraints();
		gbc_txtAdmincorreo.fill = GridBagConstraints.BOTH;
		gbc_txtAdmincorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmincorreo.gridx = 2;
		gbc_txtAdmincorreo.gridy = 10;
		contentPane.add(txtAdmincorreo, gbc_txtAdmincorreo);
		txtAdmincorreo.setColumns(10);
		txtAdmincorreo.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					final String mailE = txtAdmincorreo.getText();
					if (Ejecucion.ValidaCorreo(mailE) == "null")
						txtAdmincorreo.requestFocus();
					txtAdmincorreo.setText(mailE);
				}
			}
		});

		label_3 = new JLabel("Obra Social");
		label_3.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.VERTICAL;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 11;
		contentPane.add(label_3, gbc_label_3);

		final JLabel lblObraSocial = new JLabel("Nombre OS");
		final GridBagConstraints gbc_lblObraSocial = new GridBagConstraints();
		gbc_lblObraSocial.fill = GridBagConstraints.BOTH;
		gbc_lblObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblObraSocial.gridx = 1;
		gbc_lblObraSocial.gridy = 13;
		contentPane.add(lblObraSocial, gbc_lblObraSocial);

		cmbObraSocial = new JComboBox<>();
		final GridBagConstraints gbc_cmbObraSocial = new GridBagConstraints();
		gbc_cmbObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_cmbObraSocial.fill = GridBagConstraints.BOTH;
		gbc_cmbObraSocial.gridx = 2;
		gbc_cmbObraSocial.gridy = 13;
		contentPane.add(cmbObraSocial, gbc_cmbObraSocial);
		cmbObraSocial.setModel(new DefaultComboBoxModel(listaOS));
		cmbObraSocial.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if(cmbObraSocial.getSelectedItem().equals("Particular"))
				{
					txtAdminplan.setEditable(false);
					txtAdminplan.setText("Particular");
					txtAdminnroafiliado.setEditable(false);
					txtAdminnroafiliado.setText(txtDni.getText());
				}
				else
				{
					txtAdminplan.setEditable(true);
					txtAdminplan.setText("");
					txtAdminnroafiliado.setEditable(true);
					txtAdminnroafiliado.setText(txtDni.getText());
				}
			}
		});

		final JLabel lblPlanObraSocial = new JLabel("Plan");
		final GridBagConstraints gbc_lblPlanObraSocial = new GridBagConstraints();
		gbc_lblPlanObraSocial.fill = GridBagConstraints.BOTH;
		gbc_lblPlanObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanObraSocial.gridx = 4;
		gbc_lblPlanObraSocial.gridy = 13;
		contentPane.add(lblPlanObraSocial, gbc_lblPlanObraSocial);

		txtAdminplan = new JTextField();
		txtAdminplan.setToolTipText("Ingrese Plan OS");
		final GridBagConstraints gbc_txtAdminplan = new GridBagConstraints();
		gbc_txtAdminplan.fill = GridBagConstraints.BOTH;
		gbc_txtAdminplan.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminplan.gridx = 5;
		gbc_txtAdminplan.gridy = 13;
		contentPane.add(txtAdminplan, gbc_txtAdminplan);
		txtAdminplan.setColumns(10);
		lblPlanObraSocial.setLabelFor(txtAdminplan);
		txtAdminplan.setEditable(true);

		final JLabel lblNumeroAfiliado = new JLabel("Numero Afiliado");
		final GridBagConstraints gbc_lblNumeroAfiliado = new GridBagConstraints();
		gbc_lblNumeroAfiliado.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNumeroAfiliado.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroAfiliado.gridx = 1;
		gbc_lblNumeroAfiliado.gridy = 14;
		contentPane.add(lblNumeroAfiliado, gbc_lblNumeroAfiliado);

		txtAdminnroafiliado = new JTextField();
		txtAdminnroafiliado.setToolTipText("Numero Afiliado (en muchos casos puede ser el nro de DNI)");
		final GridBagConstraints gbc_txtAdminnroafiliado = new GridBagConstraints();
		gbc_txtAdminnroafiliado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnroafiliado.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnroafiliado.gridx = 2;
		gbc_txtAdminnroafiliado.gridy = 14;
		contentPane.add(txtAdminnroafiliado, gbc_txtAdminnroafiliado);
		txtAdminnroafiliado.setColumns(10);
		lblNumeroAfiliado.setLabelFor(txtAdminnroafiliado);
		txtAdminnroafiliado.setEditable(true);

		btnCerrar = new JButton("Cancelar");
		btnCerrar.addActionListener(arg0 -> {
			new PantaNuevoTurno().setVisible(true);
			dispose();
		});

		btnAadir = new JButton("Agregar");
		btnAadir.setIcon(new ImageIcon(PantaAnadirPaciente.class.getResource("/imagenes/iconos/save.png")));
		btnAadir.setHorizontalAlignment(SwingConstants.LEFT);
		btnAadir.addActionListener(arg0 -> {

			final Integer dni1 = Integer.parseInt(txtDni.getText());
			final String apellido = txtAdminapellido.getText();
			final String nombre = txtAdminnombre.getText();
			final Integer sexo = cmbSexo.getSelectedIndex();
			final Date fechanac = dateChooser.getDate();
			final Integer obrasocial = cmbObraSocial.getSelectedIndex();
			final String numeroafiliado = txtAdminnroafiliado.getText();
			final String planobra = txtAdminplan.getText();
			final Integer provincia = cmbProvincia.getSelectedIndex();
			final Integer ciudad = cmbCiudad.getSelectedIndex();
			final String domicilio = Ejecucion.EvaluaNoAplica(txtAdmindomicilio.getText());
			final Long telefono = Long.parseLong(Ejecucion.EvaluaCero(txtAdmintelefono.getText()));
			final Long celular = Long.parseLong(Ejecucion.EvaluaCero(txtAdmincelular.getText()));
			final String mail = Ejecucion.ValidaCorreo(txtAdmincorreo.getText());
			final String hace = "NUEVO";
			try {
				final SwingWorker worker = new SwingWorker(){
					@Override
					protected Object doInBackground() throws Exception {
						int ingresado = 0;
						AdministrarPaciente.ActualizaPaciente(dni1, apellido, nombre, sexo, fechanac,
								obrasocial, numeroafiliado,
								planobra, provincia, ciudad, domicilio, telefono, celular, mail, hace);
						while (ingresado == 0) {
							lblGuardandoPaciente.setVisible(true);
							ingresado = 1;
						}
						if (ingresado == 1)
						{
							final PantaNuevoTurnoPaciente pntp = new PantaNuevoTurnoPaciente(dni1, apellido, nombre);
							pntp.setVisible(true);
							Log.crearLog("Paciente Ingresado Correctamente");
							dispose();
						}
						return null;
					}
				};
				worker.execute();
			} catch (final Exception e) {
				try {
					Log.crearLog("Error: " + e.getMessage().toString());
				} catch (final IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		final GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.anchor = GridBagConstraints.WEST;
		gbc_btnAadir.fill = GridBagConstraints.VERTICAL;
		gbc_btnAadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadir.gridx = 2;
		gbc_btnAadir.gridy = 15;
		contentPane.add(btnAadir, gbc_btnAadir);
		btnCerrar.setIcon(new ImageIcon(PantaAnadirPaciente.class.getResource("/imagenes/iconos/ban.png")));
		final GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.anchor = GridBagConstraints.WEST;
		gbc_btnCerrar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCerrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCerrar.gridx = 5;
		gbc_btnCerrar.gridy = 15;
		contentPane.add(btnCerrar, gbc_btnCerrar);

		lblGuardandoPaciente = new JLabel("Guardando paciente...");
		lblGuardandoPaciente.setVisible(false);
		final GridBagConstraints gbc_lblGuardandoPaciente = new GridBagConstraints();
		gbc_lblGuardandoPaciente.anchor = GridBagConstraints.EAST;
		gbc_lblGuardandoPaciente.gridwidth = 2;
		gbc_lblGuardandoPaciente.insets = new Insets(0, 0, 0, 5);
		gbc_lblGuardandoPaciente.gridx = 5;
		gbc_lblGuardandoPaciente.gridy = 16;
		contentPane.add(lblGuardandoPaciente, gbc_lblGuardandoPaciente);

	}
}
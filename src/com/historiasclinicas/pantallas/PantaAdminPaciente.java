package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.historiasclinicas.ejecucion.AdministrarPaciente;
import com.historiasclinicas.ejecucion.Ejecucion;
import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.ejecucion.JTextFieldLimit;
import com.historiasclinicas.ejecucion.Numbers;
import com.historiasclinicas.entidades.Historia;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.entidades.Planillapediatrica;
import com.historiasclinicas.gestores.GestorCiudad;
import com.historiasclinicas.gestores.GestorHistoria;
import com.historiasclinicas.gestores.GestorOS;
import com.historiasclinicas.gestores.GestorPacientes;
import com.historiasclinicas.gestores.GestorProvincia;
import com.historiasclinicas.gestores.LostFocus;
import com.historiasclinicas.log.Log;
import com.toedter.calendar.JDateChooser;

public class PantaAdminPaciente extends JFrame implements ItemListener {
	private static final long serialVersionUID = 1L;
	FileWriter archivo;
	private JButton btnAgregarIngreso;
	private JButton btnCargarIngresos;
	private JButton btnCerrar;
	private JButton btnGuardarModificaciones;
	private JButton btnMostrarIngreso;
	private JButton btnPediatrico;
	private JButton btnReportes;
	private JComboBox<String> cmbCiudad;
	private JComboBox<String> cmbObraSocial;
	private JComboBox<String> cmbProvincia;
	private JComboBox<String> cmbSexo;
	String[] columnNames = {"Fecha", "Especialista"};
	private JComboBox<?> comboBox;
	private JPanel contentPane;
	private JDateChooser dateChooser;
	Calendar fechaActual = Calendar.getInstance();
	private JLabel lblContacto;
	private JLabel lblCorregirEmail;
	private JLabel lblCorreoElectronico;
	private JLabel lblDatosPersonales;
	private JLabel lblDni;
	private JLabel lblEstado;
	private JLabel lblGrupoSang;
	private JLabel lblIngresos;
	private JLabel lblOs;
	private JLabel lblSexo;
	private JLabel lblVermodificarPaciente;
	private String[] listaCiudad;
	private List<Historia> listaHistorias = null;
	private String[] listaOS;
	private String[] listaProvincia;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private Paciente pacientes;
	private final String perfil = PantaLogin.perfil.get(0).getPerfil();
	private Planillapediatrica planillaPediatrico;
	private PantaPlanillaMuestraPediatrico ppmp;
	private PantaPlanillaPediatrico ppp;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtAdminnombre;
	private JTextField txtAdmincelular;
	private JTextField txtAdmincorreo;
	private JTextField txtAdmindomicilio;
	private JTextField txtAdminapellido;
	private JTextField txtAdminnroafiliado;
	private JTextField txtAdminplan;
	private JTextField txtAdmintelefono;
	private JTextField txtDni;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PantaAdminPaciente(Paciente pacientes) {
		setResizable(false);

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(PantaAdminPaciente.class.getResource("/imagenes/logotipo.png")));

		listaOS = GestorOS.ConsultarOS();
		listaCiudad = GestorCiudad.ConsultarCiudad();
		listaProvincia = GestorProvincia.ConsultarProvincia();
		this.pacientes = pacientes;
		setTitle("Ver/Modificar Paciente");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1047, 713);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo
		.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/iconos/twentytwo/archive.png")));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/iconos/twentytwo/save.png")));
		mntmSalir.addActionListener(arg0 -> System.exit(0));
		mnArchivo.add(mntmSalir);

		contentPane = new JPanel();

		contentPane.setBorder(null);
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 20, 100, 127, 250, 30, 85, 153, 89, 0, 20, 0 };
		gbl_contentPane.rowHeights = new int[] { 10, 0, 33, 20, 20, 23, 0, 20, 20, 20, 20, 20, 20, 0, 0, 0,
				38, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblVermodificarPaciente = new JLabel("VER/MODIFICAR PACIENTE");
		lblVermodificarPaciente.setFont(new Font("SansSerif", Font.PLAIN, 12));
		final GridBagConstraints gbc_lblVermodificarPaciente = new GridBagConstraints();
		gbc_lblVermodificarPaciente.gridwidth = 8;
		gbc_lblVermodificarPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblVermodificarPaciente.gridx = 1;
		gbc_lblVermodificarPaciente.gridy = 0;
		contentPane.add(lblVermodificarPaciente, gbc_lblVermodificarPaciente);

		lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_lblDatosPersonales = new GridBagConstraints();
		gbc_lblDatosPersonales.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDatosPersonales.gridwidth = 4;
		gbc_lblDatosPersonales.anchor = GridBagConstraints.NORTH;
		gbc_lblDatosPersonales.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosPersonales.gridx = 1;
		gbc_lblDatosPersonales.gridy = 1;
		contentPane.add(lblDatosPersonales, gbc_lblDatosPersonales);

		lblDni = new JLabel("Dni");
		final GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 2;
		contentPane.add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		txtDni.setDocument(new JTextFieldLimit(10));
		txtDni.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDni.setEditable(false);
		final GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 2;
		contentPane.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);
		txtDni.setText(Integer.toString(this.pacientes.getDni()));

		final JLabel lblApellido = new JLabel("Apellido");
		final GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 5;
		gbc_lblApellido.gridy = 2;
		contentPane.add(lblApellido, gbc_lblApellido);

		txtAdminapellido = new JTextField();
		txtAdminapellido.setText("AdminNombre");
		final GridBagConstraints gbc_txtAdminapellido = new GridBagConstraints();
		gbc_txtAdminapellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminapellido.gridwidth = 3;
		gbc_txtAdminapellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminapellido.gridx = 6;
		gbc_txtAdminapellido.gridy = 2;
		contentPane.add(txtAdminapellido, gbc_txtAdminapellido);
		txtAdminapellido.setColumns(10);
		txtAdminapellido.setText(this.pacientes.getNombre());
		txtAdminapellido.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					final boolean valido = LostFocus.ValidaApellidoyNombre(txtAdminapellido.getText());
					if (valido)
						txtAdminapellido.requestFocus();
				}
			}
		});

		final JLabel lblNombre = new JLabel("Nombre");
		final GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		contentPane.add(lblNombre, gbc_lblNombre);

		txtAdminnombre = new JTextField();
		txtAdminnombre.setText("AdminApellido");
		final GridBagConstraints gbc_txtAdminnombre = new GridBagConstraints();
		gbc_txtAdminnombre.gridwidth = 2;
		gbc_txtAdminnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnombre.gridx = 2;
		gbc_txtAdminnombre.gridy = 3;
		contentPane.add(txtAdminnombre, gbc_txtAdminnombre);
		txtAdminnombre.setColumns(10);
		txtAdminnombre.setText(this.pacientes.getApellido());
		txtAdminnombre.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					final boolean valido = LostFocus.ValidaApellidoyNombre(txtAdminnombre.getText());
					if (valido)
						txtAdminnombre.requestFocus();
				}
			}
		});

		lblSexo = new JLabel("Sexo");
		final GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 5;
		gbc_lblSexo.gridy = 3;
		contentPane.add(lblSexo, gbc_lblSexo);

		cmbSexo = new JComboBox<>();
		final GridBagConstraints gbc_cmbSexo = new GridBagConstraints();
		gbc_cmbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSexo.gridx = 6;
		gbc_cmbSexo.gridy = 3;
		contentPane.add(cmbSexo, gbc_cmbSexo);
		cmbSexo.addItem("Masculino");
		cmbSexo.addItem("Femenino");
		cmbSexo.addItemListener(this);
		cmbSexo.setSelectedIndex(pacientes.getSexo());

		final JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		final GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 4;
		contentPane.add(lblFechaNacimiento, gbc_lblFechaNacimiento);

		dateChooser = new JDateChooser();
		dateChooser.setDate(this.pacientes.getFechaNacimiento());
		dateChooser.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 4;
		contentPane.add(dateChooser, gbc_dateChooser);

		lblGrupoSang = new JLabel("Grupo Sanguineo");
		final GridBagConstraints gbc_lblGrupoSang = new GridBagConstraints();
		gbc_lblGrupoSang.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGrupoSang.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrupoSang.gridx = 5;
		gbc_lblGrupoSang.gridy = 4;
		contentPane.add(lblGrupoSang, gbc_lblGrupoSang);

		comboBox = new JComboBox();
		comboBox.setSelectedItem(this.pacientes.getGruposanguineo());
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"}));
		final GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 6;
		gbc_comboBox.gridy = 4;
		contentPane.add(comboBox, gbc_comboBox);

		lblContacto = new JLabel("Contacto");
		lblContacto.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_lblContacto = new GridBagConstraints();
		gbc_lblContacto.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblContacto.insets = new Insets(0, 0, 5, 5);
		gbc_lblContacto.gridx = 1;
		gbc_lblContacto.gridy = 5;
		contentPane.add(lblContacto, gbc_lblContacto);

		final JLabel lblProvincia = new JLabel("Provincia");
		final GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 1;
		gbc_lblProvincia.gridy = 6;
		contentPane.add(lblProvincia, gbc_lblProvincia);

		cmbProvincia = new JComboBox<>();
		cmbProvincia.setMaximumRowCount(25);
		final GridBagConstraints gbc_cmbProvincia = new GridBagConstraints();
		gbc_cmbProvincia.gridwidth = 2;
		gbc_cmbProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_cmbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbProvincia.gridx = 2;
		gbc_cmbProvincia.gridy = 6;
		contentPane.add(cmbProvincia, gbc_cmbProvincia);
		cmbProvincia.setModel(new DefaultComboBoxModel(listaProvincia));
		cmbProvincia.setSelectedIndex(pacientes.getProvincia());

		final JLabel lblCiudad = new JLabel("Ciudad");
		final GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 5;
		gbc_lblCiudad.gridy = 6;
		contentPane.add(lblCiudad, gbc_lblCiudad);

		cmbCiudad = new JComboBox();
		cmbCiudad.setModel(new DefaultComboBoxModel(listaCiudad));
		cmbCiudad.setSelectedIndex(pacientes.getCiudad());
		final GridBagConstraints gbc_cmbCiudad = new GridBagConstraints();
		gbc_cmbCiudad.gridwidth = 2;
		gbc_cmbCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbCiudad.gridx = 6;
		gbc_cmbCiudad.gridy = 6;
		contentPane.add(cmbCiudad, gbc_cmbCiudad);

		final JLabel lblDomicilio = new JLabel("Domicilio");
		final GridBagConstraints gbc_lblDomicilio = new GridBagConstraints();
		gbc_lblDomicilio.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomicilio.gridx = 1;
		gbc_lblDomicilio.gridy = 7;
		contentPane.add(lblDomicilio, gbc_lblDomicilio);

		txtAdmindomicilio = new JTextField();
		txtAdmindomicilio.setText("AdminDomicilio");
		final GridBagConstraints gbc_txtAdmindomicilio = new GridBagConstraints();
		gbc_txtAdmindomicilio.gridwidth = 2;
		gbc_txtAdmindomicilio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmindomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmindomicilio.gridx = 2;
		gbc_txtAdmindomicilio.gridy = 7;
		contentPane.add(txtAdmindomicilio, gbc_txtAdmindomicilio);
		txtAdmindomicilio.setColumns(10);
		txtAdmindomicilio.setText(this.pacientes.getDomicilio());
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
		gbc_lblTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 8;
		contentPane.add(lblTelefono, gbc_lblTelefono);

		txtAdmintelefono = new JTextField();
		txtAdmintelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAdmintelefono.setText("AdminTelefono");
		txtAdmintelefono.setDocument(new JTextFieldLimit(15));
		txtAdmintelefono.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				Numbers.caracteres(e);
			}
		});
		final GridBagConstraints gbc_txtAdmintelefono = new GridBagConstraints();
		gbc_txtAdmintelefono.gridwidth = 2;
		gbc_txtAdmintelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmintelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmintelefono.gridx = 2;
		gbc_txtAdmintelefono.gridy = 8;
		contentPane.add(txtAdmintelefono, gbc_txtAdmintelefono);
		txtAdmintelefono.setColumns(10);
		txtAdmintelefono.setText(Long.toString(this.pacientes.getTelefono()));
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
		gbc_lblCelular.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelular.gridx = 5;
		gbc_lblCelular.gridy = 8;
		contentPane.add(lblCelular, gbc_lblCelular);

		txtAdmincelular = new JTextField();
		txtAdmincelular.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAdmincelular.setDocument(new JTextFieldLimit(15));
		txtAdmincelular.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				Numbers.caracteres(e);
			}
		});
		txtAdmincelular.setText("AdminCelular");
		final GridBagConstraints gbc_txtAdmincelular = new GridBagConstraints();
		gbc_txtAdmincelular.gridwidth = 2;
		gbc_txtAdmincelular.fill = GridBagConstraints.BOTH;
		gbc_txtAdmincelular.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmincelular.gridx = 6;
		gbc_txtAdmincelular.gridy = 8;
		contentPane.add(txtAdmincelular, gbc_txtAdmincelular);
		txtAdmincelular.setColumns(8);
		txtAdmincelular.setText(Long.toString(this.pacientes.getTelefonoCelular()));
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
		if (perfil.equals("Secretaria"))
			btnPediatrico.setVisible(false);

		lblCorreoElectronico = new JLabel("Correo Electronico");
		lblCorreoElectronico.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_lblCorreoElectronico = new GridBagConstraints();
		gbc_lblCorreoElectronico.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoElectronico.gridx = 1;
		gbc_lblCorreoElectronico.gridy = 9;
		contentPane.add(lblCorreoElectronico, gbc_lblCorreoElectronico);

		final JLabel lblCorreo = new JLabel("Correo");
		final GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 10;
		contentPane.add(lblCorreo, gbc_lblCorreo);

		txtAdmincorreo = new JTextField();
		txtAdmincorreo.setText("AdminCorreo");
		final GridBagConstraints gbc_txtAdmincorreo = new GridBagConstraints();
		gbc_txtAdmincorreo.gridwidth = 2;
		gbc_txtAdmincorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmincorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmincorreo.gridx = 2;
		gbc_txtAdmincorreo.gridy = 10;
		contentPane.add(txtAdmincorreo, gbc_txtAdmincorreo);
		txtAdmincorreo.setColumns(10);
		txtAdmincorreo.setText(this.pacientes.getCorreo());
		txtAdmincorreo.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					final String mailE = txtAdmincorreo.getText();
					if (Ejecucion.ValidaCorreo(mailE).equals(Errores.NoAplica())) {
						lblCorregirEmail.setVisible(true);
						txtAdmincorreo.requestFocus();
					}
					lblCorregirEmail.setVisible(false);
					txtAdmincorreo.setText(Ejecucion.ValidaCorreo(txtAdmincorreo.getText()));
				}
			}
		});
		if (perfil.equals("Secretaria"))
			btnReportes.setVisible(false);

		lblCorregirEmail = new JLabel("* Corregir");
		lblCorregirEmail.setEnabled(true);
		lblCorregirEmail.setVisible(false);
		lblCorregirEmail.setForeground(Color.RED);
		final GridBagConstraints gbc_lblCorregirEmail = new GridBagConstraints();
		gbc_lblCorregirEmail.gridwidth = 5;
		gbc_lblCorregirEmail.anchor = GridBagConstraints.WEST;
		gbc_lblCorregirEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorregirEmail.gridx = 4;
		gbc_lblCorregirEmail.gridy = 10;
		contentPane.add(lblCorregirEmail, gbc_lblCorregirEmail);

		lblOs = new JLabel("Obra Social");
		lblOs.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_lblOs = new GridBagConstraints();
		gbc_lblOs.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOs.insets = new Insets(0, 0, 5, 5);
		gbc_lblOs.gridx = 1;
		gbc_lblOs.gridy = 11;
		contentPane.add(lblOs, gbc_lblOs);

		final JLabel lblObraSocial = new JLabel("Nombre OS");
		final GridBagConstraints gbc_lblObraSocial = new GridBagConstraints();
		gbc_lblObraSocial.fill = GridBagConstraints.BOTH;
		gbc_lblObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblObraSocial.gridx = 1;
		gbc_lblObraSocial.gridy = 12;
		contentPane.add(lblObraSocial, gbc_lblObraSocial);

		cmbObraSocial = new JComboBox<>();
		final GridBagConstraints gbc_cmbObraSocial = new GridBagConstraints();
		gbc_cmbObraSocial.gridwidth = 2;
		gbc_cmbObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_cmbObraSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbObraSocial.gridx = 2;
		gbc_cmbObraSocial.gridy = 12;
		contentPane.add(cmbObraSocial, gbc_cmbObraSocial);
		cmbObraSocial.setModel(new DefaultComboBoxModel(listaOS));
		cmbObraSocial.setSelectedIndex(pacientes.getObraSocial());
		cmbObraSocial.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if(cmbObraSocial.getSelectedItem().equals("Particular"))
				{
					txtAdminplan.setEditable(false);
					txtAdminplan.setText("Particular");
					txtAdminnroafiliado.setEditable(false);
					txtAdminnroafiliado.setText(txtDni.getText());
				}
				else {
					txtAdminplan.setEditable(true);
					txtAdminnroafiliado.setEditable(true);
					txtAdminnroafiliado.setText(txtDni.getText());
				}
			}
		});

		final JLabel lblPlanObraSocial = new JLabel("Plan");
		final GridBagConstraints gbc_lblPlanObraSocial = new GridBagConstraints();
		gbc_lblPlanObraSocial.fill = GridBagConstraints.BOTH;
		gbc_lblPlanObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanObraSocial.gridx = 5;
		gbc_lblPlanObraSocial.gridy = 12;
		contentPane.add(lblPlanObraSocial, gbc_lblPlanObraSocial);

		txtAdminplan = new JTextField();
		txtAdminplan.setEditable(false);
		txtAdminplan.setText("AdminPlan");
		final GridBagConstraints gbc_txtAdminplan = new GridBagConstraints();
		gbc_txtAdminplan.gridwidth = 3;
		gbc_txtAdminplan.fill = GridBagConstraints.BOTH;
		gbc_txtAdminplan.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminplan.gridx = 6;
		gbc_txtAdminplan.gridy = 12;
		contentPane.add(txtAdminplan, gbc_txtAdminplan);
		txtAdminplan.setColumns(10);
		txtAdminplan.setText(pacientes.getPlanOs());

		final JLabel lblNumeroAfiliado = new JLabel("Numero Afiliado");
		final GridBagConstraints gbc_lblNumeroAfiliado = new GridBagConstraints();
		gbc_lblNumeroAfiliado.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNumeroAfiliado.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroAfiliado.gridx = 1;
		gbc_lblNumeroAfiliado.gridy = 13;
		contentPane.add(lblNumeroAfiliado, gbc_lblNumeroAfiliado);

		lblIngresos = new JLabel("Ingresos");
		lblIngresos.setVisible(true);
		if (perfil.equals("Secretaria"))
			lblIngresos.setVisible(false);

		txtAdminnroafiliado = new JTextField();
		txtAdminnroafiliado.setEditable(false);
		final GridBagConstraints gbc_txtAdminnroafiliado = new GridBagConstraints();
		gbc_txtAdminnroafiliado.gridwidth = 2;
		gbc_txtAdminnroafiliado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnroafiliado.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnroafiliado.gridx = 2;
		gbc_txtAdminnroafiliado.gridy = 13;
		contentPane.add(txtAdminnroafiliado, gbc_txtAdminnroafiliado);
		txtAdminnroafiliado.setColumns(10);
		txtAdminnroafiliado.setText(pacientes.getNroAfiliado());
		lblIngresos.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_lblIngresos = new GridBagConstraints();
		gbc_lblIngresos.gridwidth = 4;
		gbc_lblIngresos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngresos.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresos.gridx = 1;
		gbc_lblIngresos.gridy = 14;
		contentPane.add(lblIngresos, gbc_lblIngresos);
		scrollPane = new JScrollPane();
		scrollPane.setVisible(true);
		if (perfil.equals("Secretaria"))
			scrollPane.setVisible(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 15;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setBorder(null);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Fecha", "Especialista"
				}

				){
			private static final long serialVersionUID = -8074698750263831930L;
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		if (perfil.equals("Secretaria"))
			btnAgregarIngreso.setVisible(false);
		if (perfil.equals("Secretaria"))
			btnMostrarIngreso.setVisible(false);
		if (perfil.equals("Secretaria"))
			btnCargarIngresos.setVisible(false);

		btnReportes = new JButton("Reportes");
		btnReportes.setVisible(true);
		btnReportes.addActionListener(arg0 -> {
			final PantaReportes pr = new PantaReportes(pacientes);
			pr.setVisible(true);
		});

		btnGuardarModificaciones = new JButton("Guardar");
		btnGuardarModificaciones.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardarModificaciones
		.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/iconos/twentytwo/save.png")));
		btnGuardarModificaciones.addActionListener(arg0 -> {
			final Integer dni = Integer.parseInt(txtDni.getText());
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
			final String gs = comboBox.getSelectedItem().toString();
			final String hace = "ACTUALIZA";
			final SwingWorker worker = new SwingWorker(){
				@Override
				protected Object doInBackground() throws Exception {
					try {
						AdministrarPaciente.ActualizaPaciente(dni, nombre, apellido, sexo, fechanac, obrasocial, numeroafiliado,
								planobra, provincia, ciudad, domicilio, telefono, celular, mail, gs, hace);
						Log.crearLog("Paciente Actualizado Con Exito");
					} catch (final Exception e) {
						try {
							Log.crearLog(e.getMessage());
						} catch (final IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					return null;
				}
			};
			worker.execute();
		});
		final GridBagConstraints gbc_btnGuardarModificaciones = new GridBagConstraints();
		gbc_btnGuardarModificaciones.fill = GridBagConstraints.BOTH;
		gbc_btnGuardarModificaciones.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarModificaciones.gridx = 8;
		gbc_btnGuardarModificaciones.gridy = 15;
		contentPane.add(btnGuardarModificaciones, gbc_btnGuardarModificaciones);
		btnReportes.setHorizontalAlignment(SwingConstants.LEFT);
		btnReportes.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/iconos/twentytwo/database.png")));
		final GridBagConstraints gbc_btnReportes = new GridBagConstraints();
		gbc_btnReportes.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReportes.insets = new Insets(0, 0, 5, 5);
		gbc_btnReportes.gridx = 8;
		gbc_btnReportes.gridy = 16;
		contentPane.add(btnReportes, gbc_btnReportes);

		btnPediatrico = new JButton("Pediatrico");
		btnPediatrico.setVisible(true);
		btnPediatrico.addActionListener(e -> {
			try {
				MuestraPediatrico();
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnPediatrico.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/iconos/twentytwo/child.png")));
		btnPediatrico.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnPediatrico = new GridBagConstraints();
		gbc_btnPediatrico.fill = GridBagConstraints.BOTH;
		gbc_btnPediatrico.insets = new Insets(0, 0, 5, 5);
		gbc_btnPediatrico.gridx = 8;
		gbc_btnPediatrico.gridy = 17;
		contentPane.add(btnPediatrico, gbc_btnPediatrico);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCerrar.addActionListener(e -> {
			PantaPacientes pp;
			try {
				pp = new PantaPacientes();
				pp.setVisible(true);
			} catch (final IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
		});
		btnCerrar.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/iconos/twentytwo/close.png")));
		final GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.fill = GridBagConstraints.BOTH;
		gbc_btnCerrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCerrar.gridx = 8;
		gbc_btnCerrar.gridy = 18;
		contentPane.add(btnCerrar, gbc_btnCerrar);

		btnAgregarIngreso = new JButton("Agregar Historia");
		btnAgregarIngreso.setVisible(true);
		btnAgregarIngreso.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarIngreso.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/iconos/twentytwo/paste.png")));
		btnAgregarIngreso.setEnabled(true);
		btnAgregarIngreso.addActionListener(arg0 -> {
			new PantaAnadirIngreso(pacientes).setVisible(true);
			try {
				TraeHistorias();
				Log.crearLog("TraeHistorias Correcto");
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		btnMostrarIngreso = new JButton("Mostrar Historia");
		btnMostrarIngreso.setVisible(true);
		btnMostrarIngreso.addActionListener(e -> {
			try {
				IngresaAHistoria();
			} catch (final IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnMostrarIngreso.setHorizontalAlignment(SwingConstants.LEFT);
		btnMostrarIngreso.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/iconos/twentytwo/cube.png")));
		final GridBagConstraints gbc_btnMostrarIngreso = new GridBagConstraints();
		gbc_btnMostrarIngreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMostrarIngreso.anchor = GridBagConstraints.NORTH;
		gbc_btnMostrarIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_btnMostrarIngreso.gridx = 8;
		gbc_btnMostrarIngreso.gridy = 20;
		contentPane.add(btnMostrarIngreso, gbc_btnMostrarIngreso);
		final GridBagConstraints gbc_btnAgregarIngreso = new GridBagConstraints();
		gbc_btnAgregarIngreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregarIngreso.anchor = GridBagConstraints.NORTH;
		gbc_btnAgregarIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregarIngreso.gridx = 8;
		gbc_btnAgregarIngreso.gridy = 21;
		contentPane.add(btnAgregarIngreso, gbc_btnAgregarIngreso);

		btnCargarIngresos = new JButton("Cargar Ingresos");
		btnCargarIngresos.setVisible(true);
		btnCargarIngresos.setHorizontalAlignment(SwingConstants.LEFT);
		btnCargarIngresos.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/iconos/twentytwo/table.png")));
		btnCargarIngresos.addActionListener(arg0 -> {
			try {
				TraeHistorias();
				Log.crearLog("TraeHistorias Correcto");
			} catch (final IOException e) {
				final String error = e.toString();
				lblEstado.setVisible(true);
				lblEstado.setText("Error Leyendo Ingresos...");
				e.printStackTrace();
				try {
					Log.crearLog(error);
				} catch (final IOException e1) {
					e1.printStackTrace();
				}
				lblEstado.setVisible(false);
			}
		});

		lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setVisible(false);
		final GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.gridwidth = 2;
		gbc_lblEstado.fill = GridBagConstraints.BOTH;
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.gridx = 6;
		gbc_lblEstado.gridy = 22;
		contentPane.add(lblEstado, gbc_lblEstado);
		final GridBagConstraints gbc_btnCargarIngresos = new GridBagConstraints();
		gbc_btnCargarIngresos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCargarIngresos.anchor = GridBagConstraints.NORTH;
		gbc_btnCargarIngresos.insets = new Insets(0, 0, 0, 5);
		gbc_btnCargarIngresos.gridx = 8;
		gbc_btnCargarIngresos.gridy = 22;
		contentPane.add(btnCargarIngresos, gbc_btnCargarIngresos);

	}

	public List<Historia> getListaHistorias() {
		return listaHistorias;
	}

	public void IngresaAHistoria() throws IOException {
		final int fila = table.getSelectedRow();
		Historia historias = null;
		while (historias == null){
			lblEstado.setVisible(true);
			lblEstado.setText("leyendo historia...");
			historias = listaHistorias.get(table.convertRowIndexToModel(fila));
		}
		final PantaNewMostrarIngreso pmi = new PantaNewMostrarIngreso(historias, pacientes);
		Log.crearLog("Ingresado Correctamente");
		pmi.setVisible(true);
		lblEstado.setVisible(false);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}

	private void MuestraPediatrico() throws NumberFormatException, IOException {
		final long count = GestorPacientes.cuentaPediatrico(pacientes.getDni());
		if(count == 0)
		{
			ppp = new PantaPlanillaPediatrico(pacientes);
			ppp.setVisible(true);
		}
		else
		{
			planillaPediatrico = GestorPacientes.TraePediatrico(pacientes);
			ppmp = new PantaPlanillaMuestraPediatrico(planillaPediatrico, pacientes);
			ppmp.setVisible(true);
		}
	}

	public void setListaHistorias(ArrayList<Historia> listaHistorias) {
		this.listaHistorias = listaHistorias;
	}

	public void TraeHistorias() throws IOException {
		@SuppressWarnings("rawtypes")
		final
		SwingWorker worker = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				listaHistorias = GestorHistoria.ConsultarHistoria(Integer.parseInt(txtDni.getText()));
				final DefaultTableModel df = new DefaultTableModel();
				df.setColumnIdentifiers(columnNames);
				final Object[] fila = new Object[df.getColumnCount()];
				for (int i = 0; i < listaHistorias.size(); i++) {
					lblEstado.setVisible(true);
					lblEstado.setText("Leyendo pacientes");
					lblEstado.setText("Leyendo pacientes.");
					lblEstado.setText("Leyendo pacientes..");
					lblEstado.setText("Leyendo pacientes...");
					final String pattern = "dd/MM/yyyy";
					final SimpleDateFormat format = new SimpleDateFormat(pattern);
					fila[0] = format.format(listaHistorias.get(i).getFecha());
					fila[1] = listaHistorias.get(i).getEspecialista();
					df.addRow(fila);
				}
				table.setModel(df);
				Log.crearLog("Trae Historias Completo!");
				lblEstado.setVisible(false);
				return null;
			}
		};
		worker.execute();
	}

}

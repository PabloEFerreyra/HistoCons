package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Date;

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
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

import com.historiasclinicas.ejecucion.AdministrarPaciente;
import com.historiasclinicas.ejecucion.Ejecucion;
import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorCiudad;
import com.historiasclinicas.gestores.GestorOS;
import com.historiasclinicas.gestores.GestorProvincia;
import com.historiasclinicas.gestores.LostFocus;
import com.historiasclinicas.log.Log;
import com.toedter.calendar.JDateChooser;

public class PantaAdminPacienteSec extends JFrame implements ItemListener {
	private static final long serialVersionUID = 1L;
	private JButton btnCerrar;
	private JButton btnGuardarModificaciones;
	private JComboBox<String> cmbCiudad;
	private JComboBox<String> cmbObraSocial;
	private JComboBox<String> cmbProvincia;
	private JComboBox<String> cmbSexo;
	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JLabel lblContacto;
	private JLabel lblCorregirEmail;
	private JLabel lblCorreoElectronico;
	private JLabel lblDatosPersonales;
	private JLabel lblDni;
	private JLabel lblNewLabel;
	private JLabel lblOs;
	private JLabel lblSexo;
	private String[] listaCiudad;
	private String[] listaOS;
	private String[] listaProvincia;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private Paciente paciente;
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
	public PantaAdminPacienteSec(Paciente pacientes) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PantaAdminPacienteSec.class.getResource("/imagenes/logotipo.png")));
		paciente = pacientes;
		listaOS = GestorOS.ConsultarOS();
		listaCiudad = GestorCiudad.ConsultarCiudad();
		listaProvincia = GestorProvincia.ConsultarProvincia();
		setTitle("Ver/Modificar Paciente");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 936, 517);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(
				new ImageIcon(PantaAdminPacienteSec.class.getResource("/imagenes/iconos/twentytwo/archive.png")));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(
				new ImageIcon(PantaAdminPacienteSec.class.getResource("/imagenes/iconos/twentytwo/close.png")));
		mntmSalir.addActionListener(arg0 -> System.exit(0));
		mnArchivo.add(mntmSalir);

		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 18, 101, 248, 0, 50, 258, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 39, 33, 20, 25, 20, 0, 20, 20, 20, 20, 20, 25, 20, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(e -> {
			try {
				new PantaPacientes().setVisible(true);
			} catch (final IOException e1) {
				e1.printStackTrace();
			}
			dispose();
		});

		lblNewLabel = new JLabel("Administraci\u00F3n Paciente");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 12));
		lblNewLabel.setIcon(new ImageIcon(PantaAdminPacienteSec.class.getResource("/imagenes/iconos/user-plus.png")));
		final GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		btnCerrar.setIcon(new ImageIcon(PantaAdminPacienteSec.class.getResource("/imagenes/iconos/close.png")));
		final GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCerrar.anchor = GridBagConstraints.NORTH;
		gbc_btnCerrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCerrar.gridx = 6;
		gbc_btnCerrar.gridy = 0;
		contentPane.add(btnCerrar, gbc_btnCerrar);

		lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_lblDatosPersonales = new GridBagConstraints();
		gbc_lblDatosPersonales.fill = GridBagConstraints.BOTH;
		gbc_lblDatosPersonales.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosPersonales.gridx = 2;
		gbc_lblDatosPersonales.gridy = 1;
		contentPane.add(lblDatosPersonales, gbc_lblDatosPersonales);

		btnGuardarModificaciones = new JButton("Guardar Modificaciones");
		btnGuardarModificaciones
		.setIcon(new ImageIcon(PantaAdminPacienteSec.class.getResource("/imagenes/iconos/save.png")));
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
			final String hace = "ACTUALIZA";
			final SwingWorker worker = new SwingWorker(){
				@Override
				protected Object doInBackground() throws Exception {
					try {
						AdministrarPaciente.ActualizaPaciente(dni, apellido, nombre, sexo, fechanac, obrasocial, numeroafiliado,
								planobra, provincia, ciudad, domicilio, telefono, celular, mail, hace);

						Log.crearLog("Paciente Actualizado con exito!");
					} catch (final Exception e) {
						final String error = e.toString();
						try {
							Log.crearLog("Error " + error);
						} catch (final IOException e1) {
							e1.printStackTrace();
						}
					}
					return null;
				}
			};
			worker.execute();
		});
		final GridBagConstraints gbc_btnGuardarModificaciones = new GridBagConstraints();
		gbc_btnGuardarModificaciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarModificaciones.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarModificaciones.gridx = 6;
		gbc_btnGuardarModificaciones.gridy = 1;
		contentPane.add(btnGuardarModificaciones, gbc_btnGuardarModificaciones);

		lblDni = new JLabel("Dni");
		final GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 2;
		contentPane.add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		txtDni.setEditable(false);
		final GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 2;
		contentPane.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);
		txtDni.setText(Integer.toString(paciente.getDni()));
		txtDni.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					boolean valido = false;
					try {
						valido = LostFocus.ValidaDni(txtDni.getText());
					} catch (final NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (final HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (final IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (valido)
						txtDni.requestFocus();
				}
			}
		});

		final JLabel lblApellido = new JLabel("Apellido");
		final GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 4;
		gbc_lblApellido.gridy = 2;
		contentPane.add(lblApellido, gbc_lblApellido);

		txtAdminnombre = new JTextField();
		txtAdminnombre.setText("AdminNombre");
		final GridBagConstraints gbc_txtAdminnombre = new GridBagConstraints();
		gbc_txtAdminnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnombre.gridx = 5;
		gbc_txtAdminnombre.gridy = 2;
		contentPane.add(txtAdminnombre, gbc_txtAdminnombre);
		txtAdminnombre.setColumns(10);
		txtAdminnombre.setText(paciente.getNombre());
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

		final JLabel lblNombre = new JLabel("Nombre");
		final GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		contentPane.add(lblNombre, gbc_lblNombre);

		txtAdminapellido = new JTextField();
		txtAdminapellido.setText("AdminApellido");
		final GridBagConstraints gbc_txtAdminapellido = new GridBagConstraints();
		gbc_txtAdminapellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminapellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminapellido.gridx = 2;
		gbc_txtAdminapellido.gridy = 3;
		contentPane.add(txtAdminapellido, gbc_txtAdminapellido);
		txtAdminapellido.setColumns(10);
		txtAdminapellido.setText(paciente.getApellido());
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

		lblSexo = new JLabel("Sexo");
		final GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.WEST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 4;
		gbc_lblSexo.gridy = 3;
		contentPane.add(lblSexo, gbc_lblSexo);

		cmbSexo = new JComboBox<>();
		final GridBagConstraints gbc_cmbSexo = new GridBagConstraints();
		gbc_cmbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSexo.gridx = 5;
		gbc_cmbSexo.gridy = 3;
		contentPane.add(cmbSexo, gbc_cmbSexo);
		cmbSexo.addItem("Masculino");
		cmbSexo.addItem("Femenino");
		cmbSexo.setSelectedIndex(paciente.getSexo());

		final JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		final GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 4;
		contentPane.add(lblFechaNacimiento, gbc_lblFechaNacimiento);

		dateChooser = new JDateChooser();
		dateChooser.setDate(paciente.getFechaNacimiento());
		dateChooser.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 4;
		contentPane.add(dateChooser, gbc_dateChooser);

		lblContacto = new JLabel("Contacto");
		lblContacto.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_lblContacto = new GridBagConstraints();
		gbc_lblContacto.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblContacto.insets = new Insets(0, 0, 5, 5);
		gbc_lblContacto.gridx = 2;
		gbc_lblContacto.gridy = 5;
		contentPane.add(lblContacto, gbc_lblContacto);

		final JLabel lblProvincia = new JLabel("Provincia");
		final GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 1;
		gbc_lblProvincia.gridy = 6;
		contentPane.add(lblProvincia, gbc_lblProvincia);

		cmbProvincia = new JComboBox<>();
		cmbProvincia.setMaximumRowCount(25);
		final GridBagConstraints gbc_cmbProvincia = new GridBagConstraints();
		gbc_cmbProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_cmbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbProvincia.gridx = 2;
		gbc_cmbProvincia.gridy = 6;
		contentPane.add(cmbProvincia, gbc_cmbProvincia);
		cmbProvincia.setModel(new DefaultComboBoxModel(listaProvincia));
		cmbProvincia.setSelectedIndex(paciente.getProvincia());

		final JLabel lblCiudad = new JLabel("Ciudad");
		final GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.WEST;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 4;
		gbc_lblCiudad.gridy = 6;
		contentPane.add(lblCiudad, gbc_lblCiudad);

		cmbCiudad = new JComboBox();
		cmbCiudad.setModel(new DefaultComboBoxModel(listaCiudad));
		cmbCiudad.setSelectedIndex(paciente.getCiudad());
		final GridBagConstraints gbc_cmbCiudad = new GridBagConstraints();
		gbc_cmbCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbCiudad.gridx = 5;
		gbc_cmbCiudad.gridy = 6;
		contentPane.add(cmbCiudad, gbc_cmbCiudad);

		final JLabel lblDomicilio = new JLabel("Domicilio");
		final GridBagConstraints gbc_lblDomicilio = new GridBagConstraints();
		gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomicilio.gridx = 1;
		gbc_lblDomicilio.gridy = 7;
		contentPane.add(lblDomicilio, gbc_lblDomicilio);

		txtAdmindomicilio = new JTextField();
		txtAdmindomicilio.setText("AdminDomicilio");
		final GridBagConstraints gbc_txtAdmindomicilio = new GridBagConstraints();
		gbc_txtAdmindomicilio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmindomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmindomicilio.gridx = 2;
		gbc_txtAdmindomicilio.gridy = 7;
		contentPane.add(txtAdmindomicilio, gbc_txtAdmindomicilio);
		txtAdmindomicilio.setColumns(10);
		txtAdmindomicilio.setText(paciente.getDomicilio());
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
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 8;
		contentPane.add(lblTelefono, gbc_lblTelefono);

		txtAdmintelefono = new JTextField();
		txtAdmintelefono.setText("AdminTelefono");
		final GridBagConstraints gbc_txtAdmintelefono = new GridBagConstraints();
		gbc_txtAdmintelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmintelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmintelefono.gridx = 2;
		gbc_txtAdmintelefono.gridy = 8;
		contentPane.add(txtAdmintelefono, gbc_txtAdmintelefono);
		txtAdmintelefono.setColumns(10);
		txtAdmintelefono.setText(Long.toString(paciente.getTelefono()));
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
		gbc_lblCelular.anchor = GridBagConstraints.WEST;
		gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelular.gridx = 4;
		gbc_lblCelular.gridy = 8;
		contentPane.add(lblCelular, gbc_lblCelular);

		txtAdmincelular = new JTextField();
		txtAdmincelular.setText("AdminCelular");
		final GridBagConstraints gbc_txtAdmincelular = new GridBagConstraints();
		gbc_txtAdmincelular.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmincelular.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmincelular.gridx = 5;
		gbc_txtAdmincelular.gridy = 8;
		contentPane.add(txtAdmincelular, gbc_txtAdmincelular);
		txtAdmincelular.setColumns(10);
		txtAdmincelular.setText(Long.toString(paciente.getTelefonoCelular()));
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

		lblCorreoElectronico = new JLabel("Correo Electronico");
		lblCorreoElectronico.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_lblCorreoElectronico = new GridBagConstraints();
		gbc_lblCorreoElectronico.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoElectronico.gridx = 2;
		gbc_lblCorreoElectronico.gridy = 9;
		contentPane.add(lblCorreoElectronico, gbc_lblCorreoElectronico);

		final JLabel lblCorreo = new JLabel("Correo");
		final GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 10;
		contentPane.add(lblCorreo, gbc_lblCorreo);

		txtAdmincorreo = new JTextField();
		txtAdmincorreo.setText("AdminCorreo");
		final GridBagConstraints gbc_txtAdmincorreo = new GridBagConstraints();
		gbc_txtAdmincorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmincorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmincorreo.gridx = 2;
		gbc_txtAdmincorreo.gridy = 10;
		contentPane.add(txtAdmincorreo, gbc_txtAdmincorreo);
		txtAdmincorreo.setColumns(10);
		txtAdmincorreo.setText(paciente.getCorreo());
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

		lblCorregirEmail = new JLabel("* Corregir");
		lblCorregirEmail.setEnabled(true);
		lblCorregirEmail.setVisible(false);
		lblCorregirEmail.setForeground(Color.RED);
		final GridBagConstraints gbc_lblCorregirEmail = new GridBagConstraints();
		gbc_lblCorregirEmail.anchor = GridBagConstraints.WEST;
		gbc_lblCorregirEmail.gridwidth = 4;
		gbc_lblCorregirEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorregirEmail.gridx = 3;
		gbc_lblCorregirEmail.gridy = 10;
		contentPane.add(lblCorregirEmail, gbc_lblCorregirEmail);

		lblOs = new JLabel("Obra Social");
		lblOs.setFont(new Font("Garamond", Font.BOLD, 14));
		final GridBagConstraints gbc_lblOs = new GridBagConstraints();
		gbc_lblOs.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblOs.insets = new Insets(0, 0, 5, 5);
		gbc_lblOs.gridx = 2;
		gbc_lblOs.gridy = 11;
		contentPane.add(lblOs, gbc_lblOs);

		final JLabel lblObraSocial = new JLabel("Nombre OS");
		final GridBagConstraints gbc_lblObraSocial = new GridBagConstraints();
		gbc_lblObraSocial.fill = GridBagConstraints.VERTICAL;
		gbc_lblObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblObraSocial.gridx = 1;
		gbc_lblObraSocial.gridy = 13;
		contentPane.add(lblObraSocial, gbc_lblObraSocial);

		cmbObraSocial = new JComboBox<>();
		cmbObraSocial.setSelectedIndex(paciente.getObraSocial());
		final GridBagConstraints gbc_cmbObraSocial = new GridBagConstraints();
		gbc_cmbObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_cmbObraSocial.fill = GridBagConstraints.HORIZONTAL;
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
		gbc_lblPlanObraSocial.anchor = GridBagConstraints.WEST;
		gbc_lblPlanObraSocial.fill = GridBagConstraints.VERTICAL;
		gbc_lblPlanObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanObraSocial.gridx = 4;
		gbc_lblPlanObraSocial.gridy = 13;
		contentPane.add(lblPlanObraSocial, gbc_lblPlanObraSocial);

		txtAdminplan = new JTextField();
		txtAdminplan.setEditable(false);
		txtAdminplan.setText("AdminPlan");
		final GridBagConstraints gbc_txtAdminplan = new GridBagConstraints();
		gbc_txtAdminplan.fill = GridBagConstraints.BOTH;
		gbc_txtAdminplan.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminplan.gridx = 5;
		gbc_txtAdminplan.gridy = 13;
		contentPane.add(txtAdminplan, gbc_txtAdminplan);
		txtAdminplan.setColumns(10);
		txtAdminplan.setText(pacientes.getPlanOs());

		final JLabel lblNumeroAfiliado = new JLabel("Numero Afiliado");
		final GridBagConstraints gbc_lblNumeroAfiliado = new GridBagConstraints();
		gbc_lblNumeroAfiliado.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroAfiliado.gridx = 1;
		gbc_lblNumeroAfiliado.gridy = 14;
		contentPane.add(lblNumeroAfiliado, gbc_lblNumeroAfiliado);

		txtAdminnroafiliado = new JTextField();
		txtAdminnroafiliado.setEditable(false);
		final GridBagConstraints gbc_txtAdminnroafiliado = new GridBagConstraints();
		gbc_txtAdminnroafiliado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnroafiliado.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnroafiliado.gridx = 2;
		gbc_txtAdminnroafiliado.gridy = 14;
		contentPane.add(txtAdminnroafiliado, gbc_txtAdminnroafiliado);
		txtAdminnroafiliado.setColumns(10);
		txtAdminnroafiliado.setText(paciente.getNroAfiliado());

	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {

	}
}

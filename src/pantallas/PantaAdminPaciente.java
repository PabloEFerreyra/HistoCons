package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

import com.histocons.ejecucion.Ejecucion;
import com.histocons.ejecucion.Errores;
import com.histocons.entidades.Historia;
import com.histocons.entidades.Paciente;
import com.histocons.gestores.GestorHistoria;
import com.histocons.gestores.LostFocus;

public class PantaAdminPaciente extends JFrame implements ItemListener 
{
	 FileWriter archivo;
	 
    Calendar fechaActual = Calendar.getInstance();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAdminapellido;
	private JTextField txtAdminnombre;
	private JTextField txtAdminfechanac;
	private JTextField txtAdminos;
	private JTextField txtAdminplan;
	private JTextField txtAdminnroafiliado;
	private JTextField txtAdminciudad;
	private JTextField txtAdmindomicilio;
	private JTextField txtAdmintelefono;
	private JTextField txtAdmincelular;
	private JTextField txtAdmincorreo;
	private Paciente pacientes;
	private JScrollPane scrollPane;
	private JList<Object> lista;
	private JLabel lblFechaEspecialista;
	private List<Historia> listaHistorias=null;
	private JButton btnNewButton;
	private JButton button;
	private JTextField txtDni;
	private JLabel lblDni;
	private JLabel lblSexo;
	private JButton btnAgregarIngreso;
	private JButton btnGuardarModificaciones;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JLabel lblNewLabel;
	private JLabel lblDatosPersonales;
	private JLabel lblContacto;
	private JLabel lblCorreoElectronico;
	private JLabel lblOs;
	private JLabel lblIngresos;
	private JButton btnCerrar;
	private JComboBox<String> cmbSexo;
	private JComboBox<String> cmbProvincia;
	private JLabel label;
	private JComboBox<String> cmbObraSocial;
	private JLabel lblCorregirEmail;
	
	public PantaAdminPaciente(final Paciente pacientes)  
	{
		if (new File("log.txt").exists()==false){try {
			archivo=new FileWriter(new File("log.txt"),false);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
	     try {
			archivo = new FileWriter(new File("log.txt"), true);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaAdminPaciente.class.getResource("/imagenes/icono-grupo-facebook.png")));
		
		
		this.pacientes=pacientes;
		
		setTitle("Ver/Modificar Paciente");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 867, 730);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		contentPane = new JPanel();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{45, 101, 318, 0, 65, 258, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{48, 0, 39, 33, 20, 20, 20, 0, 20, 20, 20, 20, 20, 25, 20, 0, 0, 0, 20, 53, 58, 43, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new PantaPacientes().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		lblNewLabel = new JLabel("Administraci\u00F3n Paciente");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 12));
		lblNewLabel.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/user_48.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		btnCerrar.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/cancel-button.png")));
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCerrar.anchor = GridBagConstraints.NORTH;
		gbc_btnCerrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCerrar.gridx = 6;
		gbc_btnCerrar.gridy = 1;
		contentPane.add(btnCerrar, gbc_btnCerrar);
		
		lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setFont(new Font("Garamond", Font.BOLD, 14));
		GridBagConstraints gbc_lblDatosPersonales = new GridBagConstraints();
		gbc_lblDatosPersonales.fill = GridBagConstraints.VERTICAL;
		gbc_lblDatosPersonales.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosPersonales.gridx = 2;
		gbc_lblDatosPersonales.gridy = 2;
		contentPane.add(lblDatosPersonales, gbc_lblDatosPersonales);
		
		btnGuardarModificaciones = new JButton("Guardar Modificaciones");
		btnGuardarModificaciones.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/unidad-de-disco-icono-3963-48.png")));
		btnGuardarModificaciones.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int dni = Integer.parseInt(txtDni.getText());
				String apellido = txtAdminapellido.getText();
				String nombre = txtAdminnombre.getText();
				String sexo = (String)cmbSexo.getSelectedItem();
				String fechanac = txtAdminfechanac.getText();
				String obrasocial = txtAdminos.getText();
				int numeroafiliado = Integer.parseInt(txtAdminnroafiliado.getText());
				String planobra = txtAdminplan.getText();
				String provincia = (String)cmbProvincia.getSelectedItem();
				String ciudad = Ejecucion.EvaluaNoAplica(txtAdminciudad.getText());
				String domicilio = Ejecucion.EvaluaNoAplica(txtAdmindomicilio.getText());
				int telefono = Integer.parseInt(Ejecucion.EvaluaCero(txtAdmintelefono.getText()));
				int celular = Integer.parseInt(Ejecucion.EvaluaCero(txtAdmincelular.getText()));
				String mail = Ejecucion.ValidaCorreo(txtAdmincorreo.getText());
				String hace = "ACTUALIZA";
				
				try
				{
					com.histocons.ejecucion.AdministraPaciente.ActualizaPaciente(dni, apellido, nombre, sexo, 
							fechanac, obrasocial, numeroafiliado, planobra, provincia, ciudad, 
							domicilio, telefono, celular, mail, hace);
					com.histocons.log.Log.crearLog("Paciente Actualizado Con Exito");
				}
				catch(Exception e)
				{
					try {
						com.histocons.log.Log.crearLog(e.getMessage());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		GridBagConstraints gbc_btnGuardarModificaciones = new GridBagConstraints();
		gbc_btnGuardarModificaciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardarModificaciones.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarModificaciones.gridx = 6;
		gbc_btnGuardarModificaciones.gridy = 2;
		contentPane.add(btnGuardarModificaciones, gbc_btnGuardarModificaciones);
		
		lblDni = new JLabel("Dni");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 3;
		contentPane.add(lblDni, gbc_lblDni);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 3;
		contentPane.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);
		txtDni.setText(Integer.toString(this.pacientes.getDni()));
		txtDni.addFocusListener(new FocusListener() 
		{
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					boolean valido = LostFocus.ValidaDni(txtDni.getText());
					if(valido)
					{
						txtDni.requestFocus();
					}					
				}
			}
		});
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 4;
		gbc_lblApellido.gridy = 3;
		contentPane.add(lblApellido, gbc_lblApellido);
		
		txtAdminnombre = new JTextField();
		txtAdminnombre.setText("AdminNombre");
		GridBagConstraints gbc_txtAdminnombre = new GridBagConstraints();
		gbc_txtAdminnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnombre.gridx = 5;
		gbc_txtAdminnombre.gridy = 3;
		contentPane.add(txtAdminnombre, gbc_txtAdminnombre);
		txtAdminnombre.setColumns(10);
		txtAdminnombre.setText(this.pacientes.getNombre());
		txtAdminnombre.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					boolean valido = LostFocus.ValidaApellidoyNombre(txtAdminnombre.getText());
					if(valido)
					{
							txtAdminnombre.requestFocus();
					}					
				}
			}
		});
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		txtAdminapellido = new JTextField();
		txtAdminapellido.setText("AdminApellido");
		GridBagConstraints gbc_txtAdminapellido = new GridBagConstraints();
		gbc_txtAdminapellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminapellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminapellido.gridx = 2;
		gbc_txtAdminapellido.gridy = 4;
		contentPane.add(txtAdminapellido, gbc_txtAdminapellido);
		txtAdminapellido.setColumns(10);
		txtAdminapellido.setText(this.pacientes.getApellido());
		txtAdminapellido.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					boolean valido = LostFocus.ValidaApellidoyNombre(txtAdminapellido.getText());
					if(valido)
					{
							txtAdminapellido.requestFocus();
					}					
				}
			}
		});
		
		lblSexo = new JLabel("Sexo");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 4;
		gbc_lblSexo.gridy = 4;
		contentPane.add(lblSexo, gbc_lblSexo);
		
		cmbSexo = new JComboBox<String>();
		GridBagConstraints gbc_cmbSexo = new GridBagConstraints();
		gbc_cmbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSexo.gridx = 5;
		gbc_cmbSexo.gridy = 4;
		contentPane.add(cmbSexo, gbc_cmbSexo);
		cmbSexo.addItem("Masculino");
		cmbSexo.addItem("Femenino");
		cmbSexo.addItemListener(this);
		cmbSexo.setSelectedItem(pacientes.getSexo());
		
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 5;
		contentPane.add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		txtAdminfechanac = new JTextField();
		txtAdminfechanac.setEditable(false);
		txtAdminfechanac.setText("AdminFechaNac");
		GridBagConstraints gbc_txtAdminfechanac = new GridBagConstraints();
		gbc_txtAdminfechanac.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminfechanac.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminfechanac.gridx = 2;
		gbc_txtAdminfechanac.gridy = 5;
		contentPane.add(txtAdminfechanac, gbc_txtAdminfechanac);
		txtAdminfechanac.setColumns(10);
		txtAdminfechanac.setText(this.pacientes.getFechaNacimiento());
		
		lblContacto = new JLabel("Contacto");
		lblContacto.setFont(new Font("Garamond", Font.BOLD, 14));
		GridBagConstraints gbc_lblContacto = new GridBagConstraints();
		gbc_lblContacto.insets = new Insets(0, 0, 5, 5);
		gbc_lblContacto.gridx = 2;
		gbc_lblContacto.gridy = 6;
		contentPane.add(lblContacto, gbc_lblContacto);
		
		JLabel lblProvincia = new JLabel("Provincia");
		GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 1;
		gbc_lblProvincia.gridy = 7;
		contentPane.add(lblProvincia, gbc_lblProvincia);
		
		cmbProvincia = new JComboBox<String>();
		cmbProvincia.setMaximumRowCount(25);
		GridBagConstraints gbc_cmbProvincia = new GridBagConstraints();
		gbc_cmbProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_cmbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbProvincia.gridx = 2;
		gbc_cmbProvincia.gridy = 7;
		contentPane.add(cmbProvincia, gbc_cmbProvincia);
		cmbProvincia.addItem("Buenos Aires");
		cmbProvincia.addItem("Catamarca");
		cmbProvincia.addItem("Chaco");
		cmbProvincia.addItem("Chubut");
		cmbProvincia.addItem("Ciudad Autónoma de Buenos Aires");
		cmbProvincia.addItem("Córdoba");
		cmbProvincia.addItem("Corrientes");
		cmbProvincia.addItem("Entre Ríos");
		cmbProvincia.addItem("Formosa");
		cmbProvincia.addItem("Jujuy");
		cmbProvincia.addItem("La Pampa");
		cmbProvincia.addItem("La Rioja");
		cmbProvincia.addItem("Mendoza");
		cmbProvincia.addItem("Misiones");
		cmbProvincia.addItem("Neuquén");
		cmbProvincia.addItem("Río Negro");
		cmbProvincia.addItem("Salta");
		cmbProvincia.addItem("San Juan");
		cmbProvincia.addItem("San Luis");
		cmbProvincia.addItem("Santa Cruz");
		cmbProvincia.addItem("Santa Fe");
		cmbProvincia.addItem("Santiago del Estero");
		cmbProvincia.addItem("Tierra del Fuego");
		cmbProvincia.addItem("Tucumán");
		cmbProvincia.addItemListener(this);
		cmbProvincia.setSelectedItem(pacientes.getProvincia());
		cmbProvincia.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if(cmbProvincia.getSelectedItem().equals("Ciudad Autónoma de Buenos Aires"))
				{
			    	txtAdminciudad.setText("CABA");
			    	txtAdminciudad.setEditable(false);
				}
		    	else
		    	{
		    		txtAdminciudad.setText("");
			    	txtAdminciudad.setEditable(true);
		    	}
		    }
		});
		JLabel lblCiudad = new JLabel("Ciudad");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 4;
		gbc_lblCiudad.gridy = 7;
		contentPane.add(lblCiudad, gbc_lblCiudad);
		
		txtAdminciudad = new JTextField();
		txtAdminciudad.setText("AdminCiudad");
		GridBagConstraints gbc_txtAdminciudad = new GridBagConstraints();
		gbc_txtAdminciudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminciudad.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminciudad.gridx = 5;
		gbc_txtAdminciudad.gridy = 7;
		contentPane.add(txtAdminciudad, gbc_txtAdminciudad);
		txtAdminciudad.setColumns(10);
		txtAdminciudad.setText(this.pacientes.getCiudad());
		txtAdminciudad.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					String ciudadVer = txtAdminciudad.getText();
					txtAdminciudad.setText(Ejecucion.EvaluaNoAplica(ciudadVer));				
				}
			}
		});
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		GridBagConstraints gbc_lblDomicilio = new GridBagConstraints();
		gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomicilio.gridx = 1;
		gbc_lblDomicilio.gridy = 8;
		contentPane.add(lblDomicilio, gbc_lblDomicilio);
		
		txtAdmindomicilio = new JTextField();
		txtAdmindomicilio.setText("AdminDomicilio");
		GridBagConstraints gbc_txtAdmindomicilio = new GridBagConstraints();
		gbc_txtAdmindomicilio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmindomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmindomicilio.gridx = 2;
		gbc_txtAdmindomicilio.gridy = 8;
		contentPane.add(txtAdmindomicilio, gbc_txtAdmindomicilio);
		txtAdmindomicilio.setColumns(10);
		txtAdmindomicilio.setText(this.pacientes.getDomicilio());
		txtAdmindomicilio.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					String domicilioVer = txtAdmindomicilio.getText();
					txtAdmindomicilio.setText(Ejecucion.EvaluaNoAplica(domicilioVer));					
				}
			}
		});
		
		JLabel lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 9;
		contentPane.add(lblTelefono, gbc_lblTelefono);
		
		txtAdmintelefono = new JTextField();
		txtAdmintelefono.setText("AdminTelefono");
		GridBagConstraints gbc_txtAdmintelefono = new GridBagConstraints();
		gbc_txtAdmintelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmintelefono.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmintelefono.gridx = 2;
		gbc_txtAdmintelefono.gridy = 9;
		contentPane.add(txtAdmintelefono, gbc_txtAdmintelefono);
		txtAdmintelefono.setColumns(10);
		txtAdmintelefono.setText(Long.toString(this.pacientes.getTelefono()));
		txtAdmintelefono.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					String telefonoE = txtAdmintelefono.getText();
					txtAdmintelefono.setText(Ejecucion.EvaluaCero(telefonoE));
				}
			}
		});
		
		JLabel lblCelular = new JLabel("Celular");
		GridBagConstraints gbc_lblCelular = new GridBagConstraints();
		gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelular.gridx = 4;
		gbc_lblCelular.gridy = 9;
		contentPane.add(lblCelular, gbc_lblCelular);
		
		txtAdmincelular = new JTextField();
		txtAdmincelular.setText("AdminCelular");
		GridBagConstraints gbc_txtAdmincelular = new GridBagConstraints();
		gbc_txtAdmincelular.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmincelular.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmincelular.gridx = 5;
		gbc_txtAdmincelular.gridy = 9;
		contentPane.add(txtAdmincelular, gbc_txtAdmincelular);
		txtAdmincelular.setColumns(10);
		txtAdmincelular.setText(Long.toString(this.pacientes.getTelefonoCelular()));
		txtAdmincelular.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					String celularE = txtAdmincelular.getText();
					txtAdmincelular.setText(Ejecucion.EvaluaCero(celularE));				
				}
			}
		});
		
		lblCorreoElectronico = new JLabel("Correo Electronico");
		lblCorreoElectronico.setFont(new Font("Garamond", Font.BOLD, 14));
		GridBagConstraints gbc_lblCorreoElectronico = new GridBagConstraints();
		gbc_lblCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreoElectronico.gridx = 2;
		gbc_lblCorreoElectronico.gridy = 10;
		contentPane.add(lblCorreoElectronico, gbc_lblCorreoElectronico);
		
		JLabel lblCorreo = new JLabel("Correo");
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 1;
		gbc_lblCorreo.gridy = 11;
		contentPane.add(lblCorreo, gbc_lblCorreo);
		
		txtAdmincorreo = new JTextField();
		txtAdmincorreo.setText("AdminCorreo");
		GridBagConstraints gbc_txtAdmincorreo = new GridBagConstraints();
		gbc_txtAdmincorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmincorreo.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdmincorreo.gridx = 2;
		gbc_txtAdmincorreo.gridy = 11;
		contentPane.add(txtAdmincorreo, gbc_txtAdmincorreo);
		txtAdmincorreo.setColumns(10);
		txtAdmincorreo.setText(this.pacientes.getCorreo());
		txtAdmincorreo.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					String mailE = txtAdmincorreo.getText();
					if(Ejecucion.ValidaCorreo(mailE).equals(Errores.NoAplica()))
					{
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
		GridBagConstraints gbc_lblCorregirEmail = new GridBagConstraints();
		gbc_lblCorregirEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorregirEmail.gridx = 3;
		gbc_lblCorregirEmail.gridy = 11;
		contentPane.add(lblCorregirEmail, gbc_lblCorregirEmail);
		
		lblOs = new JLabel("Obra Social");
		lblOs.setFont(new Font("Garamond", Font.BOLD, 14));
		GridBagConstraints gbc_lblOs = new GridBagConstraints();
		gbc_lblOs.insets = new Insets(0, 0, 5, 5);
		gbc_lblOs.gridx = 2;
		gbc_lblOs.gridy = 12;
		contentPane.add(lblOs, gbc_lblOs);
		
		label = new JLabel("Obra Social");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 13;
		contentPane.add(label, gbc_label);
		
		cmbObraSocial = new JComboBox<String>();
		GridBagConstraints gbc_cmbObraSocial = new GridBagConstraints();
		gbc_cmbObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_cmbObraSocial.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbObraSocial.gridx = 2;
		gbc_cmbObraSocial.gridy = 13;
		contentPane.add(cmbObraSocial, gbc_cmbObraSocial);
		cmbObraSocial.addItem("Particular");
		cmbObraSocial.addItem("Otro...");
		cmbObraSocial.addItemListener(this);
		String ObraSeleccionada = pacientes.getObraSocial();
		if(ObraSeleccionada.equals("Otro..."))
			ObraSeleccionada ="Otro...";
		else
			ObraSeleccionada = "Particular";
		cmbObraSocial.setSelectedItem(ObraSeleccionada);
		cmbObraSocial.addActionListener(new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if(cmbObraSocial.getSelectedItem().equals("Otro..."))
				{
		    		txtAdminos.setEditable(true);
					txtAdminos.setText("");
					txtAdminplan.setEditable(true);
					txtAdminplan.setText("");
					txtAdminnroafiliado.setEditable(true);
					txtAdminnroafiliado.setText("");
				}
				else
				{
					txtAdminos.setEditable(false);
					txtAdminos.setText("Particular");
					txtAdminplan.setEditable(false);
					txtAdminplan.setText("Particular");
					txtAdminnroafiliado.setEditable(false);
					txtAdminnroafiliado.setText("0");
				}
		    }
		});
		
		JLabel lblObraSocial = new JLabel("Nombre OS");
		GridBagConstraints gbc_lblObraSocial = new GridBagConstraints();
		gbc_lblObraSocial.fill = GridBagConstraints.VERTICAL;
		gbc_lblObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblObraSocial.gridx = 1;
		gbc_lblObraSocial.gridy = 14;
		contentPane.add(lblObraSocial, gbc_lblObraSocial);
		
		txtAdminos = new JTextField();
		txtAdminos.setEditable(false);
		GridBagConstraints gbc_txtAdminos = new GridBagConstraints();
		gbc_txtAdminos.fill = GridBagConstraints.BOTH;
		gbc_txtAdminos.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminos.gridx = 2;
		gbc_txtAdminos.gridy = 14;
		contentPane.add(txtAdminos, gbc_txtAdminos);
		txtAdminos.setColumns(10);
		txtAdminos.setText(pacientes.getObraSocial());
				
		JLabel lblPlanObraSocial = new JLabel("Plan");
		GridBagConstraints gbc_lblPlanObraSocial = new GridBagConstraints();
		gbc_lblPlanObraSocial.fill = GridBagConstraints.VERTICAL;
		gbc_lblPlanObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanObraSocial.gridx = 4;
		gbc_lblPlanObraSocial.gridy = 14;
		contentPane.add(lblPlanObraSocial, gbc_lblPlanObraSocial);
		
		txtAdminplan = new JTextField();
		txtAdminplan.setEditable(false);
		txtAdminplan.setText("AdminPlan");
		GridBagConstraints gbc_txtAdminplan = new GridBagConstraints();
		gbc_txtAdminplan.fill = GridBagConstraints.BOTH;
		gbc_txtAdminplan.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminplan.gridx = 5;
		gbc_txtAdminplan.gridy = 14;
		contentPane.add(txtAdminplan, gbc_txtAdminplan);
		txtAdminplan.setColumns(10);
		txtAdminplan.setText(pacientes.getPlanOs());
				
		JLabel lblNumeroAfiliado = new JLabel("Numero Afiliado");
		GridBagConstraints gbc_lblNumeroAfiliado = new GridBagConstraints();
		gbc_lblNumeroAfiliado.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroAfiliado.gridx = 1;
		gbc_lblNumeroAfiliado.gridy = 15;
		contentPane.add(lblNumeroAfiliado, gbc_lblNumeroAfiliado);
		
		txtAdminnroafiliado = new JTextField();
		txtAdminnroafiliado.setEditable(false);
		GridBagConstraints gbc_txtAdminnroafiliado = new GridBagConstraints();
		gbc_txtAdminnroafiliado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnroafiliado.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnroafiliado.gridx = 2;
		gbc_txtAdminnroafiliado.gridy = 15;
		contentPane.add(txtAdminnroafiliado, gbc_txtAdminnroafiliado);
		txtAdminnroafiliado.setColumns(10);
		txtAdminnroafiliado.setText(Long.toString(pacientes.getNroAfiliado()));
				
		button = new JButton("Mostrar Ingresos");
		button.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/buscar-buscar-ampliar-icono-5681-48.png")));
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					TraeHistorias();
					com.histocons.log.Log.crearLog("TraeHistorias Correcto");
				} catch (IOException e) 
				{
						String error = e.toString();
						e.printStackTrace();
						try {
							com.histocons.log.Log.crearLog(error);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
	
				}
			}
		});
		
		lblIngresos = new JLabel("Ingresos");
		lblIngresos.setFont(new Font("Garamond", Font.BOLD, 14));
		GridBagConstraints gbc_lblIngresos = new GridBagConstraints();
		gbc_lblIngresos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIngresos.insets = new Insets(0, 0, 5, 5);
		gbc_lblIngresos.gridx = 2;
		gbc_lblIngresos.gridy = 16;
		contentPane.add(lblIngresos, gbc_lblIngresos);
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 17;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		lista = new JList<Object>();
		lista.addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getClickCount()==2)
				{
					try
					{
						IngresaAHistoria();
					}
					catch(Exception e1)
					{
						String error = e1.toString();
						try {
							com.histocons.log.Log.crearLog("Error "+error);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
					
			}
		});
		scrollPane.setViewportView(lista);
		
		lblFechaEspecialista = new JLabel("Fecha   Especialista");
		scrollPane.setColumnHeaderView(lblFechaEspecialista);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 6;
		gbc_button.gridy = 17;
		contentPane.add(button, gbc_button);
		
		btnAgregarIngreso = new JButton("Agregar Ingreso");
		btnAgregarIngreso.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/attach-1.png")));
		btnAgregarIngreso.setEnabled(true);
		btnAgregarIngreso.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new PantaAnadirIngreso(pacientes).setVisible(true);
				try {
					TraeHistorias();
					com.histocons.log.Log.crearLog("TraeHistorias Correcto");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAgregarIngreso = new GridBagConstraints();
		gbc_btnAgregarIngreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregarIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregarIngreso.gridx = 6;
		gbc_btnAgregarIngreso.gridy = 18;
		contentPane.add(btnAgregarIngreso, gbc_btnAgregarIngreso);
		
		btnNewButton = new JButton("Ver Ingreso");
		btnNewButton.setIcon(new ImageIcon(PantaAdminPaciente.class.getResource("/imagenes/hoja.png")));
		btnNewButton.setEnabled(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					IngresaAHistoria();
					com.histocons.log.Log.crearLog("Ingresado a historia correctamente");
				}
				catch(Exception e)
				{
					String error = e.toString();
					try {
						com.histocons.log.Log.crearLog("Error ingreso por "+ error);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 19;
		contentPane.add(btnNewButton, gbc_btnNewButton);

	}
	public List<Historia> getListaHistorias()
	{
		return listaHistorias;
	}
	public void setListaHistorias(ArrayList<Historia> listaHistorias)
	{
		this.listaHistorias = listaHistorias;
	}
	
	public void itemStateChanged(ItemEvent e) {		
	}
	
	public void TraeHistorias() throws IOException
	{
		listaHistorias = GestorHistoria.ConsultarHistoria(Integer.parseInt(txtDni.getText()));
		
		DefaultListModel<Object> df = new DefaultListModel<Object>();
	
		for (int i=0; i<listaHistorias.size(); i++)
		{
			Historia hi = listaHistorias.get(i);
			df.addElement(hi.getFecha()+" | "+hi.getEspecialista());
			
		}
		
		com.histocons.log.Log.crearLog("Trae Historias Completo!");
		lista.setModel(df);
	}	
	
	public void IngresaAHistoria() throws IOException
	{
		listaHistorias.get(lista.getSelectedIndex()).getPaciente();
		listaHistorias.get(lista.getSelectedIndex()).getAltura();
		listaHistorias.get(lista.getSelectedIndex()).getPeso();
		listaHistorias.get(lista.getSelectedIndex()).getAntecedentes();
		listaHistorias.get(lista.getSelectedIndex()).getOtros();
		listaHistorias.get(lista.getSelectedIndex()).getFecha();
		listaHistorias.get(lista.getSelectedIndex()).getEvolucion();
		listaHistorias.get(lista.getSelectedIndex()).getLaboratorio();
		listaHistorias.get(lista.getSelectedIndex()).getObservaciones();
		listaHistorias.get(lista.getSelectedIndex()).getDiagprinc();
		listaHistorias.get(lista.getSelectedIndex()).getDiagsec();
		listaHistorias.get(lista.getSelectedIndex()).getEspecialista();
		
		Historia historias=listaHistorias.get(lista.getSelectedIndex());

		PantaMostrarIngreso pmi = new PantaMostrarIngreso(historias);
		com.histocons.log.Log.crearLog("Ingresado Correctamente");
		pmi.setVisible(true);
	}	
}

package pantallas;

import java.awt.Color;
import java.awt.Component;
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
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.histocons.ejecucion.Ejecucion;
import com.histocons.gestores.LostFocus;
import com.toedter.calendar.JDateChooser;

import datechooser.beans.DateChooserCombo;

public class PantaAnadirPaciente extends JFrame implements ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAdminapellido;
	private JTextField txtAdminnombre;
	private JTextField txtAdminos;
	private JTextField txtAdminplan;
	private JTextField txtAdminnroafiliado;
	private JTextField txtAdminciudad;
	private JTextField txtAdmindomicilio;
	private JTextField txtAdmintelefono;
	private JTextField txtAdmincelular;
	private JTextField txtAdmincorreo;
	private JTextField txtDni;
	private JLabel lblDni;
	private JButton btnAadir;
	private JButton btnCerrar;
	private JLabel lblSexo;
	private JMenuItem mntmSalir;
	private JLabel lblNuevoPaciente;
	private DateChooserCombo dateChooserCombo;
	private JComboBox<String> cmbSexo;
	private JComboBox<String> cmbProvincia;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblObraSocial_1;
	private JComboBox<String> cmbObraSocial;
	private JLabel lblCorregirDni;
	private JLabel lblCorregirApellido;
	private JLabel lblcorregirNombre;
	public PantaAnadirPaciente() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaAnadirPaciente.class.getResource("/imagenes/icono-grupo-facebook.png")));
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

		
		setTitle("Ver/Modificar Paciente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 727, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, -115, 0, 68};
		gbl_contentPane.columnWidths = new int[] {-16, 95, 218, 0, 0, 219, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		lblNuevoPaciente = new JLabel("Nuevo Paciente");
		lblNuevoPaciente.setFont(new Font("Georgia", Font.BOLD, 12));
		lblNuevoPaciente.setIcon(new ImageIcon(PantaAnadirPaciente.class.getResource("/imagenes/user_48.png")));
		GridBagConstraints gbc_lblNuevoPaciente = new GridBagConstraints();
		gbc_lblNuevoPaciente.fill = GridBagConstraints.VERTICAL;
		gbc_lblNuevoPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevoPaciente.gridx = 2;
		gbc_lblNuevoPaciente.gridy = 0;
		contentPane.add(lblNuevoPaciente, gbc_lblNuevoPaciente);
		
		label = new JLabel("Datos Personales");
		label.setFont(new Font("Garamond", Font.BOLD, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		contentPane.add(label, gbc_label);

		
		
		lblDni = new JLabel("Dni");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.fill = GridBagConstraints.BOTH;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 2;
		contentPane.add(lblDni, gbc_lblDni);
		
		txtDni = new JTextField();
		lblDni.setLabelFor(txtDni);
		txtDni.setToolTipText("Ingrese Solo Numero de DNI");
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.BOTH;
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 2;
		contentPane.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);
		txtDni.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					boolean valido = LostFocus.ValidaDni(txtDni.getText());
					if(valido)
					{
						lblCorregirDni.setVisible(true);
						txtDni.requestFocus();
					}
					lblCorregirDni.setVisible(false);
				}
			}
		});
		
		lblCorregirDni = new JLabel("* Corregir");
		lblCorregirDni.setForeground(Color.RED);
		GridBagConstraints gbc_lblCorregirDni = new GridBagConstraints();
		gbc_lblCorregirDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorregirDni.gridx = 3;
		gbc_lblCorregirDni.gridy = 2;
		contentPane.add(lblCorregirDni, gbc_lblCorregirDni);
		lblCorregirDni.setVisible(false);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.fill = GridBagConstraints.BOTH;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 4;
		gbc_lblApellido.gridy = 2;
		contentPane.add(lblApellido, gbc_lblApellido);
		lblApellido.setLabelFor(txtAdminapellido);
		
		txtAdminapellido = new JTextField();
		txtAdminapellido.setToolTipText("Ingrese Apellido de paciente");
		GridBagConstraints gbc_txtAdminapellido = new GridBagConstraints();
		gbc_txtAdminapellido.fill = GridBagConstraints.BOTH;
		gbc_txtAdminapellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminapellido.gridx = 5;
		gbc_txtAdminapellido.gridy = 2;
		contentPane.add(txtAdminapellido, gbc_txtAdminapellido);
		txtAdminapellido.setColumns(10);
		txtAdminapellido.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					boolean valido = LostFocus.ValidaApellidoyNombre(txtAdminapellido.getText());
					if(valido)
					{
						lblCorregirApellido.setVisible(true);
						txtAdminapellido.requestFocus();
					}
					lblCorregirApellido.setVisible(false);
				}
			}
		});
		
		lblCorregirApellido = new JLabel("* Corregir");
		lblCorregirApellido.setForeground(Color.RED);
		GridBagConstraints gbc_lblCorregirApellido = new GridBagConstraints();
		gbc_lblCorregirApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorregirApellido.gridx = 6;
		gbc_lblCorregirApellido.gridy = 2;
		contentPane.add(lblCorregirApellido, gbc_lblCorregirApellido);
		lblCorregirApellido.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		contentPane.add(lblNombre, gbc_lblNombre);
		lblNombre.setLabelFor(txtAdminnombre);
		
		txtAdminnombre = new JTextField();
		txtAdminnombre.setToolTipText("Ingrese Nombre Paciente");
		GridBagConstraints gbc_txtAdminnombre = new GridBagConstraints();
		gbc_txtAdminnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnombre.gridx = 2;
		gbc_txtAdminnombre.gridy = 3;
		contentPane.add(txtAdminnombre, gbc_txtAdminnombre);
		txtAdminnombre.setColumns(10);
		txtAdminnombre.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					boolean valido = LostFocus.ValidaApellidoyNombre(txtAdminnombre.getText());
					if(valido)
					{
						lblcorregirNombre.setVisible(true);
						txtAdminnombre.requestFocus();
					}	
					lblcorregirNombre.setVisible(false);
				}
			}
		});
		
		lblcorregirNombre = new JLabel("*Corregir");
		lblcorregirNombre.setForeground(Color.RED);
		GridBagConstraints gbc_lblcorregirNombre = new GridBagConstraints();
		gbc_lblcorregirNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblcorregirNombre.gridx = 3;
		gbc_lblcorregirNombre.gridy = 3;
		contentPane.add(lblcorregirNombre, gbc_lblcorregirNombre);
		lblcorregirNombre.setVisible(false);
		
		lblSexo = new JLabel("Sexo");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 4;
		gbc_lblSexo.gridy = 3;
		contentPane.add(lblSexo, gbc_lblSexo);
		
		cmbSexo = new JComboBox<String>();
		GridBagConstraints gbc_cmbSexo = new GridBagConstraints();
		gbc_cmbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSexo.gridx = 5;
		gbc_cmbSexo.gridy = 3;
		contentPane.add(cmbSexo, gbc_cmbSexo);
		cmbSexo.addItem("Masculino");
		cmbSexo.addItem("Femenino");
		cmbSexo.addItemListener(this);
		
		Calendar c2 = new GregorianCalendar();
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.fill = GridBagConstraints.BOTH;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 1;
		gbc_lblFechaNacimiento.gridy = 4;
		contentPane.add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setCalendar(c2);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 4;
		contentPane.add(dateChooser, gbc_dateChooser);
		dateChooser.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{dateChooser.getCalendarButton()}));
		
		label_1 = new JLabel("Contacto");
		label_1.setFont(new Font("Garamond", Font.BOLD, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.VERTICAL;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 5;
		contentPane.add(label_1, gbc_label_1);
		
		JLabel lblProvincia = new JLabel("Provincia");
		GridBagConstraints gbc_lblProvincia = new GridBagConstraints();
		gbc_lblProvincia.fill = GridBagConstraints.BOTH;
		gbc_lblProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvincia.gridx = 1;
		gbc_lblProvincia.gridy = 6;
		contentPane.add(lblProvincia, gbc_lblProvincia);
		
		cmbProvincia = new JComboBox<String>();
		cmbProvincia.setMaximumRowCount(25);
		GridBagConstraints gbc_cmbProvincia = new GridBagConstraints();
		gbc_cmbProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_cmbProvincia.fill = GridBagConstraints.BOTH;
		gbc_cmbProvincia.gridx = 2;
		gbc_cmbProvincia.gridy = 6;
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
		cmbProvincia.setSelectedItem("Santa Fe");
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
		gbc_lblCiudad.fill = GridBagConstraints.BOTH;
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 4;
		gbc_lblCiudad.gridy = 6;
		contentPane.add(lblCiudad, gbc_lblCiudad);
		lblCiudad.setLabelFor(txtAdminciudad);
		
		txtAdminciudad = new JTextField();
		txtAdminciudad.setToolTipText("Ciudad del Paciente");
		GridBagConstraints gbc_txtAdminciudad = new GridBagConstraints();
		gbc_txtAdminciudad.fill = GridBagConstraints.BOTH;
		gbc_txtAdminciudad.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminciudad.gridx = 5;
		gbc_txtAdminciudad.gridy = 6;
		contentPane.add(txtAdminciudad, gbc_txtAdminciudad);
		txtAdminciudad.setColumns(10);
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
		gbc_lblDomicilio.fill = GridBagConstraints.BOTH;
		gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomicilio.gridx = 1;
		gbc_lblDomicilio.gridy = 7;
		contentPane.add(lblDomicilio, gbc_lblDomicilio);
		lblDomicilio.setLabelFor(txtAdmindomicilio);
			
			txtAdmindomicilio = new JTextField();
			txtAdmindomicilio.setToolTipText("Domicilio de Residencia del paciente");
			GridBagConstraints gbc_txtAdmindomicilio = new GridBagConstraints();
			gbc_txtAdmindomicilio.fill = GridBagConstraints.BOTH;
			gbc_txtAdmindomicilio.insets = new Insets(0, 0, 5, 5);
			gbc_txtAdmindomicilio.gridx = 2;
			gbc_txtAdmindomicilio.gridy = 7;
			contentPane.add(txtAdmindomicilio, gbc_txtAdmindomicilio);
			txtAdmindomicilio.setColumns(10);
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
			gbc_lblTelefono.fill = GridBagConstraints.BOTH;
			gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
			gbc_lblTelefono.gridx = 1;
			gbc_lblTelefono.gridy = 8;
			contentPane.add(lblTelefono, gbc_lblTelefono);
			lblTelefono.setLabelFor(txtAdmintelefono);
			
			txtAdmintelefono = new JTextField(10);
			txtAdmintelefono.setToolTipText("Nro de telefono del paciente");
			GridBagConstraints gbc_txtAdmintelefono = new GridBagConstraints();
			gbc_txtAdmintelefono.fill = GridBagConstraints.BOTH;
			gbc_txtAdmintelefono.insets = new Insets(0, 0, 5, 5);
			gbc_txtAdmintelefono.gridx = 2;
			gbc_txtAdmintelefono.gridy = 8;
			contentPane.add(txtAdmintelefono, gbc_txtAdmintelefono);
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
			gbc_lblCelular.fill = GridBagConstraints.BOTH;
			gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
			gbc_lblCelular.gridx = 4;
			gbc_lblCelular.gridy = 8;
			contentPane.add(lblCelular, gbc_lblCelular);
			lblCelular.setLabelFor(txtAdmincelular);
			
			txtAdmincelular = new JTextField(10);
			txtAdmincelular.setToolTipText("Numero de celular del paciente");
			GridBagConstraints gbc_txtAdmincelular = new GridBagConstraints();
			gbc_txtAdmincelular.fill = GridBagConstraints.BOTH;
			gbc_txtAdmincelular.insets = new Insets(0, 0, 5, 5);
			gbc_txtAdmincelular.gridx = 5;
			gbc_txtAdmincelular.gridy = 8;
			contentPane.add(txtAdmincelular, gbc_txtAdmincelular);
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
			
			label_2 = new JLabel("Correo Electronico");
			label_2.setFont(new Font("Garamond", Font.BOLD, 14));
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.fill = GridBagConstraints.VERTICAL;
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 2;
			gbc_label_2.gridy = 9;
			contentPane.add(label_2, gbc_label_2);
			
			JLabel lblCorreo = new JLabel("Correo");
			GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
			gbc_lblCorreo.fill = GridBagConstraints.BOTH;
			gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
			gbc_lblCorreo.gridx = 1;
			gbc_lblCorreo.gridy = 10;
			contentPane.add(lblCorreo, gbc_lblCorreo);
			lblCorreo.setLabelFor(txtAdmincorreo);
			
			txtAdmincorreo = new JTextField();
			txtAdmincorreo.setToolTipText("Correo electronico, si no tiene, escribir \"-\"");
			GridBagConstraints gbc_txtAdmincorreo = new GridBagConstraints();
			gbc_txtAdmincorreo.fill = GridBagConstraints.BOTH;
			gbc_txtAdmincorreo.insets = new Insets(0, 0, 5, 5);
			gbc_txtAdmincorreo.gridx = 2;
			gbc_txtAdmincorreo.gridy = 10;
			contentPane.add(txtAdmincorreo, gbc_txtAdmincorreo);
			txtAdmincorreo.setColumns(10);
			txtAdmincorreo.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
				}
				public void focusLost(FocusEvent e) {
					if (!e.isTemporary()) {
						String mailE = txtAdmincorreo.getText();
						if(Ejecucion.ValidaCorreo(mailE) == "null")
						{
							
								txtAdmincorreo.requestFocus();
						}
						txtAdmincorreo.setText(mailE);
					}
				}
			});
			
			label_3 = new JLabel("Obra Social");
			label_3.setFont(new Font("Garamond", Font.BOLD, 14));
			GridBagConstraints gbc_label_3 = new GridBagConstraints();
			gbc_label_3.fill = GridBagConstraints.VERTICAL;
			gbc_label_3.insets = new Insets(0, 0, 5, 5);
			gbc_label_3.gridx = 2;
			gbc_label_3.gridy = 11;
			contentPane.add(label_3, gbc_label_3);
			
			lblObraSocial_1 = new JLabel("Obra Social");
			GridBagConstraints gbc_lblObraSocial_1 = new GridBagConstraints();
			gbc_lblObraSocial_1.fill = GridBagConstraints.VERTICAL;
			gbc_lblObraSocial_1.anchor = GridBagConstraints.WEST;
			gbc_lblObraSocial_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblObraSocial_1.gridx = 1;
			gbc_lblObraSocial_1.gridy = 12;
			contentPane.add(lblObraSocial_1, gbc_lblObraSocial_1);
			
			cmbObraSocial = new JComboBox<String>();
			GridBagConstraints gbc_cmbObraSocial = new GridBagConstraints();
			gbc_cmbObraSocial.insets = new Insets(0, 0, 5, 5);
			gbc_cmbObraSocial.fill = GridBagConstraints.BOTH;
			gbc_cmbObraSocial.gridx = 2;
			gbc_cmbObraSocial.gridy = 12;
			contentPane.add(cmbObraSocial, gbc_cmbObraSocial);
			cmbObraSocial.addItem("Particular");
			cmbObraSocial.addItem("Otro...");
			cmbObraSocial.addItemListener(this);
			cmbObraSocial.setSelectedItem("Otro...");
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
			gbc_lblObraSocial.fill = GridBagConstraints.BOTH;
			gbc_lblObraSocial.insets = new Insets(0, 0, 5, 5);
			gbc_lblObraSocial.gridx = 1;
			gbc_lblObraSocial.gridy = 13;
			contentPane.add(lblObraSocial, gbc_lblObraSocial);
		
		txtAdminos = new JTextField();
		txtAdminos.setToolTipText("Ingrese OS");
		GridBagConstraints gbc_txtAdminos = new GridBagConstraints();
		gbc_txtAdminos.fill = GridBagConstraints.BOTH;
		gbc_txtAdminos.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminos.gridx = 2;
		gbc_txtAdminos.gridy = 13;
		contentPane.add(txtAdminos, gbc_txtAdminos);
		txtAdminos.setColumns(10);
		lblObraSocial.setLabelFor(txtAdminos);
		txtAdminos.setEditable(true);
		
		JLabel lblPlanObraSocial = new JLabel("Plan");
		GridBagConstraints gbc_lblPlanObraSocial = new GridBagConstraints();
		gbc_lblPlanObraSocial.fill = GridBagConstraints.BOTH;
		gbc_lblPlanObraSocial.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanObraSocial.gridx = 4;
		gbc_lblPlanObraSocial.gridy = 13;
		contentPane.add(lblPlanObraSocial, gbc_lblPlanObraSocial);
		
		
		txtAdminplan = new JTextField();
		txtAdminplan.setToolTipText("Ingrese Plan OS");
		GridBagConstraints gbc_txtAdminplan = new GridBagConstraints();
		gbc_txtAdminplan.fill = GridBagConstraints.BOTH;
		gbc_txtAdminplan.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminplan.gridx = 5;
		gbc_txtAdminplan.gridy = 13;
		contentPane.add(txtAdminplan, gbc_txtAdminplan);
		txtAdminplan.setColumns(10);
		lblPlanObraSocial.setLabelFor(txtAdminplan);
		txtAdminplan.setEditable(true);	
		
		JLabel lblNumeroAfiliado = new JLabel("Numero Afiliado");
		GridBagConstraints gbc_lblNumeroAfiliado = new GridBagConstraints();
		gbc_lblNumeroAfiliado.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNumeroAfiliado.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroAfiliado.gridx = 1;
		gbc_lblNumeroAfiliado.gridy = 14;
		contentPane.add(lblNumeroAfiliado, gbc_lblNumeroAfiliado);
		
		txtAdminnroafiliado = new JTextField();
		txtAdminnroafiliado.setToolTipText("Numero Afiliado (en muchos casos puede ser el nro de DNI)");
		GridBagConstraints gbc_txtAdminnroafiliado = new GridBagConstraints();
		gbc_txtAdminnroafiliado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdminnroafiliado.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdminnroafiliado.gridx = 2;
		gbc_txtAdminnroafiliado.gridy = 14;
		contentPane.add(txtAdminnroafiliado, gbc_txtAdminnroafiliado);
		txtAdminnroafiliado.setColumns(10);
		lblNumeroAfiliado.setLabelFor(txtAdminnroafiliado);
		txtAdminnroafiliado.setEditable(true);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new PantaPacientes().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		
		btnAadir = new JButton("Agregar");
		btnAadir.setSelectedIcon(new ImageIcon(PantaAnadirPaciente.class.getResource("/imagenes/unidad-de-disco-icono-3963-48.png")));
		btnAadir.setIcon(new ImageIcon(PantaAnadirPaciente.class.getResource("/imagenes/unidad-de-disco-icono-3963-48.png")));
		btnAadir.setHorizontalAlignment(SwingConstants.LEFT);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int dni = Integer.parseInt(txtDni.getText());
				String apellido = txtAdminapellido.getText();
				String nombre = txtAdminnombre.getText();
				String sexo = (String)cmbSexo.getSelectedItem();
				String fechanac = df.format(dateChooser.getDate());
				String obrasocial = txtAdminos.getText();
				int numeroafiliado = Integer.parseInt(txtAdminnroafiliado.getText());
				String planobra = txtAdminplan.getText();
				String provincia = (String)cmbProvincia.getSelectedItem();
				String ciudad = Ejecucion.EvaluaNoAplica(txtAdminciudad.getText());
				String domicilio = Ejecucion.EvaluaNoAplica(txtAdmindomicilio.getText());
				int telefono = Integer.parseInt(Ejecucion.EvaluaCero(txtAdmintelefono.getText()));
				int celular = Integer.parseInt(Ejecucion.EvaluaCero(txtAdmincelular.getText()));
				String mail = Ejecucion.ValidaCorreo(txtAdmincorreo.getText());
				String hace = "NUEVO";
				
				try
				{
				com.histocons.ejecucion.AdministraPaciente.ActualizaPaciente(dni, apellido, nombre, sexo,
						fechanac, obrasocial, numeroafiliado, planobra, provincia, ciudad,
						domicilio, telefono, celular, mail, hace);
				com.histocons.log.Log.crearLog("Paciente Ingresado Correctamente");
					new PantaPacientes().setVisible(true);
				dispose();
				}
				catch(Exception e)
				{
					try {
						com.histocons.log.Log.crearLog("Error: "+e.getMessage().toString());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
				
		});
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.fill = GridBagConstraints.VERTICAL;
		gbc_btnAadir.insets = new Insets(0, 0, 0, 5);
		gbc_btnAadir.gridx = 2;
		gbc_btnAadir.gridy = 15;
		contentPane.add(btnAadir, gbc_btnAadir);
		btnCerrar.setIcon(new ImageIcon(PantaAnadirPaciente.class.getResource("/imagenes/cancel-button.png")));
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCerrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrar.gridx = 5;
		gbc_btnCerrar.gridy = 15;
		contentPane.add(btnCerrar, gbc_btnCerrar);


	}
	/**
	 * @return the dateChooserCombo
	 */
	public DateChooserCombo getDateChooserCombo() {
		return dateChooserCombo;
	}
	/**
	 * @param dateChooserCombo the dateChooserCombo to set
	 */
	public void setDateChooserCombo(DateChooserCombo dateChooserCombo) {
		this.dateChooserCombo = dateChooserCombo;
	}
	
	public void itemStateChanged(ItemEvent arg0) {		
	}
	
	
}
package pantallas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.histocons.ejecucion.Ejecucion;
import com.histocons.ejecucion.Errores;
import com.histocons.entidades.Paciente;
import com.histocons.entidades.Usuarios;
import com.histocons.gestores.GestorHistoria;
import com.histocons.gestores.LostFocus;


public class PantaAnadirIngreso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfechaingreso;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtDiagnosticoPrincipal;
	private JTextField txtDiagnosticoSecundario;
	private JTextField txtEspecialista;
	private JTextField txtDni;
	private JTextArea txtrAntecedentes;
	private JTextArea txtOtros;
	private JTextArea txtLaboratorio;
	private JTextArea txtrEvolucion;
	private JTextArea txtrObservaciones;
	private Paciente paciente;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtIMC;
	private JLabel lblcorregirAltura;
	private JLabel lblcorregir;
	private JLabel lblcorregir_1;
	private JLabel lblcorregir_2;
	private String usuario = PantaLogin.usuario.toString();
	Calendar fecha = Calendar.getInstance();
	
    int ano = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String fechaActual = dia + "/" + (mes+1) + "/" + ano;
	
	
	public PantaAnadirIngreso(Paciente paciente ) {

		
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

		setTitle("A\u00F1adir Ingreso");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaAnadirIngreso.class.getResource("/imagenes/hoja.png")));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setPaciente(paciente);
		
		Calendar fecha = Calendar.getInstance();
		
        int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String fechaActual = dia + "/" + (mes+1) + "/" + ano;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 774, 705);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("A\u00F1adir Ingreso");
		lblNewLabel.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/hoja.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/Schnellzugriff_Icon_3.png")));
		GridBagConstraints gbc_lblPaciente = new GridBagConstraints();
		gbc_lblPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaciente.gridx = 1;
		gbc_lblPaciente.gridy = 1;
		contentPane.add(lblPaciente, gbc_lblPaciente);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 1;
		contentPane.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);
		txtDni.setText(Integer.toString(this.paciente.getDni()));
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridwidth = 4;
		gbc_txtApellido.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.gridx = 3;
		gbc_txtApellido.gridy = 1;
		contentPane.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		txtApellido.setText(this.paciente.getApellido());
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.NORTH;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 7;
		gbc_txtNombre.gridy = 1;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setText(this.paciente.getNombre());
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/icon_344_1.png")));
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 2;
		contentPane.add(lblFecha, gbc_lblFecha);
		
		txtfechaingreso = new JTextField();
		txtfechaingreso.setEditable(false);
		txtfechaingreso.setToolTipText("");
		GridBagConstraints gbc_txtfechaingreso = new GridBagConstraints();
		gbc_txtfechaingreso.insets = new Insets(0, 0, 5, 5);
		gbc_txtfechaingreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfechaingreso.gridx = 2;
		gbc_txtfechaingreso.gridy = 2;
		contentPane.add(txtfechaingreso, gbc_txtfechaingreso);
		txtfechaingreso.setColumns(10);
		txtfechaingreso.setText(fechaActual);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/icono_persona.png")));
		GridBagConstraints gbc_lblAltura = new GridBagConstraints();
		gbc_lblAltura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltura.gridx = 1;
		gbc_lblAltura.gridy = 3;
		contentPane.add(lblAltura, gbc_lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setToolTipText("Ingrese altura en mts, use el punto \".\" como separador");
		GridBagConstraints gbc_txtAltura = new GridBagConstraints();
		gbc_txtAltura.insets = new Insets(0, 0, 5, 5);
		gbc_txtAltura.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAltura.gridx = 2;
		gbc_txtAltura.gridy = 3;
		contentPane.add(txtAltura, gbc_txtAltura);
		txtAltura.setColumns(10);
		txtAltura.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					
					boolean error = LostFocus.ValidaPesoAltura(txtAltura.getText());
					if(error)
					{
						lblcorregirAltura.setVisible(true);
						txtAltura.requestFocus();
					}
					lblcorregirAltura.setVisible(false);
				}
			}
		});
		
		lblcorregirAltura = new JLabel("*Corregir");
		lblcorregirAltura.setForeground(Color.RED);
		GridBagConstraints gbc_lblcorregirAltura = new GridBagConstraints();
		gbc_lblcorregirAltura.insets = new Insets(0, 0, 5, 5);
		gbc_lblcorregirAltura.gridx = 3;
		gbc_lblcorregirAltura.gridy = 3;
		contentPane.add(lblcorregirAltura, gbc_lblcorregirAltura);
		lblcorregirAltura.setVisible(false);
		
		JLabel lblImc = new JLabel("IMC");
		lblImc.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/icono_persona.png")));
		GridBagConstraints gbc_lblImc = new GridBagConstraints();
		gbc_lblImc.insets = new Insets(0, 0, 5, 5);
		gbc_lblImc.gridx = 4;
		gbc_lblImc.gridy = 3;
		contentPane.add(lblImc, gbc_lblImc);
		
		txtIMC = new JTextField();
		txtIMC.setText("0.0");
		txtIMC.setEditable(false);
		txtIMC.setColumns(10);
		GridBagConstraints gbc_txtIMC = new GridBagConstraints();
		gbc_txtIMC.anchor = GridBagConstraints.WEST;
		gbc_txtIMC.insets = new Insets(0, 0, 5, 5);
		gbc_txtIMC.gridx = 5;
		gbc_txtIMC.gridy = 3;
		contentPane.add(txtIMC, gbc_txtIMC);
		
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/icono_persona.png")));
		GridBagConstraints gbc_lblPeso = new GridBagConstraints();
		gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeso.gridx = 1;
		gbc_lblPeso.gridy = 4;
		contentPane.add(lblPeso, gbc_lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setToolTipText("Ingrese Peso en kgs, use el punto \".\" como separador");
		GridBagConstraints gbc_txtPeso = new GridBagConstraints();
		gbc_txtPeso.insets = new Insets(0, 0, 5, 5);
		gbc_txtPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPeso.gridx = 2;
		gbc_txtPeso.gridy = 4;
		contentPane.add(txtPeso, gbc_txtPeso);
		txtPeso.setColumns(10);
		
		txtPeso.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					if (!e.isTemporary()) 
					{
						boolean error = LostFocus.ValidaPesoAltura((txtPeso.getText()));
						if (error)
						{
							lblcorregir.setVisible(true);
							txtPeso.requestFocus();
						}
						else
						{
							float peso = Float.parseFloat(txtPeso.getText());
							float altura = Float.parseFloat(txtAltura.getText());
							txtIMC.setText(Float.toString(Ejecucion.calculaimc(peso, altura)));
						}
						lblcorregir.setVisible(false);
					}
				}
			}
		});
		
		lblcorregir = new JLabel("*Corregir");
		lblcorregir.setForeground(Color.RED);
		GridBagConstraints gbc_lblcorregir = new GridBagConstraints();
		gbc_lblcorregir.insets = new Insets(0, 0, 5, 5);
		gbc_lblcorregir.gridx = 3;
		gbc_lblcorregir.gridy = 4;
		contentPane.add(lblcorregir, gbc_lblcorregir);
		lblcorregir.setVisible(false);
		
		JLabel lblAntecedentes = new JLabel("Sintomas");
		lblAntecedentes.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/icon_save.png")));
		GridBagConstraints gbc_lblAntecedentes = new GridBagConstraints();
		gbc_lblAntecedentes.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntecedentes.gridx = 1;
		gbc_lblAntecedentes.gridy = 5;
		contentPane.add(lblAntecedentes, gbc_lblAntecedentes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		txtrAntecedentes = new JTextArea();
		txtrAntecedentes.setLineWrap(true);
		txtrAntecedentes.setToolTipText("Ingrese Sintomas del paciente");
		scrollPane.setViewportView(txtrAntecedentes);
		txtrAntecedentes.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					if (!e.isTemporary()) 
					{
						if(txtrAntecedentes.getText().equals(""))
						{
							lblcorregir_1.setVisible(true);
							JOptionPane.showMessageDialog(new JDialog(), Errores.IngresoSintomas());
							txtrAntecedentes.requestFocus();
						}
						else
							lblcorregir_1.setVisible(false);
					}
				}
			}
		});
		
		lblcorregir_1 = new JLabel("*Corregir");
		lblcorregir_1.setForeground(Color.RED);
		lblcorregir_1.setVisible(false);
		GridBagConstraints gbc_lblcorregir_1 = new GridBagConstraints();
		gbc_lblcorregir_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblcorregir_1.gridx = 8;
		gbc_lblcorregir_1.gridy = 5;
		contentPane.add(lblcorregir_1, gbc_lblcorregir_1);
		
		JLabel lblOtros = new JLabel("Otros");
		lblOtros.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/icon_save.png")));
		GridBagConstraints gbc_lblOtros = new GridBagConstraints();
		gbc_lblOtros.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtros.gridx = 1;
		gbc_lblOtros.gridy = 6;
		contentPane.add(lblOtros, gbc_lblOtros);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 6;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 6;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		txtOtros = new JTextArea();
		txtOtros.setLineWrap(true);
		txtOtros.setToolTipText("Ingrese datos de Relleno para el paciente");
		scrollPane_1.setViewportView(txtOtros);
		txtOtros.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {	
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					if (!e.isTemporary()) 
					{
						if(txtOtros.getText().equals(""))
							txtOtros.setText(Errores.NoAplica());
					}
				}
			}
		});
		
		JLabel lblLaboratorio = new JLabel("Laboratorio");
		lblLaboratorio.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/icon_share.png")));
		GridBagConstraints gbc_lblLaboratorio = new GridBagConstraints();
		gbc_lblLaboratorio.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaboratorio.gridx = 1;
		gbc_lblLaboratorio.gridy = 7;
		contentPane.add(lblLaboratorio, gbc_lblLaboratorio);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 6;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 7;
		contentPane.add(scrollPane_2, gbc_scrollPane_2);
		
		txtLaboratorio = new JTextArea();
		txtLaboratorio.setToolTipText("Ingrese datos del laboratorio del paciente");
		scrollPane_2.setViewportView(txtLaboratorio);
		txtLaboratorio.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {	
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					if (!e.isTemporary()) 
					{
						if(txtLaboratorio.getText().equals(""))
							txtLaboratorio.setText(Errores.NoAplica());
					}
				}
			}
		});
		
		JLabel lblEvolucion = new JLabel("Evolucion");
		lblEvolucion.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/Thunder.png")));
		GridBagConstraints gbc_lblEvolucion = new GridBagConstraints();
		gbc_lblEvolucion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEvolucion.gridx = 1;
		gbc_lblEvolucion.gridy = 8;
		contentPane.add(lblEvolucion, gbc_lblEvolucion);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridwidth = 6;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 2;
		gbc_scrollPane_3.gridy = 8;
		contentPane.add(scrollPane_3, gbc_scrollPane_3);
		
		txtrEvolucion = new JTextArea();
		txtrEvolucion.setToolTipText("Evolucion del paciente");
		scrollPane_3.setViewportView(txtrEvolucion);
		txtrEvolucion.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					if (!e.isTemporary()) 
					{
						if(txtrEvolucion.getText().equals(""))
							txtrEvolucion.setText(Errores.NoAplica());
					}
				}
			}
		});
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/icon-star.png")));
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 1;
		gbc_lblObservaciones.gridy = 9;
		contentPane.add(lblObservaciones, gbc_lblObservaciones);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.gridwidth = 6;
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.gridx = 2;
		gbc_scrollPane_4.gridy = 9;
		contentPane.add(scrollPane_4, gbc_scrollPane_4);
		
		txtrObservaciones = new JTextArea();
		txtrObservaciones.setToolTipText("Observaciones varias del paciente");
		scrollPane_4.setViewportView(txtrObservaciones);
		txtrObservaciones.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {	
			}

			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					if (!e.isTemporary()) 
					{
						if(txtrObservaciones.getText().equals(""))
							txtrObservaciones.setText(Errores.NoAplica());
					}
				}
			}
		});
		
		JLabel lblDiagnosticoPrincipal = new JLabel("Diagnostico Principal");
		lblDiagnosticoPrincipal.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/3.png")));
		GridBagConstraints gbc_lblDiagnosticoPrincipal = new GridBagConstraints();
		gbc_lblDiagnosticoPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiagnosticoPrincipal.gridx = 1;
		gbc_lblDiagnosticoPrincipal.gridy = 10;
		contentPane.add(lblDiagnosticoPrincipal, gbc_lblDiagnosticoPrincipal);
		
		txtDiagnosticoPrincipal = new JTextField();
		txtDiagnosticoPrincipal.setToolTipText("Diagnostico Principal");
		GridBagConstraints gbc_txtDiagnosticoPrincipal = new GridBagConstraints();
		gbc_txtDiagnosticoPrincipal.gridwidth = 6;
		gbc_txtDiagnosticoPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiagnosticoPrincipal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiagnosticoPrincipal.gridx = 2;
		gbc_txtDiagnosticoPrincipal.gridy = 10;
		contentPane.add(txtDiagnosticoPrincipal, gbc_txtDiagnosticoPrincipal);
		txtDiagnosticoPrincipal.setColumns(10);
		txtDiagnosticoPrincipal.addFocusListener(new FocusListener() {
			
			public void focusGained(FocusEvent e) {
				
			}
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					if (!e.isTemporary()) 
					{
						if(txtDiagnosticoPrincipal.getText().equals(""))
						{
							lblcorregir_2.setVisible(true);
							JOptionPane.showMessageDialog(new JDialog(), Errores.Ingresediagnostico());
							txtDiagnosticoPrincipal.requestFocus();
						}
						else
							lblcorregir_2.setVisible(false);
					}
				}
			}
		});
		
		lblcorregir_2 = new JLabel("*Corregir");
		lblcorregir_2.setForeground(Color.RED);
		lblcorregir_2.setVisible(false);
		GridBagConstraints gbc_lblcorregir_2 = new GridBagConstraints();
		gbc_lblcorregir_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblcorregir_2.gridx = 8;
		gbc_lblcorregir_2.gridy = 10;
		contentPane.add(lblcorregir_2, gbc_lblcorregir_2);
		
		JLabel lblDiagnosticoSecundario = new JLabel("Diagnostico Secundario");
		lblDiagnosticoSecundario.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/3.png")));
		GridBagConstraints gbc_lblDiagnosticoSecundario = new GridBagConstraints();
		gbc_lblDiagnosticoSecundario.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiagnosticoSecundario.gridx = 1;
		gbc_lblDiagnosticoSecundario.gridy = 11;
		contentPane.add(lblDiagnosticoSecundario, gbc_lblDiagnosticoSecundario);
		
		txtDiagnosticoSecundario = new JTextField();
		txtDiagnosticoSecundario.setToolTipText("Diagnostico Secundario");
		GridBagConstraints gbc_txtDiagnosticoSecundario = new GridBagConstraints();
		gbc_txtDiagnosticoSecundario.gridwidth = 6;
		gbc_txtDiagnosticoSecundario.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiagnosticoSecundario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiagnosticoSecundario.gridx = 2;
		gbc_txtDiagnosticoSecundario.gridy = 11;
		contentPane.add(txtDiagnosticoSecundario, gbc_txtDiagnosticoSecundario);
		txtDiagnosticoSecundario.setColumns(10);
		txtDiagnosticoSecundario.addFocusListener(new FocusListener() {
			
			public void focusGained(FocusEvent e) {
				
			}
			
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					if (!e.isTemporary()) 
					{
						if(txtDiagnosticoSecundario.getText().equals(""))
							txtDiagnosticoSecundario.setText(Errores.NoAplica());
					}
				}
			}
		});
		
		JLabel lblEspecialista = new JLabel("Especialista");
		lblEspecialista.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/Schnellzugriff_Icon_3.png")));
		GridBagConstraints gbc_lblEspecialista = new GridBagConstraints();
		gbc_lblEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecialista.gridx = 1;
		gbc_lblEspecialista.gridy = 12;
		contentPane.add(lblEspecialista, gbc_lblEspecialista);
		
		txtEspecialista = new JTextField();
		txtEspecialista.setEditable(false);
		txtEspecialista.setToolTipText("");
		GridBagConstraints gbc_txtEspecialista = new GridBagConstraints();
		gbc_txtEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_txtEspecialista.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspecialista.gridx = 2;
		gbc_txtEspecialista.gridy = 12;
		contentPane.add(txtEspecialista, gbc_txtEspecialista);
		txtEspecialista.setColumns(10);		
		txtEspecialista.setText(usuario);
		
		JButton btnAadir = new JButton("Agregar");
		btnAadir.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/unidad-de-disco-icono-3963-48.png")));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					AnadeIngreso();
					com.histocons.log.Log.crearLog("Ingrso Correcto");
				}
				catch(Exception e)
				{
					String error = e.getMessage().toString();
					try {
						com.histocons.log.Log.crearLog("Error: "+ error);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/cancel-button.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrar.gridx = 2;
		gbc_btnCerrar.gridy = 13;
		contentPane.add(btnCerrar, gbc_btnCerrar);
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.insets = new Insets(0, 0, 0, 5);
		gbc_btnAadir.gridx = 7;
		gbc_btnAadir.gridy = 13;
		contentPane.add(btnAadir, gbc_btnAadir);
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void AnadeIngreso() throws IOException
	{
		int dni = Integer.parseInt(txtDni.getText());
		float altura = Float.parseFloat(txtAltura.getText());
		float peso = Integer.parseInt(txtPeso.getText());
		String fecActual = fechaActual;
		String sintomas = txtrAntecedentes.getText();
		if(sintomas.equals(""))
		{
			JOptionPane.showMessageDialog(new JDialog(), Errores.IngresoSintomas());
			txtrAntecedentes.requestFocus();
		}	
		String otros = txtOtros.getText();
		String laboratorio = txtLaboratorio.getText();
		String evolucion = txtrEvolucion.getText();
		String observaciones = txtrObservaciones.getText();
		String diagnosticoprinc = txtDiagnosticoPrincipal.getText();
		if(diagnosticoprinc.equals(""))
		{
			JOptionPane.showMessageDialog(new JDialog(), Errores.Ingresediagnostico());
			txtDiagnosticoPrincipal.requestFocus();
		}
		String diagnosticosec = txtDiagnosticoSecundario.getText();
		String especialista = usuario;
		
		boolean err = false;
		try {
			err = GestorHistoria.NuevoIngreso(dni, altura, peso, fecActual, sintomas, otros, laboratorio, evolucion, observaciones, 
					diagnosticoprinc, diagnosticosec, especialista);
			JOptionPane.showMessageDialog(new JDialog(), Errores.IngresoHistoriaCorrecta());
			com.histocons.log.Log.crearLog(Errores.IngresoHistoriaCorrecta().toString());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
			com.histocons.log.Log.crearLog(e.getMessage().toString());
			e.printStackTrace();
		}

			if (!err)
				dispose();
	}
}

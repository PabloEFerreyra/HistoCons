package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.ejecucion.JTextFieldLimit;
import com.historiasclinicas.ejecucion.Numbers;
import com.historiasclinicas.entidades.Historia;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorArchivos;
import com.historiasclinicas.gestores.GestorHistoria;
import com.historiasclinicas.log.Log;

public class PantaAnadirIngreso extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -4111307181033285919L;
	Calendar fecha = Calendar.getInstance();
	int mes = fecha.get(Calendar.MONTH);
	int ano = fecha.get(Calendar.YEAR);
	public String Apellido;
	private final JButton btnAgregar;
	private final JPanel contentPane;
	int dia = fecha.get(Calendar.DAY_OF_MONTH);
	public String DNI;
	private final String especialidad = "General";
	Date fec = new java.util.Date();
	String fechaActual = dia + "/" + (mes + 1) + "/" + ano;
	private final JLabel lblcompletarDiagnostico;
	private final JLabel lblcorregir;
	private final JLabel lblcorregirOrden;
	private final JLabel lblEstado;
	private final JList<Object> lista;
	private List<Historia> listaHistorias = null;
	public String Nombre;
	private Paciente paciente;
	private final JTextField txtApellido;
	private final JTextField txtDiagnosticoPrincipal;
	private final JTextField txtDiagnosticoSecundario;
	private final JTextField txtDni;
	private final JTextField txtEspecialista;
	private final JTextField txtFecha;
	private final JTextField txtIdPaciente;
	private final JTextArea txtLaboratorio;
	private final JTextField txtOrdenConsulta;
	private final JTextArea txtrAntecedentes;
	private final JTextArea txtrEvolucion;
	private final JTextArea txtrObservaciones;
	private final JTextArea txtrOtros;
	private String usuario = PantaLogin.perfil.get(0).getNombre()+" "+PantaLogin.perfil.get(0).getApellido() + " - " + PantaLogin.perfil.get(0).getMatricula();

	@SuppressWarnings("deprecation")
	public PantaAnadirIngreso(Paciente paciente) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setPaciente(paciente);


		final Calendar fecha = Calendar.getInstance();

		final int ano = fecha.get(Calendar.YEAR);
		final int mes = fecha.get(Calendar.MONTH);
		final int dia = fecha.get(Calendar.DAY_OF_MONTH);
		final String fechaActual = dia + "/" + (mes + 1) + "/" + ano;

		setTitle("A\u00F1adir Ingreso");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(PantaAnadirIngreso.class.getResource("/imagenes/logotipo.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1232, 661);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		final JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 70, 0, 65, 46, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 174, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		final JLabel label = new JLabel("A\u00F1adir Ingreso");
		label.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/file-o.png")));
		final GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);

		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/logotipo.png")));
		final GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 11;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		final JLabel lblNroIdPaciente = new JLabel("Nro. Id. Paciente");
		final GridBagConstraints gbc_lblNroIdPaciente = new GridBagConstraints();
		gbc_lblNroIdPaciente.anchor = GridBagConstraints.EAST;
		gbc_lblNroIdPaciente.fill = GridBagConstraints.VERTICAL;
		gbc_lblNroIdPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroIdPaciente.gridx = 1;
		gbc_lblNroIdPaciente.gridy = 1;
		contentPane.add(lblNroIdPaciente, gbc_lblNroIdPaciente);

		txtIdPaciente = new JTextField();
		txtIdPaciente.setHorizontalAlignment(SwingConstants.RIGHT);
		txtIdPaciente.setEditable(false);
		txtIdPaciente.setText(this.paciente.getId().toString());
		final GridBagConstraints gbc_txtIdPaciente = new GridBagConstraints();
		gbc_txtIdPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdPaciente.fill = GridBagConstraints.BOTH;
		gbc_txtIdPaciente.gridx = 2;
		gbc_txtIdPaciente.gridy = 1;
		contentPane.add(txtIdPaciente, gbc_txtIdPaciente);
		txtIdPaciente.setColumns(10);

		final JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente
		.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/user-md.png")));
		final GridBagConstraints gbc_lblPaciente = new GridBagConstraints();
		gbc_lblPaciente.anchor = GridBagConstraints.WEST;
		gbc_lblPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaciente.gridx = 1;
		gbc_lblPaciente.gridy = 2;
		contentPane.add(lblPaciente, gbc_lblPaciente);

		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setText(Integer.toString(this.paciente.getDni()));
		DNI = Integer.toString(this.paciente.getDni());
		final GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.gridwidth = 3;
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 2;
		contentPane.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setText(this.paciente.getApellido());
		Apellido = this.paciente.getApellido();
		final Date nac = this.paciente.getFechaNacimiento();
		final int month = nac.getMonth()+1;
		final String FechaNac = nac.getDate()+"/"+month+"/"+nac.getYear();
		txtApellido.setEditable(false);
		final GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 5;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 5;
		gbc_txtApellido.gridy = 2;
		contentPane.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		Nombre = this.paciente.getNombre();

		final JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setIcon(
				new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/calendar.png")));
		final GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.WEST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 3;
		contentPane.add(lblFecha, gbc_lblFecha);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setToolTipText("");
		txtFecha.setText(fechaActual);
		;
		final GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.gridx = 2;
		gbc_txtFecha.gridy = 3;
		contentPane.add(txtFecha, gbc_txtFecha);
		txtFecha.setColumns(10);

		final JButton btnExamenVisual = new JButton("Examen Visual");
		btnExamenVisual.addActionListener(e -> GestorArchivos.abrirarchivo("src/imagenes/e.jpg"));

		final JLabel lblOrdCons = new JLabel("Ord Cons:");
		final GridBagConstraints gbc_lblOrdCons = new GridBagConstraints();
		gbc_lblOrdCons.anchor = GridBagConstraints.WEST;
		gbc_lblOrdCons.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrdCons.gridx = 4;
		gbc_lblOrdCons.gridy = 3;
		contentPane.add(lblOrdCons, gbc_lblOrdCons);

		txtOrdenConsulta = new JTextField();
		txtOrdenConsulta.setDocument(new JTextFieldLimit(20));
		txtOrdenConsulta.setHorizontalAlignment(SwingConstants.RIGHT);
		txtOrdenConsulta.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				Numbers.caracteres(e);
			}
		});
		txtOrdenConsulta.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary())
					if (!e.isTemporary())
						if (txtOrdenConsulta.getText().length() == 0)
							txtOrdenConsulta.setText("0");
			}
		});
		txtOrdenConsulta.setText("0");
		final GridBagConstraints gbc_txtOrdenConsulta = new GridBagConstraints();
		gbc_txtOrdenConsulta.gridwidth = 3;
		gbc_txtOrdenConsulta.insets = new Insets(0, 0, 5, 5);
		gbc_txtOrdenConsulta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrdenConsulta.gridx = 5;
		gbc_txtOrdenConsulta.gridy = 3;
		contentPane.add(txtOrdenConsulta, gbc_txtOrdenConsulta);
		txtOrdenConsulta.setColumns(10);

		lblcorregirOrden = new JLabel("*Corregir");
		lblcorregirOrden.setForeground(Color.RED);
		final GridBagConstraints gbc_lblcorregirOrden = new GridBagConstraints();
		gbc_lblcorregirOrden.anchor = GridBagConstraints.WEST;
		gbc_lblcorregirOrden.insets = new Insets(0, 0, 5, 5);
		gbc_lblcorregirOrden.gridx = 8;
		gbc_lblcorregirOrden.gridy = 3;
		contentPane.add(lblcorregirOrden, gbc_lblcorregirOrden);
		btnExamenVisual.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/eye.png")));
		btnExamenVisual.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnExamenVisual = new GridBagConstraints();
		gbc_btnExamenVisual.fill = GridBagConstraints.VERTICAL;
		gbc_btnExamenVisual.anchor = GridBagConstraints.WEST;
		gbc_btnExamenVisual.gridwidth = 2;
		gbc_btnExamenVisual.insets = new Insets(0, 0, 5, 5);
		gbc_btnExamenVisual.gridx = 1;
		gbc_btnExamenVisual.gridy = 4;
		contentPane.add(btnExamenVisual, gbc_btnExamenVisual);

		final JLabel label_1 = new JLabel("Fin datos Paciente/Inicio datos ficha");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		final GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 4;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 6;
		gbc_label_1.gridy = 5;
		contentPane.add(label_1, gbc_label_1);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane);

		final JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{103, 240, 0, 45, 71, 91, 35, 75, 35, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{60, 53, 23, 23, 22, 22, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		final JLabel lblSintomas = new JLabel("Antecedentes *");
		lblSintomas.setForeground(Color.RED);
		lblSintomas.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/save.png")));
		final GridBagConstraints gbc_lblSintomas = new GridBagConstraints();
		gbc_lblSintomas.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSintomas.insets = new Insets(0, 0, 5, 5);
		gbc_lblSintomas.gridx = 0;
		gbc_lblSintomas.gridy = 0;
		panel.add(lblSintomas, gbc_lblSintomas);

		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 0;
		panel.add(scrollPane_1, gbc_scrollPane_1);

		txtrAntecedentes = new JTextArea();
		scrollPane_1.setViewportView(txtrAntecedentes);
		txtrAntecedentes.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary())
					if (!e.isTemporary())
						if (txtrAntecedentes.getText().equals("")) {
							lblcorregir.setVisible(true);
							JOptionPane.showMessageDialog(new JDialog(), Errores.IngresoSintomas(), "Error", JOptionPane.ERROR_MESSAGE);
							txtrAntecedentes.requestFocus();
						} else
							lblcorregir.setVisible(false);
			}
		});

		lblcorregir = new JLabel("*Corregir");
		lblcorregir.setForeground(Color.RED);
		lblcorregir.setVisible(false);
		final GridBagConstraints gbc_lblcorregir = new GridBagConstraints();
		gbc_lblcorregir.anchor = GridBagConstraints.WEST;
		gbc_lblcorregir.fill = GridBagConstraints.VERTICAL;
		gbc_lblcorregir.insets = new Insets(0, 0, 5, 5);
		gbc_lblcorregir.gridx = 3;
		gbc_lblcorregir.gridy = 0;
		panel.add(lblcorregir, gbc_lblcorregir);

		final JLabel lblRecom = new JLabel("Otros");
		lblRecom.setIcon(
				new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/align-justify.png")));
		final GridBagConstraints gbc_lblRecom = new GridBagConstraints();
		gbc_lblRecom.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRecom.insets = new Insets(0, 0, 5, 5);
		gbc_lblRecom.gridx = 4;
		gbc_lblRecom.gridy = 0;
		panel.add(lblRecom, gbc_lblRecom);

		final JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.gridwidth = 6;
		gbc_scrollPane_3.gridx = 5;
		gbc_scrollPane_3.gridy = 0;
		panel.add(scrollPane_3, gbc_scrollPane_3);

		txtrOtros = new JTextArea();
		scrollPane_3.setViewportView(txtrOtros);
		txtrOtros.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary())
					if (!e.isTemporary())
						if (txtrOtros.getText().equals(""))
							txtrOtros.setText(Errores.NoAplica());
			}
		});

		final JLabel lblMedicacion = new JLabel("Laboratorio");
		lblMedicacion
		.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/flask.png")));
		final GridBagConstraints gbc_lblMedicacion = new GridBagConstraints();
		gbc_lblMedicacion.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMedicacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblMedicacion.gridx = 0;
		gbc_lblMedicacion.gridy = 1;
		panel.add(lblMedicacion, gbc_lblMedicacion);

		final JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 2;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 1;
		panel.add(scrollPane_2, gbc_scrollPane_2);

		txtLaboratorio = new JTextArea();
		scrollPane_2.setViewportView(txtLaboratorio);
		txtLaboratorio.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary())
					if (!e.isTemporary())
						if (txtLaboratorio.getText().equals(""))
							txtLaboratorio.setText(Errores.NoAplica());
			}
		});

		final JLabel lblEvolucin = new JLabel("Evoluci\u00F3n");
		lblEvolucin
		.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/signal.png")));
		final GridBagConstraints gbc_lblEvolucin = new GridBagConstraints();
		gbc_lblEvolucin.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblEvolucin.insets = new Insets(0, 0, 5, 5);
		gbc_lblEvolucin.gridx = 4;
		gbc_lblEvolucin.gridy = 1;
		panel.add(lblEvolucin, gbc_lblEvolucin);

		final JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_4.gridwidth = 6;
		gbc_scrollPane_4.gridx = 5;
		gbc_scrollPane_4.gridy = 1;
		panel.add(scrollPane_4, gbc_scrollPane_4);

		txtrEvolucion = new JTextArea();
		scrollPane_4.setViewportView(txtrEvolucion);

		final JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones
		.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/eye.png")));
		final GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.anchor = GridBagConstraints.WEST;
		gbc_lblObservaciones.fill = GridBagConstraints.VERTICAL;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 0;
		gbc_lblObservaciones.gridy = 2;
		panel.add(lblObservaciones, gbc_lblObservaciones);

		final JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
		gbc_scrollPane_5.gridwidth = 2;
		gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_5.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_5.gridheight = 2;
		gbc_scrollPane_5.gridx = 1;
		gbc_scrollPane_5.gridy = 2;
		panel.add(scrollPane_5, gbc_scrollPane_5);

		txtrObservaciones = new JTextArea();
		scrollPane_5.setViewportView(txtrObservaciones);
		txtrObservaciones.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary())
					if (!e.isTemporary())
						if (txtrObservaciones.getText().equals(""))
							txtrObservaciones.setText(Errores.NoAplica());
			}
		});

		final JButton btnCertificados = new JButton("Certificados");
		btnCertificados.setHorizontalAlignment(SwingConstants.LEFT);
		btnCertificados.addActionListener(arg0 -> {
			final String edade = Integer.toString(edad(FechaNac));
			final PantaAF paf = new PantaAF();
			paf.lblEdad.setText(edade);
			paf.lblApellido.setText(Apellido);
			paf.lblNombre.setText(Nombre);
			paf.lblDni.setText(DNI);
			paf.lblUsuario.setText(usuario);
			paf.setVisible(true);
		});
		final GridBagConstraints gbc_btnCertificados = new GridBagConstraints();
		gbc_btnCertificados.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCertificados.insets = new Insets(0, 0, 5, 5);
		gbc_btnCertificados.gridx = 5;
		gbc_btnCertificados.gridy = 2;
		panel.add(btnCertificados, gbc_btnCertificados);

		final JLabel lblDiagPrincipal = new JLabel("Diag Principal *");
		lblDiagPrincipal.setForeground(Color.RED);
		lblDiagPrincipal
		.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/medkit.png")));
		final GridBagConstraints gbc_lblDiagPrincipal = new GridBagConstraints();
		gbc_lblDiagPrincipal.anchor = GridBagConstraints.WEST;
		gbc_lblDiagPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiagPrincipal.gridx = 0;
		gbc_lblDiagPrincipal.gridy = 4;
		panel.add(lblDiagPrincipal, gbc_lblDiagPrincipal);

		txtDiagnosticoPrincipal = new JTextField();
		final GridBagConstraints gbc_txtDiagnosticoPrincipal = new GridBagConstraints();
		gbc_txtDiagnosticoPrincipal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiagnosticoPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiagnosticoPrincipal.gridwidth = 7;
		gbc_txtDiagnosticoPrincipal.gridx = 1;
		gbc_txtDiagnosticoPrincipal.gridy = 4;
		panel.add(txtDiagnosticoPrincipal, gbc_txtDiagnosticoPrincipal);
		txtDiagnosticoPrincipal.setColumns(10);
		txtDiagnosticoPrincipal.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary())
					if (!e.isTemporary())
						if (txtDiagnosticoPrincipal.getText().equals("")) {
							lblcompletarDiagnostico.setVisible(true);
							JOptionPane.showMessageDialog(new JDialog(), Errores.Ingresediagnostico(), "Error", JOptionPane.ERROR_MESSAGE);
							txtDiagnosticoPrincipal.requestFocus();
						} else
							lblcompletarDiagnostico.setVisible(false);
			}
		});

		lblcompletarDiagnostico = new JLabel("CompletarDiagnostico");
		lblcompletarDiagnostico.setForeground(Color.RED);
		lblcompletarDiagnostico.setVisible(false);
		final GridBagConstraints gbc_lblcompletarDiagnostico = new GridBagConstraints();
		gbc_lblcompletarDiagnostico.anchor = GridBagConstraints.WEST;
		gbc_lblcompletarDiagnostico.gridwidth = 3;
		gbc_lblcompletarDiagnostico.insets = new Insets(0, 0, 5, 0);
		gbc_lblcompletarDiagnostico.gridx = 8;
		gbc_lblcompletarDiagnostico.gridy = 4;
		panel.add(lblcompletarDiagnostico, gbc_lblcompletarDiagnostico);

		final JLabel lblDiagSecundario = new JLabel("Diag Secundario");
		lblDiagSecundario
		.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/medkit.png")));
		final GridBagConstraints gbc_lblDiagSecundario = new GridBagConstraints();
		gbc_lblDiagSecundario.anchor = GridBagConstraints.EAST;
		gbc_lblDiagSecundario.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiagSecundario.gridx = 0;
		gbc_lblDiagSecundario.gridy = 5;
		panel.add(lblDiagSecundario, gbc_lblDiagSecundario);

		txtDiagnosticoSecundario = new JTextField();
		final GridBagConstraints gbc_txtDiagnosticoSecundario = new GridBagConstraints();
		gbc_txtDiagnosticoSecundario.insets = new Insets(0, 0, 0, 5);
		gbc_txtDiagnosticoSecundario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiagnosticoSecundario.gridwidth = 7;
		gbc_txtDiagnosticoSecundario.gridx = 1;
		gbc_txtDiagnosticoSecundario.gridy = 5;
		panel.add(txtDiagnosticoSecundario, gbc_txtDiagnosticoSecundario);
		txtDiagnosticoSecundario.setColumns(10);
		txtDiagnosticoSecundario.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary())
					if (!e.isTemporary())
						if (txtDiagnosticoSecundario.getText().equals(""))
							txtDiagnosticoSecundario.setText(Errores.NoAplica());
			}
		});

		final JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_6.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		final GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		gbc_scrollPane_6.gridheight = 2;
		gbc_scrollPane_6.gridwidth = 3;
		gbc_scrollPane_6.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_6.gridx = 10;
		gbc_scrollPane_6.gridy = 6;
		contentPane.add(scrollPane_6, gbc_scrollPane_6);


		lista = new JList<>();
		lista.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (e.getClickCount() == 2)
					try {
						IngresaAHistoria();
					} catch (final Exception e1) {
						final String error = e1.toString();
						try {
							Log.crearLog("Error " + error);
						} catch (final IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}

			}
		});
		scrollPane_6.setViewportView(lista);

		final JLabel lblEspecialista = new JLabel("Especialista");
		lblEspecialista
		.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/twentytwo/user-md.png")));
		final GridBagConstraints gbc_lblEspecialista = new GridBagConstraints();
		gbc_lblEspecialista.anchor = GridBagConstraints.WEST;
		gbc_lblEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecialista.gridx = 1;
		gbc_lblEspecialista.gridy = 7;
		contentPane.add(lblEspecialista, gbc_lblEspecialista);

		txtEspecialista = new JTextField();
		txtEspecialista.setEditable(false);
		final GridBagConstraints gbc_txtEspecialista = new GridBagConstraints();
		gbc_txtEspecialista.gridwidth = 8;
		gbc_txtEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_txtEspecialista.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspecialista.gridx = 2;
		gbc_txtEspecialista.gridy = 7;
		contentPane.add(txtEspecialista, gbc_txtEspecialista);
		txtEspecialista.setColumns(10);
		txtEspecialista.setText(usuario);

		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelar.addActionListener(arg0 -> dispose());
		btnCancelar.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/ban.png")));
		final GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 8;
		contentPane.add(btnCancelar, gbc_btnCancelar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregar.setIcon(new ImageIcon(PantaAnadirIngreso.class.getResource("/imagenes/iconos/save.png")));
		final GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 3;
		gbc_btnAgregar.gridy = 8;
		contentPane.add(btnAgregar, gbc_btnAgregar);

		final JButton btnMostrarHistorial = new JButton("Mostrar Historial");
		btnMostrarHistorial.addActionListener(arg0 -> {
			try {
				TraeHistorias();
				Log.crearLog("TraeHistorias Correcto");
			} catch (final IOException e) {
				final String error = e.toString();
				e.printStackTrace();
				try {
					Log.crearLog(error);
				} catch (final IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		final GridBagConstraints gbc_btnMostrarHistorial = new GridBagConstraints();
		gbc_btnMostrarHistorial.anchor = GridBagConstraints.NORTH;
		gbc_btnMostrarHistorial.gridwidth = 3;
		gbc_btnMostrarHistorial.insets = new Insets(0, 0, 5, 5);
		gbc_btnMostrarHistorial.gridx = 10;
		gbc_btnMostrarHistorial.gridy = 8;
		contentPane.add(btnMostrarHistorial, gbc_btnMostrarHistorial);

		lblEstado = new JLabel("estado...");
		final GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.gridx = 12;
		gbc_lblEstado.gridy = 9;
		contentPane.add(lblEstado, gbc_lblEstado);
		lblEstado.setVisible(false);
		btnAgregar.addActionListener(arg0 -> {
			try {
				AnadeIngreso();
				Log.crearLog("Ingrso Correcto");
			} catch (final Exception e1) {
				final String error1 = e1.getMessage().toString();
				try {
					Log.crearLog("Error: " + error1);
				} catch (final IOException e11) {
					// TODO Auto-generated catch block
					e11.printStackTrace();
				}
			}
		});

	}

	public void AnadeIngreso() throws IOException {
		@SuppressWarnings("rawtypes")
		final
		SwingWorker worker = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				final int dni = Integer.parseInt(txtDni.getText());
				final String sintomas = txtrAntecedentes.getText();
				if (sintomas.equals("")) {
					JOptionPane.showMessageDialog(new JDialog(), Errores.IngresoSintomas(), "Error", JOptionPane.ERROR_MESSAGE);
					txtrAntecedentes.requestFocus();
				}
				final String otros = txtrOtros.getText();
				final String laboratorio = txtLaboratorio.getText();
				final String evolucion = txtrEvolucion.getText();
				final String observaciones = txtrObservaciones.getText();
				final String diagnosticoprinc = txtDiagnosticoPrincipal.getText();
				final Integer orden = Integer.parseInt(txtOrdenConsulta.getText());
				if (diagnosticoprinc.equals("")) {
					JOptionPane.showMessageDialog(new JDialog(), Errores.Ingresediagnostico(),"Error", JOptionPane.ERROR_MESSAGE);
					txtDiagnosticoPrincipal.requestFocus();
				}
				final String diagnosticosec = txtDiagnosticoSecundario.getText();
				final String especialista = usuario;
				boolean err = false;
				try {
					lblEstado.setVisible(true);
					lblEstado.setText("Ingresando Historia a la base...");
					err = GestorHistoria.NuevoIngreso(dni, fec, sintomas, otros, laboratorio, evolucion,
							observaciones, diagnosticoprinc, diagnosticosec, especialista, especialidad, orden);
					JOptionPane.showMessageDialog(new JDialog(), Errores.IngresoHistoriaCorrecta(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
					Log.crearLog(Errores.IngresoHistoriaCorrecta().toString());
				} catch (final IOException e) {
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno(), "Error", JOptionPane.ERROR_MESSAGE);
					Log.crearLog(e.getMessage().toString());
					e.printStackTrace();
				}

				if (!err)
					lblEstado.setVisible(false);
				dispose();
				return null;
			}
		};
		worker.execute();
	}

	public int edad(String FechaNacimiento) { // fecha_nac debe tener el formato
		// dd/MM/yyyy

		final Date fechaActual = new Date();
		final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		final String hoy = formato.format(fechaActual);
		final String[] dat1 = FechaNacimiento.split("/");
		final String[] dat2 = hoy.split("/");
		int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
		final int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
		if (mes < 0)
			anos = anos - 1;
		else if (mes == 0) {
			final int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
			if (dia > 0)
				anos = anos - 1;
		}
		return anos;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void IngresaAHistoria() throws IOException {
		@SuppressWarnings("rawtypes")
		final
		SwingWorker worker = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				listaHistorias.get(lista.getSelectedIndex()).getPaciente();
				listaHistorias.get(lista.getSelectedIndex()).getAntecedentes();
				listaHistorias.get(lista.getSelectedIndex()).getOtros();
				listaHistorias.get(lista.getSelectedIndex()).getFecha();
				listaHistorias.get(lista.getSelectedIndex()).getEvolucion();
				listaHistorias.get(lista.getSelectedIndex()).getLaboratorio();
				listaHistorias.get(lista.getSelectedIndex()).getObservaciones();
				listaHistorias.get(lista.getSelectedIndex()).getDiagprinc();
				listaHistorias.get(lista.getSelectedIndex()).getDiagsec();
				listaHistorias.get(lista.getSelectedIndex()).getEspecialista();

				final Historia historias = listaHistorias.get(lista.getSelectedIndex());

				final PantaNewMostrarIngreso pmi = new PantaNewMostrarIngreso(historias, paciente);
				lblEstado.setVisible(true);
				lblEstado.setText("ingresando a historia...");
				Log.crearLog("Ingresado Correctamente");
				pmi.setVisible(true);
				return null;
			}
		};
		lblEstado.setVisible(false);
		worker.execute();
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void TraeHistorias() throws IOException {
		@SuppressWarnings("rawtypes")
		final
		SwingWorker worker = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				listaHistorias = GestorHistoria.ConsultarHistoria(Integer.parseInt(txtDni.getText()));

				final DefaultListModel<Object> df = new DefaultListModel<>();

				for (int i = 0; i < listaHistorias.size(); i++) {
					final Historia hi = listaHistorias.get(i);
					df.addElement(hi.getFecha() + " | " + hi.getEspecialista());
					lblEstado.setVisible(true);
					lblEstado.setText("trayendo historias...");
				}

				Log.crearLog("Trae Historias Completo!");
				lista.setModel(df);
				lblEstado.setVisible(false);
				return null;
			}
		};
		worker.execute();
	}
}

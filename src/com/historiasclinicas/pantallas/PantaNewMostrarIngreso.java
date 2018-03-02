package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.entidades.Historia;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.Conexion;
import com.historiasclinicas.log.Log;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class PantaNewMostrarIngreso extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -4111307181033285919L;
	private final JButton btnImprimir;
	private final JPanel contentPane;
	private File fichero;
	private final String folder = "C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\";
	private final JLabel lblcompletarDiagnostico;
	private String pacient;
	@SuppressWarnings("rawtypes")
	private Map parametro;
	private String salida;
	private final JTextField txtDiagnosticoPrincipal;
	private final JTextField txtDiagnosticoSecundario;
	private final JTextField txtEspecialista;
	private final JTextField txtFecha;
	private final JTextArea txtLaboratorio;
	private final JTextField txtOrden;
	private final JTextArea txtrAntecedentes;
	private final JTextArea txtrEvolucion;
	private final JTextArea txtrObservaciones;
	private final JTextArea txtrOtros;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PantaNewMostrarIngreso(Historia historias, Paciente paciente) throws IOException {
		Log.crearLog("Usuario Ingreso a mostrar Historia Seleccionada " + historias.getFecha()
		+ historias.getEspecialista());
		setPacient(paciente.getNombre() + " " + paciente.getApellido() + " Dni: " + paciente.getDni());
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(PantaNewMostrarIngreso.class.getResource("/imagenes/logotipo.png")));
		setTitle("Mostrar Ingreso");
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
		gbl_contentPane.columnWidths = new int[] { 0, 0, 70, 0, 0, 46, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 174, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		final JLabel lblMostrarIngreso = new JLabel("Mostrar Ingreso");
		lblMostrarIngreso.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/file-o.png")));
		final GridBagConstraints gbc_lblMostrarIngreso = new GridBagConstraints();
		gbc_lblMostrarIngreso.fill = GridBagConstraints.VERTICAL;
		gbc_lblMostrarIngreso.gridwidth = 2;
		gbc_lblMostrarIngreso.insets = new Insets(0, 0, 5, 5);
		gbc_lblMostrarIngreso.gridx = 1;
		gbc_lblMostrarIngreso.gridy = 0;
		contentPane.add(lblMostrarIngreso, gbc_lblMostrarIngreso);

		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/logotipo.png")));
		final GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 11;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		final JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setIcon(
				new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/twentytwo/calendar.png")));
		final GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.WEST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 2;
		contentPane.add(lblFecha, gbc_lblFecha);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setToolTipText("");
		final String pattern = "MM/dd/yyyy";
		final SimpleDateFormat format = new SimpleDateFormat(pattern);
		txtFecha.setText(format.format(historias.getFecha()));
		;
		final GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.gridwidth = 2;
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.gridx = 2;
		gbc_txtFecha.gridy = 2;
		contentPane.add(txtFecha, gbc_txtFecha);
		txtFecha.setColumns(10);

		final JLabel lblNroOrden = new JLabel("Nro Orden:");
		final GridBagConstraints gbc_lblNroOrden = new GridBagConstraints();
		gbc_lblNroOrden.anchor = GridBagConstraints.WEST;
		gbc_lblNroOrden.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroOrden.gridx = 1;
		gbc_lblNroOrden.gridy = 3;
		contentPane.add(lblNroOrden, gbc_lblNroOrden);

		txtOrden = new JTextField();
		txtOrden.setText(historias.getOrden().toString());
		txtOrden.setEditable(false);
		final GridBagConstraints gbc_txtOrden = new GridBagConstraints();
		gbc_txtOrden.gridwidth = 2;
		gbc_txtOrden.insets = new Insets(0, 0, 5, 5);
		gbc_txtOrden.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrden.gridx = 2;
		gbc_txtOrden.gridy = 3;
		contentPane.add(txtOrden, gbc_txtOrden);
		txtOrden.setColumns(10);

		final JLabel label_1 = new JLabel("Fin datos Paciente/Inicio datos ficha");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		final GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 4;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 6;
		gbc_label_1.gridy = 4;
		contentPane.add(label_1, gbc_label_1);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 12;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);

		final JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{103, 240, 0, 45, 71, 91, 35, 75, 35, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{60, 53, 23, 23, 22, 22, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		final JLabel lblSintomas = new JLabel("Antecedentes");
		lblSintomas.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/twentytwo/save.png")));
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
		txtrAntecedentes.setEditable(false);
		scrollPane_1.setViewportView(txtrAntecedentes);
		txtrAntecedentes.setText(historias.getAntecedentes());

		final JLabel lblRecom = new JLabel("Otros");
		lblRecom.setIcon(
				new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/twentytwo/align-justify.png")));
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
		txtrOtros.setEditable(false);
		scrollPane_3.setViewportView(txtrOtros);
		txtrOtros.setText(historias.getOtros());

		final JLabel lblMedicacion = new JLabel("Laboratorio");
		lblMedicacion
		.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/twentytwo/flask.png")));
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
		txtLaboratorio.setEditable(false);
		scrollPane_2.setViewportView(txtLaboratorio);
		txtLaboratorio.setText(historias.getLaboratorio());

		final JLabel lblEvolucin = new JLabel("Evoluci\u00F3n");
		lblEvolucin
		.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/twentytwo/signal.png")));
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
		txtrEvolucion.setEditable(false);
		txtrEvolucion.setText(historias.getEvolucion());
		scrollPane_4.setViewportView(txtrEvolucion);

		final JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones
		.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/twentytwo/eye.png")));
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
		txtrObservaciones.setEditable(false);
		scrollPane_5.setViewportView(txtrObservaciones);
		txtrObservaciones.setText(historias.getObservaciones());

		final JLabel lblDiagPrincipal = new JLabel("Diag Principal");
		lblDiagPrincipal
		.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/twentytwo/medkit.png")));
		final GridBagConstraints gbc_lblDiagPrincipal = new GridBagConstraints();
		gbc_lblDiagPrincipal.anchor = GridBagConstraints.WEST;
		gbc_lblDiagPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiagPrincipal.gridx = 0;
		gbc_lblDiagPrincipal.gridy = 4;
		panel.add(lblDiagPrincipal, gbc_lblDiagPrincipal);

		txtDiagnosticoPrincipal = new JTextField();
		txtDiagnosticoPrincipal.setEditable(false);
		txtDiagnosticoPrincipal.setText(historias.getDiagprinc());
		final GridBagConstraints gbc_txtDiagnosticoPrincipal = new GridBagConstraints();
		gbc_txtDiagnosticoPrincipal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiagnosticoPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiagnosticoPrincipal.gridwidth = 7;
		gbc_txtDiagnosticoPrincipal.gridx = 1;
		gbc_txtDiagnosticoPrincipal.gridy = 4;
		panel.add(txtDiagnosticoPrincipal, gbc_txtDiagnosticoPrincipal);
		txtDiagnosticoPrincipal.setColumns(10);

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
		.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/twentytwo/medkit.png")));
		final GridBagConstraints gbc_lblDiagSecundario = new GridBagConstraints();
		gbc_lblDiagSecundario.anchor = GridBagConstraints.EAST;
		gbc_lblDiagSecundario.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiagSecundario.gridx = 0;
		gbc_lblDiagSecundario.gridy = 5;
		panel.add(lblDiagSecundario, gbc_lblDiagSecundario);

		txtDiagnosticoSecundario = new JTextField();
		txtDiagnosticoSecundario.setEditable(false);
		final GridBagConstraints gbc_txtDiagnosticoSecundario = new GridBagConstraints();
		gbc_txtDiagnosticoSecundario.insets = new Insets(0, 0, 0, 5);
		gbc_txtDiagnosticoSecundario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiagnosticoSecundario.gridwidth = 7;
		gbc_txtDiagnosticoSecundario.gridx = 1;
		gbc_txtDiagnosticoSecundario.gridy = 5;
		panel.add(txtDiagnosticoSecundario, gbc_txtDiagnosticoSecundario);
		txtDiagnosticoSecundario.setColumns(10);
		txtDiagnosticoSecundario.setText(historias.getDiagsec());

		final JLabel lblEspecialista = new JLabel("Especialista");
		lblEspecialista
		.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/twentytwo/user-md.png")));
		final GridBagConstraints gbc_lblEspecialista = new GridBagConstraints();
		gbc_lblEspecialista.anchor = GridBagConstraints.WEST;
		gbc_lblEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecialista.gridx = 1;
		gbc_lblEspecialista.gridy = 6;
		contentPane.add(lblEspecialista, gbc_lblEspecialista);

		txtEspecialista = new JTextField();
		txtEspecialista.setEditable(false);
		final GridBagConstraints gbc_txtEspecialista = new GridBagConstraints();
		gbc_txtEspecialista.gridwidth = 8;
		gbc_txtEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_txtEspecialista.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspecialista.gridx = 2;
		gbc_txtEspecialista.gridy = 6;
		contentPane.add(txtEspecialista, gbc_txtEspecialista);
		txtEspecialista.setColumns(10);
		txtEspecialista.setText(historias.getEspecialista() + " " + historias.getEspecialidad());

		btnImprimir = new JButton("Imprimir");
		btnImprimir.setHorizontalAlignment(SwingConstants.LEFT);
		btnImprimir.setIcon(new ImageIcon(PantaNewMostrarIngreso.class.getResource("/imagenes/iconos/print.png")));
		final GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImprimir.insets = new Insets(0, 0, 5, 5);
		gbc_btnImprimir.gridx = 3;
		gbc_btnImprimir.gridy = 7;
		contentPane.add(btnImprimir, gbc_btnImprimir);
		btnImprimir.addActionListener(arg0 -> {
			parametro = new HashMap();
			parametro.put("Paciente", paciente.getDni());
			parametro.put("Fecha", historias.getFecha());

			JasperReport jr = null;
			final String archivo = folder+"Historias.jasper";
			try {
				jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
				final JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());
				JasperPrintManager.printReport(jp, true);

			} catch (final JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
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

	public String getPacient() {
		return pacient;
	}
	public void SendToPrinter(String paciente, String fecha, String sintomas,
			String otros, String laboratorio, String evolucion, String observaciones, String diagnostprinc, String diagnossec, String especialista) throws Exception {
		final Document document = new Document();
		final Calendar cal = Calendar.getInstance();

		final Date hoy = new Date(cal.getTimeInMillis());

		final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		final SimpleDateFormat fechaHoy = new SimpleDateFormat("ddMMyyyy");
		// Image imagen = Image.getInstance("Extras/logotipo.png");

		final String parrafo = "Paciente: " + paciente + "\n" + "\n" ;

		final String parrafo2 = "\n" + "Sintomas: " + sintomas + "\n" + "Otros: " + otros + "\n" + "Laboratorio: "
				+ laboratorio + "\n" + "Evolucion: " + evolucion + "\n" + "Observaciones: " + observaciones + "\n";

		final String parrafo3 = "\n" + "Diagnostico Principal: " + diagnostprinc + "\n" + "Diagnostico Secundario: "
				+ diagnossec + "\n" + "\n" + "Fecha Visita: " + fecha + "\n" + "\n" + "Especialista: " + especialista
				+ "\n" + "Firma Especialista:" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "Fecha: "
				+ formato.format(hoy) + "\n" + "\n";

		salida = fichero + " " + fechaHoy.format(hoy) + ".pdf";

		PdfWriter.getInstance(document, new FileOutputStream(salida));
		document.open();
		document.add(new Paragraph(parrafo));
		document.add(new Paragraph(parrafo2));
		document.add(new Paragraph(parrafo3));
		document.close();
	}
	public void setPacient(String pacient) {
		this.pacient = pacient;
	}
}

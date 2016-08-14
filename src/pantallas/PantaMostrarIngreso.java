package pantallas;



import java.awt.Desktop;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileNameExtensionFilter;

import com.histocons.ejecucion.Ejecucion;
import com.histocons.entidades.Historia;
import com.histocons.log.Log;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PantaMostrarIngreso extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfechaingreso;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtDiagnosticoPrincipal;
	private JTextField txtDiagnosticoSecundario;
	private JTextField txtEspecialista;
	private Historia historias;
	private JTextArea txtrAntecedentes;
	private JTextArea txtOtros;
	private JTextArea txtLaboratorio;
	private JTextArea txtrEvolucion;
	private JTextArea txtrObservaciones;
	private File fichero;
	private String salida; 
	private JTextField txtIMC;
	private float peso;
	private float altura;
	
	public PantaMostrarIngreso(final Historia historias) throws IOException {
		Log.crearLog("Usuario Ingreso a mostrar Historia Seleccionada " + 
	historias.getFecha() + historias.getEspecialista());
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

		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaMostrarIngreso.class.getResource("/imagenes/hoja.png")));
		setTitle("Mostrar Ingreso");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.historias= historias;
		peso = historias.getPeso();
		altura = historias.getAltura();
		float imc = Ejecucion.calculaimc(peso, altura);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 732, 688);
		
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
		gbl_contentPane.columnWidths = new int[]{21, 149, 196, 63, 0, 96, 338, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 20, 20, 20, 57, 57, 57, 57, 57, 20, 20, 20, 58, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Mostrar Ingreso");
		lblNewLabel.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/hoja.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/icon_344_1.png")));
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 1;
		contentPane.add(lblFecha, gbc_lblFecha);
		
		txtfechaingreso = new JTextField();
		lblFecha.setLabelFor(txtfechaingreso);
		txtfechaingreso.setEditable(false);
		txtfechaingreso.setText(this.historias.getFecha());
		txtfechaingreso.setColumns(10);
		GridBagConstraints gbc_txtfechaingreso = new GridBagConstraints();
		gbc_txtfechaingreso.anchor = GridBagConstraints.NORTH;
		gbc_txtfechaingreso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfechaingreso.insets = new Insets(0, 0, 5, 5);
		gbc_txtfechaingreso.gridx = 2;
		gbc_txtfechaingreso.gridy = 1;
		contentPane.add(txtfechaingreso, gbc_txtfechaingreso);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/icono_persona.png")));
		GridBagConstraints gbc_lblAltura = new GridBagConstraints();
		gbc_lblAltura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltura.gridx = 1;
		gbc_lblAltura.gridy = 2;
		contentPane.add(lblAltura, gbc_lblAltura);
		
		txtAltura = new JTextField();
		lblAltura.setLabelFor(txtAltura);
		txtAltura.setEditable(false);
		txtAltura.setText(Float.toString(this.historias.getAltura()));
		txtAltura.setColumns(10);
		GridBagConstraints gbc_txtAltura = new GridBagConstraints();
		gbc_txtAltura.anchor = GridBagConstraints.NORTH;
		gbc_txtAltura.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAltura.insets = new Insets(0, 0, 5, 5);
		gbc_txtAltura.gridx = 2;
		gbc_txtAltura.gridy = 2;
		contentPane.add(txtAltura, gbc_txtAltura);
		altura = Float.parseFloat(txtAltura.getText());
		
		JLabel lblImc = new JLabel("IMC");
		lblImc.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/icono_persona.png")));
		GridBagConstraints gbc_lblImc = new GridBagConstraints();
		gbc_lblImc.insets = new Insets(0, 0, 5, 5);
		gbc_lblImc.gridx = 4;
		gbc_lblImc.gridy = 2;
		contentPane.add(lblImc, gbc_lblImc);
		
		txtIMC = new JTextField();
		txtIMC.setEditable(false);
		GridBagConstraints gbc_txtIMC = new GridBagConstraints();
		gbc_txtIMC.insets = new Insets(0, 0, 5, 5);
		gbc_txtIMC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIMC.gridx = 5;
		gbc_txtIMC.gridy = 2;
		contentPane.add(txtIMC, gbc_txtIMC);
		txtIMC.setColumns(10);
		
		txtIMC.setText(Float.toString(imc));
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/icono_persona.png")));
		GridBagConstraints gbc_lblPeso = new GridBagConstraints();
		gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeso.gridx = 1;
		gbc_lblPeso.gridy = 3;
		contentPane.add(lblPeso, gbc_lblPeso);
		
		txtPeso = new JTextField();
		lblPeso.setLabelFor(txtPeso);
		txtPeso.setEditable(false);
		txtPeso.setText(Float.toString(this.historias.getPeso()));
		txtPeso.setColumns(10);
		GridBagConstraints gbc_txtPeso = new GridBagConstraints();
		gbc_txtPeso.anchor = GridBagConstraints.NORTH;
		gbc_txtPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPeso.insets = new Insets(0, 0, 5, 5);
		gbc_txtPeso.gridx = 2;
		gbc_txtPeso.gridy = 3;
		contentPane.add(txtPeso, gbc_txtPeso);
		peso = Float.parseFloat(txtPeso.getText());
		
		JLabel lblAntecedentes = new JLabel("Sintomas");
		lblAntecedentes.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/icon_save.png")));
		GridBagConstraints gbc_lblAntecedentes = new GridBagConstraints();
		gbc_lblAntecedentes.anchor = GridBagConstraints.NORTH;
		gbc_lblAntecedentes.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntecedentes.gridx = 1;
		gbc_lblAntecedentes.gridy = 4;
		contentPane.add(lblAntecedentes, gbc_lblAntecedentes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 4;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		txtrAntecedentes = new JTextArea();
		scrollPane.setViewportView(txtrAntecedentes);
		lblAntecedentes.setLabelFor(txtrAntecedentes);
		txtrAntecedentes.setEditable(false);
		txtrAntecedentes.setText(this.historias.getAntecedentes());
		
		JLabel lblOtros = new JLabel("Otros");
		lblOtros.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/icon_save.png")));
		GridBagConstraints gbc_lblOtros = new GridBagConstraints();
		gbc_lblOtros.anchor = GridBagConstraints.NORTH;
		gbc_lblOtros.insets = new Insets(0, 0, 5, 5);
		gbc_lblOtros.gridx = 1;
		gbc_lblOtros.gridy = 5;
		contentPane.add(lblOtros, gbc_lblOtros);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 5;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		txtOtros = new JTextArea();
		scrollPane_1.setViewportView(txtOtros);
		lblOtros.setLabelFor(txtOtros);
		txtOtros.setEditable(false);
		txtOtros.setText(this.historias.getOtros());
		
		JLabel lblLaboratorio = new JLabel("Laboratorio");
		lblLaboratorio.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/icon_share.png")));
		GridBagConstraints gbc_lblLaboratorio = new GridBagConstraints();
		gbc_lblLaboratorio.anchor = GridBagConstraints.NORTH;
		gbc_lblLaboratorio.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaboratorio.gridx = 1;
		gbc_lblLaboratorio.gridy = 6;
		contentPane.add(lblLaboratorio, gbc_lblLaboratorio);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 5;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 6;
		contentPane.add(scrollPane_2, gbc_scrollPane_2);
		
		txtLaboratorio = new JTextArea();
		scrollPane_2.setViewportView(txtLaboratorio);
		lblLaboratorio.setLabelFor(txtLaboratorio);
		txtLaboratorio.setEditable(false);
		txtLaboratorio.setText(this.historias.getLaboratorio());
		
		JLabel lblEvolucion = new JLabel("Evolucion");
		lblEvolucion.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/Thunder.png")));
		GridBagConstraints gbc_lblEvolucion = new GridBagConstraints();
		gbc_lblEvolucion.anchor = GridBagConstraints.NORTH;
		gbc_lblEvolucion.insets = new Insets(0, 0, 5, 5);
		gbc_lblEvolucion.gridx = 1;
		gbc_lblEvolucion.gridy = 7;
		contentPane.add(lblEvolucion, gbc_lblEvolucion);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridwidth = 5;
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_3.gridx = 2;
		gbc_scrollPane_3.gridy = 7;
		contentPane.add(scrollPane_3, gbc_scrollPane_3);
		
		txtrEvolucion = new JTextArea();
		scrollPane_3.setViewportView(txtrEvolucion);
		lblEvolucion.setLabelFor(txtrEvolucion);
		txtrEvolucion.setText(this.historias.getEvolucion());
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/icon-star.png")));
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.anchor = GridBagConstraints.NORTH;
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 1;
		gbc_lblObservaciones.gridy = 8;
		contentPane.add(lblObservaciones, gbc_lblObservaciones);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
		gbc_scrollPane_4.gridwidth = 5;
		gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_4.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_4.gridx = 2;
		gbc_scrollPane_4.gridy = 8;
		contentPane.add(scrollPane_4, gbc_scrollPane_4);
		
		txtrObservaciones = new JTextArea();
		scrollPane_4.setViewportView(txtrObservaciones);
		lblObservaciones.setLabelFor(txtrObservaciones);
		txtrObservaciones.setEditable(false);
		txtrObservaciones.setText(this.historias.getObservaciones());
		
		JLabel lblDiagnosticoPrincipal = new JLabel("Diagnostico Principal");
		lblDiagnosticoPrincipal.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/3.png")));
		GridBagConstraints gbc_lblDiagnosticoPrincipal = new GridBagConstraints();
		gbc_lblDiagnosticoPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiagnosticoPrincipal.gridx = 1;
		gbc_lblDiagnosticoPrincipal.gridy = 9;
		contentPane.add(lblDiagnosticoPrincipal, gbc_lblDiagnosticoPrincipal);
		
		txtDiagnosticoPrincipal = new JTextField();
		lblDiagnosticoPrincipal.setLabelFor(txtDiagnosticoPrincipal);
		txtDiagnosticoPrincipal.setEditable(false);
		txtDiagnosticoPrincipal.setText(this.historias.getDiagprinc());
		txtDiagnosticoPrincipal.setColumns(10);
		GridBagConstraints gbc_txtDiagnosticoPrincipal = new GridBagConstraints();
		gbc_txtDiagnosticoPrincipal.gridwidth = 5;
		gbc_txtDiagnosticoPrincipal.anchor = GridBagConstraints.NORTH;
		gbc_txtDiagnosticoPrincipal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiagnosticoPrincipal.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiagnosticoPrincipal.gridx = 2;
		gbc_txtDiagnosticoPrincipal.gridy = 9;
		contentPane.add(txtDiagnosticoPrincipal, gbc_txtDiagnosticoPrincipal);
		
		JLabel lblDiagnosticoSecundario = new JLabel("Diagnostico Secundario");
		lblDiagnosticoSecundario.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/3.png")));
		GridBagConstraints gbc_lblDiagnosticoSecundario = new GridBagConstraints();
		gbc_lblDiagnosticoSecundario.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiagnosticoSecundario.gridx = 1;
		gbc_lblDiagnosticoSecundario.gridy = 10;
		contentPane.add(lblDiagnosticoSecundario, gbc_lblDiagnosticoSecundario);
		
		txtDiagnosticoSecundario = new JTextField();
		lblDiagnosticoSecundario.setLabelFor(txtDiagnosticoSecundario);
		txtDiagnosticoSecundario.setEditable(false);
		txtDiagnosticoSecundario.setText(this.historias.getDiagsec());
		txtDiagnosticoSecundario.setColumns(10);
		GridBagConstraints gbc_txtDiagnosticoSecundario = new GridBagConstraints();
		gbc_txtDiagnosticoSecundario.gridwidth = 5;
		gbc_txtDiagnosticoSecundario.anchor = GridBagConstraints.NORTH;
		gbc_txtDiagnosticoSecundario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiagnosticoSecundario.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiagnosticoSecundario.gridx = 2;
		gbc_txtDiagnosticoSecundario.gridy = 10;
		contentPane.add(txtDiagnosticoSecundario, gbc_txtDiagnosticoSecundario);
		
		JLabel lblEspecialista = new JLabel("Especialista");
		lblEspecialista.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/icono_persona.png")));
		GridBagConstraints gbc_lblEspecialista = new GridBagConstraints();
		gbc_lblEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecialista.gridx = 1;
		gbc_lblEspecialista.gridy = 11;
		contentPane.add(lblEspecialista, gbc_lblEspecialista);
		
		txtEspecialista = new JTextField();
		lblEspecialista.setLabelFor(txtEspecialista);
		txtEspecialista.setEditable(false);
		txtEspecialista.setText(this.historias.getEspecialista());
		txtEspecialista.setColumns(10);
		GridBagConstraints gbc_txtEspecialista = new GridBagConstraints();
		gbc_txtEspecialista.anchor = GridBagConstraints.NORTH;
		gbc_txtEspecialista.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_txtEspecialista.gridx = 2;
		gbc_txtEspecialista.gridy = 11;
		contentPane.add(txtEspecialista, gbc_txtEspecialista);
		
		final JButton btnImprimir = new JButton("Mandar a PDF");
		btnImprimir.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/print_48.png")));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String paciente = Integer.toString(historias.getPaciente());
		        String fecha = txtfechaingreso.getText();
		        String altura = txtAltura.getText();
		        String sintomas = txtrAntecedentes.getText();
				String peso = txtPeso.getText();
				String imc = txtIMC.getText();
				String otros = txtOtros.getText();
				String laboratorio = txtLaboratorio.getText();
				String evolucion = txtrEvolucion.getText();
				String observaciones = txtrObservaciones.getText();
				String diagnostprinc = txtDiagnosticoPrincipal.getText();
				String diagnossec = txtDiagnosticoSecundario.getText();
				String especialista = txtEspecialista.getText();
				
				JFileChooser fc = new JFileChooser();
				
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				fc.addChoosableFileFilter(new FileNameExtensionFilter("*.PDF", "PDF"));
				
				int seleccion=fc.showSaveDialog(null);
				
				if(seleccion == JFileChooser.APPROVE_OPTION)
				{
					fichero = fc.getSelectedFile();
					
					try{
			             
			            SendToPrinter(paciente, altura, peso, imc, fecha, sintomas, otros, laboratorio, evolucion,
			            		observaciones, diagnostprinc, diagnossec, especialista);
			            Log.crearLog("Impresion de Historia Correcta en "+salida);
			            JOptionPane.showMessageDialog(btnImprimir, "Se imprimio Correctamente en  "+salida);
			            
			            File exit =  new File (salida);
			            
			            Desktop.getDesktop().open(exit);
			            
			        }catch(Exception e){
			            System.out.println(e);
			            try {
							Log.crearLog("Error: "+ e.getMessage().toString());
							JOptionPane.showMessageDialog(btnImprimir, "Ocurrio un error, revise o consulte a sistemas");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			            
			        }
					
				}
				
			}
		});
		
		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.insets = new Insets(0, 0, 0, 5);
		gbc_btnImprimir.gridx = 1;
		gbc_btnImprimir.gridy = 12;
		contentPane.add(btnImprimir, gbc_btnImprimir);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(PantaMostrarIngreso.class.getResource("/imagenes/cancel-button.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					dispose();
				
			}
		});
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrar.gridx = 6;
		gbc_btnCerrar.gridy = 12;
		contentPane.add(btnCerrar, gbc_btnCerrar);	
	}
	
	public void SendToPrinter(String paciente, String altura, String peso, String imc, String fecha, String sintomas, String otros,
			String laboratorio,String evolucion, String observaciones, String diagnostprinc, String diagnossec, String especialista) throws Exception{
        Document document = new Document();        
    	Calendar cal = Calendar.getInstance();
        
        Date hoy = new Date(cal.getTimeInMillis());

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat fechaHoy = new SimpleDateFormat("ddMMyyyy");
        //Image imagen = Image.getInstance("Extras/logotipo.png");
        
        String parrafo = 	"DNI Paciente: "+paciente+ "\n"
        					+"\n"
        					+"Altura: "+altura+"\n"
        					+"Peso: "+peso+"\n"
        					+"IMC: "+imc+"\n"
        					+"\n";
        
        String parrafo2 = 	"\n"
        					+"Sintomas: "+sintomas+"\n"
        					+"Otros: "+otros+"\n"
        					+"Laboratorio: "+laboratorio+"\n"
        					+"Evolucion: "+evolucion+"\n"
        					+"Observaciones: "+observaciones+"\n";
         
        String parrafo3 = 	"\n"
        					+"Diagnostico Principal: "+diagnostprinc+"\n"
        					+ "Diagnostico Secundario: "+diagnossec+"\n"
        					+"\n"
        					+ "Fecha Visita: "+fecha+"\n"
        					+"\n"
        					+ "Especialista: "+especialista+"\n"
        					+"Firma Especialista:"+"\n"
        					+"\n"
        					+"\n"
        					+"\n"
        					+"\n"
        					+"\n"
        					+"\n"
        					+"Fecha: "+formato.format(hoy)+"\n"
        					+"\n";
        					
        
         salida = fichero+" "+fechaHoy.format(hoy)+".pdf";
        
        	PdfWriter.getInstance(document, new FileOutputStream(salida));
        	 document.open();
             document.add(new Paragraph(parrafo));
             document.add(new Paragraph(parrafo2));
             document.add(new Paragraph(parrafo3));
             document.close();
    }

	



	public Historia getHistorias() {
		return historias;
	}


	public void setHistorias(Historia historias) {
		this.historias = historias;
	}
}

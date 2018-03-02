package com.historiasclinicas.pantallas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.entidades.Turnos;
import com.historiasclinicas.gestores.GestorPacientes;
import com.historiasclinicas.gestores.GestorTurnos;
import com.historiasclinicas.log.Log;
import com.toedter.calendar.JDateChooser;

public class PantaListaTurnos extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -4986245537095109601L;
	private final JButton btnActualizarLista;
	private final JButton btnMarcarIngresado;
	private final JButton btnNuevoTurno;
	String[] columnNames = {"Hora", "Paciente", "Estado"};
	private final JPanel contentPane;
	private final JDateChooser dateChooser;
	private String especialista = PantaLogin.usuario.toString();
	private Date fechaTurno;
	private List<Turnos> ListaTurnos = null;
	private String paciente;
	private final String perfil = PantaLogin.perfil.get(0).getPerfil();
	private final JScrollPane scrollPane;
	private final JTable table;
	/**
	 * Create the frame.
	 */
	public PantaListaTurnos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaListaTurnos.class.getResource("/imagenes/logotipo.png")));
		setTitle("Administrar Turnos Medico");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 890, 444);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(PantaListaTurnos.class.getResource("/imagenes/iconos/twentytwo/archive.png")));
		menuBar.add(mnArchivo);

		final JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(e -> System.exit(0));
		mntmSalir.setIcon(new ImageIcon(PantaListaTurnos.class.getResource("/imagenes/iconos/twentytwo/close.png")));
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 32, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		final JLabel lblTurnos = new JLabel("Turnos");
		lblTurnos.setFont(new Font("Georgia", Font.BOLD, 12));
		lblTurnos.setIcon(new ImageIcon(PantaListaTurnos.class.getResource("/imagenes/iconos/calendar.png")));
		final GridBagConstraints gbc_lblTurnos = new GridBagConstraints();
		gbc_lblTurnos.anchor = GridBagConstraints.WEST;
		gbc_lblTurnos.gridwidth = 7;
		gbc_lblTurnos.insets = new Insets(0, 0, 5, 5);
		gbc_lblTurnos.gridx = 1;
		gbc_lblTurnos.gridy = 0;
		contentPane.add(lblTurnos, gbc_lblTurnos);

		final JLabel lblIcono = new JLabel("");
		final GridBagConstraints gbc_lblIcono = new GridBagConstraints();
		gbc_lblIcono.anchor = GridBagConstraints.EAST;
		gbc_lblIcono.gridwidth = 9;
		gbc_lblIcono.insets = new Insets(0, 0, 5, 0);
		gbc_lblIcono.gridx = 14;
		gbc_lblIcono.gridy = 0;
		contentPane.add(lblIcono, gbc_lblIcono);
		lblIcono.setIcon(new ImageIcon(PantaListaTurnos.class.getResource("/imagenes/logotipo.png")));

		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridwidth = 20;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setBorder(null);
		table.setDefaultEditor(Object.class, null);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Hora", "Paciente", "Estado"
				}
				));
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		btnActualizarLista = new JButton("Actualizar Lista");
		btnActualizarLista.setBackground(SystemColor.control);
		btnActualizarLista.addActionListener(e -> llenarLista());
		btnActualizarLista.setHorizontalAlignment(SwingConstants.LEFT);
		btnActualizarLista.setIcon(new ImageIcon(PantaListaTurnos.class.getResource("/imagenes/iconos/twentytwo/history.png")));
		final GridBagConstraints gbc_btnActualizarLista = new GridBagConstraints();
		gbc_btnActualizarLista.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnActualizarLista.insets = new Insets(0, 0, 5, 5);
		gbc_btnActualizarLista.gridx = 21;
		gbc_btnActualizarLista.gridy = 1;
		contentPane.add(btnActualizarLista, gbc_btnActualizarLista);

		final JButton btnIngresarATurno = new JButton("Ingresar a Paciente");
		if (perfil.equals("Secretaria"))
			btnIngresarATurno.setEnabled(false);
		btnIngresarATurno.addActionListener(e -> {
			try {
				ingresaTurno();
			} catch (final IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnIngresarATurno.setHorizontalAlignment(SwingConstants.LEFT);
		btnIngresarATurno.setIcon(new ImageIcon(PantaListaTurnos.class.getResource("/imagenes/iconos/twentytwo/clipboard.png")));
		final GridBagConstraints gbc_btnIngresarATurno = new GridBagConstraints();
		gbc_btnIngresarATurno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIngresarATurno.insets = new Insets(0, 0, 5, 5);
		gbc_btnIngresarATurno.gridx = 21;
		gbc_btnIngresarATurno.gridy = 2;
		contentPane.add(btnIngresarATurno, gbc_btnIngresarATurno);

		btnMarcarIngresado = new JButton("Marcar Ingresado");
		btnMarcarIngresado.addActionListener(e -> {
			try {
				seleccionaTurno();
			} catch (final IOException e1) {
				try {
					Log.crearLog(e1.toString());
				} catch (final IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				e1.printStackTrace();
			}
		});
		btnMarcarIngresado.setHorizontalAlignment(SwingConstants.LEFT);
		btnMarcarIngresado.setIcon(new ImageIcon(PantaListaTurnos.class.getResource("/imagenes/iconos/twentytwo/check.png")));
		final GridBagConstraints gbc_btnMarcarIngresado = new GridBagConstraints();
		gbc_btnMarcarIngresado.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMarcarIngresado.insets = new Insets(0, 0, 5, 5);
		gbc_btnMarcarIngresado.gridx = 21;
		gbc_btnMarcarIngresado.gridy = 3;
		contentPane.add(btnMarcarIngresado, gbc_btnMarcarIngresado);

		final Calendar c2 = new GregorianCalendar();
		new SimpleDateFormat("dd/MM/yyyy");

		btnNuevoTurno = new JButton("Nuevo Turno");
		btnNuevoTurno.addActionListener(e -> {
			final PantaNuevoTurno pnt = new PantaNuevoTurno();
			pnt.setVisible(true);
		});
		btnNuevoTurno.setHorizontalAlignment(SwingConstants.LEFT);
		btnNuevoTurno.setIcon(new ImageIcon(PantaListaTurnos.class.getResource("/imagenes/iconos/twentytwo/bell-o.png")));
		final GridBagConstraints gbc_btnNuevoTurno = new GridBagConstraints();
		btnNuevoTurno.setEnabled(true);
		if(perfil.equals("Medico"))
			btnNuevoTurno.setVisible(false);
		gbc_btnNuevoTurno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNuevoTurno.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevoTurno.gridx = 21;
		gbc_btnNuevoTurno.gridy = 4;
		contentPane.add(btnNuevoTurno, gbc_btnNuevoTurno);
		dateChooser = new JDateChooser();
		dateChooser.setCalendar(c2);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 21;
		gbc_dateChooser.gridy = 5;
		contentPane.add(dateChooser, gbc_dateChooser);
	}

	public String getEspecialista() {
		return especialista;
	}

	public void ingresaTurno() throws IOException {
		@SuppressWarnings("rawtypes")
		final
		SwingWorker worker = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				try {
					final int fila = table.getSelectedRow();
					ListaTurnos.get(table.convertRowIndexToModel(fila)).getEstados().getEstado();
					final int Estado = ListaTurnos.get(table.convertRowIndexToModel(fila)).getEstados().getId();
					final Turnos turnos = ListaTurnos.get(table.getSelectedRow());
					final Paciente paciente = GestorPacientes.ConsultarPaciente(ListaTurnos.get(table.convertRowIndexToModel(fila)).getPacienteApellido()).get(0);
					Log.crearLog("Cambio de turno fecha "+fechaTurno+",paciente "+paciente);
					final int tres = 3;
					if (Estado < tres)
					{
						GestorTurnos.ActualizaEstado(turnos.getPaciente());
						new PantaAdminPaciente(paciente).setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(new JDialog(), Errores.turnoyapasado(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}
				catch (final Exception e)
				{
					Log.crearLog(e.getMessage().toString());
				}
				return null;
			}
		};
		worker.execute();

	}

	private void llenarLista() {
		fechaTurno = dateChooser.getDate();
		final java.sql.Date sqlDate = new java.sql.Date(fechaTurno.getTime());
		
		ListaTurnos = GestorTurnos.ConsultarTurno(especialista, sqlDate);
		final DefaultTableModel df = new DefaultTableModel();
		df.setColumnIdentifiers(columnNames);
		final Object[] fila = new Object[df.getColumnCount()];
		if (ListaTurnos.size() == 0)
		{
			JOptionPane.showMessageDialog(null, "No hay turnos para esta fecha", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			for (int i = 0; i < ListaTurnos.size(); i++) {
				fila[0] = ListaTurnos.get(i).getHoraTurno();
				fila[1] = ListaTurnos.get(i).getPacienteApellido() + "   " + ListaTurnos.get(i).getPacienteNombre();
				fila[2] = ListaTurnos.get(i).getEstados().getEstado();
				df.addRow(fila);
			}
			table.setModel(df);
		}
	}
	public void seleccionaTurno() throws IOException {
		@SuppressWarnings("rawtypes")
		final
		SwingWorker worker = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				try {
					final int fila = table.getSelectedRow();
					ListaTurnos.get(table.convertRowIndexToModel(fila)).getEstados().getEstado();
					final int Estado = ListaTurnos.get(table.convertRowIndexToModel(fila)).getEstados().getId();
					final Turnos turnos = ListaTurnos.get(table.getSelectedRow());
					Log.crearLog("Cambio de turno fecha "+fechaTurno+",paciente "+paciente);
					final int tres = 3;
					if (Estado < tres)
						GestorTurnos.ActualizaEstado(turnos.getPaciente());
					else
						JOptionPane.showMessageDialog(null, Errores.turnoyapasado(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
				} catch (final Exception e) {
					Log.crearLog(e.getMessage().toString());
				}
				return null;
			}
		};
		worker.execute();
	}

	public void setEspecialista(String especialista) {
		this.especialista = especialista;
	}

}

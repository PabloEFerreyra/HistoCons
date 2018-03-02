package com.historiasclinicas.pantallas;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.ejecucion.CanConvert;
import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorHorarios;
import com.historiasclinicas.gestores.GestorPacientes;
import com.historiasclinicas.gestores.GestorTurnos;
import com.historiasclinicas.gestores.GestorUsuarios;
import com.historiasclinicas.log.Log;
import com.toedter.calendar.JDateChooser;

public class PantaNuevoTurno extends JFrame {

	private static final long serialVersionUID = -671078374293582133L;
	private JButton btnBuscarTurnosActivos;
	private JComboBox<Object> cmbEspecialista;
	private JComboBox<Object> comboBox;
	private JPanel contentPane;

	private JDateChooser dateChooser;
	private DateFormat df1;
	private Integer dni;
	private String[] listaEspecialista;
	private String[] listaHorarios;
	private JMenuItem mntmSalir;
	public List<Paciente> paciente;
	public PantaAnadirPacienteTurnos pap;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtNombre;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PantaNuevoTurno() {
		listaEspecialista = GestorUsuarios.TraeNombreUsuarios();
		listaHorarios = GestorHorarios.ConsultarHorarios();
		setTitle("Ingreso Nuevo Turno");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaNuevoTurno.class.getResource("/imagenes/logotipo.png")));

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 863, 316);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(arg0 -> System.exit(0));
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 29, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		final JLabel lblAgregarTurno = new JLabel("Agregar Turno");
		lblAgregarTurno.setIcon(new ImageIcon(PantaNuevoTurno.class.getResource("/imagenes/iconos/calendar-plus-o.png")));
		final GridBagConstraints gbc_lblAgregarTurno = new GridBagConstraints();
		gbc_lblAgregarTurno.anchor = GridBagConstraints.WEST;
		gbc_lblAgregarTurno.gridwidth = 7;
		gbc_lblAgregarTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarTurno.gridx = 1;
		gbc_lblAgregarTurno.gridy = 0;
		contentPane.add(lblAgregarTurno, gbc_lblAgregarTurno);

		final JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PantaNuevoTurno.class.getResource("/imagenes/logotipo.png")));
		final GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridwidth = 6;
		gbc_label.gridx = 10;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);

		final JLabel lblDni = new JLabel("DNI");
		lblDni.setIcon(new ImageIcon(PantaNuevoTurno.class.getResource("/imagenes/iconos/twentytwo/user.png")));
		final GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 1;
		contentPane.add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		final GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.gridwidth = 4;
		gbc_txtDni.insets = new Insets(0, 0, 5, 5);
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 1;
		contentPane.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);

		final JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setIcon(new ImageIcon(PantaNuevoTurno.class.getResource("/imagenes/iconos/twentytwo/user.png")));
		final GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 6;
		gbc_lblApellido.gridy = 1;
		contentPane.add(lblApellido, gbc_lblApellido);

		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		final GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 6;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 7;
		gbc_txtApellido.gridy = 1;
		contentPane.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);

		final JButton btnBuscar = new JButton("Buscar Paciente");
		btnBuscar.addActionListener(e -> {
			final Integer dni = Integer.parseInt(txtDni.getText());
			txtDni.setEditable(false);
			paciente = GestorPacientes.ConsultaInexistencia(dni);
			if (paciente == null)
			{
				JOptionPane.showMessageDialog(new JDialog(), Errores.dnipacientenoexistente(), "Error", JOptionPane.ERROR_MESSAGE);
				pap = new PantaAnadirPacienteTurnos(txtDni.getText());
				pap.setVisible(true);
				dispose();
			}
			else
			{
				txtApellido.setText(paciente.get(0).getApellido().toString());
				txtNombre.setText(paciente.get(0).getNombre().toString());
				txtDni.setEditable(true);
			}
		});
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);

		btnBuscar.setIcon(new ImageIcon(PantaNuevoTurno.class.getResource("/imagenes/iconos/twentytwo/search.png")));
		final GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.BOTH;
		gbc_btnBuscar.gridwidth = 2;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 13;
		gbc_btnBuscar.gridy = 1;
		contentPane.add(btnBuscar, gbc_btnBuscar);

		final JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setIcon(new ImageIcon(PantaNuevoTurno.class.getResource("/imagenes/iconos/twentytwo/user.png")));
		final GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		contentPane.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		final GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 4;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		final JLabel lblEspecialista = new JLabel("Especialista");
		final GridBagConstraints gbc_lblEspecialista = new GridBagConstraints();
		gbc_lblEspecialista.fill = GridBagConstraints.VERTICAL;
		gbc_lblEspecialista.anchor = GridBagConstraints.WEST;
		gbc_lblEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecialista.gridx = 6;
		gbc_lblEspecialista.gridy = 2;
		contentPane.add(lblEspecialista, gbc_lblEspecialista);

		cmbEspecialista = new JComboBox();
		cmbEspecialista.setModel(new DefaultComboBoxModel(listaEspecialista));
		final GridBagConstraints gbc_cmbEspecialista = new GridBagConstraints();
		gbc_cmbEspecialista.gridwidth = 6;
		gbc_cmbEspecialista.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEspecialista.fill = GridBagConstraints.BOTH;
		gbc_cmbEspecialista.gridx = 7;
		gbc_cmbEspecialista.gridy = 2;
		contentPane.add(cmbEspecialista, gbc_cmbEspecialista);

		final JLabel lblFechaTurno = new JLabel("Fecha Turno");
		final GridBagConstraints gbc_lblFechaTurno = new GridBagConstraints();
		gbc_lblFechaTurno.anchor = GridBagConstraints.WEST;
		gbc_lblFechaTurno.fill = GridBagConstraints.VERTICAL;
		gbc_lblFechaTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaTurno.gridx = 1;
		gbc_lblFechaTurno.gridy = 4;
		contentPane.add(lblFechaTurno, gbc_lblFechaTurno);

		final Calendar c2 = new GregorianCalendar();
		setDf1(new SimpleDateFormat("dd/MM/yyyy"));

		dateChooser = new JDateChooser();
		final GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 4;
		dateChooser = new JDateChooser();
		dateChooser.setCalendar(c2);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		contentPane.add(dateChooser, gbc_dateChooser);

		final JLabel lblHoraTurno = new JLabel("Hora Turno");
		final GridBagConstraints gbc_lblHoraTurno = new GridBagConstraints();
		gbc_lblHoraTurno.anchor = GridBagConstraints.EAST;
		gbc_lblHoraTurno.fill = GridBagConstraints.VERTICAL;
		gbc_lblHoraTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblHoraTurno.gridx = 6;
		gbc_lblHoraTurno.gridy = 4;
		contentPane.add(lblHoraTurno, gbc_lblHoraTurno);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(listaHorarios));
		final GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 7;
		gbc_comboBox.gridy = 4;
		contentPane.add(comboBox, gbc_comboBox);

		btnBuscarTurnosActivos = new JButton("Agregar Turno");
		btnBuscarTurnosActivos.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarTurnosActivos.setToolTipText("buscar turnos y agregar el actual");
		btnBuscarTurnosActivos.addActionListener(e -> {

			try {
				ConfirmaHayTurnos();
			} catch (final IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnBuscarTurnosActivos.setIcon(new ImageIcon(PantaNuevoTurno.class.getResource("/imagenes/iconos/twentytwo/calendar-times-o.png")));
		final GridBagConstraints gbc_btnBuscarTurnosActivos = new GridBagConstraints();
		gbc_btnBuscarTurnosActivos.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscarTurnosActivos.gridwidth = 2;
		gbc_btnBuscarTurnosActivos.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarTurnosActivos.gridx = 13;
		gbc_btnBuscarTurnosActivos.gridy = 4;
		contentPane.add(btnBuscarTurnosActivos, gbc_btnBuscarTurnosActivos);
		txtDni.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary()) {
					boolean valido = false;
					try {
						valido = CanConvert.Convert(txtDni.getText());
					} catch (NumberFormatException | HeadlessException e1) {
						try {
							Log.CreaLog(e1.toString());
						} catch (final IOException e2) {
							e2.printStackTrace();
						}
					}
					if (valido == false){
						JOptionPane.showMessageDialog(new JDialog(), Errores.dninumeros(), "Error", JOptionPane.ERROR_MESSAGE);
						txtDni.requestFocus();
					}
				}
			}
		});

	}

	private void ConfirmaHayTurnos() throws IOException {
		dni = Integer.parseInt(txtDni.getText());
		final Date fecha = dateChooser.getDate();
		final java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
		final String especialista = cmbEspecialista.getSelectedItem().toString();
		final String horario = comboBox.getSelectedItem().toString();
		final boolean eActivos = GestorTurnos.ConsultarTurnosPasados(dni);
		if (eActivos){
			final int realizado = GestorTurnos.NuevoTurno(dni, sqlDate, especialista, horario);
			if (realizado == 1){
				JOptionPane.showMessageDialog(new JDialog(), "Paciente Ingresado con éxito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
			else
				JOptionPane.showMessageDialog(new JDialog(), "Ocurrió un error, revise su conexion a internet y repita operación", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{
			final int reply = JOptionPane.showConfirmDialog(new JDialog(), "Desea cerrar los turnos previos?","Se han encontrado turnos sin cerrar", JOptionPane.YES_NO_OPTION );
			if (reply == JOptionPane.YES_OPTION)
			{
				GestorTurnos.CierraTurnos(dni);
				ConfirmaHayTurnos();
			}
			else
			{
				JOptionPane.showMessageDialog(new JDialog(), "No vas a poder asignar un turno si no cancelas el anterior", "Informacion", JOptionPane.INFORMATION_MESSAGE );
				ConfirmaHayTurnos();
			}
		}
	}

	public DateFormat getDf1() {
		return df1;
	}
	public void setDf1(DateFormat df1) {
		this.df1 = df1;
	}

}

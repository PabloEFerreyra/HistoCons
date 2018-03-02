package com.historiasclinicas.pantallas;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorPacientes;
import com.historiasclinicas.log.Log;

public class PantaPacientes extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String apellido;
	public String Apellido;
	private final JButton btnBuscar;
	private final JButton btnMostrar;
	String[] columnNames = { "DNI", "Apellido", "Nombre" };
	private final JPanel contentPane;
	public String DNI;
	private final JLabel lblLeyendoBaseDe;

	private final JLabel lblNewLabel;
	private List<Paciente> ListaPacientes = null;
	private final JMenuBar menuBar;
	private final JMenu mnArchivo;
	private final JMenuItem mntmSalir;
	public String Nombre;
	private final JScrollPane scrollPane;
	private final JTable table;
	private final JTextField txtApellido;

	public PantaPacientes() throws IOException {
		Log.crearLog("Ingreso Correcto a pantalla de pacientes");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			Log.CreaLog(e1.toString());
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaPacientes.class.getResource("/imagenes/logotipo.png")));
		setTitle("Busqueda Pacientes");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1359, 754);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/iconos/twentytwo/archive.png")));
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/iconos/twentytwo/close.png")));
		mntmSalir.addActionListener(arg0 -> System.exit(0));
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 16, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 38, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		lblNewLabel = new JLabel("Busqueda de pacientes");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 12));
		lblNewLabel.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/iconos/search.png")));
		final GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				final int key = e.getKeyCode();
				if (e.getSource() == txtApellido)
					if (key == KeyEvent.VK_ENTER) {
						llenarTabla();
					}
			}
		});

		lblLeyendoBaseDe = new JLabel("");
		final GridBagConstraints gbc_lblLeyendoBaseDe = new GridBagConstraints();
		gbc_lblLeyendoBaseDe.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblLeyendoBaseDe.insets = new Insets(0, 0, 5, 0);
		gbc_lblLeyendoBaseDe.gridx = 4;
		gbc_lblLeyendoBaseDe.gridy = 0;
		contentPane.add(lblLeyendoBaseDe, gbc_lblLeyendoBaseDe);
		lblLeyendoBaseDe.setFont(new Font("Trebuchet MS", Font.PLAIN, 8));

		txtApellido.setToolTipText("Ingrese apellido a buscar");
		final GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 1;
		contentPane.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscar.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/iconos/twentytwo/search.png")));
		btnBuscar.addActionListener(arg0 -> {
			llenarTabla();
		});
		final GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 1;
		contentPane.add(btnBuscar, gbc_btnBuscar);

		final JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregar.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/iconos/twentytwo/save.png")));
		btnAgregar.addActionListener(arg0 -> {
			final PantaAnadirPaciente pap = new PantaAnadirPaciente();
			pap.setVisible(true);
			dispose();
		});
		final GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 4;
		gbc_btnAgregar.gridy = 1;
		contentPane.add(btnAgregar, gbc_btnAgregar);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"DNI", "Apellido", "Nombre"
				}
				));

		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		llenarTabla();

		btnMostrar = new JButton("Ingresar a paciente");
		btnMostrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnMostrar.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/iconos/twentytwo/users.png")));
		btnMostrar.addActionListener(arg0 -> {

			try {
				seleccionaPaciente();
			} catch (final IOException e) {
				try {
					Log.CreaLog(e.toString());
				} catch (final IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		});
		final GridBagConstraints gbc_btnMostrar = new GridBagConstraints();
		gbc_btnMostrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMostrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnMostrar.anchor = GridBagConstraints.NORTH;
		gbc_btnMostrar.gridx = 4;
		gbc_btnMostrar.gridy = 2;
		contentPane.add(btnMostrar, gbc_btnMostrar);
	}

	public List<Paciente> getListaPacientes() {
		return ListaPacientes;
	}

	public boolean isCellEditable(int rowIndex, int vColIndex) {
		return false;
	}

	@SuppressWarnings("rawtypes")
	private void llenarTabla() {
		final SwingWorker worker = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				lblLeyendoBaseDe.setText("leyendo base de datos...");
				apellido = txtApellido.getText();
				final DefaultTableModel df = new DefaultTableModel();
				ListaPacientes = GestorPacientes.ConsultarPaciente(apellido);
				if(!ListaPacientes.isEmpty())
				{
					df.setColumnIdentifiers(columnNames);
					final Object[] fila = new Object[df.getColumnCount()];
					for (int i = 0; i < ListaPacientes.size(); i++) {
						fila[0] = ListaPacientes.get(i).getDni().toString();
						fila[1] = ListaPacientes.get(i).getApellido();
						fila[2] = ListaPacientes.get(i).getNombre();
						df.addRow(fila);
					}
					lblLeyendoBaseDe.setText("");
					table.setModel(df);
				}
				else
					JOptionPane.showMessageDialog(new JDialog(), "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		};
		worker.execute();
		txtApellido.setEditable(true);
		lblLeyendoBaseDe.setVisible(false);
	}

	public void seleccionaPaciente() throws IOException {
		try {
			final int fila = table.getSelectedRow();
			final Paciente pacientes = ListaPacientes.get(table.convertRowIndexToModel(fila));
			Log.crearLog("LLamada Correcta a paciente seleccionado");
			lblLeyendoBaseDe.setText("Ingresando a paciente...");
			lblLeyendoBaseDe.setVisible(true);
			new PantaAdminPaciente(pacientes).setVisible(true);
			dispose();
		} catch (final Exception e) {

		}

	}

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		ListaPacientes = listaPacientes;
	}
}

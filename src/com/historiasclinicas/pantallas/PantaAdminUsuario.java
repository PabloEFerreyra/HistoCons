package com.historiasclinicas.pantallas;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.entidades.Usuarios;
import com.historiasclinicas.gestores.GestorUsuarios;
import com.historiasclinicas.log.Log;

public class PantaAdminUsuario extends JFrame {

	private static final long serialVersionUID = -6890276574269263350L;
	private final JButton btnBackupDb;
	private final JButton btnCerrar;
	private final JButton btnInforme;
	private final JButton btnIngresarALog;
	private final JButton btnNewButton;
	private final JButton btnNuevo;
	private final JPanel contentPane;
	private final JList<Object> list;
	private List<Usuarios> ListaUsuarios = null;


	public PantaAdminUsuario() {
		setResizable(false);
		ListaUsuarios = GestorUsuarios.TraeUsuarios();
		setTitle("Area Administracion Usuarios");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(PantaAdminUsuario.class.getResource("/imagenes/logotipo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (final InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (final IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (final UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setBounds(100, 100, 743, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 554, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 50, 33, 35, 31, 0, 0, 32, 0, 16, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);


		final DefaultListModel<Object> df = new DefaultListModel<>();

		for (int i = 0; i < ListaUsuarios.size(); i++) {
			final Usuarios us = ListaUsuarios.get(i);
			df.addElement(us.getNombre() + " " + us.getApellido()+ " | " + us.getUsername() + " | " + us.getIsactive() + " | " + us.getPerfil());
		}

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		list.setModel(df);
		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (e.getClickCount() == 2)
					try {
						AbrirModificarUsuario();

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

		final JLabel lblUsuarioContrasea = new JLabel("Usuario | Activo | Perfil | Especialidad");
		scrollPane.setColumnHeaderView(lblUsuarioContrasea);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		btnNuevo.addActionListener(e -> {
			try {
				new PantaAnadirUsuario(null).setVisible(true);
			} catch (final IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
		});
		btnNuevo.setIcon(new ImageIcon(PantaAdminUsuario.class.getResource("/imagenes/iconos/twentytwo/user-plus.png")));
		final GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.fill = GridBagConstraints.BOTH;
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 0);
		gbc_btnNuevo.gridx = 2;
		gbc_btnNuevo.gridy = 1;
		contentPane.add(btnNuevo, gbc_btnNuevo);

		btnNewButton = new JButton("Modificar");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(e -> AbrirModificarUsuario());
		btnNewButton.setIcon(new ImageIcon(PantaAdminUsuario.class.getResource("/imagenes/iconos/twentytwo/user-md.png")));
		final GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCerrar.addActionListener(e -> System.exit(0));
		btnCerrar.setIcon(new ImageIcon(PantaAdminUsuario.class.getResource("/imagenes/iconos/twentytwo/remove.png")));
		final GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.fill = GridBagConstraints.BOTH;
		gbc_btnCerrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCerrar.gridx = 2;
		gbc_btnCerrar.gridy = 3;
		contentPane.add(btnCerrar, gbc_btnCerrar);

		btnInforme = new JButton("Generar Informe");
		btnInforme.setHorizontalAlignment(SwingConstants.LEFT);
		btnInforme.addActionListener(arg0 -> {
			final PantaInformesAdmin pia = new PantaInformesAdmin();
			pia.setVisible(true);
		});
		btnInforme.setIcon(new ImageIcon(PantaAdminUsuario.class.getResource("/imagenes/iconos/twentytwo/bar-chart.png")));
		final GridBagConstraints gbc_btnInforme = new GridBagConstraints();
		gbc_btnInforme.fill = GridBagConstraints.BOTH;
		gbc_btnInforme.insets = new Insets(0, 0, 5, 0);
		gbc_btnInforme.gridx = 2;
		gbc_btnInforme.gridy = 4;
		contentPane.add(btnInforme, gbc_btnInforme);

		btnIngresarALog = new JButton("Ingresar a log");
		btnIngresarALog.addActionListener(e -> {
			final File exit = new File("C:\\ProgramData\\HistoriasClinicas");
			try {
				Desktop.getDesktop().open(exit);
			} catch (final IOException e1) {
				e1.printStackTrace();
			}
		});
		btnIngresarALog.setHorizontalAlignment(SwingConstants.LEFT);
		btnIngresarALog.setIcon(new ImageIcon(PantaAdminUsuario.class.getResource("/imagenes/iconos/twentytwo/angle-double-down.png")));
		final GridBagConstraints gbc_btnIngresarALog = new GridBagConstraints();
		gbc_btnIngresarALog.fill = GridBagConstraints.BOTH;
		gbc_btnIngresarALog.insets = new Insets(0, 0, 5, 0);
		gbc_btnIngresarALog.gridx = 2;
		gbc_btnIngresarALog.gridy = 5;
		contentPane.add(btnIngresarALog, gbc_btnIngresarALog);

		btnBackupDb = new JButton("Backup DB");
		btnBackupDb.setHorizontalAlignment(SwingConstants.LEFT);
		btnBackupDb.addActionListener(arg0 -> {
			try{
				Runtime.getRuntime().exec("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\backup\\backup.exe");
				JOptionPane.showMessageDialog(new JDialog(),"Backup Correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(final IOException e)
			{
				JOptionPane.showMessageDialog(new JDialog(),"Error Interno", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		final GridBagConstraints gbc_btnBackupDb = new GridBagConstraints();
		gbc_btnBackupDb.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBackupDb.insets = new Insets(0, 0, 5, 0);
		gbc_btnBackupDb.gridx = 2;
		gbc_btnBackupDb.gridy = 6;
		contentPane.add(btnBackupDb, gbc_btnBackupDb);
	}

	public void AbrirModificarUsuario() {
		ListaUsuarios.get(list.getSelectedIndex()).getUsername();
		ListaUsuarios.get(list.getSelectedIndex()).getPassword();
		ListaUsuarios.get(list.getSelectedIndex()).getIsactive();
		ListaUsuarios.get(list.getSelectedIndex()).getPerfil();
		final Usuarios usuarios = ListaUsuarios.get(list.getSelectedIndex());

		PantaModificaUsuario pmu = null;
		try {
			pmu = new PantaModificaUsuario(usuarios);
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pmu.setVisible(true);
		dispose();
	}
}
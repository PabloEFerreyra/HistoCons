package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.historiasclinicas.entidades.Usuarios;
import com.historiasclinicas.gestores.GestorLogin;
import com.historiasclinicas.log.Log;

public class PantaLogin extends JFrame {

	public static List<Usuarios> perfil;
	private static final long serialVersionUID = 1L;
	public static String usuario;
	private final JButton btnCancelar;
	private final JButton btnIngresar;
	private final JPanel contentPane;
	private final JLabel ingresolbl;
	private final JPasswordField jpassClave_1;
	private final JLabel lblNewLabel;
	private final JLabel lblNewLabel_1;
	private final JMenuBar menuBar;
	private final JPanel panel_1;
	private final JTextField txtUsuario_1;

	public PantaLogin() {
		super();
		setType(Type.POPUP);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaLogin.class.getResource("/imagenes/logotipo.png")));
		setTitle("Login Historias Clinicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (final InstantiationException e1) {
			e1.printStackTrace();
		} catch (final IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (final UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setBounds(100, 100, 277, 339);

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);

		final JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(PantaLogin.class.getResource("/imagenes/iconos/twentytwo/question-circle.png")));
		menuBar.add(mnAyuda);

		final JMenuItem mntmTestConexion = new JMenuItem("Test Conexion");
		mntmTestConexion.setIcon(new ImageIcon(PantaLogin.class.getResource("/imagenes/iconos/twentytwo/plug.png")));
		mntmTestConexion.addActionListener(arg0 -> new PruebaConexion().setVisible(true));
		mnAyuda.add(mntmTestConexion);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 349, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		final JPanel panel = new JPanel();
		panel.setBorder(null);
		final GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{120, 120};
		gbl_panel.rowHeights = new int[]{0, 26, 30, 28, 28, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\Imagenes\\logotipo.png"));
		final GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblNewLabel = new JLabel("Login Historias Clinicas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		final GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		txtUsuario_1 = new JTextField();
		txtUsuario_1.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_txtUsuario_1 = new GridBagConstraints();
		gbc_txtUsuario_1.gridwidth = 2;
		gbc_txtUsuario_1.fill = GridBagConstraints.BOTH;
		gbc_txtUsuario_1.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuario_1.gridx = 0;
		gbc_txtUsuario_1.gridy = 2;
		panel.add(txtUsuario_1, gbc_txtUsuario_1);
		txtUsuario_1.setToolTipText("Ingrese Usuario");
		txtUsuario_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtUsuario_1.setColumns(10);
		txtUsuario_1.setBorder(null);

		jpassClave_1 = new JPasswordField();
		jpassClave_1.setBorder(null);
		final GridBagConstraints gbc_jpassClave_1 = new GridBagConstraints();
		gbc_jpassClave_1.gridwidth = 2;
		gbc_jpassClave_1.fill = GridBagConstraints.BOTH;
		gbc_jpassClave_1.insets = new Insets(0, 0, 5, 0);
		gbc_jpassClave_1.gridx = 0;
		gbc_jpassClave_1.gridy = 3;
		panel.add(jpassClave_1, gbc_jpassClave_1);
		jpassClave_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				final int key = e.getKeyCode();
				if (e.getSource() == jpassClave_1)
					if (key == KeyEvent.VK_ENTER) {
						try {
							Log.crearLog("Tecla Ingresada: " + "info " + key);
						} catch (final IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

						try {
							Ingreso();
						} catch (final IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			}
		});
		jpassClave_1.setToolTipText("Ingrese Contrase\u00F1a");
		jpassClave_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jpassClave_1.setEchoChar('*');

		panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.setBorder(null);
		final GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);

		ingresolbl = new JLabel("");
		panel_1.add(ingresolbl);
		ingresolbl.setBackground(Color.WHITE);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(arg0 -> {
			try {
				Log.CreaLog("Cancelado Inicio de sesion");
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(1);
		});

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(SystemColor.control);
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setSelectedIcon(new ImageIcon(PantaLogin.class.getResource("/imagenes/iconos/bell.png")));
		btnIngresar.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnIngresar = new GridBagConstraints();
		gbc_btnIngresar.fill = GridBagConstraints.BOTH;
		gbc_btnIngresar.insets = new Insets(0, 0, 0, 5);
		gbc_btnIngresar.gridx = 0;
		gbc_btnIngresar.gridy = 5;
		panel.add(btnIngresar, gbc_btnIngresar);
		btnIngresar.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnIngresar.setIcon(new ImageIcon(PantaLogin.class.getResource("/imagenes/iconos/twentytwo/heartbeat.png")));
		btnIngresar.addActionListener(e -> {
			try {
				Ingreso();
			} catch (final IOException e1) {
				ingresolbl.setText("Error Interno");
				botonera();
				e1.printStackTrace();
				try {
					Log.CreaLog(e1.toString());
				} catch (final IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelar.setIcon(new ImageIcon(PantaLogin.class.getResource("/imagenes/iconos/twentytwo/close.png")));
		final GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 5;
		panel.add(btnCancelar, gbc_btnCancelar);
	}

	public void botonera ()
	{
		txtUsuario_1.setEditable(true);
		jpassClave_1.setEditable(true);
		btnCancelar.setEnabled(false);
		btnIngresar.setEnabled(true);
	}

	@SuppressWarnings("rawtypes")
	private void Ingreso() throws IOException {
		btnIngresar.setEnabled(false);
		jpassClave_1.setEditable(false);
		usuario = txtUsuario_1.getText();
		final String clave = String.valueOf(jpassClave_1.getPassword());
		final SwingWorker worker = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				perfil = null;
				while (perfil == null){
					txtUsuario_1.setEditable(false);
					panel_1.setVisible(true);
					ingresolbl.setText("ingresando...");
					btnCancelar.setEnabled(true);
					perfil = GestorLogin.validar_ingreso(usuario.toString(), clave);
				}
				if (perfil.size() != 0)
				{
					ingresolbl.setText("Bienvenido!");
					try {
						if (perfil.get(0).getPerfil().equals("Admin")) {
							Log.crearLog("Inicio de sesion usuario: " + usuario + " - " + "Perfil: " + perfil.get((0)).getPerfil());
							final PantaAdminUsuario pau = new PantaAdminUsuario();
							pau.setVisible(true);
							dispose();
						} else {
							Log.crearLog("Inicio de sesion usuario: " + usuario + " - " + "Perfil: " + perfil.get((0)).getPerfil());
							new Menu().setVisible(true);
							dispose();
						}
					} catch (final Exception e) {
						System.out.println(e);
						Log.crearLog(e.toString());
					}
				}
				else{
					botonera();
					ingresolbl.setText("Revise datos Ingreso");
				}
				return null;
			}
		};
		worker.execute();
	}
}

package com.historiasclinicas.pantallas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.ejecucion.Ejecucion;
import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Usuarios;
import com.historiasclinicas.log.Log;

public class PantaAnadirUsuario extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -7010662155793902563L;
	private final JButton btnCerrar;
	private final JButton btnGuardar;
	private final JComboBox<?> cmbEspecialidad;
	private final JPanel contentPane;
	private final JTextField txtApellido;
	private final JTextField txtMatricula;
	private final JTextField txtNombre;
	private final JTextField txtPassword;
	private final JTextField txtUsuario;

	/**
	 * Create the frame.
	 *
	 * @param usuarios
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PantaAnadirUsuario(Usuarios usuarios) throws IOException {

		Log.crearLog("El Usuario Administrativo Ingreso a La pantalla de nuevos usuarios");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Log.CreaLog(e1.toString());
		}

		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Agregar Usuario");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		final JLabel lblModificarUsuario = new JLabel("Agregar Usuario");
		lblModificarUsuario
		.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/user-plus.png")));
		lblModificarUsuario.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 14));
		final GridBagConstraints gbc_lblModificarUsuario = new GridBagConstraints();
		gbc_lblModificarUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblModificarUsuario.gridwidth = 5;
		gbc_lblModificarUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificarUsuario.gridx = 1;
		gbc_lblModificarUsuario.gridy = 0;
		contentPane.add(lblModificarUsuario, gbc_lblModificarUsuario);

		final JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/twentytwo/user.png")));
		final GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		final GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 4;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		final JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/twentytwo/user.png")));
		final GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.anchor = GridBagConstraints.WEST;
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 2;
		contentPane.add(lblApellido, gbc_lblApellido);

		txtApellido = new JTextField();
		final GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 4;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 2;
		contentPane.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);

		final JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/twentytwo/user.png")));
		final GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 3;
		contentPane.add(lblUsuario, gbc_lblUsuario);

		txtUsuario = new JTextField();
		final GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 4;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 3;
		contentPane.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		txtUsuario.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary())
					if (txtUsuario.getText().equals("")) {
						try {
							Log.CreaLog(Errores.UsuarioPassIncorrecto().toString());
						} catch (final IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(new JDialog(), Errores.UsuarioPassIncorrecto(), "Error", JOptionPane.ERROR_MESSAGE);
						txtUsuario.requestFocus();
					}
			}
		});

		final JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/twentytwo/key.png")));
		final GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		contentPane.add(lblContrasea, gbc_lblContrasea);

		txtPassword = new JTextField();
		final GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.gridwidth = 4;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 4;
		contentPane.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		txtPassword.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!e.isTemporary())
					if (txtUsuario.getText().equals("")) {
						try {
							Log.crearLog(Errores.UsuarioPassIncorrecto() + "Error Contraseña ingresada para nuevo usuario");
						} catch (final IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(new JDialog(), Errores.UsuarioPassIncorrecto(), "Error", JOptionPane.ERROR_MESSAGE);
						txtPassword.requestFocus();
					}
			}
		});

		final JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/twentytwo/group.png")));
		final GridBagConstraints gbc_lblPerfil = new GridBagConstraints();
		gbc_lblPerfil.anchor = GridBagConstraints.WEST;
		gbc_lblPerfil.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerfil.gridx = 1;
		gbc_lblPerfil.gridy = 5;
		contentPane.add(lblPerfil, gbc_lblPerfil);

		final JComboBox<String> cmbPerfil = new JComboBox<>();
		final GridBagConstraints gbc_cmbPerfil = new GridBagConstraints();
		gbc_cmbPerfil.gridwidth = 4;
		gbc_cmbPerfil.insets = new Insets(0, 0, 5, 5);
		gbc_cmbPerfil.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPerfil.gridx = 2;
		gbc_cmbPerfil.gridy = 5;
		contentPane.add(cmbPerfil, gbc_cmbPerfil);
		cmbPerfil.addItem("Medico");
		cmbPerfil.addItem("Admin");
		cmbPerfil.addItem("Secretario");
		cmbPerfil.setSelectedItem("Medico");

		final JLabel lblActivo = new JLabel("Activo");
		lblActivo.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/twentytwo/bell-o.png")));
		final GridBagConstraints gbc_lblActivo = new GridBagConstraints();
		gbc_lblActivo.anchor = GridBagConstraints.WEST;
		gbc_lblActivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblActivo.gridx = 1;
		gbc_lblActivo.gridy = 6;
		contentPane.add(lblActivo, gbc_lblActivo);

		final JComboBox<String> cmbActivo = new JComboBox<>();
		final GridBagConstraints gbc_cmbActivo = new GridBagConstraints();
		gbc_cmbActivo.gridwidth = 4;
		gbc_cmbActivo.insets = new Insets(0, 0, 5, 5);
		gbc_cmbActivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbActivo.gridx = 2;
		gbc_cmbActivo.gridy = 6;
		contentPane.add(cmbActivo, gbc_cmbActivo);
		cmbActivo.addItem("SI");
		cmbActivo.addItem("NO");
		cmbActivo.setSelectedItem("SI");

		

		final JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/twentytwo/user-md.png")));
		final GridBagConstraints gbc_lblEspecialidad = new GridBagConstraints();
		gbc_lblEspecialidad.anchor = GridBagConstraints.EAST;
		gbc_lblEspecialidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecialidad.gridx = 1;
		gbc_lblEspecialidad.gridy = 7;
		contentPane.add(lblEspecialidad, gbc_lblEspecialidad);

		cmbEspecialidad = new JComboBox();
		cmbEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"General", "Pediatra", ""}));
		cmbEspecialidad.setSelectedIndex(2);
		final GridBagConstraints gbc_cmbEspecialidad = new GridBagConstraints();
		gbc_cmbEspecialidad.gridwidth = 4;
		gbc_cmbEspecialidad.insets = new Insets(0, 0, 5, 5);
		gbc_cmbEspecialidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEspecialidad.gridx = 2;
		gbc_cmbEspecialidad.gridy = 7;
		contentPane.add(cmbEspecialidad, gbc_cmbEspecialidad);
		
		final JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_lblMatricula = new GridBagConstraints();
		gbc_lblMatricula.anchor = GridBagConstraints.EAST;
		gbc_lblMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatricula.gridx = 1;
		gbc_lblMatricula.gridy = 8;
		contentPane.add(lblMatricula, gbc_lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setEditable(false);
		txtMatricula.setText("0");
		if(cmbPerfil.getSelectedItem() == "Medico")
			txtMatricula.setEditable(true);
		else
			txtMatricula.setEditable(false);
		final GridBagConstraints gbc_txtMatricula = new GridBagConstraints();
		gbc_txtMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_txtMatricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMatricula.gridx = 2;
		gbc_txtMatricula.gridy = 8;
		contentPane.add(txtMatricula, gbc_txtMatricula);
		txtMatricula.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/save.png")));
		final GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 9;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		btnGuardar.addActionListener(e -> {
			final String Usuario = txtUsuario.getText();
			boolean error = true;
			if (Usuario.equals("")) {
				JOptionPane.showMessageDialog(new JDialog(), Errores.UsuarioPassIncorrecto(), "Error", JOptionPane.ERROR_MESSAGE);
				txtUsuario.requestFocus();
			}
			final String Passwrd = txtPassword.getText();
			if (Passwrd.equals("")) {
				JOptionPane.showMessageDialog(new JDialog(), Errores.UsuarioPassIncorrecto(), "Error", JOptionPane.ERROR_MESSAGE);
				txtPassword.requestFocus();
			}
			final String Activo = (String) cmbActivo.getSelectedItem();
			final String Perfil = (String) cmbPerfil.getSelectedItem();
			final String Nombre = txtNombre.getText();
			final String Apellido = txtApellido.getText();
			final String Especialidad = (String) cmbEspecialidad.getSelectedItem();
			final Integer Matricula = Integer.parseInt(txtMatricula.getText());
			final String Hace = "NUEVO";
			try {
				error = Ejecucion.GuardaUsuario(Usuario, Passwrd, Activo, Perfil, Nombre, Apellido, Especialidad, Matricula, Hace);
				Log.CreaLog(Boolean.toString(error) + " - Usuario Creado");
			} catch (final Exception e1) {
				System.out.print(e1);
				try {
					Log.crearLog(e1.toString());
				} catch (final IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			if (!error) {
				dispose();
				final PantaAdminUsuario pau = new PantaAdminUsuario();
				pau.setVisible(true);
			} else
				JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno(), "Error", JOptionPane.ERROR_MESSAGE);
		});

		btnCerrar = new JButton("Cancelar");
		btnCerrar.addActionListener(e -> {
			try {
				Log.crearLog("Cancelado Nuevo Usuario");
			} catch (final IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			new PantaAdminUsuario().setVisible(true);
		});
		btnCerrar.setIcon(new ImageIcon(PantaAnadirUsuario.class.getResource("/imagenes/iconos/ban.png")));
		final GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCerrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrar.gridx = 5;
		gbc_btnCerrar.gridy = 9;
		contentPane.add(btnCerrar, gbc_btnCerrar);
	}

}
package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.ejecucion.Ejecucion;
import com.historiasclinicas.entidades.Usuarios;
import com.historiasclinicas.log.Log;

public class PantaModificaUsuario extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -7010662155793902563L;
	private final JButton btnCerrar;
	private final JPanel contentPane;
	private final JPasswordField passwordField;
	private final JTextField txtApellido;
	private final JTextField txtNombre;
	private final JTextField txtUsuario;

	/**
	 * Create the frame.
	 *
	 * @param usuarios
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public PantaModificaUsuario(Usuarios usuarios) throws IOException {
		Log.crearLog("El usuario administrativo ingreso a modificar un usuario");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setResizable(false);
		setTitle("Modificar Usuario");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		final JLabel lblModificarUsuario = new JLabel("Modificar Usuario");
		lblModificarUsuario.setIcon(new ImageIcon(PantaModificaUsuario.class.getResource("/imagenes/iconos/user.png")));
		lblModificarUsuario.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 14));
		final GridBagConstraints gbc_lblModificarUsuario = new GridBagConstraints();
		gbc_lblModificarUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblModificarUsuario.gridwidth = 5;
		gbc_lblModificarUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificarUsuario.gridx = 1;
		gbc_lblModificarUsuario.gridy = 0;
		contentPane.add(lblModificarUsuario, gbc_lblModificarUsuario);

		final JLabel lblNombre = new JLabel("Nombre");
		final GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		contentPane.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		txtNombre.setText(usuarios.getNombre());
		txtNombre.setEditable(false);
		final GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 4;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		final JLabel lblApellido = new JLabel("Apellido");
		final GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 2;
		contentPane.add(lblApellido, gbc_lblApellido);

		txtApellido = new JTextField();
		txtApellido.setText(usuarios.getApellido());
		txtApellido.setEditable(false);
		final GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 4;
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 2;
		gbc_txtApellido.gridy = 2;
		contentPane.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);

		final JLabel lblUsuario = new JLabel("Usuario");
		final GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 3;
		contentPane.add(lblUsuario, gbc_lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		final GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 4;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 3;
		contentPane.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		txtUsuario.setText(usuarios.getUsername());

		final JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		final GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		contentPane.add(lblContrasea, gbc_lblContrasea);

		passwordField = new JPasswordField();
		passwordField.setText(usuarios.getPassword());
		final GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 4;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 4;
		contentPane.add(passwordField, gbc_passwordField);
		final JLabel lblPerfil = new JLabel("Perfil");
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
		cmbPerfil.setSelectedItem(usuarios.getPerfil());

		final JLabel lblActivo = new JLabel("Activo");
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
		cmbActivo.setSelectedItem(usuarios.getIsactive());

		final JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.addActionListener(e -> {
			final String Usuario = txtUsuario.getText();
			final String Passwrd = passwordField.getText();
			final String Activo = (String) cmbActivo.getSelectedItem();
			final String Perfil = (String) cmbPerfil.getSelectedItem();
			final String Nombre = txtNombre.getText();
			final String Apellido = txtApellido.getText();
			final String Especialidad = usuarios.getEspecialidad();
			final Integer Matricula = usuarios.getMatricula();
			final String Hace = "ACTUALIZA";
			try {
				Ejecucion.GuardaUsuario(Usuario, Passwrd, Activo, Perfil, Nombre, Apellido, Especialidad, Matricula, Hace);
			} catch (final IOException e1) {
				e1.printStackTrace();
			}
			dispose();
			new PantaAdminUsuario().setVisible(true);
		});
		btnGuardar.setIcon(new ImageIcon(PantaModificaUsuario.class.getResource("/imagenes/iconos/save.png")));
		final GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 8;
		contentPane.add(btnGuardar, gbc_btnGuardar);

		btnCerrar = new JButton("Cancelar");
		btnCerrar.addActionListener(arg0 -> {
			dispose();
			new PantaAdminUsuario().setVisible(true);
		});
		btnCerrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setIcon(new ImageIcon(PantaModificaUsuario.class.getResource("/imagenes/iconos/ban.png")));
		final GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCerrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrar.gridx = 5;
		gbc_btnCerrar.gridy = 8;
		contentPane.add(btnCerrar, gbc_btnCerrar);
	}

}

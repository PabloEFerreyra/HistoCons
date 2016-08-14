package pantallas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.histocons.ejecucion.Ejecucion;
import com.histocons.entidades.Usuarios;
import com.histocons.log.Log;
public class PantaModificaUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7010662155793902563L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	/**
	 * Create the frame.
	 * @param usuarios 
	 * @throws IOException 
	 */
	public PantaModificaUsuario(Usuarios usuarios) throws IOException {
		Log.crearLog("El usuario administrativo ingreso a modificar un usuario");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaModificaUsuario.class.getResource("/imagenes/Schnellzugriff_Icon_3.png")));
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Modificar Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblModificarUsuario = new JLabel("Modificar Usuario");
		lblModificarUsuario.setIcon(new ImageIcon(PantaModificaUsuario.class.getResource("/imagenes/user_48.png")));
		lblModificarUsuario.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 14));
		GridBagConstraints gbc_lblModificarUsuario = new GridBagConstraints();
		gbc_lblModificarUsuario.gridwidth = 5;
		gbc_lblModificarUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificarUsuario.gridx = 1;
		gbc_lblModificarUsuario.gridy = 0;
		contentPane.add(lblModificarUsuario, gbc_lblModificarUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 1;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.gridwidth = 4;
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 1;
		contentPane.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		txtUsuario.setText(usuarios.getUsername());
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 2;
		contentPane.add(lblContrasea, gbc_lblContrasea);
		
		txtPassword = new JTextField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.gridwidth = 4;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 2;
		contentPane.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		txtPassword.setText(usuarios.getPassword());
		JLabel lblPerfil = new JLabel("Perfil");
		GridBagConstraints gbc_lblPerfil = new GridBagConstraints();
		gbc_lblPerfil.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerfil.gridx = 1;
		gbc_lblPerfil.gridy = 3;
		contentPane.add(lblPerfil, gbc_lblPerfil);
		
		final JComboBox<String> cmbPerfil = new JComboBox<String>();
		GridBagConstraints gbc_cmbPerfil = new GridBagConstraints();
		gbc_cmbPerfil.gridwidth = 4;
		gbc_cmbPerfil.insets = new Insets(0, 0, 5, 5);
		gbc_cmbPerfil.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbPerfil.gridx = 2;
		gbc_cmbPerfil.gridy = 3;
		contentPane.add(cmbPerfil, gbc_cmbPerfil);
		cmbPerfil.addItem("Medico");
		cmbPerfil.addItem("Admin");
		cmbPerfil.addItem("Secretario");
		cmbPerfil.setSelectedItem(usuarios.getPerfil());
		
		JLabel lblActivo = new JLabel("Activo");
		GridBagConstraints gbc_lblActivo = new GridBagConstraints();
		gbc_lblActivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblActivo.gridx = 1;
		gbc_lblActivo.gridy = 4;
		contentPane.add(lblActivo, gbc_lblActivo);
		
		final JComboBox<String> cmbActivo = new JComboBox<String>();
		GridBagConstraints gbc_cmbActivo = new GridBagConstraints();
		gbc_cmbActivo.gridwidth = 4;
		gbc_cmbActivo.insets = new Insets(0, 0, 5, 5);
		gbc_cmbActivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbActivo.gridx = 2;
		gbc_cmbActivo.gridy = 4;
		contentPane.add(cmbActivo, gbc_cmbActivo);
		cmbActivo.addItem("SI");
		cmbActivo.addItem("NO");
		cmbActivo.setSelectedItem(usuarios.getIsactive());
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Usuario = txtUsuario.getText();
				String Passwrd = txtPassword.getText();
				String Activo = (String)cmbActivo.getSelectedItem();
				String Perfil = (String)cmbPerfil.getSelectedItem();
				String Hace = "ACTUALIZA";
				try {
					Ejecucion.GuardaUsuario(Usuario,Passwrd,Activo,Perfil,Hace);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
				new PantaAdminUsuario().setVisible(true);
			}
		});
		btnGuardar.setIcon(new ImageIcon(PantaModificaUsuario.class.getResource("/imagenes/unidad-de-disco-icono-3963-48.png")));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 6;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setIcon(new ImageIcon(PantaModificaUsuario.class.getResource("/imagenes/cancel-button.png")));
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCerrar.gridx = 5;
		gbc_btnCerrar.gridy = 6;
		contentPane.add(btnCerrar, gbc_btnCerrar);
	}


}

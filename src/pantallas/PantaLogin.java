package pantallas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.histocons.gestores.GestorLogin;

public class PantaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	public static Object usuario;
	private JPanel contentPane;
	private JTextField txtUsuario_1;
	private JPasswordField jpassClave_1;
	public static Object perfil;
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PantaLogin frame = new PantaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public PantaLogin() 
	{
		super();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaLogin.class.getResource("/imagenes/logotipo.png")));
		setTitle("Login Historias Clinicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setBounds(100, 100, 382, 477);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmTestConexion = new JMenuItem("Test Conexion");
		mntmTestConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PruebaConexion().setVisible(true);
			}
		});
		mnAyuda.add(mntmTestConexion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{349, 0};
		gbl_contentPane.rowHeights = new int[]{218, 16, 39, 18, 18, 35, 0, 16, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantaLogin.class.getResource("/imagenes/logotipo.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblBienvenidoAHistocons = new JLabel("Bienvenido a Historias Clinicas");
		lblBienvenidoAHistocons.setFont(new Font("Lucida Handwriting", Font.PLAIN, 16));
		GridBagConstraints gbc_lblBienvenidoAHistocons = new GridBagConstraints();
		gbc_lblBienvenidoAHistocons.fill = GridBagConstraints.VERTICAL;
		gbc_lblBienvenidoAHistocons.insets = new Insets(0, 0, 5, 0);
		gbc_lblBienvenidoAHistocons.gridx = 0;
		gbc_lblBienvenidoAHistocons.gridy = 1;
		contentPane.add(lblBienvenidoAHistocons, gbc_lblBienvenidoAHistocons);
		
		txtUsuario_1 = new JTextField();
		txtUsuario_1.setToolTipText("Ingrese Usuario");
		txtUsuario_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_txtUsuario_1 = new GridBagConstraints();
		gbc_txtUsuario_1.fill = GridBagConstraints.BOTH;
		gbc_txtUsuario_1.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuario_1.gridx = 0;
		gbc_txtUsuario_1.gridy = 3;
		contentPane.add(txtUsuario_1, gbc_txtUsuario_1);
		txtUsuario_1.setColumns(10);
		
		jpassClave_1 = new JPasswordField();
		jpassClave_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
			    if(e.getSource()==jpassClave_1)
			    {
			        if(key==KeyEvent.VK_ENTER)
			        { 
			        	try {
							com.histocons.log.Log.crearLog("Tecla Ingresada: "+"info "+key);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
			        		
			        	try {
							Ingreso();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        }
			    }
			}
		});
		jpassClave_1.setToolTipText("Ingrese Contrase\u00F1a");
		jpassClave_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jpassClave_1.setEchoChar('*');
		GridBagConstraints gbc_jpassClave_1 = new GridBagConstraints();
		gbc_jpassClave_1.fill = GridBagConstraints.BOTH;
		gbc_jpassClave_1.insets = new Insets(0, 0, 5, 0);
		gbc_jpassClave_1.gridx = 0;
		gbc_jpassClave_1.gridy = 4;
		contentPane.add(jpassClave_1, gbc_jpassClave_1);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
		btnNewButton.setIcon(new ImageIcon(PantaLogin.class.getResource("/imagenes/icono-de-apagado-10534.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
					Ingreso();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

	private void Ingreso() throws IOException
 	{
    	usuario = txtUsuario_1.getText();
	    String clave = String.valueOf(jpassClave_1.getPassword());
	    perfil = GestorLogin.validar_ingreso(usuario.toString(), clave);
	    
	    try{	
	    	if(perfil.equals("Admin"))
			{
		    	com.histocons.log.Log.crearLog("Inicio de sesion usuario: "+ usuario+" - "+"Perfil: "+perfil);
		    	dispose();
				new PantaAdminUsuario().setVisible(true);
			}
			else
			{
				com.histocons.log.Log.crearLog("Inicio de sesion usuario: "+usuario+" - "+"Perfil: "+perfil);
				new PantaPacientes().setVisible(true);
				dispose();
			}
	    }
	    catch(Exception e)
	    {
	    	com.histocons.log.Log.crearLog(e.toString());
	    }
	    
	}
}

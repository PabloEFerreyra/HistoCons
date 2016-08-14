package pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.histocons.entidades.Usuarios;
import com.histocons.gestores.GestorUsuarios;

public class PantaAdminUsuario extends JFrame {

	private static final long serialVersionUID = -6890276574269263350L;
	private JPanel contentPane;
	private List<Usuarios> ListaUsuarios = null;
	private JList<Object> list;
	private JButton btnNewButton;
	private JButton btnCerrar;
	private JButton btnNuevo;

	public PantaAdminUsuario() {

		
		setTitle("Area Administracion Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaAdminUsuario.class.getResource("/imagenes/logotipo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		setBounds(100, 100, 737, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{554, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{50, 66, 0, 0, 155, 16, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		ListaUsuarios = GestorUsuarios.TraeUsuarios();
		
		DefaultListModel<Object> df = new DefaultListModel<Object>();
		
		for (int i=0; i<ListaUsuarios.size(); i++){
			Usuarios us = ListaUsuarios.get(i);
			df.addElement(us.getUsername()+" - "+us.getIsactive() +" - "+us.getPerfil());
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		list = new JList<Object>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		list.setModel(df);
		list.addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getClickCount()==2)
				{
					try
					{
						AbrirModificarUsuario();
						
					}
					catch(Exception e1)
					{
						String error = e1.toString();
						try {
							com.histocons.log.Log.crearLog("Error "+error);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
					
			}
		});
		
		JLabel lblUsuarioContrasea = new JLabel("Usuario | Activo | Perfil");
		scrollPane.setColumnHeaderView(lblUsuarioContrasea);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AbrirModificarUsuario();
				
			}
		});
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new PantaAnadirUsuario(null).setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PantaAdminUsuario.class.getResource("/imagenes/attach-1.png")));
		GridBagConstraints gbc_btnNuevo = new GridBagConstraints();
		gbc_btnNuevo.fill = GridBagConstraints.BOTH;
		gbc_btnNuevo.insets = new Insets(0, 0, 5, 0);
		gbc_btnNuevo.gridx = 2;
		gbc_btnNuevo.gridy = 1;
		contentPane.add(btnNuevo, gbc_btnNuevo);
		btnNewButton.setIcon(new ImageIcon(PantaAdminUsuario.class.getResource("/imagenes/buscar-buscar-ampliar-icono-5681-48.png")));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnCerrar.setIcon(new ImageIcon(PantaAdminUsuario.class.getResource("/imagenes/cancel-button.png")));
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.fill = GridBagConstraints.BOTH;
		gbc_btnCerrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCerrar.gridx = 2;
		gbc_btnCerrar.gridy = 3;
		contentPane.add(btnCerrar, gbc_btnCerrar);
	}
	public List<Usuarios> getListaUsuarios() {
		return ListaUsuarios;
	}
	public void setListaUsuarios(ArrayList<Usuarios> listaUsuarios) {
		ListaUsuarios = listaUsuarios;
	}
	
	public void AbrirModificarUsuario()
	{
		ListaUsuarios.get(list.getSelectedIndex()).getUsername();
		ListaUsuarios.get(list.getSelectedIndex()).getPassword();
		ListaUsuarios.get(list.getSelectedIndex()).getIsactive();
		ListaUsuarios.get(list.getSelectedIndex()).getPerfil();
		Usuarios usuarios = ListaUsuarios.get(list.getSelectedIndex());
		
		PantaModificaUsuario pmu = null;
		try {
			pmu = new PantaModificaUsuario(usuarios);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pmu.setVisible(true);
		dispose();
	}
}
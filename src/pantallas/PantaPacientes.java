package pantallas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.histocons.entidades.Paciente;
import com.histocons.gestores.GestorPacientes;

public class PantaPacientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtApellido;
	private JScrollPane scrollPane;
	private JButton btnMostrar;
	private List<Paciente> ListaPacientes=null;
	private JList<Object> list;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JLabel lblNewLabel;
	private JLabel lblApellido;
	private String perfil = PantaLogin.perfil.toString();

	
	public PantaPacientes() throws IOException {
		com.histocons.log.Log.crearLog("Ingreso Correcto a pantalla de pacientes");
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

		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaPacientes.class.getResource("/imagenes/logotipo.png")));
		setTitle("Busqueda Pacientes");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 497);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 300, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("Busqueda de pacientes");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 12));
		lblNewLabel.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/buscar-buscar-ampliar-icono-5681-48.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
			    if(e.getSource()==txtApellido)
			    {
			        if(key==KeyEvent.VK_ENTER)
			        { 
			        	
						ListaPacientes = GestorPacientes.ConsultarPaciente(txtApellido.getText());
						
						DefaultListModel<Object> df = new DefaultListModel<Object>();
					
						for (int i=0; i<ListaPacientes.size(); i++){
							Paciente pa = ListaPacientes.get(i);
							df.addElement(pa.getNombre()+" "+pa.getApellido()+" "+pa.getObraSocial());
							
						}
						
						
						list.setModel(df);
        
			        }
			    }
			}});


		txtApellido.setToolTipText("Ingrese apellido a buscar");
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 1;
		contentPane.add(txtApellido, gbc_txtApellido);
		txtApellido.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/buscar-buscar-ampliar-icono-5681-48.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListaPacientes = GestorPacientes.ConsultarPaciente(txtApellido.getText());
				
				DefaultListModel<Object> df = new DefaultListModel<Object>();
			
				for (int i=0; i<ListaPacientes.size(); i++){
					Paciente pa = ListaPacientes.get(i);
					df.addElement(pa.getNombre()+" "+pa.getApellido()+" "+pa.getObraSocial());
					
				}
				
				
				list.setModel(df);
				
				
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 1;
		contentPane.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/unidad-de-disco-icono-3963-48.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PantaAnadirPaciente().setVisible(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 3;
		gbc_btnAgregar.gridy = 1;
		contentPane.add(btnAgregar, gbc_btnAgregar);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		list = new JList<Object>();

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		llenarLista();
		list.addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getClickCount()==2)
					try {
						seleccionaPaciente();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		list.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key=e.getKeyCode();
				 if(key==KeyEvent.VK_ENTER)
			        { 
					 try {
						seleccionaPaciente();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        }
				 if(key==KeyEvent.VK_F5)
				 {
					llenarLista();
				 }
			}
		});
		
		
		lblApellido = new JLabel("DNI            | Nombre | Apellido | Obra Social");
		scrollPane.setColumnHeaderView(lblApellido);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.setIcon(new ImageIcon(PantaPacientes.class.getResource("/imagenes/hoja.png")));
		btnMostrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
						
				try {
					seleccionaPaciente();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_btnMostrar = new GridBagConstraints();
		gbc_btnMostrar.anchor = GridBagConstraints.NORTH;
		gbc_btnMostrar.gridx = 3;
		gbc_btnMostrar.gridy = 2;
		contentPane.add(btnMostrar, gbc_btnMostrar);
	}

	private void llenarLista() {
		ListaPacientes = GestorPacientes.ConsultarPaciente("");
		DefaultListModel<Object> df = new DefaultListModel<Object>();
		for (int i=0; i<ListaPacientes.size(); i++){
			Paciente pa = ListaPacientes.get(i);
			df.addElement(pa.getDni()+" | "+pa.getNombre()+" | "+pa.getApellido()+" | "+pa.getObraSocial());	
		}
		list.setModel(df);
	}

	public List<Paciente> getListaPacientes() {
		return ListaPacientes;
	}

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		ListaPacientes = listaPacientes;
	}


	public void seleccionaPaciente() throws IOException
	{	
		try
		{
		ListaPacientes.get(list.getSelectedIndex()).getDni();
		ListaPacientes.get(list.getSelectedIndex()).getApellido();
		ListaPacientes.get(list.getSelectedIndex()).getNombre();
		ListaPacientes.get(list.getSelectedIndex()).getFechaNacimiento();
		ListaPacientes.get(list.getSelectedIndex()).getObraSocial();
		ListaPacientes.get(list.getSelectedIndex()).getPlanOs();
		ListaPacientes.get(list.getSelectedIndex()).getNroAfiliado();
		ListaPacientes.get(list.getSelectedIndex()).getProvincia();
		ListaPacientes.get(list.getSelectedIndex()).getCiudad();
		ListaPacientes.get(list.getSelectedIndex()).getDomicilio();
		ListaPacientes.get(list.getSelectedIndex()).getTelefono();
		ListaPacientes.get(list.getSelectedIndex()).getTelefonoCelular();
		ListaPacientes.get(list.getSelectedIndex()).getCorreo();
		
		
		Paciente pacientes=ListaPacientes.get(list.getSelectedIndex());
		com.histocons.log.Log.crearLog("LLamada Correcta a paciente seleccionado");
		this.dispose();
		if(perfil.equals("Secretario"))
			new PantaAdminPacienteSec(pacientes).setVisible(true);
		else
			new PantaAdminPaciente(pacientes).setVisible(true);
		}
		catch(Exception e)
		{
			com.histocons.log.Log.crearLog(e.getMessage().toString());
		}
		
	}
	

	

}

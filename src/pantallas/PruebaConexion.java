package pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.histocons.gestores.Conexion;

public class PruebaConexion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PruebaConexion() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPruebaConexion = new JButton("Prueba Conexion");
		btnPruebaConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				                                               


				        java.sql.Connection cn= Conexion.getConexion();


				        if(cn!=null){

				                JOptionPane.showMessageDialog(null, "Conectado");

				                try{

				                    cn.close();

				                }catch(SQLException ex){

				                    System.out.println("Error al desconectar "+ex);

				                }
				        }else{
				        	JOptionPane.showMessageDialog(null, "Error al conectar");
				        }
				        
			}
		});
		btnPruebaConexion.setBounds(110, 92, 154, 25);
		contentPane.add(btnPruebaConexion);
	}
}

package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.historiasclinicas.log.Log;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PantaAF extends JFrame {

	private static final long serialVersionUID = -4622768612629811724L;
	private final JButton btnImprimir;
	private final JPanel contentPane;
	private File fichero;
	private final JLabel lblAosDeEdad;
	public JLabel lblApellido;
	private final JLabel lblDe;
	public JLabel lblDni;
	public JLabel lblEdad;
	private final JLabel lblFueExaminadoClinicamente;
	public JLabel lblNombre;
	private final JLabel lblParaRealizarActividad;
	public JLabel lblUsuario;
	private final JLabel lblYDni;
	private String salida;
	private final String titulo;

	public PantaAF() {

		titulo = "Certificado de Aptitud Fisica";
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaAF.class.getResource("/imagenes/logotipo.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 441);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JLabel lblCertificoQue = new JLabel("Certifico que");
		lblCertificoQue.setBounds(160, 123, 71, 14);
		contentPane.add(lblCertificoQue);

		final JLabel label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		label.setText(titulo);
		label.setBounds(226, 64, 171, 30);
		contentPane.add(label);

		lblApellido = new JLabel("");
		lblApellido.setBounds(241, 123, 113, 14);
		contentPane.add(lblApellido);

		lblNombre = new JLabel("");
		lblNombre.setBounds(367, 123, 161, 14);
		contentPane.add(lblNombre);

		lblDe = new JLabel("De");
		lblDe.setBounds(163, 148, 19, 14);
		contentPane.add(lblDe);

		lblEdad = new JLabel("");
		lblEdad.setBounds(192, 148, 50, 14);
		contentPane.add(lblEdad);

		lblYDni = new JLabel("y DNI");
		lblYDni.setBounds(333, 148, 46, 14);
		contentPane.add(lblYDni);

		lblDni = new JLabel("");
		lblDni.setBounds(367, 148, 113, 14);
		contentPane.add(lblDni);

		lblAosDeEdad = new JLabel("A\u00F1os de Edad");
		lblAosDeEdad.setBounds(254, 148, 69, 14);
		contentPane.add(lblAosDeEdad);

		lblFueExaminadoClinicamente = new JLabel(
				"Fue examinado clinicamente y no presenta, en la fecha, contraindicaciones");
		lblFueExaminadoClinicamente.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFueExaminadoClinicamente.setBounds(131, 173, 427, 14);
		contentPane.add(lblFueExaminadoClinicamente);

		lblParaRealizarActividad = new JLabel(
				"para realizar actividad fisica, recreativa o deportiva, acorde a su edad y sexo");
		lblParaRealizarActividad.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblParaRealizarActividad.setBounds(131, 200, 437, 14);
		contentPane.add(lblParaRealizarActividad);

		lblUsuario = new JLabel("usuario");
		lblUsuario.setBounds(241, 256, 138, 14);
		contentPane.add(lblUsuario);

		btnImprimir = new JButton("Imprimir");
		btnImprimir.setIcon(new ImageIcon(PantaAF.class.getResource("/imagenes/iconos/print.png")));
		btnImprimir.addActionListener(e -> {
			final JFileChooser fc = new JFileChooser();

			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			salida = "AutorizacionFisica" + lblApellido.getText() + lblNombre.getText() + ".pdf";
			fc.addChoosableFileFilter(new FileNameExtensionFilter("*.PDF", "PDF"));

			fc.setSelectedFile(new File(salida));

			final int seleccion = fc.showSaveDialog(getParent());

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				fichero = fc.getSelectedFile();

				try {

					final String dni = lblDni.getText();
					final String Apellido = lblApellido.getText();
					final String Nombre = lblNombre.getText();
					final String Edad = lblEdad.getText();
					final String Especialista = lblUsuario.getText();
					SendToPrinter(titulo, Apellido, Nombre, Edad, Especialista, dni);
					Log.crearLog("Impresion de Historia Correcta en " + salida);
					JOptionPane.showMessageDialog(new JDialog(), btnImprimir, "Se imprimio Correctamente en  " + salida, JOptionPane.INFORMATION_MESSAGE);

					final File exit = new File(salida);

					Desktop.getDesktop().open(exit);

				} catch (final Exception e1) {
					System.out.println(e1);
					try {
						Log.crearLog("Error: " + e1.getMessage().toString());
						JOptionPane.showMessageDialog(new JDialog(), btnImprimir, "Ocurrio un error, revise o consulte a sistemas", JOptionPane.ERROR_MESSAGE);
					} catch (final IOException e11) {
						// TODO Auto-generated catch block
						e11.printStackTrace();
					}

				}

			}
		});
		btnImprimir.setBounds(530, 327, 138, 64);
		contentPane.add(btnImprimir);
	}

	public void SendToPrinter(String titulo, String apellido, String nombre, String edad, String especialista,
			String dni) throws Exception {
		final Document document = new Document();

		final String parrafo = titulo + "\n" + "\n" + "Certifico que " + apellido + " " + nombre + "\n";

		final String parrafo2 = "De " + edad + " años de edad y DNI " + dni + "\n" + "\n";

		final String parrafo3 = "Fue Examinado clinicamente, y no presenta, en la fecha, contraindicaciones\n"
				+ "Para Realizar Actividad fisica, recreativa o deportiva, acorde a su edad y sexo\n" + "\n" + "\n"
				+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + especialista + "\n" ;

		salida = fichero.getAbsolutePath();
		PdfWriter.getInstance(document, new FileOutputStream(salida));
		document.open();
		final Paragraph par = new Paragraph(parrafo);
		par.setAlignment(Element.ALIGN_CENTER);
		document.add(par);
		final Paragraph par2 = new Paragraph(parrafo2);
		par2.setAlignment(Element.ALIGN_CENTER);
		document.add(par2);
		final Paragraph par3 = new Paragraph(parrafo3);
		par3.setAlignment(Element.ALIGN_CENTER);
		document.add(par3);
		document.close();
	}
}

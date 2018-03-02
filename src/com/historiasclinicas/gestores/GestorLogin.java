package com.historiasclinicas.gestores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Usuarios;
import com.historiasclinicas.log.Log;

public class GestorLogin {
	public static int ActuaPass(Usuarios pass) {
		int resultado = 0;
		final String SQL = "UPDATE auth_user set password=? where username=? and password=?";
		try {

			final Connection cn = Conexion.getConexion();
			final PreparedStatement pst = cn.prepareStatement(SQL);
			pst.setString(1, pass.getPassword());
			pst.setString(2, pass.getUsername());
			resultado = pst.executeUpdate();
		} catch (final SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public static List<Usuarios> validar_ingreso(String usuario, String clave) {
		List<Usuarios> perfil = null;
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		final Query<?> query = session
				.createQuery(
						"from Usuarios u where u.username =:usuario and u.password =:clave and u.isactive = 'SI'")
				.setMaxResults(1);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			query.setParameter("usuario", usuario);
			query.setParameter("clave", clave);
			try {
				perfil = (List<Usuarios>) query.list();
			} catch (final Exception e) {
				JOptionPane.showMessageDialog(null, Errores.UsuarioPassIncorrecto());
				try {
					Log.crearLog("Error login " + e);
				} catch (final IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			transaction.commit();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return perfil;
	}

}
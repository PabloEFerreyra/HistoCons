package com.historiasclinicas.gestores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/*-Hibernate Imports-*/
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*-End Hibernate Imports-*/

import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Usuarios;
import com.historiasclinicas.log.Log;

@SuppressWarnings("deprecation")
public class GestorUsuarios {

	public static int ActualizaUsuario(Usuarios usuarios) throws IOException {
		int resultado = 0;
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		final Query<?> query = session.createQuery(
				"update Usuarios u set u.password =:clave, u.perfil =:perf, u.isactive =:activo where u.username =:usuario");
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			query.setParameter("usuario", usuarios.getUsername());
			query.setParameter("clave", usuarios.getPassword());
			query.setParameter("perf", usuarios.getPerfil());
			query.setParameter("activo", usuarios.getIsactive());
			try {
				resultado = query.executeUpdate();
			} catch (final Exception e) {
				JOptionPane.showMessageDialog(null, Errores.UsuarioPassIncorrecto());
				Log.crearLog("Error login " + e);
			}
			transaction.commit();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	public static int NuevoUsuario(String usuario, String passwrd, String activo, String perfil, String nombre, String apellido, String especialidad, Integer matricula) {
		SessionFactory factory;
		int hecho = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			final Usuarios usuario1 = new Usuarios();
			usuario1.setUsername(usuario);
			usuario1.setPassword(passwrd);
			usuario1.setIsactive(activo);
			usuario1.setPerfil(perfil);
			usuario1.setNombre(nombre);
			usuario1.setApellido(apellido);
			usuario1.setEspecialidad(especialidad);

			try {
				session.save(usuario1);
				hecho = 1;
				return hecho;
			} catch (final Exception e) {
				hecho = 0;
				return hecho;
			}
		} catch (final HibernateException e) {
			if (transaction != null)
				hecho = 0;
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return hecho;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public static String[] TraeNombreUsuarios() {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		List<Usuarios> usuarios = new ArrayList<>();
		final Transaction transaction = null;
		try {
			usuarios = session.createQuery("select u.username from Usuarios u where u.perfil = 'medico'").list();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		final String[] lUsuarios = usuarios.toArray(new String[usuarios.size()]) ;
		return lUsuarios;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public static List<Usuarios> TraeUsuarios() {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		List<Usuarios> usuarios = new ArrayList<>();
		final Transaction transaction = null;
		try {
			usuarios = session.createQuery("from Usuarios").list();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return usuarios;
	}
}

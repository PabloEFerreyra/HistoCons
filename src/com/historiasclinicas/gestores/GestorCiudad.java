package com.historiasclinicas.gestores;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.historiasclinicas.entidades.Ciudad;

public class GestorCiudad {
	@SuppressWarnings({ "unused", "unchecked" })
	public static String[] ConsultarCiudad() {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();

		List<Ciudad> Ciudades = new ArrayList<>();
		final Transaction transaction = null;
		try {
			Ciudades = session.createQuery("select distinct c.ciudadnombre from Ciudad c order by c.ciudadnombre asc").list();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		final String[] lciudades = Ciudades.toArray(new String[Ciudades.size()]);
		return lciudades;

	}
}

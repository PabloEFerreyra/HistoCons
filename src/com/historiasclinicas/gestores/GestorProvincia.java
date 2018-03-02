package com.historiasclinicas.gestores;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.historiasclinicas.entidades.Provincia;

public class GestorProvincia {
	@SuppressWarnings({ "unused", "unchecked" })
	public static String[] ConsultarProvincia() {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();

		List<Provincia> Provincias = new ArrayList<>();
		final Transaction transaction = null;
		try {
			Provincias = session.createQuery("select p.provincianombre from Provincia p ").list();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		final String[] lprovincias = Provincias.toArray(new String[Provincias.size()]);
		return lprovincias;

	}

	@SuppressWarnings({ "unchecked", "unused" })
	public static short TraerProvId(String selectedItem) {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();

		List<Provincia> Provincias = new ArrayList<>();
		final Transaction transaction = null;
		try {
			((Query<?>) Provincias).setParameter("provincia", selectedItem);
			Provincias = (List<Provincia>) session
					.createQuery("select p.id from Provincia p where p.provincianombre =:provincia").setMaxResults(1);
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		final short idprov = Provincias.get(0).getId();
		return idprov;
	}
}

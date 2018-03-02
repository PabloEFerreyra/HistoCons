package com.historiasclinicas.gestores;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.historiasclinicas.entidades.Obrassociales;

public class GestorOS {
	@SuppressWarnings({ "unused", "unchecked" })
	public static String[] ConsultarOS() {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();

		List<Obrassociales> OS = new ArrayList<>();
		final Transaction transaction = null;
		try {
			OS = session.createQuery("select o.nombreOs from Obrassociales o ").list();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		final String[] lOS = OS.toArray(new String[OS.size()]);
		return lOS;

	}

	@SuppressWarnings({ "unchecked", "unused" })
	public static Integer TraerOSId(String selectedItem) {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();

		List<Obrassociales> OS = new ArrayList<>();
		final Transaction transaction = null;
		try {
			((Query<?>) OS).setParameter("OS", selectedItem);
			OS = (List<Obrassociales>) session
					.createQuery("select o.id from Obrassociales o where o.nombreOs=:OS").setMaxResults(1);
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		final Integer idOS = OS.get(0).getId();
		return idOS;
	}
}

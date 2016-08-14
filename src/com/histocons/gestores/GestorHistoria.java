package com.histocons.gestores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.histocons.entidades.Historia;


public class GestorHistoria 
{

	

	private static Transaction transaction;


	@SuppressWarnings({ "deprecation", "unchecked", "unused" })
	public static List <Historia> ConsultarHistoria(int dni)
	{
		SessionFactory factory;
		try 
		{ 
			factory = new Configuration().configure().buildSessionFactory();
		}
		catch (HibernateException he) 
		{ 
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
			throw new ExceptionInInitializerError(he); 
		} 
		
		Session session = factory.openSession();
		
		List<Historia> listaHistoria = new ArrayList<Historia>();
		
		Transaction transaction = null;
		try
		{
			listaHistoria = session.createCriteria(Historia.class).add(Restrictions.eq("paciente", dni)).list();
		}
		catch (HibernateException e) {
	        if (transaction != null)
	            transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		return listaHistoria;
	}
		
		
	public static boolean NuevoIngreso(int dni,float altura, float peso, String fechaActual, String sintomas, String otros, String laboratorio, 
			String evolucion, String observaciones, String diagnosticoprinc, String diagnosticosec, String especialista) throws IOException
	{
		boolean error = false;
		SessionFactory factory;
        try 
	    { 
        	factory = new Configuration().configure().buildSessionFactory();
	    } catch (HibernateException he) 
	    { 
	        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
	        throw new ExceptionInInitializerError(he); 
	    } 
        Session session = factory.openSession();
        
		transaction = null;
		try
		{
			Historia historias = new Historia();
			historias.setPaciente(dni);
			historias.setAltura(altura);
			historias.setPeso(peso);
			historias.setFecha(fechaActual);
			historias.setAntecedentes(sintomas);
			historias.setOtros(otros);
			historias.setLaboratorio(laboratorio);
			historias.setEvolucion(observaciones);
			historias.setObservaciones(observaciones);
			historias.setDiagprinc(diagnosticoprinc);
			historias.setDiagsec(diagnosticosec);
			historias.setEspecialista(especialista);
			try{
				session.save(historias);
				}
				catch(Exception e)
				{
					error = true;
					return error;
				}
			}
			catch (HibernateException e) {
				error = true;
				transaction.rollback();
				e.printStackTrace();
				return error;
				} finally {
					session.close();
				}
		return error;
	}
}